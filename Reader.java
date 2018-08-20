import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
* Folosita la cititul linilor 
*/
public class Reader {

    private static Reader instance = null;
    private Queue<String> Container = new LinkedList<String>();

    private Reader(){};

    public static Reader getInstance(){
        if(instance == null) {
            return new Reader();
        } else{
            return null;
        }
    }

    public void readInput() {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while (!line.equals("end")) {

            line = scanner.nextLine();
            Container.add(line);
        }
        Container.remove("end");
    }

    public Queue<String> returnContainer() {

        return Container;
    }


}
