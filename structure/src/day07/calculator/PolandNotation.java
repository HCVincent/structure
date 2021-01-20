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
//		List<String> list = getListString(sufixExpression);
//		System.out.println("rpnList:" + list);
//		int res = calculate(list);
//		System.out.println("res:" + res);
		String expression = "1+((2+3)*4)-5";//ע����ʽ 
		List<String> infixExpressionList = toInfixExpressionList(expression);
		System.out.println("��׺���ʽ��Ӧ��List=" + infixExpressionList); // ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
		List<String> suffixExpreesionList = parseSuffixExpressionList(infixExpressionList);
		System.out.println("��׺���ʽ��Ӧ��List" + suffixExpreesionList); //ArrayList [1,2,3,+,4,*,+,5,�C] 
		
		System.out.printf("expression=%d", calculate(suffixExpreesionList)); // ?
		

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
	
	//����׺���ʽת�ɶ�Ӧ��List
	public static List<String> toInfixExpressionList(String s) {
		List<String> ls = new ArrayList<String>();
		int i = 0;
		String str;
		char c;
		do {
			// ���c��һ�������֣��ͼ��뵽ls
			if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
				ls.add("" + c);
				i++;
			} else {
				str = "";
				while(i < s.length() && (c=s.charAt(i)) >= 48 && (c=s.charAt(i)) <= 57) {
					str += c;
					i++;
				}
				ls.add(str);
			}
		} while (i < s.length());
		return ls;
	}
	
	//���õ�����׺���ʽ��Ӧ��Listת�ɺ�׺���ʽ��List
	public static List<String> parseSuffixExpressionList(List<String> ls) {
		Stack<String> s1 = new Stack<String>();
		List<String> s2 = new ArrayList<String>();
		for(String item: ls) {
			if(item.matches("\\d+")) {
				s2.add(item);
			} else if(item.equals("(")){
				s1.push(item);
			} else if(item.equals(")")){
				//����������ţ������ε�����ջ���������ѹ��s2��ֱ������������Ϊֹ
				while(!s1.peek().equals("(")) {
					s2.add(s1.pop());
				}
				s1.pop(); //����С����
			} else {
				//��item�����ȼ�С�ڵ���ջ����������ȼ�,��s1ջ����������������뵽s2�У�����s1��ջ��������Ƚ�
				while(s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
					s2.add(s1.pop());
				}
				s1.push(item);
			}
		}	
			//��s1��ʣ����������ε���������s2
			while(s1.size() != 0) {
				s2.add(s1.pop());
			}
		return s2;
	}
}

class Operation {
	private static int ADD = 1;
	private static int SUB = 1;
	private static int MUL = 2;
	private static int DIV = 2;
	
	public static int getValue(String operation) {
		int result = 0;
		switch (operation) {
		case "+":
			result = ADD;
			break;
		case "-":
			result = SUB;
			break;
		case "*":
			result = MUL;
			break;
		case "/":
			result = DIV;
			break;
		default:
			System.out.println("�����ڸ������");
			break;
		}
		return result;
	}
}
