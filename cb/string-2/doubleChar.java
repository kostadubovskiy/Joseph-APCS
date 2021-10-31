public class doubleChar{
	public String doubleChar(String str) {
  		String ans = "";
		int x = str.length();
		for(int i = 0; i < x; i++) {
			ans = ans + str.substring(i,i+1) + str.substring(i,i+1);
		}
		return ans;
	}
}
