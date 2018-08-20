/**
* Operatorul greater or equal
*/
public class geOperator extends Operator{
    public geOperator(){
    }

    public int apply(){

        if (Double.parseDouble(getRef())  <= Double.parseDouble(getArgument())) {
            return 1;
        }

        else {
            return 0;
        }
    }
}
