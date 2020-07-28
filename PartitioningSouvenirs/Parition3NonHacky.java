import java.util.*;

public class Parition3NonHacky {

	static int SubsetSum(int[] A, int n, int T) {
		
		int[][] M = new int[n+1][T+1];
	
		for (int i = 0; i <= n; i++) 
            M[i][0] = 1; 
  
        // If sum is not 0 and set is empty, 
        // then answer is false 
        for (int i = 0; i <= T; i++) 
            M[0][i] = 0; 
  
		//System.out.println(Arrays.toString(M));
		for (int i = 1; i <=n; i++) {
			for (int j = 1; j<=T; j++) {
				
				if (j-A[i-1]>=0) {
					if (M[i-1][j] ==1|| M[i-1][j-A[i-1]]==1) {
						M[i][j] = 1;
					}; 
				}else {
					M[i][j] = M[i-1][j];
				}
				
			}
		}
		return M[n][T]; 
		
	}
    private static int partition3(int[] A) {
    	if (A.length <3) {
    		return 0; 
    	} 

    	
    	int sum=0; 
    	for (int i =0; i<A.length; i++) {
    		sum+=A[i];
    	}

    	if (sum%3!=0) {
    		return 0;
    	}
    	
    	
    	int i1 = SubsetSum(A, A.length, sum/3); 
    	int i2 = SubsetSum(A, A.length, 2*sum/3); 
    	
    	if (i1==1 && i2 == 1) {
    		return 1; 
    	}

    	
    	return 0; 
    	
    }

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int n = scanner.nextInt();
	        int[] A = new int[n];
	        for (int i = 0; i < n; i++) {
	            A[i] = scanner.nextInt();
	        }
	        System.out.println(partition3(A));
	    }
	}

