import java.io.*;
import java.util.*;

public class Sorting {
    private static Random random = new Random();

    private static int[] partition3(int[] a, int l, int r) {
      //write your code here
        
        if (r-l<=1) {
        	if (a[r]<a[l]) {
        		int temp = a[l]; 
        		a[l] = a[r]; 
        		a[r] = temp;
        	}
        }
        
        int x = a[l]; //pivot element
        int t = r;  // region for element greater than x
        int j = l; // region for element less than x
        int i = j; //tracks which elements to be compared in the sequence 
        
       while (i <= t) {
    	   if (a[i] < x) {
    		   
    		   int temp = a[i]; 
    		   a[i] = a[j]; 
    		   a[j] = temp; 
    		   j+=1; 
    		   i+=1;
    		   
    	   }
    	   if (a[i] > x) {

    		   int temp = a[i]; 
    		   a[i] = a[t]; 
    		   a[t] = temp; 
    		   t-=1;
    		   
    		   
    	   } 
    	  if (a[i]==x) {
    		   i+=1;
    	   }
    	   
       }
        
        
        
        int[] m = {j,t}; 
        return m; 
    }
    
    private static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;

        int[] m = partition3(a, l, r); 
        int m1 = m[0]; 
        int m2 = m[1];
        
        randomizedQuickSort(a, l, m1-1);
        randomizedQuickSort(a, m2+1, r);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}

