public class Time{
  public static void main(String[] args){
    double hour;
    double minute;
    double second;
    double since_midnight;
    double until_tm;
    double elapsed_time;
    hour = 10;
    minute = 36;
    second = 39;
    since_midnight = (hour * 3600 + minute * 60 + second);
    until_tm = (86400-since_midnight);
    elapsed_time = ((36-27) * 60 + 39 - 46);
    System.out.println(since_midnight);
    System.out.println(until_tm);
    System.out.println(since_midnight/864);
    System.out.print(elapsed_time);
    System.out.print(" seconds.");
  }
}
