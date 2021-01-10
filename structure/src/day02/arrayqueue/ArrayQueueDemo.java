package day02.arrayqueue;

import java.util.Scanner;

public class ArrayQueueDemo {
	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue(3);
		char key = ' ';
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while(loop) {
			System.out.println("s(show):");
			System.out.println("e(exit):");
			System.out.println("a(add):");
			System.out.println("g(get):");
			System.out.println("h(head):");
			key = scanner.next().charAt(0);
			switch(key) {
			case 's':
				queue.showQueue();
				break;
			case 'e':
				scanner.close();
				loop = false;
				break;
			case 'a':
				System.out.println("���һ����");
				int value = scanner.nextInt();
				queue.addQueue(value);
				break;
			case 'g':
				try {
					int res = queue.getQueue();
					System.out.printf("ȡ����������%d\n",res);
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'h':
				try {
					int res = queue.headQueue();
					System.out.printf("ȡ���Ķ�ͷ��%d\n",res);
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			default:
				break;
			}
		}
	}
}

class ArrayQueue{
	private int maxSize;
	private int front;
	private int rear;
	private int[] arr;
	
	public ArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		front = -1; //ָ�����ͷ����������front��ָ�����ͷ��ǰһ��λ��
		rear = -1; //ָ�����β��ָ�����β�����ݣ���Ϊ�������һ�����ݣ�
	}
	
	public boolean isFull() {
		return rear == maxSize - 1;
	}
	
	public boolean isEmpty() {
		return rear == front;
	}
	
	public void addQueue(int n) {
		if(isFull()) {
			System.out.println("���ˣ����ܼ�");
			return;
		}
		rear++;
		arr[rear] = n;
	}
	
	public int getQueue() {
		if(isEmpty()) {
			throw new RuntimeException("���пգ�����ȡ����");
		}
		front++;
		return arr[front];
	}
	
	public void showQueue() {
		if(isEmpty()) {
			System.out.println("�յ�");
			return;
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%d\n", i, arr[i]);
		}
	}
	
	public int headQueue() {
		if(isEmpty()) {
			throw new RuntimeException("�յ�");
		}
		
		return arr[front+1];
	}
}