import java.util.*;

/**
*Shuting Yard Algorithm
*In cadrul caruia se rezolva parantezele
*/
public class SYA {

/**
* testeaza daca este numar
* @param primeste ca paremetru un string
*/
    public static boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

/**
* testeaza daca stringul este compus din litere mari
* @param primeste ca parametru un string
*/
    public static boolean isUpperCase(String s)
    {
        for (int i=0; i<s.length(); i++)
        {
            if (!Character.isUpperCase(s.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }

/**
* formeaza expresia fara paranteze pentru arbore
* @param expresia cu paranteze
* intoarce o stiva cu operatori si valori
*/
    public static Stack<String> takeInput(String input) {

        Stack<String> stack = new Stack<String>();
        Stack<String> operator = new Stack<String>();
        Stack<Integer> precedence = new Stack<Integer>();

        for(String val: input.split(" ")) {

            if(isNumeric(val) == true || isUpperCase(val) == true) {
                while(precedence.size() > 0 && precedence.pop() == 2) {
                    stack.push(operator.pop());
                }
                stack.push(val);
            }

            if(val.equals("||") ||  val.equals("&&")) {

                operator.push(val);
                precedence.push(1);


            }


            if(val.equals("(")) {
                operator.push(val);
            }


            if(val.equals(")")) {
                while(! operator.peek().equals("(") ) {
                    stack.push(operator.pop());
                }
                operator.pop();
            }



        }

        while(operator.size() > 0) {
            stack.push(operator.pop());
        }

        return stack;
    }

}
