// Collin Blinder
// cblinder@students.pitzer.edu
public class SportsCar extends Car{

	private int maxSpeed;
	private int numSeconds;
	private boolean isConvertible;

	public SportsCar(String make, 
					String model, 
					int year, 
					String color, 
					String owner, 
					int numRepairs,
					int maxSpeed,
					int numSeconds,
					boolean isConvertible
					){
		super( make,  model,  year,  color,  owner,  numRepairs);
		this.maxSpeed = maxSpeed;
		this.numSeconds = numSeconds;
		this.isConvertible = isConvertible;
	}

	public int getMaxSpeed(){
		return maxSpeed;
	}

	public int getNumSeconds(){
		return numSeconds;
	}

	public boolean getIsConvertable(){
		return isConvertible;
	}

	public boolean isSnazzy(){
		boolean returnBoolean = false;
		if(this.maxSpeed>100 && this.isConvertible==true && this.getColor()=="Pink" || this.getColor()=="Yellow" || this.getColor()== "Red"){
			returnBoolean=true;
		}
		return returnBoolean;
	}

	public int compareTo(Car otherCar){
		SportsCar someCar = (SportsCar)otherCar;
		int otherCarSum = (someCar.getYear()+someCar.maxSpeed);
		int thisCarSum = (this.getYear()+this.maxSpeed);
		int returnInt = 0;
		if(thisCarSum<otherCarSum){
			returnInt = -1;
		}else if(thisCarSum>otherCarSum){
			returnInt = 1;
		}
		return returnInt;
	}

	public static void main(String[] args){
		SportsCar car2 = new SportsCar("Ford", "Taurus", 2010, "Red", "Fred Ambler", 1,101,4,true);
		SportsCar car3 = new SportsCar("Chevy", "SomeChevy", 2007, "Green", "Fred Blair", 9,101,3,true);
		SportsCar car4 = new SportsCar("Toyota", "Prius", 2010, "Blue", "Fred Chambre", 3,99,5,false);
		SportsCar car5 = new SportsCar("Toyota", "Prius", 2007, "Blue", "Fred Chambre", 3,102,5,false);
		System.out.println(car2.isSnazzy());
		System.out.println(car3.isSnazzy());
		System.out.println(car4.isSnazzy());
		System.out.println(car2.compareTo(car3));
		System.out.println(car3.compareTo(car4));
		System.out.println(car4.compareTo(car5));

		System.out.println(car2.isReliable());
		System.out.println(car3.isReliable());

		System.out.println("Car 3 Owner: "+car3.getOwner());
		car3.sellTo(car4.getOwner());
		System.out.println(car3.getOwner());

		System.out.println("Car 3 Repais = "+car3.getNumRepairs());
		car3.repair();
		System.out.println("Car 3 Repais = "+car3.getNumRepairs());


	}
}