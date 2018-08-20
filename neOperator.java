/**
* Operatorul not equal care are doua cazuri
*/
public class neOperator extends Operator{

    public neOperator(){}

    public int apply(){

        if(getType().equals("name")) {
            if(!getRef().equals(getArgument())) {
                return 1;
            }

            else return 0;
        }

        else {
            if(getType().equals("value")) {
                if(Double.parseDouble(getRef()) != Double.parseDouble(getArgument())) {
                    return 1;
                }

                else return 0;
            }
        }

        return  0;
    }
}
