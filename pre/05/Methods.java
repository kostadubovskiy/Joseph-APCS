public class ValueMethods{
  public static void main(String[] args){
    System.out.println(isDivisible(2,10));
    System.out.println(isTriangle(2,5,3));
    System.out.println(ack(2,10));
  }

  public static boolean isDivisible(int n, int m) {
    if (m % n == 0) {
      return true;
    }
    return false;
  }

  public static boolean isTriangle(int a, int b, int c) {
    if (a + b <= c) {
      return false;
    }
    else if (a + c <= b) {
      return false;
    }
    else if (b + c <= a) {
      return false;
    }
    return true;
  }

  public static int ack(int m, int n) {
    if (m == 0) {
         return n + 1;
    }
    else if (n == 0) {
        return ack(m - 1, 1);
    }
    else {
        return ack(m - 1, ack(m, n - 1));
    }
  }
}
