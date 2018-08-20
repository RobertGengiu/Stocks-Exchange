import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
* Folosit pentru a retine ultimele stock-uri cand se creeaza un nou operator
*/
public class Stocks {

    private HashMap<String, FilteredFeed> stocks;
    private FilteredFeedFactory feedFactory = null;
    private ArrayList<String> stocksEntry = null;

/**
* Constructor fara parametru
* Initializeaza fabrica de feed-uri, hashmap-ul de stock-uri si lista cu key pentru hashmap
*/
    public Stocks (){
        stocks = new LinkedHashMap<String, FilteredFeed>();
        feedFactory = FilteredFeedFactory.getInstance();
        stocksEntry = new ArrayList<String>();
    }


/**
* Adauga in hashmap un element la cheia respectiva
*/
    public void add(String key, String newValue){
        if(stocks.get(key) == null) {
            stocksEntry.add(key);
            stocks.put(key, feedFactory.makeFilteredFeed(key, newValue));
        }
        else
            stocks.replace(key, feedFactory.makeFilteredFeed(key, newValue));
    }

/**
* Intoarce valoarea ultimului stock
*/
    public double getLastValueforStock(String nameOfEntry) {
        return stocks.get(nameOfEntry).getValue();
    }

/**
*Intoarce numarul de intrari din hashmap
*/
    public int noumberOfStocks() {
        return stocksEntry.size();
    }

/**
*Intoarce cheia unui stock din lista
*/
    public String nameOfAStock(int index) {
        return stocksEntry.get(index);
    }
}
