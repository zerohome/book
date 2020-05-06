package ik.test;

import java.io.IOException;
import java.io.StringReader;

import org.junit.Test;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.model.analyzer.Lexeme;

public class CommonTest {
	public void print(String str) {
		try {
			IKSegmenter ik = new IKSegmenter(new StringReader(str), false);
			Lexeme l = null;
			while ((l = ik.next()) != null) {
				System.out.println(l.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test1() throws IOException {
		String str = "南京市的长江大桥";	// I am xxx
		print(str);
	}
}
