import java.util.Scanner;

abstract class vehicle{
	private int vid;
	private int year;
	private String model;
	private double rentalrate;
	private double mileagerate;
	
	vehicle(int vid, int year, String model, double rentalrate, double mileagerate){
		this.vid = vid;
		this.year = year;
		this.model = model;
		this.rentalrate = rentalrate;
		this.mileagerate = mileagerate;
	}
	
	public int getvid(){
		return vid;
	}
	
	public int getyear(){
		return year;
	}
	
	public String getmodel(){
		return model;
	}
	
	public double getrentalrate(){
		return rentalrate;
	}
	
	public double getmileagerate(){
		return mileagerate;
	}
	
	public void setvid(int vid){
		this.vid = vid;
	}
	
	public void setyear(int year){
		this.year = year;
	}
	
	public void setmodel(String model){
		this.model = model;
	}
	
	public void setrentalrate(double rentalrate){
		this.rentalrate = rentalrate;
	}
	
	public void setmileagerate(double mileagerate){
		this.mileagerate = mileagerate;
	}
	
	abstract public double calculaterentalcost(int days, int miles);
	
	abstract public void getvehicledetails();
}

class car extends vehicle{
	car(int vid, int year, String model, double rentalrate, double mileagerate){
		super(vid, year, model, rentalrate, mileagerate);
	}
	
	public double calculaterentalcost(int days, int miles){
		double basecost = getrentalrate() * days;
		double mileagecost = getmileagerate() * miles;
		return basecost + mileagecost;
	}
	
	public void getvehicledetails(){
		System.out.println("-----------------VEHICLE DETAILS.-----------------");
		System.out.println("VEHICLE ID: " + getvid());
		System.out.println("YEAR: " + getyear());
		System.out.println("VEHICLE MODEL: " + getmodel());
	}
}

class truck extends vehicle{
	truck(int vid, int year, String model, double rentalrate, double mileagerate){
		super(vid, year, model, rentalrate, mileagerate);
	}
	
	public double calculaterentalcost(int days, int miles){
		double basecost = getrentalrate() * days * 0.1;
		double mileagecost = getmileagerate() * miles * 0.15;
		return basecost + mileagecost;
	}
	
	public void getvehicledetails(){
		System.out.println("-----------------VEHICLE DETAILS.-----------------");
		System.out.println("VEHICLE ID: " + getvid());
		System.out.println("YEAR: " + getyear());
		System.out.println("VEHICLE MODEL: " + getmodel());
	}
}

class motorcycle extends vehicle{
	motorcycle(int vid, int year, String model, double rentalrate, double mileagerate){
		super(vid, year, model, rentalrate, mileagerate);
	}
	
	public double calculaterentalcost(int days, int miles){
		double basecost;
		
		if(days > 7){
			basecost = getrentalrate() * days * 0.2;
		}
		
		else{
			basecost = getrentalrate() * days;
		}
		
		double mileagecost = getmileagerate() * miles;
		return basecost + mileagecost;
	}
	
	public void getvehicledetails(){
		System.out.println("\n -----------------VEHICLE DETAILS.-----------------");
		System.out.println("VEHICLE ID: " + getvid());
		System.out.println("YEAR: " + getyear());
		System.out.println("VEHICLE MODEL: " + getmodel());
	}
}

class vehiclesys{
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("CHOOSE THE VEHICLE TYPE.");
		System.out.println("1. CAR");
		System.out.println("2. TRUCK");
		System.out.println("3. MOTORCYCLE");
		System.out.print("TYPE THE NUMBER: ");
		int vehicletype = sc.nextInt();
		
		System.out.print("ENTER RENTAL DAYS COUNT: ");
		int days = sc.nextInt();
		
		System.out.print("ENTER MILES TO DRIVE: ");
		int miles = sc.nextInt();
		
		switch(vehicletype){
			case 1:
				car cr = new car(101, 2014, "BMW-M3", 2500, 0.20);
				cr.getvehicledetails();
				System.out.println("RENTAL COST: " + cr.calculaterentalcost(days, miles));
				break;
				
			case 2:
				truck tr = new truck(102, 2016, "TOYATA", 3500, 0.30);
				tr.getvehicledetails();
				System.out.println("RENTAL COST: " + tr.calculaterentalcost(days, miles));
				break;
				
			case 3:
				motorcycle mr = new motorcycle(103, 2015, "HONDA DIO", 1000, 0.15);
				mr.getvehicledetails();
				System.out.println("RENTAL COST: " + mr.calculaterentalcost(days, miles));
				break;
				
			default:
				System.out.println("Invalid Data.");
				break;
		}
	}
}