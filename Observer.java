import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
* Clasa observer care are un hashmap de feed-uri
*/
public class Observer {

    private int ok = 0;
    private int id;
    private String expression;
    private HashMap<String, FilteredFeed> feed;
    private FilteredFeedFactory feedFactory = null;

    /**
	* Constructor cu parametrii
    */
    public Observer(String newId, String newExpression) {
        id = Integer.parseInt(newId);
        expression = newExpression;
        feed = new LinkedHashMap<String, FilteredFeed>();
        feedFactory = FilteredFeedFactory.getInstance();
    }

    /**
	* Intoarce id-ul
	*/
    public int getId() {
        return id;
    }

    /** 
    * Notifica observatorul in cazul in care trebuie sa adauge un element nou
    */
    public void update(String newName, String newValue, String type) {

        if(type.equals("fromStocks")) {
            feed.put(newName, feedFactory.makeFilteredFeed(newName, newValue));
            feed.get(newName).setPrintable(true);
            feed.get(newName).reset();
            feed.get(newName).setFluctuation(0.00);

            return;
        }

        if( feed.get(newName) == null) {
            feed.put(newName, feedFactory.makeFilteredFeed(newName, newValue));
            feed.get(newName).setPrintable(true);
        }

        else {
            FilteredFeed aux = feed.get(newName);
            aux.increase_nr_of_changes();
            aux.setValue(newValue);
            feed.get(newName).setPrintable(true);
            if(ok == 1) {
                aux.setFluctuation((-aux.getValue() + aux.getFormer_value())/ aux.getFormer_value() * -100);
                if(aux.getFluctuation() > 10000) {
                    aux.setFluctuation(0.00);
                }
                if(aux.getFluctuation() == -0.00) {
                    aux.setFluctuation(0.00);
                }
            }

        }

    }

    /**
	*Notifica observatorul ca feed-ul nu a reusit sa treaca si ca trebuie sa creasca numarul de schimbari
    */
    public void fail(String newName, String newValue) {


        if( feed.get(newName) == null) {
            feed.put(newName, feedFactory.makeFilteredFeed(newName, newValue));
            feed.get(newName).setPrintable(false);
        }
        else {
            feed.get(newName).increase_nr_of_changes();
            feed.get(newName).setPrintable(false);
        }
    }

    /**
	* Afiseaza continutul unui observator, punand elementele intr-o lista pe care o sorteaza dupa cheie
    */
    public void printFeed() {

        ArrayList<String> printList = new ArrayList<String>();

            for (String key : feed.keySet()) {
                if(feed.get(key) != null && feed.get(key).isPrintable()) {
                    printList.add("obs " + id + ": " + feed.get(key).getContent());
                    feed.get(key).reset();
                    feed.get(key).setFormer_value(feed.get(key).getValue());
                    feed.get(key).setFluctuation(0.00);
                    ok = 1;
                }
            }

            printList.sort(String::compareTo);

            for(int i = 0 ; i < printList.size(); i++) {
                System.out.println(printList.get(i));
            }
    }


    /**
	*Intoarce expresia pentru feed-uri din cadrul observatorului
    */
    public String getExpression() {
        return expression;
    }
}
