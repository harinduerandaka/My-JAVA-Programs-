abstract class appliance{
	private String appliancename;
	private String brand;
	private int powerconsumption;
	
	appliance(String appliancename, String brand, int powerconsumption){
		this.appliancename = appliancename;
		this.brand = brand; 
		this.powerconsumption = powerconsumption;
	}
	
	public String getappliancename(){
		return appliancename;
	}
	
	public String getbrand(){
		return brand;
	}
	
	public int getpowerconsumption(){
		return powerconsumption;
	}
	
	public void setappliancename(String appliancename){
		this.appliancename = appliancename;
	}
	
	public void setbrand(String brand){
		this.brand = brand;
	}
	
	public void setpowerconsumption(int powerconsumption){
		this.powerconsumption = powerconsumption;
	}
	
	abstract public void appliancedetails();
	
	abstract public double calculateenergyusage();
}

class light extends appliance{
	private int brightnesslevel;
	private int hours;
	
	light(String appliancename, String brand, int powerconsumption, int brightnesslevel, int hours){
		super(appliancename, brand, powerconsumption);
		this.brightnesslevel = brightnesslevel;
		this.hours = hours;
	}
	
	public void appliancedetails(){
		System.out.println("Energy Report for All Home Appliance.");
		System.out.println("Appliance Name: " + getappliancename());
		System.out.println("Appliance Brand: " + getbrand());
		System.out.println("Appliance Powerconsumption: " + getpowerconsumption());
		System.out.println("Brithnesslevel: " + brightnesslevel);
	}
	
	public double calculateenergyusage(){
		double energyusage = getpowerconsumption() * (brightnesslevel / 100.0) * hours / 1000.0;
		return energyusage;
	}
}

class fan extends appliance{
	private int speedlevel;
	private int hours;
	
	fan(String appliancename, String brand, int powerconsumption, int speedlevel, int hours){
		super(appliancename, brand, powerconsumption);
		this.speedlevel = speedlevel;
		this.hours = hours;
	}
	
	public void appliancedetails(){
		System.out.println("Energy Report for All Home Appliance.");
		System.out.println("Appliance Name: " + getappliancename());
		System.out.println("Appliance Brand: " + getbrand());
		System.out.println("Appliance Powerconsumption: " + getpowerconsumption());
		System.out.println("Speedlevel: " + speedlevel);
	}
	
	public double calculateenergyusage(){
		double energyusage = getpowerconsumption() * (speedlevel / 0.5) * hours / 1000.0;
		return energyusage;
	}
}

class airconditioner extends appliance{
	private int temparature;
	private int hours;
	
	airconditioner(String appliancename, String brand, int powerconsumption, int temparature, int hours){
		super(appliancename, brand, powerconsumption);
		this.temparature = temparature;
		this.hours = hours;
	}
	
	public void appliancedetails(){
		System.out.println("Energy Report for All Home Appliance.");
		System.out.println("Appliance Name: " + getappliancename());
		System.out.println("Appliance Brand: " + getbrand());
		System.out.println("Appliance Powerconsumption: " + getpowerconsumption());
		System.out.println("Temparature: " + temparature);
	}
	
	public double calculateenergyusage(){
		double energyusage = (getpowerconsumption() * hours) / 1000.0;
		return energyusage;
	}
}

class SmartHomeSystem{
	public double findprice(double totalenergyusage){
		double cost;
		double units = totalenergyusage;
		if(units > 0 && units < 30){
			cost = units * 1.90;
			return cost;
		}
		
		else if(units > 30 && units < 90){
			cost = (30 * 1.90) + ((units -30) * 4.50);
			return cost;
		}
		
		else{
			return 0;
		}
	}
	
	public static void main(String [] args){
		light li = new light("Light", "Philips", 100, 80, 10);
		li.appliancedetails();
		System.out.println("Energy Usage: " + li.calculateenergyusage());
		
		System.out.println();
		fan fn = new fan("Fan", "LG", 200, 5, 10);
		fn.appliancedetails();
		System.out.println("Energy Usage: " + fn.calculateenergyusage());
		
		System.out.println();
		airconditioner ar = new airconditioner("Airconditioner", "Samsung", 500, 20, 10);
		ar.appliancedetails();
		System.out.println("Energy Usage: " + ar.calculateenergyusage());
		
		System.out.println();
		double totalenergyusage = li.calculateenergyusage() + fn.calculateenergyusage() + ar.calculateenergyusage();
		System.out.println("Total Energy Consumption: " + totalenergyusage);
		
		SmartHomeSystem sm = new SmartHomeSystem();
		System.out.println("Total Cost for Day: " + sm.findprice(totalenergyusage));
	}
}