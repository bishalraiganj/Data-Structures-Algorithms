package Stack;

public record Employee(String firstName, String lastName, int id)  implements Comparable<Employee> {




	@Override
	public int compareTo(Employee o)
	{

		if(this == o ||  ( this.id == o.id  && this.firstName.trim().equals(o.firstName.trim())) && this.lastName.trim().equals(o.lastName.trim()))
		{
			return 0;
		}
		else if(this.id() > o.id())
		{
			return 1;
		}
		else
		{
			return -1;
		}



	}

	@Override
	public boolean equals(Object o)
	{
		if( this == o)
		{
			return true;
		}

		if( o == null  || o.getClass() != this.getClass())
		{
			return false;
		}


		Employee e = (Employee) o;
		if(id != e.id || firstName !=e.firstName || lastName != e.lastName )
		{
			return false;
		}

		return true;
	}

	@Override
	public int hashCode()
	{
		int result = firstName.hashCode() + lastName.hashCode() + id;
		return result;
	}

	@Override
	public String toString()
	{
		return  "[%s %s %d]".formatted(firstName, lastName, id);
	}




}
