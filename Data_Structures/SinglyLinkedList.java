public class SinglyLinkedList<T extends Comparable<T>>{

	GenericNode<T> head ;


	public void addToFrontSorted(T item)
	{

		GenericNode<T> newNode = new GenericNode<>(item);
		if(head==null)
		{
			head = newNode;
			return; //Returning control immediately
		}

		GenericNode<T> tempNode = head;
		while(tempNode!=null && tempNode.next!=null && !(tempNode.getNext().getCurrent().compareTo(item)>=0))
		{
			tempNode = tempNode.next;
		}



		//TempNode is not the only node in the list and is the smaller one
		if(tempNode != null && tempNode.getNext()!=null &&  tempNode.getNext().getCurrent().compareTo(item)>=0)
		{
			if(tempNode.getNext().getCurrent().compareTo(item)==0)
			{

			GenericNode<T> nextNode = tempNode.getNext().getNext();

				newNode.setNext(nextNode);
				tempNode.getNext().setNext(newNode);
				return;
			}else
			{
				GenericNode<T> nNode =tempNode.getNext();
				tempNode.setNext(newNode);
				newNode.setNext(nNode);

			  return;
			}
		}
		else {

			if(tempNode.getCurrent().compareTo(item)>0) {
				head=newNode;
				newNode.setNext(tempNode);
			}
			else
			{
				tempNode.setNext(newNode);
			}
		}



	}



	public String printList()
	{
		StringBuilder s =new StringBuilder();


		GenericNode<T> tempNode = head;
		while(tempNode!=null )
		{
			s.append(   (head == tempNode ? "Head ->" +  tempNode.toString() : tempNode.toString()));

			s.append( tempNode.getNext()==null ? "": " -> ");
			tempNode = tempNode.getNext();

		}
		return s.toString();
	}









}
