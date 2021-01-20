package day06.stack;

import java.util.Scanner;

public class ArrayStackDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayStack stack = new ArrayStack(4);
		String key = "";
		boolean loop = true;
		Scanner scanner = new Scanner(System.in);
		while(loop) {
			System.out.println("show");
			System.out.println("exit");
			System.out.println("pusy");
			System.out.println("pop");
			System.out.println("请输入你的选择");
			key = scanner.next();
			switch (key) {
			case "show": 
				stack.list();
				break;
			case "push":
				int value = scanner.nextInt();
				stack.push(value);
				break;
			case "pop":
				try {
					int res = stack.pop();
					System.out.printf("出栈的数据是%d\n", res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case "exit": 
				scanner.close();
				loop = false;
				break;
			default:
				break;
				
			}
		}
		System.out.println("程序退出");
		
	}

}

class ArrayStack {
	private int maxSize; //栈的大小
	private int[] stack;
	private int top = -1; //top表示栈顶
	
	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
	}
	
	//栈满
	public boolean isFull() {
		return top == maxSize - 1;
	}
	
	//栈空
	public boolean isEmpty() {
		return top == -1;
	}
	
	//入栈
	public void push(int value) {
		//先判断是否栈满
		if(isFull()) {
			System.out.println("满了");
			return;
		}
		top++;
		stack[top] = value;
	}
	
	//出栈
	public int pop() {
		//判断是否栈空
		if(isEmpty()) {
			throw new RuntimeException("栈空，没有数据");
		}
		int value = stack[top];
		top--;
		return value;
	}
	
	//遍历栈
	public void list() {
		if(isEmpty()) {
			System.out.println("栈空");
			return;
		}
		for(int i = top; i >= 0; i--) {
			System.out.printf("stack[%d]=%d\n", i, stack[i]);
		}
	}
}