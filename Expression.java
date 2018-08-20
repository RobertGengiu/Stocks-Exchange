import java.util.Stack;
import java.util.StringTokenizer;

/**
*Rezolva expresia
*/
public class Expression {

    public static OperatorFactory operatorFactory = null;

    static String[] arrayOfWords = new String[10000];

    /**
    * Creaza un nou string inlocuind continutul parantezelor cu valori de adevar
    */
    public static String evaluate_inside_parenthesis(String helper, String name, String value) {

        operatorFactory = OperatorFactory.getInstance();
        StringTokenizer Tok = new StringTokenizer(helper);
        int n = 0;

        while(Tok.hasMoreElements()) {
            arrayOfWords[n] = Tok.nextToken();
            n++;
        }

        String expressionToBeProced = new String("");

        for (int i = 0; i < n; i++) {

            if(arrayOfWords[i].equals("eq") || arrayOfWords[i].equals("ne")) {
                Operator operator  = operatorFactory.makeOperator(arrayOfWords[i]);

                if(arrayOfWords[i+1].equals("name")) {
                    operator.setType("name");
                    operator.setRef(arrayOfWords[i+2]);
                    operator.setArgument(name);
                    expressionToBeProced = expressionToBeProced + (char) (operator.apply() + 48) + " ";
                    i += 2;
                }
                else {

                    if(arrayOfWords[i+1].equals("value")) {
                        operator.setType("value");
                        operator.setRef(arrayOfWords[i + 2]);
                        operator.setArgument(value);
                        expressionToBeProced = expressionToBeProced + (char) (operator.apply() + 48) + " ";
                        i += 2;
                    }
                }

            } else if (arrayOfWords[i].equals("lt") || arrayOfWords[i].equals("le") || arrayOfWords[i].equals("gt") ||
                    arrayOfWords[i].equals("ge")) {

                Operator operator = operatorFactory.makeOperator(arrayOfWords[i]);
                operator.setType("value");
                operator.setRef(arrayOfWords[i + 2]);
                operator.setArgument(value);
                expressionToBeProced = expressionToBeProced + (char) (operator.apply() + 48) + " ";
                i += 2;


            } else {
                expressionToBeProced = expressionToBeProced + arrayOfWords[i] + " ";
            }

        }
        return expressionToBeProced;
    }

    /**
    * Creaza arborele si intoarce valoarea 1 in caz de succes si 0 in caz de fail
    */
    public static int success(Observer observer, String name, String value) {

        String expression = observer.getExpression();

        if (expression.equals("nil")) {
            return 1;
        }

        String expressionToBeProced = Expression.evaluate_inside_parenthesis(expression, name, value);
        Stack<String> expressionProced = SYA.takeInput(expressionToBeProced);

        if (expressionProced.size() == 1) {
            return Integer.parseInt(expressionProced.pop());
        }


        OrNode or;
        AndNode and;

        int result = 0;
        Stack<Integer> intermmediar = new Stack<Integer>();

        while(!expressionProced.isEmpty()) {
            String last = expressionProced.firstElement();
            expressionProced.removeElement(last);
            if(last.equals("0") || last.equals("1")) {
                intermmediar.push(Integer.parseInt(last));
            }
            else {
                OperandNode n1 = new OperandNode(intermmediar.pop());
                OperandNode n2 = new OperandNode(intermmediar.pop());

                if(last.equals("||")) {
                    or = new OrNode(n1, n2);
                    intermmediar.push(or.accept(new CalculatorVisitor()));
                }

                if(last.equals("&&")) {
                    and = new AndNode(n1, n2);
                    intermmediar.push(and.accept(new CalculatorVisitor()));
                }
            }
        }

        result = intermmediar.pop();
        return result;
    }
}
