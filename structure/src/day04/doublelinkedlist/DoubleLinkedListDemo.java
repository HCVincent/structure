package day04.doublelinkedlist;

public class DoubleLinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// �ȴ����ڵ�
		HeroNode2 hero1 = new HeroNode2(1, "�ν�", "��ʱ��");
		HeroNode2 hero2 = new HeroNode2(2, "¬����", "������");
		HeroNode2 hero3 = new HeroNode2(3, "����", "�Ƕ���");
		HeroNode2 hero4 = new HeroNode2(4, "�ֳ�", "����ͷ");
		DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
		doubleLinkedList.addByOrder(hero4);
		doubleLinkedList.addByOrder(hero2);
		doubleLinkedList.addByOrder(hero1);
		doubleLinkedList.addByOrder(hero3);
		doubleLinkedList.list();
	}

}

class HeroNode2 {
	public int no;
	public String name;
	public String nickname;
	public HeroNode2 next;
	public HeroNode2 pre;

	public HeroNode2(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}

	@Override
	public String toString() {
		return "HeroNode2 [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
}

class DoubleLinkedList {
	private HeroNode2 head = new HeroNode2(0, "", "");

	public HeroNode2 getHead() {
		return head;
	}

	public void list() {
		if (head.next == null) {
			System.out.println("�յ�");
			return;
		}
		HeroNode2 temp = head.next;
		while (true) {
			if (temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
	}

	// ���һ���ڵ㵽˫����������
	public void add(HeroNode2 heroNode) {
		HeroNode2 temp = head;
		while (true) {
			if (temp.next == null) {
				break;
			}
			temp = temp.next;

		}
		temp.next = heroNode;
		heroNode.pre = temp;
	}

	public void update(HeroNode2 newHeroNode) {
		if (head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		HeroNode2 temp = head.next;
		boolean flag = false;
		while (true) {
			if (temp == null) {
				break;
			}
			if (temp.no == newHeroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.name = newHeroNode.name;
			temp.nickname = newHeroNode.nickname;
		} else {
			System.out.println("û�����Ӣ��");
		}
	}

	public void del(int no) {
		HeroNode2 temp = head;
		boolean flag = false;
		while (true) {
			if (temp == null) {
				break;
			}
			if (temp.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			temp.pre.next = temp.next;
			if (temp.next != null) {
				temp.next.pre = temp.pre;
			}

		} else {
			System.out.println("������");
		}
	}

	// ���ձ�������
	public void addByOrder(HeroNode2 heroNode) {
		HeroNode2 temp = head;
		boolean flag = false;
		while (true) {
			if (temp.next == null) {
				break;
			}
			if (temp.next.no > heroNode.no) {
				break;
			} 
			if (temp.next.no == heroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if (flag) {
			System.out.println("%d��Ӣ���Ѿ�����" + heroNode.no);
		}  else {
			heroNode.next = temp.next;
			heroNode.pre = temp;
			temp.next = heroNode;
			if(heroNode.next != null) {
				heroNode.next.pre = heroNode;
			}
		}

	}
}
