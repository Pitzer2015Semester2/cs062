// Collin Blinder
// cblinder@students.pitzer.edu
/* This program runs in Theta(n) because it does not need to address each element 
in each second level array. The program is written with the knowledge that each second level array
will contain all 1's before any 0's. Therefore, once an array is discovered containing more
1's than any previous array, all other arrays may be checked starting at the index of that
array's last 1; cutting down significantly on the program's complexity.*/
public class SquareMatrix{

	public static int findRow(int[][] A){
		int max=0;
		int maxNumOfOnes = 0;
		int stepY =0;
		int numOfOnes =0;
		for(int i=0; i<A.length;i++){
			stepY = numOfOnes;
			numOfOnes = 0;

			while(stepY<A[i].length  && A[i][stepY]!=0){
				numOfOnes++;
				stepY++;
			}
			if(numOfOnes>maxNumOfOnes){
				maxNumOfOnes=numOfOnes;
				max = i;
			}
			
		}
		return max;
	}

	public static void main(String[] args){

	int[][] A = {{1,0,0,0,0},
                 {1,1,1,0,0},
                 {1,1,0,0,0},
                 {1,1,1,1,0},
                 {0,0,0,0,0}};

	int[][] B = {{1,0,0,0,0,1},
				{1,1,1,0,0,1},
				{1,1,0,0,0,1},
				{1,1,1,1,0,1},
				{0,0,0,0,0,1},
				{1,1,1,1,1,1}};

	int[][] C = {{1,1,1,1,1,0,0,0,0,0,0,0},
				{1,1,1,1,1,1,1,0,0,0,0,0},
				{1,1,1,1,0,0,0,0,0,0,0,0},
				{1,1,1,1,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0},
				{1,1,1,1,1,1,1,1,0,0,0,0},
				{1,0,0,0,0,0,0,0,0,0,0,0},
				{1,1,1,0,0,0,0,0,0,0,0,0},
				{1,1,1,0,0,0,0,0,0,0,0,0},
				{1,1,1,1,1,1,1,1,1,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0},
				{1,1,1,0,0,0,0,0,0,0,0,0}};

	int[][] D = {{1,1,1,1,1,0,0,0,0,0,0,0},
				{1,1,1,1,1,1,1,0,0,0,0,0},
				{1,1,1,1,0,0,0,0,0,0,0,0},
				{1,1,1,1,0,0,0,0,0,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0},
				{1,1,1,1,1,1,1,1,0,0,0,0},
				{1,0,0,0,0,0,0,0,0,0,0,0},
				{1,1,1,0,0,0,0,0,0,0,0,0},
				{1,1,1,0,0,0,0,0,0,0,0,0},
				{1,1,1,1,1,1,1,1,1,0,0,0},
				{0,0,0,0,0,0,0,0,0,0,0,0},
				{1,1,1,1,1,1,1,1,1,1,1,1}};

    System.out.println("The row found is " + findRow(A));
    System.out.println("The row found is " + findRow(B));
    System.out.println("The row found is " + findRow(C));
    System.out.println("The row found is " + findRow(D));
	}
}