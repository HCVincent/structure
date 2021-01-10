package day03.singlelinkedlist;

import java.util.Stack;

public class TestStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> stack = new Stack<String>();
		stack.add("jack");
		stack.add("tom");
		stack.add("smith");
		while(stack.size() > 0) {
			System.out.println(stack.pop());
		}
	}

}
