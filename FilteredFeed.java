import java.util.Locale;

/**
* Clasa pentru feedurile care intra in hashmap-ul fiecarui observator
*/

public class FilteredFeed {
    private double fluctuation;
    private int nr_of_changes;
    private String name;
    private double value;
    private double former_value;
    private boolean printable = false;

/**
* Constructor care primeste numele si valoarea feed-ului
*/
    public FilteredFeed(String newName, String newValue) {
        fluctuation = 0.0;
        nr_of_changes = 0;
        name = newName;
        value = Double.parseDouble(newValue);
        former_value = 0.0;
        increase_nr_of_changes();
        printable = false;
    }

/**
* Reseteaza de fiecare data cand se da un print 
*/
    public void reset() {
        nr_of_changes = 0;
    }

/**
* Creste numarul de schimbari din cadrul fiecarui feed
*/
    public void increase_nr_of_changes() {
        nr_of_changes++;
    }

/**
* Modifica valoarea unui feed
*/
    public void setValue(String newValue) {
        value = Double.parseDouble(newValue);
    }

/**
* Intoarce valoarea unui feed
*/
    public double getValue() {
        return value;
    }

/**
* Seteaza ultima valoare ca actuala
*/
    public void setFormer_value(double former_value) {
        this.former_value = former_value;
    }

/**
* Intoarce stringul formatat pentru printare 
*/
    public String getContent()
    {
        return name + " " + String.format(Locale.US, "%.2f", value)  + " " + String.format(Locale.US, "%.2f"
                , fluctuation) + "% " + nr_of_changes;
    }

/**
* Verifica daca este printabil
*/
    public boolean isPrintable() {
        return printable;
    }

/**
* Modifica daca este cazul sa se printezze
*/
    public void setPrintable(boolean printable) {
        this.printable = printable;
    }

/**
* Intoarce valoarea fostei valori pentru calculul fluctuatiei
*/

    public double getFormer_value() {
        return former_value;
    }

/**
* Modifica manual fluctuatia
*/
    public void setFluctuation(double fluctuation) {
        this.fluctuation = fluctuation;
    }

/**
* Intoarce numarul de schimbari
*/
    public int getNr_of_changes() {
        return nr_of_changes;
    }

/**
* Intoarce fluctuatia
*/
    public double getFluctuation() {
        return fluctuation;
    }
}
