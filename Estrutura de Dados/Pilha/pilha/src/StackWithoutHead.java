public class StackWithoutHead {

    private Node top;

    public void addNode(int value){

        Node newNode = new Node(value);

        if (top == null){
            top = newNode;
            return;
        }
        newNode.setNext(top);
        top = newNode;
    }

    public Node removeNode(){
        if(top == null){
            System.out.println("A Pilha está vazia.");
            return null;
        }
        Node nodeToRemove = top;
        top = top.getNext();
        System.out.println("\n");
        return nodeToRemove;
    }

    public void printStack(){
        if(top == null){
            System.err.println("Pilha vazia.");
            return;
        }
        Node current = top;
        while (current != null) {
            System.out.println(current.getValue());
            current= current.getNext();
        }
    }
}
