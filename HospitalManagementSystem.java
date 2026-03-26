abstract class patient{
	private String patientid;
	private String name;
	private int age;
	
	patient(String patientid, String name, int age){
		this.patientid = patientid;
		this.name = name;
		this.age = age;
	}
	
	public String getpatientid(){
		return patientid;
	}
	
	public String getname(){
		return name;
	}
	
	public int getage(){
		return age;
	}
	
	public void setpatientid(String patientid){
		this.patientid = patientid;
	}
	
	public void setname(String name){
		this.name = name;
	}
	
	public void setage(int age){
		this.age = age;
	}
	
	abstract public void displaydetails();
	
	abstract public double calculatebill();
}

class outpatient extends patient{
	private double consultantfee;
	private double testfee;
	
	outpatient(String patientid, String name, int age, double consultantfee, double testfee){
		super(patientid, name, age);
		this.consultantfee = consultantfee;
		this.testfee = testfee;
	}
	
	public void displaydetails(){
		System.out.println();
		System.out.println("-------------------OUTPATIENT DETAILS.-------------------");
		System.out.println("Patient ID: " + getpatientid());
		System.out.println("Patient Name: " + getname());
		System.out.println("Patient Age: " + getage());
	}
	
	public double calculatebill(){
		return consultantfee + testfee;
	}
}

class inpatient extends patient{
	private double roomcharge;
	private int daysadmit;
	
	inpatient(String patientid, String name, int age, double roomcharge, int daysadmit){
		super(patientid, name, age);
		this.roomcharge = roomcharge;
		this.daysadmit = daysadmit;
	}
	
	public void displaydetails(){
		System.out.println();
		System.out.println("-------------------INPATIENT DETAILS.-------------------");
		System.out.println("Patient ID: " + getpatientid());
		System.out.println("Patient Name: " + getname());
		System.out.println("Patient Age: " + getage());
	}
	
	public double calculatebill(){
		return roomcharge * daysadmit;
	}
}

class HospitalManagementSystem{
	public static void main(String [] args){
		outpatient op = new outpatient("PID101", "Saman", 40, 1500, 1000);
		op.displaydetails();
		System.out.println("Bill Amount: " + op.calculatebill());
		
		inpatient ip = new inpatient("PID105", "Kamal", 43, 2000, 10);
		ip.displaydetails();
		System.out.println("Bill Amount: " + ip.calculatebill());
	}
}