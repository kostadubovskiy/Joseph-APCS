public class endOther {
  public boolean endOther(String a, String b) {
    int x = a.length();
    int y = b.length();
    if(x >= y) {
      String check1 = a.substring(x-y);
      if (check1.toLowerCase().equals(b.toLowerCase())) {
        return true;
      }
      else {
        return false;
      }
    }
    else {
      String check2 = b.substring(y-x);
      if (check2.toLowerCase().equals(a.toLowerCase())) {
        return true;
      }
      else {
        return false;
      }
    }
  }
}
