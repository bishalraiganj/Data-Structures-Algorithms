public class SinglyLinkedList<T>{

	GenericNode<T> head ;


	public void addToFront(T item)
	{

		GenericNode<T> newNode = new GenericNode<>(item);
		if(head==null)
		{
			head=item;
		}


	}







}
