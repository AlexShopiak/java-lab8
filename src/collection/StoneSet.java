/*
 * StoneSet
 *
 * Version 1.0
 *
 * (c) 2023 Oleksii Shopiak
 * All rights reserved.
 *
 * It is a typed set of Stone ojects 
 * which has doubly linked array structure
 */
package collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import stone.Stone;

public class StoneSet extends StoneDoublyLinkedList implements Set<Stone> { 
    public StoneSet() {}

    public StoneSet(Stone element) {
        add(element);
    }

    public StoneSet(Collection<Stone> collection) {
        addAll(collection);
    }

    @Override
    public boolean add(Stone element) {
        if (element == null) {
            throw new NullPointerException();
        }

        if (contains(element)) {
            return false;
        }

        insertAtEnd_DLL(element);
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Stone> collection) {
        if (collection == null) {
            throw new NullPointerException();
        }

        boolean changed = false;
        Iterator<?> iterator = collection.iterator();

        while (iterator.hasNext()) {
            Object o = iterator.next();
            if (o == null) {
                throw new NullPointerException();
            }
            Stone stone = (Stone) o;
            boolean addition = add(stone);
            if (addition) changed = true;
        }

        return changed;
    }

    @Override
    public void clear() {
        clear_DLL();
    }

    @Override
    public boolean contains(Object element) {
        if (element == null) {
            throw new NullPointerException();
        }

        if (!(element instanceof Stone)) {
            return false;
        }

        Node current = head; 
        while (current != null) { 
            Stone stone = current.data;
            if (stone.equals((Stone) element)) {
                return true;
            }
            current = current.next; 
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        if (collection == null) {
            throw new NullPointerException();
        }

        Iterator<?> iterator = collection.iterator();

        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if (obj == null) {
                throw new NullPointerException();
            }
            if (!(obj instanceof Stone)) {
                return false;
            }
            boolean containing = contains(obj);
            if (!containing) return false;
        }

        return true;
    }

    @Override
    public boolean equals(Object o) {
        return hashCode() == o.hashCode();
    }

    @Override
    public int hashCode() {
        int sum = 0; 

        Node current = head;
        while (current != null) { 
            Stone stone = current.data;
            sum += (stone != null ? stone.hashCode() : 0);
            current = current.next; 
        }

        return sum;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<Stone> iterator() {//?
        return new Iterator_DLL();
    }

    @Override
    public boolean remove(Object element) {//can
        if (element == null) {
            throw new NullPointerException();
        }

        if (!(element instanceof Stone)) {
            return false;
        }

        Node current = head; 
        int pos = 0;

        while (current != null) { 
            Stone stone = current.data;
            if (stone.equals((Stone) element)) {
                deleteAtSpecificPosition_DLL(pos);
                return true;
            }
            current = current.next; 
            pos++;
        }

        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        if (collection == null) {
            throw new NullPointerException();
        }

        boolean changed = false;

        Iterator<?> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            if (obj == null) {
                throw new NullPointerException();
            }
            if (obj instanceof Stone) {
                boolean removing = remove((Stone) obj);
                if (removing) changed = true;
            }
        }

        return changed;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        if (collection == null) {
            throw new NullPointerException();
        }

        boolean changed = false;
        int pos = 0;

        Node current = head; 
        while (current != null) { 
            Stone stone = current.data;
            if (!collection.contains(stone)) {
                deleteAtSpecificPosition_DLL(pos);
                changed = true;
                pos--;
            }
            current = current.next; 
            pos++;
        }

        return changed;    
    }

    @Override
    public int size() { //can
        return size_DLL();
    }

    @Override
    public Stone[] toArray() {
        int size = size();
        Stone[] stones = new Stone[size];
        
        Node current = head;
        for (int i = 0; i < size; i++) {
            stones[i] = current.data;
            current = current.next;
        }

        return stones;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <Stone> Stone[] toArray(Stone[] array) {
        if (array == null) {
            throw new NullPointerException();
        }

        Stone[] stones = (Stone[]) toArray();
        Stone[] copy = Arrays.copyOf(stones, array.length);

        return copy;
    }
}
