package linkedList;

class ListNode {
	Object val;
	ListNode next;

	ListNode(Object x) {
		val = x;
		next = null;
	}
}

public class LinkedListOperation {
	
	public static boolean search(ListNode head, ListNode target) {
		ListNode pointer = head;
		while (pointer != null) {
			if (pointer == target) {
				return true;
			}
			pointer = pointer.next;
		}
		return false;
	}
	
	public static ListNode insert(ListNode head, ListNode target, int index) {
		ListNode pointer = new ListNode(head.val);
		ListNode fakehead = pointer;
		pointer.next = head;
		while (index >= 1) {
			pointer = pointer.next;
			index--;
		}
		ListNode post = pointer.next;
		pointer.next = target;
		target.next = post;
		return fakehead.next;
	}
	
	public static ListNode delete(ListNode head, ListNode target) {
		ListNode pointer = new ListNode(head.val);
		pointer.next = head;
		ListNode fakehead = pointer;
		while (pointer != null) {
			if (pointer.next == target) {
				pointer.next = pointer.next.next;
				break;
			}
			pointer = pointer.next;
		}
		return fakehead.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(5);
		head.next.next.next = new ListNode(8);
		System.out.println(search(head, head.next.next));
		ListNode cur = new ListNode(4);
		ListNode head2 = insert(head, cur, 2);
		ListNode backup = head2;
		while (head2 != null) {
			System.out.print(head2.val + " ");
			head2 = head2.next;
		}
		System.out.println(" ");
		ListNode head3 = delete(backup, cur);
		while (head3 != null) {
			System.out.print(head3.val + " ");
			head3 = head3.next;
		}
	}

}
