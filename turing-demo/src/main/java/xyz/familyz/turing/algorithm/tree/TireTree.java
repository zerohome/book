/*
 * Copyright(c) by 2017-2017 HackMask Tefchnologies , Ltd. All Rights Reserved
 *
 */
package xyz.familyz.turing.algorithm.tree;

/**
 * <p>字典树 .</p>
 * <p>时间 ： 2020年5月1日</p>
 * <p>Copyright 2017-2017, HackMask Tech. Co., Ltd.</p>
 * @author  1150310037
 * @version 1.0
 */
public class TireTree {

	public static void main(String[] args) {
		String[] words = {"java", "php", "ps", "python", "js", "css", "html"};
		TreeNode root = new TreeNode();
		for (String word : words) {
			createTireTree(root, word);
		}
		System.out.println(find(root, "ps"));
		showAllWords(root);
	}
	
	public static void createTireTree(TreeNode node, String word) {
		char d[] = word.toCharArray();
		for (char c : d) {
			int loc = c - 'a';
			if (node.childs[loc] == null) {
				node.childs[loc] = new TreeNode();
				node.childs[loc].data = c;
			}
			node = node.childs[loc];
		}
		node.isLeaf = true;
	}
	
	public static boolean find(TreeNode node, String word) {
		char d[] = word.toCharArray();
		for (char c : d) {
			int loc = c - 'a';
			if (node.childs[loc] == null) {
				return false;
			}
			node = node.childs[loc];
		}
		return node.isLeaf;
	}
	
	public static void showAllWords(TreeNode root) {
		for (TreeNode node : root.childs) {
			if (null == node) {
				continue;
			}
			System.out.print(node.data);
			if (node.isLeaf) {
				System.out.print("\t");
				continue;
			}
			showAllWords(node);
		}
	}
}

class TreeNode{
	final static int MAX_SIZE = 26;
	char data;
	boolean isLeaf = false;
	TreeNode[] childs;
	
	public TreeNode() {
		childs = new TreeNode[MAX_SIZE];
		isLeaf = false;
	}
}