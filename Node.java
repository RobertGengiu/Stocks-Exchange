/**
* Folosit pentru arborele de vizitare
*/
public class Node implements IVisitable {

    public Node Left;
    public Node Right;

    public Node(Node left, Node right) {
        Left = left;
        Right = right;
    }

    @Override
    public int accept(IVisitor visitor) {
        return 0;
    }
}