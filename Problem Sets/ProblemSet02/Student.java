// Collin Blinder
// cblinder@students.pitzer.edu
public class Student{
	private String name;
	private String state;
	private String phone;
	private int id;
	private String major;
	private double gpa;


	public Student(String name, String state, double gpa,String major, int id, String phone){ //, String phone, int id, String major, double gpa){
		this.name = name;
		this.state = state;
		this.phone = phone;
		this.id = id;
		this.major =major;
		this.gpa = gpa;
	}

	public String getName(){
		return name;
	}

	public String getState(){
		return state;
	}

	public String getPhone(){
		return phone;
	}

	public int getId(){
		return id;
	}

	public String getMajor(){
		return major;
	}

	public double getGpa(){
		return gpa;
	}

	public static void main(String[] args){}

}