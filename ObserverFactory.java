/**
* Factory singleton
*/
public class ObserverFactory {
    private static ObserverFactory instance = null;

    private ObserverFactory(){};

    public static ObserverFactory getInstance() {
        if(instance == null) {
            return new ObserverFactory();
        }
        return null;
    }

    /**
	* Creaza observatori
    */
    public Observer makeObserver(String id, String expression) {
        Observer newObserver = null;

        if (isInteger(id) == true){
            return new Observer(id, expression);
        }

        return null;
    }

    /**
	* Verifica daca id-ul este numar intreg
    */
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e1) {
            return false;
        } catch(NullPointerException e2) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }
}
