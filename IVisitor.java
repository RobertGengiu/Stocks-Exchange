/**
* Interfata pentru visitor
*/
interface IVisitor {

    int visit(AndNode operatorNode);

    int visit(OrNode operatorNode);

    int visit(OperandNode operandNode);
}