package day07.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {

	public static void main(String[] args) {
		// �����沨�����ʽ
		// Ϊ���㣬���ֺͷ����ÿո����
		String sufixExpression = "30 4 + 5 * 6 -";
		// ���ַ����ŵ�ArrayList��
		// ��ArrayList����һ�����������������ջ��ɼ���
		List<String> list = getListString(sufixExpression);
		System.out.println("rpnList:" + list);
		int res = calculate(list);
		System.out.println("res:" + res);
		
	}

	// ��һ���沨�����ʽ�����ν����ݺ���������뵽ArrayList��
	public static List<String> getListString(String suffixExpression) {
		String[] split = suffixExpression.split(" ");
		List<String> list = new ArrayList<String>();
		for (String ele : split) {
			list.add(ele);
		}
		return list;
	}

	public static int calculate(List<String> ls) {
		// ������ջ��ֻ��Ҫһ��ջ
		Stack<String> stack = new Stack<String>();
		for (String item : ls) {
			if (item.matches("\\d+")) { // ƥ���λ��
				stack.push(item);
			} else {
				// pop�����������������ջ
				int num2 = Integer.parseInt(stack.pop());
				int num1 = Integer.parseInt(stack.pop());
				int res = 0;
				if (item.equals("+")) {
					res = num1 + num2;
				} else if (item.equals("-")) {
					res = num1 - num2;
				} else if (item.equals("*")) {
					res = num1 * num2;
				} else if (item.equals("/")) {
					res = num1 / num2;
				} else {
					throw new RuntimeException("���������");
				}
				stack.push("" + res);
			}
		}
		// �������stack�е���������
		return Integer.parseInt(stack.pop());
	}
}
