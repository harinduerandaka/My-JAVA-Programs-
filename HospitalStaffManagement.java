interface medicalstaff{
	double calculatesalary();
	
	void displaydetails();
}

class doctor implements medicalstaff{
	String staffid;
	String name;
	String specialization;
	double consultationfee;
	
	doctor(String staffid, String name, String specialization, double consultationfee){
		this.staffid = staffid;
		this.name = name;
		this.specialization = specialization;
		this.consultationfee = consultationfee;
	}
	
	public double calculatesalary(){
		return consultationfee * 20;
	}
	
	public void displaydetails(){
		System.out.println();
		System.out.println("------------Details of Doctor.------------");
		System.out.println("Staff ID: " + staffid);
		System.out.println("Doctor: " + name);
		System.out.println("Specialization To: " + specialization);
	}
}

class nurse implements medicalstaff{
	String staffid;
	String name;
	String ward;
	double salary;
	
	nurse(String staffid, String name, String ward, double salary){
		this.staffid = staffid;
		this.name = name;
		this.ward = ward;
		this.salary = salary;
	}
	
	public double calculatesalary(){
		return salary;
	}
	
	public void displaydetails(){
		System.out.println();
		System.out.println("------------Details of Nurse.------------");
		System.out.println("Staff ID: " + staffid);
		System.out.println("Nurse: " + name);
		System.out.println("Ward: " + ward);
	}
}

class HospitalStaffManagement{
	public static void main(String [] args){
		doctor ds = new doctor("d10", "Priyankara", "Eyes", 1000);
		ds.displaydetails();
		System.out.println("Salary is:" + ds.calculatesalary());
		
		nurse ns = new nurse("n120", "nurse", "E10", 43000);
		ns.displaydetails();
		System.out.println("Salary is:" + ns.calculatesalary());
	}
}