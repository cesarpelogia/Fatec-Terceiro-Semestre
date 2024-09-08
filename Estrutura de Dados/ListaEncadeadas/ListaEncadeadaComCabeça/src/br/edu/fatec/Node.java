package br.edu.fatec;

public class Node<L> {
    private int position;
    private L data;
    private Node<L> next;

    // Construtor
    public Node(int position, L data) {
        this.position = position;
        this.data = data;
        this.next = null;
    }

    // Getters e Setters
    public int getPosition() {
        return position;
    }

    public L getData() {
        return data;
    }

    public Node<L> getNext() {
        return next;
    }

    public void setNext(Node<L> next) {
        this.next = next;
    }
}