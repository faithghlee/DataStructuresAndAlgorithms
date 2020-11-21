package hashT;

public class KeyValueEntry {
	/**
	 * Class of KeyValue pairs 
	 */

		
		private String ssn; 
		private String name; 
		
		public KeyValueEntry(String number, String name) {
			this.ssn = number; 
			this.name = name; 
		}
		public String getSSN() {
			return ssn;
		}
		public String getName() {
			return name; 
		}
		

}
