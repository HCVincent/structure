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
//		List<String> list = getListString(sufixExpression);
//		System.out.println("rpnList:" + list);
//		int res = calculate(list);
//		System.out.println("res:" + res);
		String expression = "1+((2+3)*4)-5";//注意表达式 
		List<String> infixExpressionList = toInfixExpressionList(expression);
		System.out.println("中缀表达式对应的List=" + infixExpressionList); // ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
		List<String> suffixExpreesionList = parseSuffixExpressionList(infixExpressionList);
		System.out.println("后缀表达式对应的List" + suffixExpreesionList); //ArrayList [1,2,3,+,4,*,+,5,–] 
		
		System.out.printf("expression=%d", calculate(suffixExpreesionList)); // ?
		

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
	
	//将中缀表达式转成对应的List
	public static List<String> toInfixExpressionList(String s) {
		List<String> ls = new ArrayList<String>();
		int i = 0;
		String str;
		char c;
		do {
			// 如果c是一个非数字，就加入到ls
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
	
	//将得到的中缀表达式对应的List转成后缀表达式的List
	public static List<String> parseSuffixExpressionList(List<String> ls) {
		Stack<String> s1 = new Stack<String>();
		List<String> s2 = new ArrayList<String>();
		for(String item: ls) {
			if(item.matches("\\d+")) {
				s2.add(item);
			} else if(item.equals("(")){
				s1.push(item);
			} else if(item.equals(")")){
				//如果是右括号，则依次弹出是栈顶运算符，压入s2，直到遇到左括号为止
				while(!s1.peek().equals("(")) {
					s2.add(s1.pop());
				}
				s1.pop(); //消除小括号
			} else {
				//当item的优先级小于等于栈顶运算符优先级,将s1栈顶运算符弹出并加入到s2中，再与s1的栈顶运算符比较
				while(s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
					s2.add(s1.pop());
				}
				s1.push(item);
			}
		}	
			//将s1中剩余运算符依次弹出并加入s2
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
			System.out.println("不存在该运算符");
			break;
		}
		return result;
	}
}
