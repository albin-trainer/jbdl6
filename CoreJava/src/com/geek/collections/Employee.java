package com.geek.collections;

public class Employee implements Comparable<Employee>{
	int eid;
	String ename;
	public Employee(int eid, String ename) {
		super();
		this.eid = eid;
		this.ename = ename;
	}
	public int hashCode() {
		System.out.println("***hashCode called***");
		return eid;
	}
	public boolean equals(Object obj) {
		System.out.println("***equals called ***");
		Employee e=(Employee)obj;
		if(this.eid==e.eid && this.ename.equals(e.ename))
			return true;
		return false;
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + "]";
	}
	@Override
	public int compareTo(Employee e) {
		if(this.eid<e.eid)
			 return 1;
		else if (this.eid>e.eid)
			return -1;
		return 0;
	}
	
	
}