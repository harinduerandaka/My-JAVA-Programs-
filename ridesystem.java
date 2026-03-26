import java.util.Scanner;

abstract class ride{
	protected String sourcelocation;
	protected String destinationlocation;
	protected double distanceinkm;
	
	ride(String sourcelocation, String destinationlocation, double distanceinkm){
		this.sourcelocation = sourcelocation;
		this.destinationlocation = destinationlocation;
		this.distanceinkm = distanceinkm;
	}
	
	abstract double calculatefare();
	
	abstract void displayridedetails();
}

class bikeride extends ride{
	bikeride(String sourcelocation, String destinationlocation, double distanceinkm){
		super(sourcelocation, destinationlocation, distanceinkm);
	}
	
	void displayridedetails(){
		System.out.println();
		System.out.println("--------Ride Details--------");
		System.out.println("From: " + sourcelocation);
		System.out.println("To: " + destinationlocation);
		System.out.println("Distance: " + distanceinkm);
	}
	
	double calculatefare(){
		return distanceinkm * 5;
	}
}

class carride extends ride{
	carride(String sourcelocation, String destinationlocation, double distanceinkm){
		super(sourcelocation, destinationlocation, distanceinkm);
	}
	
	void displayridedetails(){
		System.out.println();
		System.out.println("--------Ride Details--------");
		System.out.println("From: " + sourcelocation);
		System.out.println("To: " + destinationlocation);
		System.out.println("Distance: " + distanceinkm);
	}
	
	double calculatefare(){
		return distanceinkm * 10 + 50;
	}
}

class autoride extends ride{
	autoride(String sourcelocation, String destinationlocation, double distanceinkm){
		super(sourcelocation, destinationlocation, distanceinkm);
	}
	
	void displayridedetails(){
		System.out.println();
		System.out.println("--------Ride Details--------");
		System.out.println("From: " + sourcelocation);
		System.out.println("To: " + destinationlocation);
		System.out.println("Distance: " + distanceinkm);
	}
	
	double calculatefare(){
		return distanceinkm * 8;
	}
}

class customer{
	private String customername;
	private String phonenum;
	
	customer(String customername, String phonenum){
		this.customername = customername;
		this.phonenum = phonenum;
	}
	
	public String getcustomername(){
		return customername;
	}
	
	public String getphonenum(){
		return phonenum;
	}
	
	public void setcustomername(String customername){
		this.customername = customername;
	}
	
	public void setphonenum(String phonenum){
		this.phonenum = phonenum;
	}
	
	void customerdetails(){
		System.out.println();
		System.out.println("Customer Name: " + getcustomername());
		System.out.println("Phone: " + getphonenum());
	}
}

class ridesystem{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Customer Name: ");
		String customername = sc.nextLine();
		
		System.out.print("Enter Phone Number: ");
		String phonenum = sc.nextLine();
		
		System.out.print("Select Ride Type(bike/car/auto): ");
		String type = sc.nextLine();
		
		System.out.print("Enter Source Location: ");
		String sourcelocation = sc.nextLine();
		
		System.out.print("Enter Destination Location: ");
		String destinationlocation = sc.nextLine();
		
		System.out.print("Enter Distance: ");
		double distanceinkm = sc.nextDouble();
		
		customer cs = new customer(customername, phonenum);
		cs.customerdetails();
		
		switch(type){
			case "bike":
				bikeride br = new bikeride(sourcelocation, destinationlocation, distanceinkm);
				br.displayridedetails();
				System.out.println("Ride Type: " + type);
				System.out.println("Fare: " + br.calculatefare());
				break;
				
			case "car":
				carride cr = new carride(sourcelocation, destinationlocation, distanceinkm);
				cr.displayridedetails();
				System.out.println("Ride Type: " + type);
				System.out.println("Fare: " + cr.calculatefare());
				break;
				
			case "auto":
				autoride ar = new autoride(sourcelocation, destinationlocation, distanceinkm);
				ar.displayridedetails();
				System.out.println("Ride Type: " + type);
				System.out.println("Fare: " + ar.calculatefare());
				break;
			
			default:
				System.out.println("Invalid Type!");
				break;
		}
	}
}