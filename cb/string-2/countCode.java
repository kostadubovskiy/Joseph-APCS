public class countCode {
  public int countCode(String str) {
    int counter = 0;
    int x = str.length();
    for(int i = 0; i < x-3; i++)
      if((str.substring(i,i+2).equals("co")) && (str.substring(i+3,i+4).equals("e"))) {
        counter = counter + 1;
      }
    return counter;
  }
}
