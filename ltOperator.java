/**
* Operatorul lower
*/
public class ltOperator extends Operator{

    public ltOperator(){}
    @Override
    public int apply(){

        if (Double.parseDouble(getRef())  > Double.parseDouble(getArgument())) {
            return 1;
        }

        else {
            return 0;
        }
    }
}
