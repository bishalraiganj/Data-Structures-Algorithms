public class EmployeeDoublyLinkedList {






		private EmployeeNode head;
		private int size;
		private EmployeeNode tail;



		public void addToFront(Employee e) {

			EmployeeNode node = new EmployeeNode(e);
			node.setNext(head);
			if (size == 0) {
				tail = node;
			} else
			{
				head.setPrevious(node);
			}
			head = node;

			size++;

		}


		public void addToEnd(Employee e)
		{
			EmployeeNode node = new EmployeeNode(e);

			if(tail == null)
			{
				head = node;
			}
			else
			{
				tail.setNext(node);
				node.setPrevious(tail);
			}
			tail = node;
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
				System.out.print(current + (current.getNext()==null?"":" <=> "));
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

			if(head != null)
			{
				head.setPrevious(null);
				if(head.getNext() == null)
				{
					tail = head;
				}
			}
			else
			{
				tail = null;
			}

			size--;
			removedNode.setNext(null);
			return removedNode;
		}


		public EmployeeNode removeFromEnd()
		{

			if(isEmpty())
			{
				return null;
			}
			EmployeeNode removedNode = tail;

			if(tail.getPrevious() == null)
			{
				head = null;
			}
			else
			{
				tail.getPrevious().setNext(null);
			}
			tail = tail.getPrevious();
			size--;
			removedNode.setPrevious(null);
			return removedNode;




		}


	}





