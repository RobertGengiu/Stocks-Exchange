/**
*Clasa principala
*/
public class MainClass {

    public static void main(String[] args) {

        Reader reader = Reader.getInstance();
        reader.readInput();
        Execute execute = Execute.getInstance(reader.returnContainer());
        execute.resolve();
    }
}
