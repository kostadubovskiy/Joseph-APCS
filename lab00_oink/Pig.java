
/*
 Ariel Fuchs, Kostsa Dubovskiy, Joseph Othman
 * APCS
 * Lab00 -- Etterbay Odingcay Oughthray Ollaborationcay/String manipulation and iteration and recursion/Create a pig latin translator.
 * 2021-11-08
 * time spent: 2hrs
 * class Pig
 * a Pig Latin translator
*/

import java.util.Scanner;

public class Pig {

    private static final String VOWELS = "aeiouyAEIOUY";

    private static final String CAPITALS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private static final String PUNCTUATION = ",.;?!:";


    /*
     boolean hasA(String,String) -- checks for a letter in a String
     pre:  w != null, letter.length() == 1
     post: hasA("cat", "a") -> true
     hasA("cat", "p") -> false
     **/
    public static boolean hasA( String w, String letter ) {
        /*
         *checks for letter in a string
         */
        for (int index = 0; index < w.length(); index ++) {
            if (w.substring(index,index+1).equals(letter)) {
                return true;
            }
        }
        return false;

    }//end hasA()


    /*
     boolean isAVowel(String) -- tells whether a letter is a vowel
     precondition: letter.length() == 1
     **/
    public static boolean isAVowel(String letter) {
        return VOWELS.indexOf(letter) != -1;
    }


    public static boolean isACapital(String letter) {
        return CAPITALS.indexOf(letter) != -1;
    }


    //tells wether a symbol is a punctuation mark
    public static boolean isPunctuation(String letter) {
        return PUNCTUATION.indexOf(letter) != -1;
    }

    /*
     int countVowels(String) -- counts vowels in a String
     pre:  w != null
     post: countVowels("meatball") -> 3
     **/
    public static int countVowels(String w) {

        return allVowels(w).length();

      /* long version using for
         int numVowels = 0; //init vowels counter var
         //must touch each letter in word, so use FOR
         for( int i = 0; i < w.length(); i++ ) {
         if ( isAVowel( w.substring(i,i+1) ) )
         numVowels++;
         }
         return numVowels;
      */
    }


    /*
     boolean hasAVowel(String) -- tells whether a String has a vowel
     pre:  w != null
     post: hasAVowel("cat") -> true
     hasAVowel("zzz") -> false
     **/
    public static boolean hasAVowel(String w) {
        return allVowels(w).length() >= 0;
    }


    /*
     String allVowels(String) -- returns vowels in a String
     pre:  w != null
     post: allVowels("meatball") -> "eaa"
     **/
    public static String allVowels(String w) {

        String ans = ""; //init return String

        for (int i = 0; i < w.length(); i++) {

            if (isAVowel(w.substring(i, i + 1)))
                ans += w.substring(i, i + 1); //grow the return String
        }
        return ans;
    }


    /*
     String firstVowel(String) -- returns first vowel in a String
     pre:  w != null
     post: firstVowel("") --> ""
     firstVowel("zzz") --> ""
     firstVowel("meatball") --> "e"
     **/
    public static String firstVowel(String w) {

        String ans = "";

        if (hasAVowel(w)) //Q: Why this necess?
            ans = allVowels(w).substring(0, 1);

        return ans;
    }


    /*
     boolean beginsWithVowel(String) -- tells whether a String begins with a vowel
     pre:  w != null and w.length() > 0
     post: beginsWithVowel("apple")  --> true
     beginsWithVowel("strong") --> false
     **/
    public static boolean beginsWithVowel(String w) {
        return isAVowel(w.substring(0, 1));
    }


    public static boolean beginsWithCapital(String w) {
        return isACapital(w.substring(0, 1));
    }


    public static String capitalize(String w) {

        w = w.toLowerCase();
        w = w.substring(0, 1).toUpperCase() + w.substring(1);
        return w;
    }


    public static String recapitalize(String w) {
        for (int i = 0; i < CAPITALS.length(); i++) {
            if (CAPITALS.substring(i, i + 1) == w.substring(0, 1)) {
                return w;
            }
        }
        w = w.toLowerCase();
        w = w.substring(0, 1).toUpperCase() + w.substring(1);
        return w;
    }

    /*
     String engToPig(String) -- converts an English word to Pig Latin
     pre:  w.length() > 0
     post: engToPig("apple")  --> "appleway"Pig2
     engToPig("strong") --> "ongstray"
     engToPig("java")   --> "avajay"
     **/
    public static String engToPig(String w) {

        String ans = "";

        if (beginsWithVowel(w))
            ans = w + "way";

        else {
            int vPos = w.indexOf(firstVowel(w));
            ans = w.substring(vPos) + w.substring(0, vPos) + "ay";
        }

        return ans;
    }

    public static String engToPigPunct(String w) {
        int p = w.length();
        String res = "";

        // Find 1st non-punctuation from the right
        while (p > 0 && isPunctuation(w.substring(p - 1, p)))
            p--;

        // Translate the part of w without the "punctuation tail"
        if (p > 0)
            res = Pig.engToPig(w.substring(0, p));

        // Add "punctuation tail" back
        if (p < w.length())
            res = res + w.substring(p);

        return res;
    }


    public static String translator(String w) {
        String s = w.trim();
        String word = "";
        String result = "";
        int p = 0;

        while (p >= 1) {
            p = s.indexOf(" ");
            word = s.substring(0, p).trim();
            if (Pig.beginsWithCapital(word))
                word = capitalize(Pig.engToPigPunct(word));
            else
                word = Pig.engToPigPunct(word);
            s = s.substring(p + 1);
            result = result + " " + word;
        }

        if (Pig.beginsWithCapital(s))
            word = capitalize(Pig.engToPigPunct(s));
        else
            word = Pig.engToPigPunct(s);

        result = result + " " + word;
        return result.trim();

    }


    public static String translateSentence(String s) {
        int i = 0;
        String a = "";
        if (hasA(s, " ")) {
            while (i < s.length()) {
                if (s.substring(i, i + 1).equals(" ")) {
                    String word = s.substring(0, i);

                    if (isACapital(word.substring(0, 1))) {
                        a = capitalize(engToPigPunct(word)) + " " + translateSentence(s.substring(i + 1));
                    } else {
                        a = engToPigPunct(word) + " " + translateSentence(s.substring(i + 1));
                    }
                    i = s.length();
                } else {
                    i++;
                }
            }
        } else if (isACapital(s))
            a = capitalize(engToPigPunct(s));
        else
            a = engToPigPunct(s);

        return a;
    }


    public static void main(String[] args) {
        //instantiate a Scanner with STDIN as its bytestream
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            System.out.println(translateSentence(sc.next()));
        }
    }//end main()
}
