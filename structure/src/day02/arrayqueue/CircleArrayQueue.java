package day02.arrayqueue;

import java.util.Scanner;


public class CircleArrayQueue {
	public static void main(String[] args) {
		CircleArray queue = new CircleArray(4);//��һ����Чλ��
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

class CircleArray {
	private int maxSize;
	private int front;
	private int rear;
	private int[] arr;
	
	public CircleArray(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		front = 0; //ָ�����ͷ����������front��ָ�����ͷ�ĵ�һ��λ��
		rear = 0; //ָ�����β��ָ��������һ��Ԫ�صĺ�һ��λ�ã���Ϊϣ���ճ�һ��λ��
	}
	
	public boolean isFull() {
		return (rear + 1) % maxSize == front;
	}
	
	public boolean isEmpty() {
		return front == rear;
	}
	
	public void addQueue(int n) {
		if(isFull()) {
			System.out.println("���ˣ����ܼ�");
			return;
		}
		
		arr[rear] = n;
		rear = (rear + 1) % maxSize;
	}
	
	public int getQueue() {
		if(isEmpty()) {
			throw new RuntimeException("���пգ�����ȡ����");
		}
		//1.��front��Ӧ��ֵ������һ����ʱ����
		//2.��front����
		//3.����ʱ��������
		int value = arr[front];
		front = (front + 1)% maxSize;
		return value;
	}
	//�����ǰ�м�����ЧԪ��
	public int size() {
		return (rear + maxSize - front) % maxSize;
	}
	public void showQueue() {
		if(isEmpty()) {
			System.out.println("�յ�");
			return;
		}
		for(int i = front; i < front + size(); i++) {
			System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
		}
	}
	
	public int headQueue() {
		if(isEmpty()) {
			throw new RuntimeException("�յ�");
		}
		
		return arr[front];
	}
}