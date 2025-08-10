public class EmployeeNode {


	private Employee employee;
	private EmployeeNode next;
	private EmployeeNode previous;


	public EmployeeNode(Employee e) {
		this.employee = e;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee e) {
		this.employee = e;
	}

	public EmployeeNode getNext() {
		return next;
	}

	public void setNext(EmployeeNode next) {
		this.next = next;
	}


	public EmployeeNode getPrevious() {
		return previous;
	}

	public void setPrevious(EmployeeNode previous) {
		this.previous = previous;
	}


	@Override
	public boolean equals(Object o)
	{
		if(this == o)
		{
			return true;
		}

		if( o == null || this.getClass() != o.getClass())
		{
			return false;
		}


		EmployeeNode e = (EmployeeNode) o;

		if(this.employee == e.getEmployee())
		{
			return true;
		}
		return false;
	}


	@Override
	public String toString()
	{
		return employee.toString();
	}



}
