import java.util.Scanner;

abstract class membershipplan{
	private String plantype;
	private double registrationfees;
	private double baseprice;
	
	membershipplan(String plantype, double registrationfees, double baseprice){
		this.plantype = plantype;
		this.registrationfees = registrationfees;
		this.baseprice = baseprice;
	}
	
	public String getplantype(){
		return plantype;
	}
	
	public double getregistrationfees(){
		return registrationfees;
	}
	
	public double getbaseprice(){
		return baseprice;
	}
	
	public void setplantype(String plantype){
		this.plantype = plantype;
	}
	
	public void setregistrationfees(double registrationfees){
		this.registrationfees = registrationfees;
	}
	
	public void setbaseprice(double baseprice){
		this.baseprice = baseprice;
	}
	
	abstract public double calculateprice();
}

class groupsession extends membershipplan{
	public String paymentpackage;
	
	groupsession(String plantype, double registrationfees, double baseprice, String paymentpackage){
		super(plantype, registrationfees, baseprice);
		this.paymentpackage = paymentpackage;
	}
	
	public double calculateprice(){
		if(paymentpackage.equalsIgnoreCase("Annual")){
			double pricing = getregistrationfees() + (getbaseprice() * 12) * 0.8;
			return pricing;
		}
				
		else if(paymentpackage.equalsIgnoreCase("Monthly")){
			double pricing = getregistrationfees() + getbaseprice();
			return pricing;
		}
		
		else{
			return 0;
		}
	}
}

class personalsession extends membershipplan{
	personalsession(String plantype, double registrationfees, double baseprice){
		super(plantype, registrationfees, baseprice);
	}
	
	public double calculateprice(){
		double pricing = getregistrationfees() + (getbaseprice() * 30);
		return pricing;
	}
}

abstract class customer{
	public String customername;
	public String address;
	public int phonenumber;
	public int age;
	public int height;
	public int weight;
	
	customer(String customername, String address, int phonenumber, int age, int height, int weight){
		this.customername = customername; 
		this.address = address; 
		this.phonenumber = phonenumber;  
		this.age = age; 
		this.height = height; 
		this.weight = weight;
	}
	
	abstract public double calculateBMR();
	
	abstract public double calculateTDEE(double activitypoints);
}

class BMR extends customer{
	public String gender;
	double bmrvalue;
	
	BMR(String customername, String address, int phonenumber, int age, int height, int weight, String gender){
		super(customername, address, phonenumber, age, height, weight);
		this.gender = gender;
	}
	
	public double calculateBMR(){
		if(gender.equalsIgnoreCase("male")){
			bmrvalue = (10 * weight) + (6.25 * height) - (5 * age) + 5;
			return bmrvalue;
		}
		
		else if(gender.equalsIgnoreCase("female")){
			bmrvalue = (10 * weight) + (6.25 * height) - (5 * age) + 161;
			return bmrvalue;
		}
		
		else{
			return 0;
		}
	}
	
	public double calculateTDEE(double activitypoints){
		double tdeevalue = bmrvalue + activitypoints;
		return tdeevalue;
	}
}

class fitness{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Choose the Plantype(group / personal): ");
		String plantype = sc.nextLine();
		
		switch(plantype){
			case "group":
				System.out.print("Choose the Payment Package(Annual / Monthly): ");
				String paymentpackage = sc.nextLine();
				groupsession gs = new groupsession(plantype, 1000, 100,  paymentpackage);
				System.out.println("Your Group Session Price: " + gs.calculateprice());
				System.out.println("\n");
				break;
		
			case "personal":
				personalsession ps = new personalsession("single", 1000, 150);
				System.out.println("FEES: " + ps.calculateprice());
				System.out.println("\n");
				break;
				
			default:
				System.out.println("Invalid Data.");
				break;
		}
		
		System.out.print("Do You want to Continue with our GYM? (Y/N): ");
		String reply = sc.nextLine();
		
		if(reply.equalsIgnoreCase("N")){
			System.out.println("Thank You!");
		}
		
		else if(reply.equalsIgnoreCase("Y")){
			System.out.print("Enter Your Name: ");
			String customername = sc.nextLine();
			
			System.out.print("Enter Your Address: ");
			String address = sc.nextLine();
			
			System.out.print("Enter Your Phone Number: ");
			int phonenumber = sc.nextInt();
			
			System.out.print("Enter Your Age: ");
			int age = sc.nextInt();
			
			System.out.print("Enter Your Height(cm): ");
			int height = sc.nextInt();
			
			System.out.print("Enter Your Weight(kg): ");
			int weight = sc.nextInt();
			
			sc.nextLine();
			
			System.out.print("Enter Your Gender(male/female): ");
			String gender = sc.nextLine();
			
			System.out.println("\n");
			
			System.out.println("Choose Your Activity Level: ");
			System.out.println("1.2 - Sedentary");
			System.out.println("1.375 - Ligthly Active");
			System.out.println("1.55 - Moderately Active");
			System.out.println("1.725 - Very Active");
			System.out.println("1.9 - Extremely Active");
			System.out.print("Enter Activity Points: ");
			double activitypoints = sc.nextDouble();
			
			System.out.println("\n");
			
			BMR bm = new BMR(customername, address, phonenumber, age, height, weight, gender);
			System.out.println("Your Basal Metabolic Rate: " + bm.calculateBMR());
			System.out.println("Your Total Daily Energy Expenditure: " + bm.calculateTDEE(activitypoints));
		}
		
		else{
			System.out.println("Invalid Data.");
		}
	}
}