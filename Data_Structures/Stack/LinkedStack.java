package Stack;

import java.util.LinkedList;
import java.util.ListIterator;

public class   LinkedStack<T extends Employee> {


	private LinkedList<T> stack = new LinkedList<>();

	public void push(T  e)
	{
		stack.push(e);
	}

	public T pop()
	{
		return stack.pop();
	}

	public T peek()
	{
		return stack.peek();
	}

	public boolean isEmpty()
	{
		return stack.isEmpty();
	}

	public void printStack()
	{

		ListIterator<T> iterator = stack.listIterator();

		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}

	}

}
