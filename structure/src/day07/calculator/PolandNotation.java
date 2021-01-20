package day07.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {

	public static void main(String[] args) {
		// 定义逆波兰表达式
		// 为方便，数字和符号用空格隔开
		String sufixExpression = "30 4 + 5 * 6 -";
		// 将字符串放到ArrayList中
		// 将ArrayList传递一个方法，遍历，配合栈完成计算
		List<String> list = getListString(sufixExpression);
		System.out.println("rpnList:" + list);
		int res = calculate(list);
		System.out.println("res:" + res);
		
	}

	// 将一个逆波兰表达式，依次将数据和运算符放入到ArrayList中
	public static List<String> getListString(String suffixExpression) {
		String[] split = suffixExpression.split(" ");
		List<String> list = new ArrayList<String>();
		for (String ele : split) {
			list.add(ele);
		}
		return list;
	}

	public static int calculate(List<String> ls) {
		// 创建给栈，只需要一个栈
		Stack<String> stack = new Stack<String>();
		for (String item : ls) {
			if (item.matches("\\d+")) { // 匹配多位数
				stack.push(item);
			} else {
				// pop出两个数，运算后入栈
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
					throw new RuntimeException("运算符有误");
				}
				stack.push("" + res);
			}
		}
		// 最后留在stack中的是运算结果
		return Integer.parseInt(stack.pop());
	}
}
