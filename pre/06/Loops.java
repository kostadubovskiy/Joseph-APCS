public class Loops{
  public static void main(String[] args){
    System.out.println(power(1.2,3));
    System.out.println(factorial(5));
    System.out.println(myexp(2,21));
  }

  public static double power(double x, int n){
    double j;
    int a;
    j = 1.0;
    a = n;
    while (a > 0){
      j = x * j;
      a = a - 1;
    }
    return j;
  }

  public static int factorial(int n){
    int j;
    int a;
    j = 1;
    a = n;
    while (a > 0){
      j = a * j;
      a = a - 1;
    }
    return j;
  }

  public static double myexp(double x, double n){
    double j;
    int a;
    j = 1.0;
    a = 1;
    while (a <= n){
      j = j + power(x,a) / factorial(a);
      a = a + 1;
    }
    return j;
  }
}
