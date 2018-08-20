import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
* Se executa fiecare linie primita
*/
public class Execute {

    private static Execute instance = null;
    private Queue<String> Container = new LinkedList<String>();

    private static HashMap<String, Observer> observers;

/**
* Constructor ce primeste o coada de executie
*/
    private Execute(Queue<String> newContainer) {
        Container = newContainer;
    };

    private static Stocks stocks;

/**
* Se asigura ca exista spatii inaite si dupa o paranteza
*/
    public static String clean_expression(String expression) {

        String helper = new String("");

        for (int i = 0; i < expression.length(); i++) {
            if(expression.charAt(i) == '(') {
                helper = helper + "( ";
            }

            else if(expression.charAt(i) == ')') {
                helper = helper + " )";
            }

            else {
                helper = helper + expression.charAt(i);
            }
        }
        return helper;

    }

/**
* Singleton
* se asigura ca o singura data se creeaza o instanta a lui Execute
*/
    public static Execute getInstance(Queue<String> newContainer) {
        if (instance == null) {
            observers = new HashMap<String, Observer>();
            stocks = new Stocks();
            return new Execute(newContainer);
        }
        else{
            return null;
        }
    }
/**
* Afiseaza coada
*/
    public void print() {
        while(Container.size() > 0){
            System.out.println(Container.peek());
            Container.remove(Container.peek());
        }
    }

/**
* Interpreteaza fiecare linie pana la end
*/
    public void resolve() {
        ObserverFactory observerFactory = ObserverFactory.getInstance();

        while(Container.size() > 0){

            String[] holder = new String[3];
            int i = 0;
            for (String val: Container.peek().split(" ", 3)) {
                holder[i++] = val;
            }

            if(holder[0].charAt(0) == 'c') {
                observers.put(holder[1], observerFactory.makeObserver(holder[1], clean_expression(holder[2])));
                    for(int j = 0; j < stocks.noumberOfStocks(); j++) {

                        String key = stocks.nameOfAStock(j);
                        String value = "" + stocks.getLastValueforStock(key);

                        if(Expression.success(observers.get(holder[1]), key, value) == 1) {
                         observers.get(holder[1]).update(key, value, "fromStocks");
                        }

                    }
            }

            if(holder[0].charAt(0) == 'f') {

                stocks.add(holder[1], holder[2]);
                for(String key : observers.keySet()) {
                    if(Expression.success(observers.get(key), holder[1], holder[2]) == 1) {
                        observers.get(key).update(holder[1], holder[2], "normal");
                    }

                    else {
                        observers.get(key).fail(holder[1], holder[2]);
                    }
                }

            }

            if(holder[0].charAt(0) == 'p') {

                if (observers.get(holder[1]) != null) {
                    observers.get(holder[1]).printFeed();
                }

            }

            if(holder[0].charAt(0) == 'd') {
                observers.remove(holder[1]);
            }

            Container.remove(Container.peek());
        }
    }
}
