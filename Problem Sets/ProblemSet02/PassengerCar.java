// Collin Blinder
// cblinder@students.pitzer.edu
public class PassengerCar extends Car{

	private int numPassengers;
	private int numDoors;
	private String transmissionType;

	public PassengerCar(String make, 
						String model, 
						int year, 
						String color, 
						String owner, 
						int numRepairs, 
						int numPassengers, 
						int numDoors, 
						String transmissionType){
		super(make, model, year, color, owner, numRepairs);
		this.numPassengers = numPassengers;
		this.numDoors = numDoors;
		this.transmissionType = transmissionType;
	}

	public boolean isComfortable(){
		if(numPassengers>=5 &&
			numDoors==4 &&
			2015-this.getYear()<=5){
			return true;
		}else{
			return false;
		}
	}
	public int getNumPassengers(){
		return numPassengers;
	}

	public int getNumDoors(){
		return numDoors;
	}

	public String getTransmissionType(){
		return transmissionType;
	}

	public boolean isHardtoDrive(){
		boolean returnVal = false;
		if(this.getTransmissionType()=="manual"){
			returnVal = true;
		}
		return returnVal;
	}

	public int compareTo(Car otherCar){
		PassengerCar someCar = (PassengerCar)otherCar;
		int thisCarSum = (this.getYear()+this.numPassengers+this.numDoors);
		int otherCarSum = (someCar.getYear()+someCar.numPassengers+someCar.numDoors);
		int returnInt = 0;	
		if(thisCarSum<otherCarSum){
			returnInt = -1;
		} else if(thisCarSum>otherCarSum){
			returnInt = 1;
		}
		return returnInt;
	}

	public static void main(String[] args){
		PassengerCar car2 = new PassengerCar("Ford", "Taurus", 2010, "Red", "Fred Ambler", 1, 5,4, "manual");
		PassengerCar car3 = new PassengerCar("Chevy", "SomeChevy", 2007, "Green", "Fred Blair", 9,3,4,"automatic");
		PassengerCar car4 = new PassengerCar("Toyota", "Prius", 2010, "Blue", "Fred Chambre", 3, 3,2, "manual");
		PassengerCar car5 = new PassengerCar("VW", "GTI", 2013, "Red", "Fred Dobbs", 4,2,2,"automatic");
		PassengerCar car6 = new PassengerCar("VW", "Golf", 2013, "Red", "Fred Evans", 4,2,2,"automatic");
		System.out.println(car2.isComfortable());
		System.out.println(car3.isComfortable());
		System.out.println(car2.isHardtoDrive());
		System.out.println(car3.isHardtoDrive());
		System.out.println(car4.compareTo(car2));
		System.out.println(car2.compareTo(car4));
		System.out.println(car5.compareTo(car6));
		System.out.println(car2.isReliable());
		System.out.println(car3.isReliable());

		System.out.println("Car 2 Owner: "+car2.getOwner());
		car2.sellTo(car3.getOwner());
		System.out.println(car2.getOwner());

		System.out.println("Car 2 Repais = "+car2.getNumRepairs());
		car2.repair();
		System.out.println("Car 2 Repais = "+car2.getNumRepairs());
	}
}