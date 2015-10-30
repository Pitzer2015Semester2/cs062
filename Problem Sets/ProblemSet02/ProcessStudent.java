// Collin Blinder
// cblinder@students.pitzer.edu
import java.util.*;
import java.io.*;

public class ProcessStudent{

	public static double averageGPA(ArrayList<Student> studentList){
		double totalGpa=0;
		for(Student student: studentList){
			totalGpa+=student.getGpa();
		}
		return totalGpa/studentList.size();
	}
	public static ArrayList<Student> studentsWithAreaCode(ArrayList<Student> studentList,String areaCode){
		ArrayList<Student> returnArray = new ArrayList<Student>();
		for(Student student : studentList){
			String phoneNumArray[] = student.getPhone().split("");
			if((phoneNumArray[0]+phoneNumArray[1]+phoneNumArray[2]).equals(areaCode)){
				returnArray.add(student);
			}
		}
		return returnArray;
	}

	public static ArrayList<Student> studentsMajorIn(ArrayList<Student> studentList, String major){
		ArrayList<Student> studentsInMajor = new ArrayList<Student>();
		for(Student student : studentList){
			if(student.getMajor().equals(major)){
				studentsInMajor.add(student);
			}
		}
		return studentsInMajor;
	}

	public static Student highestGPA(ArrayList<Student> studentList, String state){
		Student bestInState = studentList.get(0);
		for(Student student: studentList){
			if(student.getState().equals(state) && student.getGpa()>bestInState.getGpa()){
				bestInState = student;
			}
		}
		return bestInState;
	}

	public static String histogram(ArrayList<Student> studentList){
		ArrayList<String> stateArray = new ArrayList<String>();
		String returnString ="";
		for(Student student : studentList){
			if(!stateArray.contains(student.getState())){ //O n^2 fix
				stateArray.add(student.getState());
			} 
		}
		int studentsInState[] = new int[stateArray.size()];
		for(Student student : studentList){
			studentsInState[stateArray.indexOf(
					student.getState())]++;
		}
		returnString+= "State, No of Students\n";
		for (String state : stateArray) {
			returnString+=
			state+", "+
			studentsInState[(
				stateArray.indexOf(
					state))]+"\n";

		}
		return returnString;
	}

	public static ArrayList<Student> createStudentArray(Scanner input){
		ArrayList<Student> studentList = new ArrayList<Student>();
		String studentName = "";
		String state = "";
		double gpa =0;
		String major = "";
		int id = 0;
		String phoneNum = "";
		while(input.hasNextLine()){
			String line = input.nextLine();
			Scanner parser = new Scanner(line);
			while(parser.hasNext()){
				String parsePoint = parser.next();
				if(parsePoint.equals("Name:")){
					studentName = parser.next()+" "+parser.next()+" "+parser.next();
				}
				if(parsePoint.equals("Address:")){

					String city = input.nextLine();
					state = input.nextLine();
				}
				if(parsePoint.equals("Phone:")){
					phoneNum = "";
					phoneNum+= parser.nextInt();
					phoneNum+=parser.nextInt();
					phoneNum+=parser.nextInt();
				}
				if(parsePoint.equals("Id:")){

					id = parser.nextInt();
					major = input.nextLine();
					major = major.replace("Major: ","");
				}
				if(parsePoint.equals("GPA:")){
					gpa = parser.nextDouble();
					studentList.add(new Student(studentName, state, gpa,major,id, phoneNum));
				}
			}	
		}
		return studentList;
	}	

	public static void main(String[] args) throws IOException{
		String inputFileName = "./str2.txt";

		Scanner input = new Scanner(new File(inputFileName));
		ArrayList<Student> studentList = createStudentArray(input);

		System.out.println(highestGPA(studentList,"Kentucky").getName());
		System.out.println(studentList.get(3).getMajor());
		System.out.println(averageGPA(studentList));
		System.out.println(histogram(studentList));
		System.out.println(studentsMajorIn(studentList,"Social Work").get(0).getPhone());

		// System.out.println(studentsWithAreaCode(studentList, "277").get(0).getName());
		System.out.println(studentsWithAreaCode(studentList, "277"));
	}	
}