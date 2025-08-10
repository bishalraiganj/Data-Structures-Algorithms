public class GenericNode <T>{

	T next;
	T current;
	T previous;


	public GenericNode(T obj)
	{
		this.current=obj;
	}

	public T getCurrent()
	{
		return current;
	}

	public T getNext()
	{
		return next;
	}

	public T getPrevious()
	{
		return previous;
	}

	public void setNext(T next)
	{
		this.next = next;
	}

	public void setPrevious(T previous)
	{
		this.previous = previous;
	}
}
