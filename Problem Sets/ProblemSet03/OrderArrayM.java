public class OrderArrayM{

	public static void switchElements(int[] m, int index1, int index2){
		int temp = m[index2];
		m[index2] = m[index1];
		m[index1] = temp;
	}

	public static String printArr(int[] m){
		String returnString="";
		for(int i=0; i<m.length; i++){
			returnString+=m[i]+" | ";
		}
		// returnString+="\n";
		return returnString;
	}

	public static void orderM1(int[] m, int f){
		int s = 0;
		int p = (m.length-1)/2;
		int n = m.length-1;
		int temp = 0;
		System.out.println("p: "+p+" n: "+n);
		for(int i=0; i<3; i++){
			for(int j=0; j<m.length; j++){
				if(m[i]<f){
					if(m[i]<m[s]){
						temp = m[s];
						m[s] = m[i];
						m[i] = temp;
						s++;
					}
				if(m[i]>f){
					if(m[i]>m[n]){
						temp = m[n];
						m[n] = m[i];
						m[i] = temp;
						n--;

					}
				}

				if(m[i]==f){
					if(m[i]>m[p]){
						temp = m[p];
						m[p] = m[i];
						m[i] = temp;
						p++;
					}
				}
				}
			}
		}
	}

		public static void orderM2(int[] m, int f){
			int low = 0;
			int hi = m.length-1;
			int temp = 0;
			for(int i=0; i<m.length; i++){
				System.out.println("hi: "+hi + "low: "+low);
				for(int j=0; j<m.length; j++){
					System.out.println(m[j]);
				}
				System.out.println("");
				if(m[i]<f){
						temp = m[low];
						m[low] = m[i];
						m[i] = temp;
						low++;
				} 
				if(m[i]>f){
					
						temp = m[hi];
						m[hi] = m[i];
						m[i] = temp;
						hi--;

				}
				if(m[i]==f){
					temp = m[low+1];
					m[low+1]=m[i];
					m[i] = temp;

				}


				}
			}
		// }

		public static void orderM3(int[] m, int f){
			int low = 0;
			int hi = m.length-1;
			int temp;
			
			for(int i=0; i<m.length; i++){

				if(m[i]<f){
						temp = m[low];
						m[low] = m[i];
						m[i] = temp;
						low++; 
				}
				if(m[i]>f){
					
						temp = m[hi];
						m[hi] = m[i];
						m[i] = temp;
						hi--;
				}

			}

		}

		public static void orderM4(int p, int m[]){
			int arrIndexLen = m.length-1;
			int counter =0;
			for(int i=0; i<m.length; i++){
				if(m[i]<f){
					switchElements(m,counter,i);
					counter++;
					
				}
			}
				for(int j=counter; j<m.length; j++){
					if(m[j]==f){
						switchElements(m,counter,j);
						counter++;
					}
				}
		}
	

	public static void main(String[] args){
		int m1[] = {6,2,5,2,7,5,3}; // 2,2,3,5,5,7,6
		int m2[] = {5, 6, 3, 5, 8, 7, 6, 5, 9, 2};
		int m3[] = {7, 6, 8, 9, 2, 3, 1, 5, 5,5 };
		int m4[] = {2, 3, 1, 7, 9, 8};
		orderM4(m4,5);
	}
}