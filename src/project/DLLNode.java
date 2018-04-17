package project;

public class DLLNode<E> {

    private E value;
    private DLLNode<E> prev;
    private DLLNode<E> next;

    // Constructs a DLLNode with just the value
    public DLLNode(E value) {
	this(value, null, null);
    }

    // Constructs a DLLNode and sets the previous and next node
    public DLLNode(E value, DLLNode<E> prev, DLLNode<E> next) {
	this.value = value;
	this.prev = prev;
	this.next = next;
    }

    // Returns the previous node
    public DLLNode getPrev() {
	return prev;
    }

    // Sets the previous node to node passed as param
    public void setPrev(DLLNode previous) {
	this.prev = previous;
    }

    // Returns the next node
    public DLLNode getNext() {
	return next;
    }

    // Sets the next node to node passed as param
    public void setNext(DLLNode next) {
	this.next = next;
    }

    // Returns the value stored in node
    public E getValue() {
	return value;
    }

    // Sets the value stored in node
    public void setValue(E value) {
	this.value = value;
    }
}
