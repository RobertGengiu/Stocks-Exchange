
public class OperandNode extends Node implements IVisitable {

    public int Value;

    public OperandNode(int value) {
        super(null, null);
        Value = value;
    }

    @Override
    public int accept(IVisitor visitor) {
        return visitor.visit(this);
    }
}