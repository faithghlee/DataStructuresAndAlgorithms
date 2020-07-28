import java.util.*;
import java.io.*;

public class Partition3 {
	public static boolean isAllEqual(int[] a){
        for(int i=1; i<a.length; i++){
            if(a[0] != a[i]){
                return false;
            }
        }

        return true;
    }
	

    private static int partition3(int[] A) {
        //write your code here
    	//Edge Cases
    	if (A.length <3) {
    		return 0; 
    	} 
    	if (isAllEqual(A) && A.length%3!=0) {
    		return 0; 
    	}
    	
    	int sum=0; 
    	for (int i =0; i<A.length; i++) {
    		sum+=A[i];
    	}
    	for (int i =0; i<A.length; i++) {
    		if (A[i]>sum/3) {
    			return 0;
    		};
    	}
    	if (sum%3!=0) {
    		return 0;
    	}

    	return 1;
        
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

