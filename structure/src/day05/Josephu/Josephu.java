package day05.Josephu;

public class Josephu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
		circleSingleLinkedList.addBoy(25);
		circleSingleLinkedList.showBoy();
		circleSingleLinkedList.countBoy(1, 2, 25);
	}

}

//����һ�����ε�������
class CircleSingleLinkedList{
	//����һ��first�ڵ㣬��ǰû�б��
	private Boy first = new Boy(-1);
	//���С���ڵ㣬����һ����������
	public void addBoy(int nums) {
		//��nums������У��
		if (nums < 1) {
			System.out.println("nums��ֵ����ȷ");
			return;
		}
		Boy curBoy = null; // ����ָ�룬����������������
		//ʹ��for��������������
		for(int i = 1; i <= nums; i++) {
			Boy boy = new Boy(i);
			if(i == 1) {
				first = boy;
				first.setNext(first);
				curBoy = first;
			} else {
				curBoy.setNext(boy);
				boy.setNext(first);
				curBoy = boy;
			}
		}
	}
	//������ǰ��������
	public void showBoy(){
		if(first == null) {
			System.out.println("��");
			return;
		}
		Boy curBoy = first;
		while(true) {
			System.out.printf("��ǰС�����Ϊ%d\n",curBoy.getNo());
			if(curBoy.getNext() == first) { //�������
				break;
			}
			curBoy = curBoy.getNext();  //����
		}
	}
	
	//�����û������룬�������Ȧ��˳��
	/**
	 * @param startNo  �ӵڼ���С����ʼ��
	 * @param countNum ������
	 * @param nums	   ��ʼ״̬С������
	 */
	public void countBoy(int startNo, int countNum, int nums) {
		//�ȶ����ݽ���У��
		if(first == null || startNo < 1 || startNo > nums) {
			System.out.println("������������");
			return;
		}
		//��������ָ�룬����С����Ȧ
		Boy helper = first;
		while(true) {
			if(helper.getNext() == first) {
				break;
			}
			helper = helper.getNext();
		}
		//С������ǰ������first��helperͬʱ�ƶ�k-1��
		for(int j = 0; j < startNo - 1; j++) {
			first = first.getNext();
			helper = helper.getNext();
		}
		
		//��С������ʱ����first��helperͬʱ�ƶ�m-1�Σ�Ȼ���Ȧ
		//ֱ��ֻʣ��һ���ڵ�
		while(true) {
			if(helper == first) {
				break;
			}
			for(int j = 0; j < countNum - 1; j++) {
				first = first.getNext();
				helper = helper.getNext();
			}
			System.out.printf("%d��С����Ȧ\n", first.getNo());
			first = first.getNext();
			helper.setNext(first);
		}
		System.out.printf("�������Ȧ�е�С�����Ϊ%d\n", first.getNo());
	}
}

class Boy {
	private int no;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	private Boy next;
	public Boy getNext() {
		return next;
	}
	public void setNext(Boy next) {
		this.next = next;
	}
	public Boy (int no) {
		this.no = no;
	}
}
