import java.util.*;
// Memoization approach --> good for large values of W
 
public class Knapsack {
	
	static int knapsack(int w, HashMap<Integer, Integer>map, List<Integer> items) {
	//static int knapsack(int w, Vector v, List<Integer> items) {
		if (map.containsKey(w)) {
			return map.get(w);
		}

		map.put(w, 0); 
		int value; 
		int value_w=0; 
		
		for(int i = 0; i < items.size(); i++) {
			if (items.get(i)<=w) {
				//find which item to include. 
				
				List<Integer> newList = new ArrayList<>(items);
				newList.remove(i);
				value = knapsack(w-items.get(i), map, newList)+items.get(i);
				
				
				
				if (value > value_w) {
					value_w = value; 
				}
			}
		}
		map.put(w, value_w);
		
		return value_w;
	}
	
    static int optimalWeight(int W, int[] w) {
        //write you code here
    	
    	//BASE CASE 
    	if (W ==0) {
    		return 0; 
    	}
    	HashMap<Integer, Integer> weightLookup = new HashMap<Integer, Integer>();
    	int maxWight=0; 
    	
    	List<Integer> intList = new ArrayList<Integer>(w.length);
    	for (int i : w)
    	{
    	    intList.add(i);
    	}
    	maxWight = knapsack(W, weightLookup, intList);
    	
    	return maxWight;
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

