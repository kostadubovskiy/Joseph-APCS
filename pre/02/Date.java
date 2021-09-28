public class Date{
  public static void main(String[] args){
    String day;
    int date;
    String month;
    int year;
    day = "Thursday";
    date = 9;
    month = "September";
    year = 2021;
    System.out.println("American Format:");
    System.out.println(day + ", " + month + " " + date + ", " + year);
    System.out.println("European Format:");
    System.out.println(day + " " + date + " " + month + ", " + year);
  }
}
