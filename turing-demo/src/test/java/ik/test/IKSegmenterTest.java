package ik.test;

import java.io.IOException;
import java.io.StringReader;

import org.junit.Test;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.model.analyzer.Lexeme;

/**
 */
public class IKSegmenterTest {

	public void print(String str) {
		try {
			IKSegmenter ik = new IKSegmenter(new StringReader(str), true);
			Lexeme l = null;
			while ((l = ik.next()) != null) {
				if(l.getProps().equals("cn_medicine"))
					System.out.println(l.getLexemeText() + ":" + l.getProps());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test0() throws IOException {
		String str = "我是习大大，我是领袖，，nn";
		//做敏感词分析
		print(str);
	}
	
	@Test
	public void test1() throws IOException {
		String str = "羌活　独活　柴胡　前胡　枳壳　茯苓　荆芥　防风　桔梗　川芎各一钱五分（各5g）　甘草五分（3g）";
		//做敏感词分析
		print(str);
	}

	@Test
	public void test2() throws IOException {
		String str = "荆防败毒散为羌活　独活　柴胡　前胡　枳壳　茯苓　荆芥　防风　桔梗　川芎各一钱五分（各5g）　甘草五分（3g），银翘散为连翘一两（9g）　银花一两（9g）　苦桔梗六钱（6g）　薄荷六钱（6g）　竹叶四钱（4g）　生甘草五钱（5g）　荆芥穗四钱（5g）　淡豆豉五钱（5g）　牛蒡子六钱（9g）";
		print(str);
	}
	@Test
	public void test3(){
		String str = "香薷二钱（6g）　银花三钱（9g）　鲜扁豆花三钱（9g）　厚朴二钱（6g）　连翘二钱（9g）";
		print(str);
	}
	@Test
	public void test4(){
		String str = "麻黄（蜜炙）1，2克 光杏仁6克 生石膏12克 生甘草1.2克 栝楼仁12克 竹沥半夏4.5克 广皮红 小枳实各3克";
		print(str);
	}
	@Test
	public void test5(){
		String str = "主方：大黄12克（酒洗）厚朴15克（去皮）枳实12克（炙）芒消9克 ";
		print(str);
	}

}
