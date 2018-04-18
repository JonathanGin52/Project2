package project;

import java.util.LinkedList;

public class Recursion {

    public static void main(String[] args) {
	MyDLL<String> dll = new MyDLL<>();
//	dll.addNode("0");
//	dll.addNode("1");
//	dll.addNode("2");
//	dll.addNode("3");
//	dll.addNode("4");
//	dll.addNode("5");
//	dll.addNode("6");
//	dll.middleAdd("0");
//	dll.middleAdd("1");
//	dll.middleAdd("2");
//	dll.middleAdd("3");
//	dll.middleAdd("4");
//	dll.middleAdd("5");
//	dll.middleAdd("6");
//	dll.middleAdd("7");
//	dll.sort();

	MyDLL<String> list = new MyDLL<>();
	list.addNode("a");
	list.addNode("b");
	list.addNode("c");
	list.addNode("d");
	list.addNode("e");
	dll.alternate(list);
//	dll.duplicate();
//	dll.reverse();
	dll.printList();

	/*
	LinkedList<String> list1 = new LinkedList<>();
	LinkedList<String> list2 = new LinkedList<>();
	list1 = append(list1, add("1", add("2", add("3", add("4", add("5", null))))));
	list2 = append(list2, add("3", add("4", add("5", add("6", add("7", null))))));
	list1 = append(list1, list2);
	printList(intersect(list1, list2));*/
    }

    // Add value to the front of list. If list is null, create a new LinkedList.
    private static LinkedList add(String value, LinkedList list) {
	if (list == null) {
	    list = new LinkedList<>();
	}
	list.addFirst(value);
	return list;
    }

    // Return the first element (String) in list
    private static String first(LinkedList list) {
	return isNull(list) ? null : (String) list.getFirst();
    }

    // Return all the elements except the first in the list
    private static LinkedList rest(LinkedList list) {
	String first = (String) list.pollFirst();
	LinkedList<String> newList = (LinkedList<String>) list.clone();
	list.addFirst(first);
	return newList;
    }

    // Returns true if list is empty or null
    private static boolean isNull(LinkedList list) {
	return list == null || list.isEmpty();
    }

    // Determine if two Strings are equal
    private static boolean isEqual(String s1, String s2) {
	return s1.equals(s2);
    }

    // Print each item in list on a new line
    private static void printList(LinkedList list) {
	if (!isNull(list)) {
	    list.forEach(System.out::println);
	} else {
	    System.out.print("List contains no elements or is null.");
	}
	System.out.println("");
    }

    // Appends list2 to the end of list1
    private static LinkedList append(LinkedList list1, LinkedList list2) {
	return isNull(list1) ? list2 : add(first(list1), append(rest(list1), list2));
    }

    // Returns true if member is an item in the list.
    private static boolean isMember(String member, LinkedList list) {
	// Checks if list is null/empty. If not empty, recursively checks every element in list for a match
	return isNull(list) ? false : isEqual(member, first(list)) ? true : isMember(member, rest(list));
    }

    // Returns a list in the same order, but with delete missing. If there is nothing to delete, return the original list.
    private static LinkedList deleteFirst(String delete, LinkedList list) {
	return isNull(list) || isEqual(delete, first(list)) ? rest(list) : append(add(first(list), null), deleteFirst(delete, rest(list)));
    }

    // Returns a list in the same order, but with all occurrences of delete missing. If there is nothing to delete, return the original list.
    private static LinkedList deleteAll(String delete, LinkedList list) {
	if (delete == null || isNull(list)) {
	    return list;
	}
	return isEqual(delete, first(list)) ? deleteAll(delete, rest(list)) : append(add(first(list), null), deleteAll(delete, rest(list)));
    }

    // Returns the reversed version of list.
    private static LinkedList reverse(LinkedList list) {
	return isNull(list) ? list : append(reverse(rest(list)), add(first(list), null));
    }

    // Returns a list of the difference between list1 and list2
    private static LinkedList difference(LinkedList list1, LinkedList list2) {
	if (isNull(list1) || isNull(list2)) {
	    return isNull(list1) ? list2 : list1;
	} else if (isMember(first(list1), list2)) {
	    return difference(rest(list1), deleteFirst(first(list1), list2));
	}
	return append(add(first(list1), null), difference(rest(list1), deleteFirst(first(list1), list2)));
    }

    // Returns a list of the union between list1 and list2.
    private static LinkedList union(LinkedList list1, LinkedList list2) {
	if (isNull(list1) || isNull(list2)) {
	    return isNull(list1) ? list2 : list2;
	}
	return append(add(first(list1), null), union(rest(list1), deleteFirst(first(list1), list2)));
    }

    // Returns a list of the intersection between list1 and list2.
    private static LinkedList intersect(LinkedList list1, LinkedList list2) {
	if (isNull(list1) || isNull(list2)) {
	    return null;
	} else if (isMember(first(list1), list2)) {
	    return append(add(first(list1), null), intersect(rest(list1), list2));
	}
	return intersect(rest(list1), list2);
    }

    // Returns true if list1 is a subset of list2. Otherwise returns false.
    private static boolean subset(LinkedList list1, LinkedList list2) {
	if (isNull(list1) || isNull(list2)) {
	    return isNull(list1);
	}
	return isMember(first(list1), list2) ? subset(rest(list1), list2) : false;
    }

    // Returns true if list1 and list2 are equal, but not necessarily in the same order. Otherwise returns false.
    private static boolean equalSets(LinkedList list1, LinkedList list2) {
	return isMember(first(list1), list2) ? equalSets(rest(list1), deleteFirst(first(list1), list2)) : isNull(list1) && isNull(list2);
    }
}
