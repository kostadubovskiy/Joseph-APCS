import java.util.Scanner;

public class Temp{
  public static void main(String[] args){
    double celsius;
    double fahrenheit;
    Scanner in = new Scanner(System.in);
    System.out.print("How many degrees Celsius? ");
    celsius = in.nextDouble();
    fahrenheit = celsius * 9 / 5 + 32;
    System.out.print(celsius + " C = " + fahrenheit + " F");
  }
}
