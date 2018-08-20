/**
* Operatorul lower or equal
*/
public class leOperator extends Operator {
    public leOperator(){

    }

    public int apply(){

        if (Double.parseDouble(getRef())  >= Double.parseDouble(getArgument())) {
            return 1;
        }

        else {
            return 0;
        }
    }
}
