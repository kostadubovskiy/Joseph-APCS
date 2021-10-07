*/

public class BigSib {
        public BigSib(String k) {
                HelloMsg = k;
        }

        public static void main (String[] args){
        }

        public static String HelloMsg;


        public static String greet(String x) {
                return HelloMsg + " " + x;
        }


}


/*
DISCO
- A constructor can be used to initialize variables very efficiently.
- A Java file may have more than one constructor, as long as the constructors have different inputs. This is known as overloading.
-
QCC
- How do constructors actually work?
- Why must we put the default constructor first in a class?
- Should a constructor ever do more than just initialize variables? Can it do more?
*/
