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

//创建一个环形单向链表
class CircleSingleLinkedList{
	//创建一个first节点，当前没有编号
	private Boy first = new Boy(-1);
	//添加小孩节点，构建一个环形链表
	public void addBoy(int nums) {
		//对nums做数据校验
		if (nums < 1) {
			System.out.println("nums的值不正确");
			return;
		}
		Boy curBoy = null; // 辅助指针，帮助构建环形链表
		//使用for来创建环形链表
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
	//遍历当前环形链表
	public void showBoy(){
		if(first == null) {
			System.out.println("无");
			return;
		}
		Boy curBoy = first;
		while(true) {
			System.out.printf("当前小孩编号为%d\n",curBoy.getNo());
			if(curBoy.getNext() == first) { //遍历完毕
				break;
			}
			curBoy = curBoy.getNext();  //后移
		}
	}
	
	//根据用户的输入，计算出出圈的顺序
	/**
	 * @param startNo  从第几个小孩开始数
	 * @param countNum 数几下
	 * @param nums	   初始状态小孩个数
	 */
	public void countBoy(int startNo, int countNum, int nums) {
		//先对数据进行校验
		if(first == null || startNo < 1 || startNo > nums) {
			System.out.println("参数输入有误");
			return;
		}
		//创建辅助指针，帮助小孩出圈
		Boy helper = first;
		while(true) {
			if(helper.getNext() == first) {
				break;
			}
			helper = helper.getNext();
		}
		//小孩报数前，先让first和helper同时移动k-1次
		for(int j = 0; j < startNo - 1; j++) {
			first = first.getNext();
			helper = helper.getNext();
		}
		
		//当小孩报数时，让first和helper同时移动m-1次，然后出圈
		//直到只剩下一个节点
		while(true) {
			if(helper == first) {
				break;
			}
			for(int j = 0; j < countNum - 1; j++) {
				first = first.getNext();
				helper = helper.getNext();
			}
			System.out.printf("%d号小孩出圈\n", first.getNo());
			first = first.getNext();
			helper.setNext(first);
		}
		System.out.printf("最后留在圈中的小孩编号为%d\n", first.getNo());
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
