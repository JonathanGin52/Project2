package project;

public class DLLNode<E extends Comparable<E>> implements Comparable<E> {

    private E value;
    private DLLNode<E> prev;
    private DLLNode<E> next;

    public DLLNode(E value, DLLNode<E> prev, DLLNode<E> next) {
	this.value = value;
	this.prev = prev;
	this.next = next;
    }

    public DLLNode getPrev() {
	return prev;
    }

    public void setPrev(DLLNode previous) {
	this.prev = previous;
    }

    public DLLNode getNext() {
	return next;
    }

    public void setNext(DLLNode next) {
	this.next = next;
    }

    public E getValue() {
	return value;
    }

    public void setValue(E value) {
	this.value = value;
    }

    @Override
    public int compareTo(E o) {
	return value.compareTo(o);
    }
}
