public class ConcreteContextOper {
    private Operations operations;

    public ConcreteContextOper() {
    }

    public void setOperations(Operations operations) {
        this.operations = operations;
    }

    public double executeOperations(Double a, Double b) {
        return operations.ConcreteStratCalculation(a, b);
    }

    public double executeOperations(Integer a, Integer b) {
        return operations.ConcreteStratCalculation(a, b);
    }

}
