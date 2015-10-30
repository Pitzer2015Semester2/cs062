// Collin Blinder
// cblinder@students.pitzer.edu
public abstract class Car implements Comparable<Car>{
	private String make;
	private String model;
	private int year;
	private String color;
	private String owner;
	private int numRepairs;

	public Car(String make, String model, int year, String color, String owner, int numRepairs){
		this.make = make;
		this.model = model;
		this.year = year;
		this.color = color;
		this.owner = owner;
		this.numRepairs = numRepairs;
	}

	public String getMake(){
		return make;
	}

	public String getModel(){
		return model;
	}

	public int getYear(){
		return year;
	}

	public String getColor(){
		return color;
	}

	public String getOwner(){
		return owner;
	}

	public void sellTo(String nextOwner){
		owner = nextOwner;
	}

	public int getNumRepairs(){
		return numRepairs;
	}

	public void repair(){
		numRepairs++;
	}


	public boolean isReliable(){
		if((2015-year)/numRepairs>1){
			return false;
		} else{
			return true;
		}
	}

	public abstract int compareTo(Car compareCar);

	public static void main(String[] args){}

}