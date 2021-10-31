public class catDog {
  public boolean catDog(String str) {
    int catCount = 0;
    int dogCount = 0;
    int x = str.length();
    for(int i = 0; i < x-2; i++)
      if (str.substring(i,i+3).equals("cat")) {
        catCount = catCount + 1;
      }
      else if (str.substring(i,i+3).equals("dog")) {
        dogCount = dogCount + 1;
      }
      if (catCount == dogCount) {
        return true;
      }
      else {
        return false;
      }
  }
}
