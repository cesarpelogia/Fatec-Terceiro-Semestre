package br.edu.fatec;

public class ListWithHead<L> {

    private Node<L> head;
    
    public ListWithHead(){
        head = new Node<L>(0, null);
    }
    
    public void insertNode(int position, L data){
        Node<L> newNode = new Node<>(position, data);
        if (head.getNext() == null){
            System.out.println("Ponteiro da cabeça: "+ head.getNext().toString());
            newNode.setNext(head.getNext());
            System.out.println("Ponteiro do próximo: " + newNode.getNext().toString());
            head.setNext(newNode);
            return;
        }
        
        Node<L> current = head;
        while (current.getNext() != null){
            current = current.getNext();
        }
        
        current.setNext(newNode);
        System.out.println("Novo nó inserido após posição: " + current.getPosition() + ". Dados: " + current.getData());
    }
}
