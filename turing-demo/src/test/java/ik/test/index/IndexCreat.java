package ik.test.index;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.model.analyzer.Lexeme;

public class IndexCreat {

	private Map<String, List<String>> map = new HashMap<String, List<String>>();
	
	private Map<String, Integer> times = new HashMap<String, Integer>();

	public void creatIndex(Integer docId, String content) throws Exception {
		// 分词
		IKSegmenter ik = new IKSegmenter(new StringReader(content), false);
		Lexeme l = null;
		while ((l = ik.next()) != null) {
			String word = l.getLexemeText();
			// 写入Map结构当中
			if (map.containsKey(word)) {
				List<String> list = map.get(word);
				list.add(docId.toString());
				map.put(word, list);
			} else { // 当前还没包含词
				List<String> list = new ArrayList<String>();
				list.add(docId.toString());
				map.put(word, list);
				times.put(word, 1);
			}
		}
	}

	public static void main(String[] args) {
		IndexCreat indexCreat = new IndexCreat();
		try {
			indexCreat.creatIndex(1, "南京市长江大桥");
			indexCreat.creatIndex(2, "羌活　独活　柴胡　前胡　枳壳　茯苓　荆芥　防风　桔梗　川芎各一钱五分（各5g）　甘草五分（3g）");
			
			String searWord = "南京市";
			System.out.println(searWord + "搜索结果:");
			List<String> lists = indexCreat.map.get(searWord);
			if(lists != null && !lists.isEmpty()){
				
				for(String str : lists){
					System.out.print(str + " ");
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
