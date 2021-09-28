import java.lang.Math;

public class Arrays{
  public static void main(String[] args){
    int c[] = {2,8,3,4,6};
    double x[] = {2,2,3,4};
    double y[] = powarray(x, 3);
    System.out.print("{" + y[0]);
    for (int i = 0; i < y.length; i++) {
        System.out.print(", " + y[i]);
    }
    System.out.println("}");
    System.out.println(indexOfMax(c));
    System.out.println(prime(11));
    boolean[] q = sieve(12);
    System.out.print("{" + q[0]);
    for (int i = 1; i < q.length; i++) {
        System.out.print(", " + q[i]);
    }
    System.out.println("}");
  }


  public static double[] powarray(double[] a, double exp) {
    double b[] = a;
    for (int i = 0; i < a.length; i++) {
    b[i] = Math.pow(a[i], exp);
    }
    return b;
  }

  public static int indexOfMax(int[] a){
    int j = a[0];
    int k = -1;
    for (int i=1; i<a.length; i++) {
        if (a[i] > j) {
            j = a[i];
            k = i;
        }
    }
    return k;
  }

  public static boolean[] sieve(int n) {
    boolean[] a;
    a = new boolean [n];
    int j = 1;
    for (j=1; j < n; j++){
      a[j] = prime(j);
    }
    return a;
  }

  public static boolean prime(int n) {
    if (n == 1) {
      return false;
    }
    int j = 2;
    for (j=2; j <= Math.sqrt(n); j++){
      if (n % j == 0) {
        return false;
      }
    } return true;
  }
}
