public class OperationSub implements Operations {
    @Override
    public double ConcreteStratCalculation (Double a, Double b) {
        return a-b;
    }
    @Override
    public Integer ConcreteStratCalculation (Integer a, Integer b) {
        return a-b;
    }
}
