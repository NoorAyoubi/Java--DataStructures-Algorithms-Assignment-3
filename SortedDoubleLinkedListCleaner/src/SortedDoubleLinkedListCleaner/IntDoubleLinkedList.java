package SortedDoubleLinkedListCleaner;

public class IntDoubleLinkedList {
    private DoubleNode head;
    private DoubleNode tail;

    // Removes duplicates from a sorted doubly linked list
    public void removeDuplications() {
        if (head == null || head.next == null) {
            return; // No duplicates if list is empty or has only one node
        }

        DoubleNode current = head;

        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                // Remove the duplicate node
                DoubleNode duplicate = current.next;
                current.next = duplicate.next;

                if (duplicate.next != null) {
                    duplicate.next.prev = current; // Update backward link
                } else {
                    tail = current; // Update tail if we removed the last node
                }
            } else {
                current = current.next; // Move to next node if no duplicate
            }
        }
    }

    // Internal class to represent a node in the doubly linked list
    private static class DoubleNode {
        int data;
        DoubleNode next;
        DoubleNode prev;

        public DoubleNode(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    // Helper method to add a node to the end of the list
    public void addToEnd(int data) {
        DoubleNode newNode = new DoubleNode(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Helper method to print the list
    public void printList() {
        DoubleNode current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
}
