package Stack;

import  Stack.Employee;

import java.util.EmptyStackException;


public class ArrayStack {



	private Employee[] stack;
	private int top;


	public ArrayStack(int capacity)
	{
		this.stack = new Employee[capacity];
	}


	public void push(Employee e)
	{
		if(top == stack.length)
		{

			Employee[] temp  = new Employee[stack.length * 2];

			System.arraycopy(temp, 0 ,stack,0,temp.length);
			stack = temp;
		}

		stack[top++] = e;

	}

	public Employee pop()
	{
		//even without 'this' keyword it works,
		//because java has auto-resolve to look for instance members(members on the object itself)
		// like in other programming languages it is necessary to use 'this'
		// keyword in order to distinguish between local variables and instance or static ones
		if(this.isEmpty())
		{
			throw new EmptyStackException();
		}

		Employee e = stack[--top];
		stack[top] = null;
		return e;

	}

	public Employee peek()
	{
		if(this.isEmpty())
		{
			throw new EmptyStackException();
		}

		return stack[top - 1 ];
	}

	public int size()
	{
		return top;
	}

	public boolean isEmpty()
	{
		return top == 0;
	}


	public void printStack()
	{

		for(int  i = top; i>0 ; i--)
		{

			System.out.println(stack[i - 1]);

		}



	}


}
