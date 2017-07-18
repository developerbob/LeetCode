
/**
 * You are given two non-empty linked lists representing two non-negative 
 * integers. The digits are stored in reverse order and each of their nodes 
 * contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except 
 * the number 0 itself.

 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * 
 * Input: (2 -> 4 -> 3) + (7 -> 0 -> 8)
 * Output: 9 -> 4 -> 1 -> 1
 * 
 * Bob Yang 2017-07-09
 */
public class Algo_2 {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		/**
		 * Understanding: dummyHead is good idea because it make sure the
		 * first node is not null. Otherwise it needs more code to handle
		 * the case that the first node is null. 
		 */
		ListNode dummyHead = new ListNode(0);  
		ListNode prev = dummyHead;
		int carry = 0;
		while (l1 != null && l2 != null) {
			int sum = carry;
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			carry = sum / 10;
			prev.next = new ListNode(sum % 10);
			prev = prev.next;
			/**
			 * Below is the code not using dummyHead.
			 * 
			 * if (ret != null) {
			 *     ret = new ListNode(sum % 10);
			 *     prev = ret;
			 * } else {
			 *     prev.next = new ListNode(sum % 10);
			 *     prev = prev.next;
			 * }
			 */
		}
		if (carry > 0) {
			prev.next = new ListNode(carry);
		}
		/**
		 * Here is how to use dummyHead.
		 */
		return dummyHead.next;
    }
	
	public ListNode createl1() {
		ListNode l1 = new ListNode(2);
		ListNode n = new ListNode(4);
		l1.next = n;
		n = new ListNode(3);
		l1.next.next = n;
		return l1;
	}
	
	public ListNode createl2() {
		ListNode l2 = new ListNode(5);
		ListNode n = new ListNode(6);
		l2.next = n;
		n = new ListNode(4);
		l2.next.next = n;
		return l2;
	}
	
	public static void main(String[] args) {
		Algo_2 a = new Algo_2();
		ListNode l1 = a.createl1();
		ListNode l2 = a.createl2();
		ListNode ret = a.addTwoNumbers(l1, l2);
		while (ret != null) {
			System.out.println(ret.val);
			ret = ret.next;
		}
	}
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
}
