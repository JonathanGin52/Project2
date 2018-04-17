package project;

import java.util.ArrayList;
import java.util.List;

public class MyDLL<E extends Comparable<E>> {

    private DLLNode<E> head;
    private DLLNode<E> tail;
    private int size;

    // Create an empty list
    public MyDLL() {
	this.size = 0;
    }

    // Inserts node to the end of the linked list
    public void addNode(E value) {
	DLLNode<E> newNode = new DLLNode<>(value, tail, null);
	if (head == null) { // Checks if list is currently empty
	    head = newNode;
	} else {
	    tail.setNext(newNode);
	}
	tail = newNode; // Set new node as tail of DLL
	size++;
    }

    // Deletes all nodes with the given value
    public void deleteNode(E value) {
	DLLNode<E> currentNode = head;
	while (currentNode != null) {
	    if (value.equals(currentNode.getValue())) {
		currentNode = unlinkNode(currentNode);
	    } else {
		currentNode = currentNode.getNext();
	    }
	}
    }

    // Unlinks node and returns the next node in the list
    private DLLNode<E> unlinkNode(DLLNode<E> node) {
	DLLNode<E> prev = node.getPrev();
	DLLNode<E> next = node.getNext();
	// Check tail
	if (next == null) {
	    tail = prev;
	} else {
	    next.setPrev(prev);
	    node.setNext(null);
	}
	// Check head
	if (prev == null) {
	    head = next;
	} else {
	    prev.setNext(next);
	    node.setPrev(null);
	}
	size--;
	return next;
    }

    // Maps values to a list, sorts list using quicksort, then re-maps sorted list back to DLL
    public void sort() {
	List<E> list = new ArrayList(size);
	for (DLLNode<E> node = head; node != null; node = node.getNext()) {
	    list.add(node.getValue());
	}
	quickSort(list, 0, size - 1);
	int i = 0;
	for (DLLNode<E> node = head; node != null; node = node.getNext()) {
	    node.setValue(list.get(i++));
	}
    }

    // Sorts list using single pivot quicksort
    private void quickSort(List<E> list, int left, int right) {
	if (left < right) {
	    int pivot = partition(list, left, right);
	    quickSort(list, left, pivot - 1);
	    quickSort(list, pivot + 1, right);
	}
    }

    // Places all values smaller than pivot on the left, and larger on right
    private int partition(List<E> list, int left, int right) {
	// Picks rightmost value as pivot
	E pivotValue = list.get(right);
	int leftPointer = left;
	int rightPointer = right - 1;
	while (leftPointer <= rightPointer) {
	    if (list.get(leftPointer).compareTo(pivotValue) > 0 && list.get(rightPointer).compareTo(pivotValue) < 0) {
		swap(list, leftPointer, rightPointer);
	    }
	    if (list.get(leftPointer).compareTo(pivotValue) <= 0) {
		leftPointer++;
	    }
	    if (list.get(rightPointer).compareTo(pivotValue) >= 0) {
		rightPointer--;
	    }
	}
	swap(list, leftPointer, right);
	return leftPointer;
    }

    // Swaps 2 values in an array
    private void swap(List<E> list, int a, int b) {
	E temp = list.get(a);
	list.set(a, list.get(b));
	list.set(b, temp);
    }

    // Reverse the nodes in the linked list.
    public void reverse() {
	DLLNode<E> current = head;
	DLLNode<E> temp = null;
	tail = head;
	while (current != null) { // Traverse list and swap prev and next pointers
	    temp = current.getPrev();
	    current.setPrev(current.getNext());
	    current.setNext(temp);
	    current = current.getPrev();
	}
	head = temp == null ? null : temp.getPrev();
    }

    // Removes all duplicate nodes in the linked list
    public void duplicate() {
	List<E> repeats = new ArrayList<>();
	for (DLLNode<E> node = head; node != null; node = node.getNext()) {
	    if (repeats.contains(node.getValue())) {
		if (node == tail) { // Do not get next node if node is tail
		    unlinkNode(node);
		} else {
		    node = unlinkNode(node).getPrev();
		}
	    } else {
		repeats.add(node.getValue());
	    }
	}
    }

    // Merges the contents of list and this class in alternating order class = 1 2 3, list = 4 4 4  alternate = 1 4 2 4 3 4
    public void alternate(MyDLL<E> list) {
	DLLNode<E> temp1;
	DLLNode<E> temp2;
	DLLNode<E> node1 = this.head;
	DLLNode<E> node2 = list.head;
	while (node1 != null && node2 != null) {
	    temp1 = node1.getNext(); // Temporarily stores rest of list1
	    temp2 = node2.getNext(); // Temporarily stores rest of list2

	    node1.setNext(node2);
	    node2.setPrev(node1);
	    if (temp1 != null) {
		temp1.setPrev(node2);
		node2.setNext(temp1);
		node2 = temp2;
	    }
	    node1 = temp1;
	}
	if (node1 == null) { // Chcek if list2 still has elements. If true, append to end of list1, and set tail of list2 as tail
	    this.tail.setNext(node2);
	    this.tail = list.tail;
	}
	size += list.size;
    }

    // Searches for value and places it at the front of the doubly linked list
    public void optiFind(E value) {
	for (DLLNode<E> node = head; node != null; node = node.getNext()) {
	    if (value.equals(node.getValue())) {
		node.getPrev().setNext(node.getNext());
		node.getNext().setPrev(node.getPrev());
		node.setNext(head);
		head = node;
		return;
	    }
	}
    }

    // Places the new node in the middle of the list
    public void middleAdd(E value) {
	if (size <= 1) { // Checks if list is empty or only contains 1 element (can append to end of list)
	    addNode(value);
	} else {
	    int middle = (int) Math.ceil(size / 2d); // Finds middle of list. Rounds up if size is odd.
	    DLLNode<E> prev = head;
	    for (int i = 1; i < middle; i++) { // Traverse linkedlist until middle element	
		prev = prev.getNext();
	    }
	    DLLNode<E> next = prev.getNext();
	    DLLNode<E> node = new DLLNode<>(value, prev, next);
	    next.setPrev(node);
	    prev.setNext(node);
	    size++;
	}
    }

    // Prints the contents of the linked list
    public void printList() {
	if (size != 0) {
	    for (DLLNode<E> node = head; node != null; node = node.getNext()) {
		System.out.print(node.getValue().toString());
		if (node == head) {
		    System.out.print(" <- head");
		}
		if (node == tail) {
		    System.out.print(" <- tail");
		}
		System.out.println();
	    }
	} else {
	    System.out.print("List contains no elements or is null.");
	}
	System.out.println("Size: " + size);
    }
}
