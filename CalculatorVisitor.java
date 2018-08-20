/**
* Calculatorul cu opearatiile de si logic si sau logic 
*/
public class CalculatorVisitor implements IVisitor {

    @Override
    public int visit(AndNode operatorNode) {
        return operatorNode.Left.accept(this) & operatorNode.Right.accept(this);
    }

    @Override
    public int visit(OrNode operatorNode) {
        return operatorNode.Left.accept(this) | operatorNode.Right.accept(this);
    }

    @Override
    public int visit(OperandNode operandNode) {
        return operandNode.Value;
    }
}

