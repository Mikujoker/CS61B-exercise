 /** An SLList is a list of integers, which hides the terrible truth
   * of the nakedness within. */
public class SLList {	
	private static class IntNode {
		public int item;
		public IntNode next;

		public IntNode(int i, IntNode n) {
			item = i;
			next = n;
			//System.out.println(size);
		}
	} 

	/* The first item (if it exists) is at sentinel.next. */
	private IntNode sentinel;
	private int size;

//	private static void lectureQuestion() {
//		SLList L = new SLList();
//		IntNode n = IntNode(5, null);
//	}

	/** Creates an empty SLList. */
	public SLList() {
		sentinel = new IntNode(63, null);
		size = 0;
	}

	public SLList(int x) {
		sentinel = new IntNode(63, null);
		sentinel.next = new IntNode(x, null);
		size = 1;
	}

	public SLList(int[] x){
		sentinel = new IntNode(63,null);
		int x_size = x.length;

		IntNode current = sentinel; // 从sentinel开始

		for (int i = 0; i < x_size; i++) {
			current.next = new IntNode(x[i], null);
			current = current.next; // 将current指向新节点
		}

		size = x_size;
	}

 	/** Adds x to the front of the list. */
 	public void addFirst(int x) {
 		sentinel.next = new IntNode(x, sentinel.next);
 		size = size + 1;
 	}

 	/** Returns the first item in the list. */
 	public int getFirst() {
 		return sentinel.next.item;
 	}

 	/** Adds x to the end of the list. */
 	public void addLast(int x) {
 		size = size + 1; 		

 		IntNode p = sentinel;

 		/* Advance p to the end of the list. */
 		while (p.next != null) {
 			p = p.next;
 		}

 		p.next = new IntNode(x, null);
 	}
	 /** Square the list when add new x*/
	 public void neo_addLast(int x) {
		 // 获取初始大小，只调用一次size()
		 int initialSize = size();

		 // 如果列表为空，直接添加新元素
		 if (initialSize == 0) {
			 addLast(x);
			 return;
		 }

		 IntNode p = sentinel.next;
		 int count = 0; // 跟踪已处理的节点数量

		 // 遍历列表，对每个节点进行平方处理
		 while (count < initialSize) {
			 // 创建一个新的节点，其值为当前节点值的平方，并将其插入到当前节点之后
			 IntNode squaredNode = new IntNode(p.item * p.item, p.next);
			 p.next = squaredNode;
			 p = squaredNode.next; // 移动到下一个原始节点

			 count++; // 更新已处理的节点数量
			 if (p == null) { // 如果到达列表末尾，跳出循环
				 break;
			 }
		 }

		 // 在列表末尾添加新元素
		 addLast(x);
	 }

	 /**  Merge the same item of the list, such as 1 → 1 → 2 → 3 becomes 2 → 2 → 3 which becomes 4 → 3*/
	 public void addAdjacent() {
		 IntNode current = sentinel.next; // 从第一个有效节点开始

		 while (current != null && current.next != null) { // 确保当前节点及其下一个节点不为空
			 if (current.item == current.next.item) { // 检查当前节点与下一个节点的值是否相同
				 current.item += current.next.item; // 将它们的值相加
				 current.next = current.next.next; // 删除下一个节点
				 size--; // 更新列表大小
			 } else {
				 current = current.next; // 如果当前节点与下一个节点的值不相同，移动到下一个节点
			 }
		 }
	 }
 	/** Returns the size of the list. */
 	public int size() {
 		return size;
 	}

	 /** Delete the first element of the list */
	 public void deleteFirst() {
		 sentinel.next = sentinel.next.next;
	 }

	public static void main(String[] args) {
 		/* Creates a list of one integer, namely 10 */
 		SLList L = new SLList();
 		L.addLast(20);
 		System.out.println(L.size());
 	}
}