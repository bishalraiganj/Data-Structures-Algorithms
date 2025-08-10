public class GenericNode <T>{

	GenericNode<T> next;
	T current;
	GenericNode<T> previous;


	public GenericNode(T obj)
	{
		this.current=obj;
	}

	public T getCurrent()
	{
		return current;
	}

	public GenericNode<T> getNext()
	{
		return next;
	}

	public GenericNode<T> getPrevious()
	{
		return previous;
	}

	public void setNext(GenericNode<T> next)
	{
		this.next = next;
	}

	public void setPrevious(GenericNode<T> previous)
	{
		this.previous = previous;
	}


	@Override
	public String toString()
	{
		return current.toString();
	}
}
