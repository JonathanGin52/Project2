package project;

import java.util.LinkedList;

public class Recursion {

    public static void main(String[] args) {
        
/*      TEST CODE
        // Singly LinkedList Test Cases
        LinkedList<String> list1 = new LinkedList();
        list1.add("a");
        list1.add("b");
        list1.add("c");
        list1.add("d");
        list1.add("d");
        list1.add("e");

        LinkedList<String> list2 = new LinkedList();
        list2.add("a");
        list2.add("b");
        list2.add("c");
        list2.add("e");
        list2.add("f");
        list2.add("g");

        LinkedList<String> list3 = new LinkedList();
        list3.add("a");
        list3.add("b");
        list3.add("c");
        list3.add("e");
        list3.add("f");

        LinkedList<String> list4 = new LinkedList();
        list4.add("a");
        list4.add("b");
        list4.add("c");
        list4.add("e");
        list4.add("f");

        LinkedList<String> list5 = new LinkedList();

        //Test Cases
        System.out.println("<SINGLY LIST TEST CASES>");
        System.out.println("<Original Lists>");
        System.out.println("list1");
        printList(list1);
        System.out.println("list2");
        printList(list2);
        System.out.println("list3");
        printList(list3);
        System.out.println("list4");
        printList(list4);
        System.out.println("list5");
        printList(list5);
        System.out.println();
        System.out.println("<isMember>");
        System.out.println(isMember("", list1));
        System.out.println(isMember("a", list1));
        System.out.println(isMember("x", list1));
        System.out.println(isMember("x", list5));
        System.out.println();
        System.out.println("<deleteFirst>");
        printList(deleteFirst("a", list1));
        printList(deleteFirst("d", list1));
        printList(deleteFirst("d", list5));
        System.out.println("<deleteAll>");
        printList(deleteAll("a", list1));
        printList(deleteAll("d", list1));
        System.out.println("<reverse>");
        System.out.println("list1");
        printList(reverse(list1));
        System.out.println("list2");
        printList(reverse(list2));
        System.out.println("list5");
        printList(reverse(list5));
        System.out.println("<difference>");
        printList(difference(list1, list2));
        System.out.println("<union>");
        printList(union(list1, list2));
        System.out.println("<subset>");
        System.out.println(subset(list1, list2));
        System.out.println(subset(list3, list2));
        System.out.println();
        System.out.println("<intersects>");
        printList(intersect(list1, list2));
        printList(intersect(list3, list4));
        System.out.println("<equalSets>");
        System.out.println(equalSets(list1, list2));
        System.out.println(equalSets(list3, list4));
        System.out.println(equalSets(list3, list4));
        System.out.println();

        //Doubly LinkedLists
        MyDLL<String> dll = new MyDLL<>();
        dll.addNode("0");
        dll.addNode("1");
        dll.addNode("2");
        dll.addNode("3");
        dll.addNode("4");
        dll.addNode("4");
        dll.addNode("4");
        dll.addNode("5");

        MyDLL<String> dll2 = new MyDLL<>();
        dll2.addNode("5");
        dll2.addNode("4");
        dll2.addNode("1");
        dll2.addNode("3");
        dll2.addNode("0");
        dll2.middleAdd("2");

        MyDLL<String> dll3 = new MyDLL<>();
        dll3.addNode("a");
        dll3.addNode("b");
        dll3.addNode("d");
        dll3.addNode("c");
        dll3.addNode("d");
        dll3.addNode("e");
        dll3.addNode("f");

        MyDLL<String> dll4 = new MyDLL<>();

        MyDLL<String> dll5 = new MyDLL<>();

        //Doubley LinkedList Test Cases
        System.out.println("<DOUBLY LINKED LIST TEST CASES>");
        System.out.println("<Original Lists>");
        System.out.println("dll");
        dll.printList();
        System.out.println("dll2");
        dll2.printList();
        System.out.println("dll3");
        dll3.printList();
        System.out.println("dll4");
        dll4.printList();
        System.out.println("<deleteNode>");
        dll.deleteNode("5");
        dll.printList();
        dll3.deleteNode("f");
        dll3.printList();
        dll4.deleteNode("1");
        dll4.printList();
        dll.addNode("5");
        dll3.addNode("f");
        System.out.println("<sort>");
        dll.sort();
        dll2.sort();
        dll3.sort();
        dll4.sort();
        dll.printList();
        dll2.printList();
        dll3.printList();
        dll4.printList();
        System.out.println("<reverse>");
        dll.reverse();
        dll3.reverse();
        dll4.reverse();
        dll.printList();
        dll3.printList();
        dll4.printList();
        System.out.println("<duplicate>");
        dll.duplicate();
        dll3.duplicate();
        dll4.duplicate();
        dll.printList();
        dll3.printList();
        dll4.printList();
        System.out.println("<alternate>");
        dll.alternate(dll2);
        dll.printList();
        dll3.alternate(dll4);
        dll3.printList();
        dll4.alternate(dll3);
        dll4.printList();
        System.out.println("<optiFind>");
        dll.optiFind("0");
        dll.printList();
        System.out.println("<middleAdd>");
        dll.middleAdd("<3>");
        dll.printList();
        dll5.middleAdd("<3>");
        dll5.printList();

        System.out.println("\n\n");
	System.out.println("\nTesting reverse():");
	printList(reverse(add("Tic", add("Tac", add("Toe", null)))));

	System.out.println("\nTesting difference():");
	printList(difference(add("2", add("4", add("6", add("8", add("10", null))))), add("1", add("2", add("3", add("4", add("5", null)))))));

	System.out.println("\nTesting union():");
	printList(union(add("2", add("4", add("6", add("8", add("10", null))))), add("1", add("2", add("3", add("4", add("5", null)))))));

	System.out.println("\nTesting intersect():");
	printList(intersect(add("2", add("4", add("6", add("8", add("10", null))))), add("1", add("2", add("3", add("4", add("5", null)))))));

	System.out.println("\nTesting subset():");
	System.out.println(subset(add("1", add("2", add("3", null))), add("1", add("2", add("3", add("4", add("5", null)))))));
	System.out.println(subset(add("1", add("2", add("6", null))), add("1", add("2", add("3", add("4", add("5", null)))))));

	System.out.println("\nTesting equalSets():");
	System.out.println(equalSets(add("1", add("2", add("3", add("5", add("4", null))))), add("3", add("2", add("1", add("4", add("5", null)))))));
	System.out.println(equalSets(add("1", add("2", add("6", null))), add("1", add("2", add("3", add("4", add("5", null)))))));
        
        */
    }

    // Add value to the front of list. If list is null, create a new LinkedList.
    private static LinkedList add(String value, LinkedList list) {
        if (list == null) { // If list is null, create a new linkedlist
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
        if (isNull(list1)) {
            return null;
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
        if (isNull(list1) || isNull(list2)) { // If either list is null, return null
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
