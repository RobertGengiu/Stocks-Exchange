/**
* Operatorul greater
*/
public class gtOperator extends Operator {

    public gtOperator(){}

    @Override
    public int apply(){

        if (Double.parseDouble(getRef())  < Double.parseDouble(getArgument())) {
            return 1;
        }

        else {
            return 0;
        }
    }
}
