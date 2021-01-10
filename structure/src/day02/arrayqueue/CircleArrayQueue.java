package day02.arrayqueue;

import java.util.Scanner;


public class CircleArrayQueue {
	public static void main(String[] args) {
		CircleArray queue = new CircleArray(4);//有一个无效位置
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

class CircleArray {
	private int maxSize;
	private int front;
	private int rear;
	private int[] arr;
	
	public CircleArray(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		front = 0; //指向队列头部，分析出front是指向队列头的第一个位置
		rear = 0; //指向队列尾，指向队列最后一个元素的后一个位置，因为希望空出一个位置
	}
	
	public boolean isFull() {
		return (rear + 1) % maxSize == front;
	}
	
	public boolean isEmpty() {
		return front == rear;
	}
	
	public void addQueue(int n) {
		if(isFull()) {
			System.out.println("满了，不能加");
			return;
		}
		
		arr[rear] = n;
		rear = (rear + 1) % maxSize;
	}
	
	public int getQueue() {
		if(isEmpty()) {
			throw new RuntimeException("队列空，不能取数据");
		}
		//1.把front对应的值保留到一个临时变量
		//2.将front后移
		//3.将临时变量返回
		int value = arr[front];
		front = (front + 1)% maxSize;
		return value;
	}
	//求出当前有几个有效元素
	public int size() {
		return (rear + maxSize - front) % maxSize;
	}
	public void showQueue() {
		if(isEmpty()) {
			System.out.println("空的");
			return;
		}
		for(int i = front; i < front + size(); i++) {
			System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
		}
	}
	
	public int headQueue() {
		if(isEmpty()) {
			throw new RuntimeException("空的");
		}
		
		return arr[front];
	}
}