/**
* Factory singleton de operatori
*/
public class OperatorFactory {
    private static OperatorFactory instance = null;

    private OperatorFactory(){};

    public static OperatorFactory getInstance() {
        if(instance == null) {
            return new OperatorFactory();
        }
        return null;
    }

    /**
	* Intoarce operatorul in functie de stringul dat
    */
    public Operator makeOperator(String newOperatorType) {

        if (newOperatorType.equals("le")){
            return new leOperator();

        }

        if (newOperatorType.equals("ge")){
            return new geOperator();

        }

        if (newOperatorType.equals("eq")){
            return new eqOperator();

        }

        if (newOperatorType.equals("lt")){
            return new ltOperator();

        }

        if (newOperatorType.equals("gt")){
            return new gtOperator();

        }

        if (newOperatorType.equals("ne")){
            return new neOperator();

        }

        return null;
    }
}