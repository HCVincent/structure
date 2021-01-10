package day03.singlelinkedlist;

import java.util.Stack;

public class SingleLinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
		HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
		HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
		HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
		
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
//定义SingleLinkedList 管理英雄
class SingleLinkedList {
	//先初始化一个头节点，头节点不要动，不存放具体的数据
	private HeroNode head = new HeroNode(0, "", "");
	public HeroNode getHead() {
		return head;
	}

	//添加节点到单项链表
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
			System.out.println("空的");
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
			System.out.println("%d号英雄已经存在" + heroNode.no);
		} else {
			heroNode.next = temp.next;
			temp.next = heroNode;
		}
		
	}
	
	public void update(HeroNode newHeroNode) {
		if(head.next == null) {
			System.out.println("链表为空");
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
			System.out.println("没有这个英雄");
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
			System.out.println("不存在");
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
	
	//查找单链表中的倒数第K个节点【新浪面试题】
	//1.编写一个方法接收head节点，同时接收一个index
	//2.index表示是倒数第index个节点
	//3.先把链表从头到尾遍历，得到链表长度
	//4.从头遍历第（size-index）个
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
	
	//反转单链表【腾讯面试题】
	public static void reverseList(HeroNode head) {
		//如果当前链表为空，或者只有一个节点，无需反转
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
	
	//逆序打印【百度面试题】
	//方式1.反转单链表后打印，破坏了原来结构，不可取
	//方式2.栈
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
	//方式3.递归
	// 正序打印
    private static void printInorder(HeroNode n) {
        if (n == null) return;
        System.out.println(n);
        printInorder(n.next);
    }
    // 逆序打印
    private static void printReverse(HeroNode n) {
        if (n == null) return;
        printReverse(n.next);
        System.out.println(n);
    }
    
    //课后练习题:合并两个有序链表
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
//定义HeroNode，每个HeroNode对象就是一个节点
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
