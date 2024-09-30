public class App {
    public static void main(String[] args) throws Exception {

        StackWithoutHead stackWithoutHead = new StackWithoutHead();

        stackWithoutHead.addNode(0);
        stackWithoutHead.addNode(1);
        stackWithoutHead.addNode(2);

        stackWithoutHead.printStack();

        stackWithoutHead.removeNode();

        stackWithoutHead.printStack();

        stackWithoutHead.addNode(2);
        stackWithoutHead.addNode(3);

        stackWithoutHead.printStack();
    }
}
