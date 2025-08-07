public class EmployeeLinkedList {



	private EmployeeNode head;
	private int size;

	public void addToFront(Employee e)
	{

		EmployeeNode node = new EmployeeNode(e);
		node.setNext(head);
		head=node;
		size++;

	}

	public boolean isEmpty()
	{
		return head == null;
	}


	public int getSize()
	{
		return size;
	}


	public void printList()
	{
		EmployeeNode current = head;

		System.out.print("Head -> ");

		while(current!=null)
		{
			System.out.print(current + (current.getNext()==null?"":", "));
			current = current.getNext();
		}
		System.out.println();



	}

	public EmployeeNode removeFromFront()
	{
		if(this.isEmpty())
		{
			return null;
		}

		EmployeeNode removedNode = head;
		head = head.getNext();
		size--;
		removedNode.setNext(null);
		return removedNode;
	}


}
