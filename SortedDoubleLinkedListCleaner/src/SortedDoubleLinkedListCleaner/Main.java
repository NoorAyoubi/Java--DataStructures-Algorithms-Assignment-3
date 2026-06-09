package SortedDoubleLinkedListCleaner;

public class Main {
    public static void main(String[] args) {
        IntDoubleLinkedList list = new IntDoubleLinkedList();
        int[] values = {1, 1, 2, 3, 3, 3, 4, 5, 5, 5};

        for (int val : values) {
            list.addToEnd(val);
        }

        System.out.print("Before: ");
        list.printList();

        list.removeDuplications();

        System.out.print("After: ");
        list.printList();
    }
}
