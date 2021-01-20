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
			System.out.println("���������ѡ��");
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
					System.out.printf("��ջ��������%d\n", res);
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
		System.out.println("�����˳�");
		
	}

}

class ArrayStack {
	private int maxSize; //ջ�Ĵ�С
	private int[] stack;
	private int top = -1; //top��ʾջ��
	
	public ArrayStack(int maxSize) {
		this.maxSize = maxSize;
		stack = new int[this.maxSize];
	}
	
	//ջ��
	public boolean isFull() {
		return top == maxSize - 1;
	}
	
	//ջ��
	public boolean isEmpty() {
		return top == -1;
	}
	
	//��ջ
	public void push(int value) {
		//���ж��Ƿ�ջ��
		if(isFull()) {
			System.out.println("����");
			return;
		}
		top++;
		stack[top] = value;
	}
	
	//��ջ
	public int pop() {
		//�ж��Ƿ�ջ��
		if(isEmpty()) {
			throw new RuntimeException("ջ�գ�û������");
		}
		int value = stack[top];
		top--;
		return value;
	}
	
	//����ջ
	public void list() {
		if(isEmpty()) {
			System.out.println("ջ��");
			return;
		}
		for(int i = top; i >= 0; i--) {
			System.out.printf("stack[%d]=%d\n", i, stack[i]);
		}
	}
}