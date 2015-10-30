// Collin Blinder
// cblinder@students.pitzer.edu
/*This algorithm uses 2 for-loops to iterate over the array. 
in the first loop through, all numbers smaller than p
are switched with any number at the index counter, which begins at
index 0 of the array and increments up each time
a number smaller than p is encountered.
The next loop traverses the array looking for numbers 
larger than p. If a number larger than p is 
encountered, it is switched with the number
at the position arrLen, 
which begins at the last index of the array
and is decremented each time a number larger than 
p is encountered and swapped.
At the end of these two loops, 
the larger and smaller numbers
have been pushed to the end and beginning 
of the array respectively, leaving all
numbers equal to p in between.
The running time of this algorithm is 
Theta(n). This is because the array is traversed twice,
2n, which is simply equal to Theta(n) in complexity.*/

public class Partition{
	public static void switchElements(int[] m, int index1, int index2){
		int temp = m[index2];
		m[index2] = m[index1];
		m[index1] = temp;
	}
	public static void partition(int p, int m[]){
			int counter =0;
			int arrLen = m.length-1;

			for(int i=0; i<m.length; i++){
				if(m[i]<p){
					switchElements(m,counter,i);
					counter++;	
				}	
			}
			for(int j=m.length-1; j>0; j--){
				if(m[j]>p){
					switchElements(m,arrLen,j);	
					arrLen--;	
				}
			}
		}
		
	public static void main(String[] args){
		int m2[] = {5, 6, 3, 5, 8, 7, 6, 5, 9, 2};
		int m3[] = {7, 6, 8, 9, 2, 3, 1, 5, 5,5 };
		int m4[] = {2, 3, 1, 7, 9, 8};
		partition(5,m2);
		for(int i=0; i<m2.length; i++){System.out.println(m2[i]);}
		System.out.println("");
		partition(5,m3);
		for(int i=0; i<m3.length; i++){System.out.println(m3[i]);}
		System.out.println("");
		partition(5,m4);
		for(int i=0; i<m4.length; i++){System.out.println(m4[i]);}
		System.out.println("");
	}
}

/*
Counting Method
                          				Cost
int counter =0;              			1
int arrLen = m.length-1;     			1 

for(int i=0; i<m.length; i++){			n+1
	if(m[i]<p){							n
		switchElements(m,counter,i);	<n
		counter++;						<n 
	}	                              ------
}	                                   3+2n+2(<n) = n+2(<n) = Theta(n)
for(int j=m.length-1; j>0; j--){     >> Same As Above ^^^^
	if(m[j]>p){
		switchElements(m,arrLen,j);	 
		arrLen--;						Total = Theta(2n) = Theta(n)
	}
}

*/

