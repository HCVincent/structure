package day03.singlelinkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeroNode hero1 = new HeroNode(1, "�ν�", "��ʱ��");
		HeroNode hero2 = new HeroNode(2, "¬����", "������");
		HeroNode hero3 = new HeroNode(3, "����", "�Ƕ���");
		HeroNode hero4 = new HeroNode(4, "�ֳ�", "����ͷ");
		
		SingleLinkedList singleLinkedList = new SingleLinkedList();
//		singleLinkedList.add(hero1);
//		singleLinkedList.add(hero4);
//		singleLinkedList.add(hero3);
//		singleLinkedList.add(hero2);
		
		singleLinkedList.addByOrder(hero1);
		singleLinkedList.addByOrder(hero4);
		singleLinkedList.addByOrder(hero2);
		singleLinkedList.addByOrder(hero3);
		singleLinkedList.update(new HeroNode(2, "1","2"));
		singleLinkedList.list();
		singleLinkedList.del(2);
		singleLinkedList.list();
	}
	

}
//����SingleLinkedList ����Ӣ��
class SingleLinkedList {
	//�ȳ�ʼ��һ��ͷ�ڵ㣬ͷ�ڵ㲻Ҫ��������ž��������
	private HeroNode head = new HeroNode(0, "", "");
	public HeroNode getHead() {
		return head;
	}

	//��ӽڵ㵽��������
	public void add(HeroNode heroNode) {
		HeroNode temp = head;
		while(true) {
			if(temp.next == null) {
				break;
			}
			temp = temp.next;
		}
		temp.next = heroNode;
	}
	
	public void list() {
		if(head.next == null) {
			System.out.println("�յ�");
			return;
		}
		HeroNode temp = head.next;
		while(true) {
			if(temp == null) {
				break;
			}
			System.out.println(temp);
			temp = temp.next;
		}
	} 
	
	public void addByOrder(HeroNode heroNode) {
		HeroNode temp = head;
		boolean flag = false;
		while(true) {
			if(temp.next == null) {
				break;
			}
			if(temp.next.no > heroNode.no) {
				break;
			} else if(temp.next.no == heroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if(flag) {
			System.out.println("%d��Ӣ���Ѿ�����" + heroNode.no);
		} else {
			heroNode.next = temp.next;
			temp.next = heroNode;
		}
		
	}
	
	public void update(HeroNode newHeroNode) {
		if(head.next == null) {
			System.out.println("����Ϊ��");
			return;
		}
		HeroNode temp = head.next;
		boolean flag = false;
		while(true) {
			if(temp == null) {
				break;
			}
			if(temp.no == newHeroNode.no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if(flag) {
			temp.name = newHeroNode.name;
			temp.nickname = newHeroNode.nickname;
		} else {
			System.out.println("û�����Ӣ��");
		}
	}
	
	public void del(int no) {
		HeroNode temp = head;
		boolean flag = false;
		while(true) {
			if(temp.next == null) {
				break;
			}
			if(temp.next.no == no) {
				flag = true;
				break;
			}
			temp = temp.next;
		}
		if(flag) {
			temp.next = temp.next.next;
		} else {
			System.out.println("������");
		}
	}
	
	public static int getLength(HeroNode head) {
		if(head.next == null) {
			return 0;
		}
		int length = 0;
		HeroNode cur = head.next;
		while(cur != null) {
			length++;
			cur = cur.next;
		}
		return length;
	}
	
	//���ҵ������еĵ�����K���ڵ㡾���������⡿
	//1.��дһ����������head�ڵ㣬ͬʱ����һ��index
	//2.index��ʾ�ǵ�����index���ڵ�
	//3.�Ȱ������ͷ��β�������õ�������
	//4.��ͷ�����ڣ�size-index����
	public static HeroNode findLastIndexNode(HeroNode head, int index) {
		if(head.next == null) {
			return null;
		}
		int size = getLength(head);
		if(index <= 0 || index > size) {
			return null;
		}
		HeroNode cur = head.next;
		for(int i = 0; i < size - index; i++) {
			cur = cur.next;
		}
		return cur;
	}
	
	//��ת��������Ѷ�����⡿
	public static void reverseList(HeroNode head) {
		//�����ǰ����Ϊ�գ�����ֻ��һ���ڵ㣬���跴ת
		if(head.next == null || head.next.next == null) {
			return;
		}
		HeroNode cur = head.next;
		HeroNode next = null;
		HeroNode reverseHead = new HeroNode(0, "", "");
		while(cur != null) {
			next = cur.next;
			cur.next = reverseHead.next;
			reverseHead.next = cur;
			cur = next;
		}
		head.next = reverseHead.next;
		
	}
	
	//�����ӡ���ٶ������⡿
	//��ʽ1.��ת��������ӡ���ƻ���ԭ���ṹ������ȡ
	//��ʽ2.ջ
	public static void reversePrint(HeroNode head) {
		if(head.next == null) {
			return;
		}
		Stack<HeroNode> stack = new Stack<HeroNode>();
		HeroNode cur = head.next;
		while(cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		while(stack.size() > 0) {
			System.out.println(stack.pop());
		}
	}
	//��ʽ3.�ݹ�
	// �����ӡ
    private static void printInorder(HeroNode n) {
        if (n == null) return;
        System.out.println(n);
        printInorder(n.next);
    }
    // �����ӡ
    private static void printReverse(HeroNode n) {
        if (n == null) return;
        printReverse(n.next);
        System.out.println(n);
    }
    
    //�κ���ϰ��:�ϲ�������������
    private static NHeroNode merge(NHeroNode n1, NHeroNode n2) {
    	NHeroNode dummy = new NHeroNode(-1);
    	NHeroNode pre = dummy;
        while (n1 != null && n2 != null) {
            if (n1.value <= n2.value) {
                pre.next = n1;
                n1 = n1.next;
            } else {
                pre.next = n2;
                n2 = n2.next;
            }
            pre = pre.next;
        }
        if (n1 == null) pre.next = n2;
        else pre.next = n1;
        return dummy.next;
    }
}

class NHeroNode {
	public int value;
	public NHeroNode next;
	public NHeroNode(int value) {
		this.value = value;
	}
}
//����HeroNode��ÿ��HeroNode�������һ���ڵ�
class HeroNode {
	public int no;
	public String name;
	public String nickname;
	public HeroNode next;
	
	public HeroNode(int no, String name, String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}
	
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + "]";
	}
	


}
