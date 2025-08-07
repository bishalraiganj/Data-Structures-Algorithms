public class EmployeeNode {


	private Employee employee;
	private EmployeeNode next;

	public EmployeeNode(Employee e)
	{
		this.employee=e;
	}

	public Employee getEmployee()
	{
		return employee;
	}
	public void setEmployee(Employee e)
	{
		this.employee=e;
	}
	public EmployeeNode getNext()
	{
		return next;
	}
	public void setNext(EmployeeNode next)
	{
		this.next=next;
	}

	@Override
	public String toString()
	{
		return employee.toString();
	}



}
