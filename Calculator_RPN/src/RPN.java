import java.util.LinkedList;

/**
 * Created by drozumniak on 2/27/2017.
 */
public class RPN {

    // return true if char c == operator[+-*/]
    public static boolean isOperator(char c){
        return c == '+' || c == '-' || c == '*' || c == '/';

    }

    //setPriority
    // создаем функцию возврата приоритета в виде числа,
    // которая принимает параметр символа oper
    public static int priority(char oper){

        if (oper == '*' || oper == '/'){
            return 1;
        }
        else if (oper == '+' || oper == '-'){
            return 0;
        }
        else {return -1;}
    }


    // Пишем метод, который принимает два параметра -
    // LinkedList и char. LinkedList'у мы строго говорим,
    // что он принимает Integer (число).
    // Данный метод "учит" считать программу.
    // LinkedList используется т.к. он умеет обращаться
    // к началу и концу своего списка, а т.к. у нас стековый
    // алгоритм, то нам нужно это уметь.


    public static void letGo(LinkedList<Integer> st, char oper){
        int someOne = st.removeLast();
        int someTwo = st.removeLast();

        switch (oper){
            case '+':
                st.add(someTwo + someOne);
                break;
            case  '-':
                st.add(someTwo - someOne);
                break;
            case '*':
                st.add(someTwo * someOne);
                break;
            case '/':
                st.add(someTwo / someOne);
                break;
            default:
                System.out.println("Something is wrong");
        }
    }

   public static int eval(String s) {
       // Создаем два контейнера типа LinkedList
       // Один для чисел, другой для символов
       LinkedList<Integer> someInts = new LinkedList<>();
       LinkedList<Character> someOpers = new LinkedList<>();
       // Пишем цикл, который бегает по нашей строке

       for (int i = 0; i < s.length(); i++) {
           char c = s.charAt(i);

           if (c == '(') {
               someOpers.add('(');
           }
           else if (c == ')') {
               while (someOpers.getLast() != '(') {
                   letGo(someInts, someOpers.removeLast());
               }
               someOpers.removeLast();
           }
           else if (isOperator(c)) {
               while (!someOpers.isEmpty() &&
                       priority(someOpers.getLast()) >= priority(c)) {
                   letGo(someInts, someOpers.removeLast());
               }
               someOpers.add(c);
           }
           else {
               String operand = "";
               while (i < s.length() &&
                       Character.isDigit(s.charAt(i))) {
                   operand += s.charAt(i++);
               }
               --i;
               someInts.add(Integer.parseInt(operand));
           }

       }
        while (!someOpers.isEmpty()){
            letGo(someInts, someOpers.removeLast());
        }
        return someInts.get(0);


    }
}
