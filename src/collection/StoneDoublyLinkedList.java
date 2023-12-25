package collection;

import stone.Stone;
import java.util.Iterator;
import java.util.NoSuchElementException;

class StoneDoublyLinkedList {
    protected Node head = null;
    protected Node tail = null;

    protected static class Node {
        protected Node prev;
        protected Stone data;
        protected Node next;

        protected Node(Stone value) {
            prev = null;
            data = value;
            next = null;
        }
    }

    protected void insertAtBeginning_DLL(Stone data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
            tail = temp;
        } else {
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
    }

    protected void insertAtEnd_DLL(Stone data) {
        Node temp = new Node(data);
        if (tail == null) {
            head = temp;
            tail = temp;
        } else {
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
    }

    protected void insertAtPosition_DLL(Stone data, int position) {
        Node temp = new Node(data);
        if (position == 0) {
            insertAtBeginning_DLL(data);
        } else {
            Node current = head;
            int currPosition = 0;
            while (current != null
                    && currPosition < position) {
                current = current.next;
                currPosition++;
            }

            if (current == null) {
                insertAtEnd_DLL(data);
            } else {
                temp.next = current;
                temp.prev = current.prev;
                current.prev.next = temp;
                current.prev = temp;
            }
        }
    }

    protected void deleteAtBeginning_DLL() {
        if (head == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        Node temp = head;
        head = head.next;
        head.prev = null;
        temp.next = null;
    }

    protected void deleteAtEnd_DLL() {
        if (tail == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        Node temp = tail;
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
    }

    protected void deleteAtSpecificPosition_DLL(int pos) {
        if (head == null) {
            return;
        }

        if (pos == 0) {
            deleteAtBeginning_DLL();
            return;
        }

        Node current = head;
        int count = 0;

        while (current != null && count != pos) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Position wrong");
            return;
        }

        if (current == tail) {
            deleteAtEnd_DLL();
            return;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;
        current.prev = null;
        current.next = null;
    }

    protected void clear_DLL() {
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.prev = null;
            current.next = null;
            current = nextNode;
        }
        head = null;
        tail = null;
    }

    protected int size_DLL() {
        int count = 0;
        Node current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    protected class Iterator_DLL implements Iterator<Stone> {
        private Node current = head;
        private Node lastReturned = null;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Stone next() throws NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Stone data = current.data;
            lastReturned = current;
            current = current.next;
            return data;
        }

        @Override
        public void remove() {
            if (lastReturned == null) {
                throw new IllegalStateException("remove() can only be called after next()");
            }

            if (lastReturned.prev != null) {
                lastReturned.prev.next = lastReturned.next;
            } else {
                head = lastReturned.next;
            }

            if (lastReturned.next != null) {
                lastReturned.next.prev = lastReturned.prev;
            } else {
                tail = lastReturned.prev;
            }

            lastReturned = null;
            //size--;
        }
    }
}
