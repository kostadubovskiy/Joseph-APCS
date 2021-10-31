public class countHi {
  public int countHi(String str) {
    int counter = 0;
	  int x = str.length();
	  int i = 0;
	  String k = "hi";
	  while(i < x - 1){
	     String check = str.substring(i,i+2);
		   if (check.equals(k)) {
		       counter = counter + 1;
		   }
		   i = i + 1;
	  }
	  return counter;
  }
}
