//mnjbn
import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

/**
 * Class that contains helper methods for the Review Lab
 **/
public class Review {

  private static HashMap<String, Double> sentiment = new HashMap<String, Double>();
  private static ArrayList<String> posAdjectives = new ArrayList<String>();
  private static ArrayList<String> negAdjectives = new ArrayList<String>();
  private static ArrayList<String> fake = new ArrayList<String>();

  private static final String SPACE = " ";

  static{
    try {
      Scanner input = new Scanner(new File("cleanSentiment.csv"));
      while(input.hasNextLine()){
        String[] temp = input.nextLine().split(",");
        sentiment.put(temp[0],Double.parseDouble(temp[1]));
        //System.out.println("added "+ temp[0]+", "+temp[1]);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing cleanSentiment.csv");
    }


  //read in the positive adjectives in postiveAdjectives.txt
     try {
      Scanner input = new Scanner(new File("positiveAdjectives.txt"));
      while(input.hasNextLine()){
    //    String temp = input.nextLine().trim();
    //    System.out.println(temp);
        posAdjectives.add(input.nextLine().trim());
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing postitiveAdjectives.txt\n" + e);
    }

  //read in the negative adjectives in negativeAdjectives.txt
     try {
      Scanner input = new Scanner(new File("negativeAdjectives.txt"));
      while(input.hasNextLine()){
        negAdjectives.add(input.nextLine().trim());
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing negativeAdjectives.txt");
    }

//read in the negative adjectives in negativeAdjectives.txt
  try {
   Scanner input = new Scanner(new File("fake.txt"));
   while(input.hasNextLine()){
     fake.add(input.nextLine().trim());
   }
   input.close();
 }
 catch(Exception e){
   System.out.println("Error reading or parsing fake.txt");
 }
}

  /**
   * returns a string containing all of the text in fileName (including punctuation),
   * with words separated by a single space
   */
  public static String textToString( String fileName )
  {
    String temp = "";
    try {
      Scanner input = new Scanner(new File(fileName));

      //add 'words' in the file to the string, separated by a single space
      while(input.hasNext()){
        temp = temp + input.next() + " ";
      }
      input.close();

    }
    catch(Exception e){
      System.out.println("Unable to locate " + fileName);
    }
    //make sure to remove any additional space that may have been added at the end of the string.
    return temp.trim();
  }

  /**
   * @returns the sentiment value of word as a number between -1 (very negative) to 1 (very positive sentiment)
   */
  public static double sentimentVal( String word )
  {
    try
    {
      return sentiment.get(word.toLowerCase());
    }
    catch(Exception e)
    {
      return 0;
    }
  }

   public static double totalSentiment(String fileName)
   {
//     String reviewstuff = textToString(fileName);
     double totalsum = 0;
try{
     Scanner reviewstuff = new Scanner(new File(fileName));
     String x = "";
     while(reviewstuff.hasNext()){
       x = reviewstuff.next();
       totalsum = (totalsum + sentimentVal(x));
     }
     return totalsum;
   }
   catch(Exception e){
     System.out.println("nvm");
   }
return totalsum = 1001;
   }

  /**
   * Returns the ending punctuation of a string, or the empty string if there is none
   */
  public static String getPunctuation( String word )
  {
    String punc = "";
    for(int i=word.length()-1; i >= 0; i--){
      if(!Character.isLetterOrDigit(word.charAt(i))){
        punc = punc + word.charAt(i);
      } else {
        return punc;
      }
    }
    return punc;
  }

    /**
   * Returns the word after removing any beginning or ending punctuation
   */
  public static String removePunctuation( String word )
  {
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(0)))
    {
      word = word.substring(1);
    }
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(word.length()-1)))
    {
      word = word.substring(0, word.length()-1);
    }

    return word;
  }

  /**
   * Randomly picks a positive adjective from the positiveAdjectives.txt file and returns it.
   */
  public static String randomPositiveAdj()
  {
    int index = (int)(Math.random() * posAdjectives.size());
    return posAdjectives.get(index);
  }

  /**
   * Randomly picks a negative adjective from the negativeAdjectives.txt file and returns it.
   */
  public static String randomNegativeAdj()
  {
    int index = (int)(Math.random() * negAdjectives.size());
    return negAdjectives.get(index);

  }

  /**
   * Randomly picks a positive or negative adjective and returns it.
   */
  public static String randomAdjective()
  {
    boolean positive = Math.random() < .5;
    if(positive){
      return randomPositiveAdj();
    } else {
      return randomNegativeAdj();
    }
  }

 public static int starRating(String fileName){
  double totalSentiment = totalSentiment(fileName);
    if(totalSentiment >= 10)
      return 5;
    else if(totalSentiment >= 7)
      return 4;
    else if(totalSentiment >= 5)
      return 3;
    else if(totalSentiment >= 3)
      return 2;
    else if(totalSentiment >= 1)
      return 1;
    else
      return 0;
 }

  public static String fakeReview (String fileName)
  {
    String fake = "";
    String file = textToString(fileName);
    Scanner input = new Scanner(file);

    while( input.hasNext()){
      String check = input.next();
      String punct = getPunctuation(check);
      if( check.charAt(0) == '*'){ // for random just use randomAdjective()
          check = removePunctuation(check);
          if(sentimentVal(check) < 0)
            check = randomNegativeAdj();
          else
            check = randomPositiveAdj();
      }
          fake = fake + check + punct + " ";
   }
      return fake;
}

    public static void main (String[] args){
    //tests
    Review test = new Review();
    System.out.println( "\ntesting textToString(String reviewmcd)\n" + textToString("reviewmcd.txt"));
    System.out.println( "\ntesting textToString(String bigReview)\n" + textToString("bigReview.txt"));
    System.out.println("\n\ntesting randomAdjective\n" + randomAdjective());
    System.out.println("\ntesting removePunctuation( !WOW!)\n" + removePunctuation("!WO.W!"));
    System.out.println("\ntesting getPunctuation(!WO.W!)\n" + getPunctuation("!WO.W!"));
    System.out.println("\ntesting sentimentVal(hello)\n" + sentimentVal("hello"));
    System.out.println("\ntesting sentimentVal(happily)\n" + sentimentVal("happily"));
    System.out.println("\ntesting sentimentVal(cold)\n" + sentimentVal("cold"));
    System.out.println("\ntesting totalSentiment(reviewmcd)\n" + totalSentiment("reviewmcd.txt"));
    System.out.println("\ntesting totalSentiment(bigReview)\n" + totalSentiment("bigReview.txt"));
    System.out.println("\ntesting starRating(reviewmcd)\n" + starRating("reviewmcd.txt"));
    System.out.println("\ntesting starRating(bigReview)\n" + starRating("bigReview.txt"));
    System.out.println("\ntesting fakereview(fake)\n" + fakeReview("fake.txt"));
    System.out.println(fake);

  }
}
