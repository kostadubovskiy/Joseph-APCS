public class xyzThere {
  public boolean xyzThere(String str) {
    int x = str.length();
    int i = 0;
    if (x<3) {
      return false;
    }
    else if (str.substring(0,3).equals("xyz")) {
      return true;
    }
    else {
      while (i < x-3) {
        if (str.substring(i+1, i+4).equals("xyz")) {
          if (str.substring(i,i+1).equals(".")) {
          }
          else {
            return true;
          }
        }
        i = i + 1;
      }
    } return false;
  }
}
