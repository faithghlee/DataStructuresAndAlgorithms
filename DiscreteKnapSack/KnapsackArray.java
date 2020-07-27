import java.util.*;
// Code uses a 2D array to store values 
//
public class KnapsackArray {
	
    static int optimalWeight(int W, int[] w) {
        //write you code here
    	
    	//BASE CASE 
    	if (W ==0) {
    		return 0; 
    	}
    	
    	
    	
    
    	int[][] table = new int [W+1][w.length+1];
    	for(int i = 0; i <=w.length; i++) {
    		table[W][i] =0; 

    	}
    	
    	for(int i = 0; i <=W; i++) {
    		table[i][w.length] =0; 

    	}
    	
    	int val = 0;
    	for (int i = 0; i <= W; i++) {
    		
    		for (int j = 1; j<=w.length; j++) {
    			table[i][j] = table[i][j-1];
    			if (w[j-1]<=i) {
    				val = table[i-w[j-1]][j-1] +w[j-1]; 
        			if (table[i][j]<val) {
        				table[i][j] = val;
        			}
    			}
    			

    		}
    		
    	}
    	
    	return table[W][w.length];

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

