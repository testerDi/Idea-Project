import java.awt.event.KeyEvent;
import java.io.Console;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String s1 = "";
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter expressions : ");


            s1 = scan.nextLine();

            /*for (int i = 0; i < s1.length()-1; i++) {
                if (s1.charAt(i) == KeyEvent.VK_ENTER) {

                    break;


                }



            }*/

            System.out.println(RPN.eval(s1));
            break;

        }
    }
}
//}