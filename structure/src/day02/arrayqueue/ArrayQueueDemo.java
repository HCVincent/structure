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
				System.out.println("输出一个数");
				int value = scanner.nextInt();
				queue.addQueue(value);
				break;
			case 'g':
				try {
					int res = queue.getQueue();
					System.out.printf("取出的数据是%d\n",res);
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'h':
				try {
					int res = queue.headQueue();
					System.out.printf("取出的队头是%d\n",res);
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
		front = -1; //指向队列头部，分析出front是指向队列头的前一个位置
		rear = -1; //指向队列尾，指向队列尾的数据（即为队列最后一个数据）
	}
	
	public boolean isFull() {
		return rear == maxSize - 1;
	}
	
	public boolean isEmpty() {
		return rear == front;
	}
	
	public void addQueue(int n) {
		if(isFull()) {
			System.out.println("满了，不能加");
			return;
		}
		rear++;
		arr[rear] = n;
	}
	
	public int getQueue() {
		if(isEmpty()) {
			throw new RuntimeException("队列空，不能取数据");
		}
		front++;
		return arr[front];
	}
	
	public void showQueue() {
		if(isEmpty()) {
			System.out.println("空的");
			return;
		}
		for(int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%d\n", i, arr[i]);
		}
	}
	
	public int headQueue() {
		if(isEmpty()) {
			throw new RuntimeException("空的");
		}
		
		return arr[front+1];
	}
}