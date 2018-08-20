/**
* Factory singleton
*/

public class FilteredFeedFactory {

    private static FilteredFeedFactory instance = null;

    private FilteredFeedFactory(){};

    public static FilteredFeedFactory getInstance() {
        if(instance == null) {
            return new FilteredFeedFactory();
        }
        return null;
    }

    public FilteredFeed makeFilteredFeed(String newName, String newValue) {
        return new FilteredFeed(newName, newValue);
    }
}
