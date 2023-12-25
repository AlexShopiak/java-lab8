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
        ErrorHandler.checkObjForNull(element);

        if (contains(element)) {
            return false;
        }

        insertAtEnd_DLL(element);
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Stone> collection) {
        ErrorHandler.checkCollForNull(collection);

        boolean changed = false;
        Iterator<?> iterator = collection.iterator();

        while (iterator.hasNext()) {
            Object obj = iterator.next();
            ErrorHandler.checkObjForNull(obj);
            Stone stone = (Stone) obj;
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
        ErrorHandler.checkObjForNull(element);

        if (!(element instanceof Stone)) {
            return false;
        }

        Iterator<Stone> iterator = iterator();
        while (iterator.hasNext()) {
            Stone stone = iterator.next();
            if (stone.equals((Stone) element)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        ErrorHandler.checkCollForNull(collection);

        Iterator<?> iterator = collection.iterator();

        while (iterator.hasNext()) {
            Object obj = iterator.next();
            ErrorHandler.checkObjForNull(obj);
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
        if (o == null) {
            return false;
        }
        return hashCode() == o.hashCode();
    }

    @Override
    public int hashCode() {
        int sum = 0;

        Iterator<Stone> iterator = iterator();
        while (iterator.hasNext()) {
            Stone stone = iterator.next();
            sum += (stone != null ? stone.hashCode() : 0);
        }

        return sum;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Iterator<Stone> iterator() {
        return new Iterator_DLL();
    }

    @Override
    public boolean remove(Object element) {
        ErrorHandler.checkObjForNull(element);

        if (!(element instanceof Stone)) {
            return false;
        }

        Iterator<Stone> iterator = iterator();
        while (iterator.hasNext()) {
            Stone stone = iterator.next();
            if (stone.equals((Stone) element)) {
                iterator.remove();
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        ErrorHandler.checkCollForNull(collection);

        boolean changed = false;

        Iterator<?> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Object obj = iterator.next();
            ErrorHandler.checkObjForNull(obj);
            if (obj instanceof Stone) {
                boolean removing = remove((Stone) obj);
                if (removing) changed = true;
            }
        }

        return changed;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        ErrorHandler.checkCollForNull(collection);

        boolean changed = false;

        Iterator<Stone> iterator = iterator();
        while (iterator.hasNext()) {
            Stone element = iterator.next();
            if (!collection.contains(element)) {
                iterator.remove();
                changed = true;
            }
        }

        return changed;
    }

    @Override
    public int size() {
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
        ErrorHandler.checkArrForNull(array);

        Stone[] stones = (Stone[]) toArray();
        Stone[] copy = Arrays.copyOf(stones, array.length);

        return copy;
    }
}

