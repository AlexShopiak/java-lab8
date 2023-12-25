package tests;

import org.junit.Test;

import java.util.Collection;
import java.util.Set;
import collection.StoneSet;
import stone.*;

public class StoneSetExceptionsTest {

    @Test(expected = NullPointerException.class)
    public void testAdd() {
        Set<Stone> set = new StoneSet();
        Stone element = null;
        set.add(element);
    }

    @Test(expected = NullPointerException.class)
    public void testAddAll() {
        Set<Stone> set = new StoneSet();
        Collection<Stone> collection = null;
        set.addAll(collection);
    }

    @Test(expected = NullPointerException.class)
    public void testContains() {
        Set<Stone> set = new StoneSet();
        Stone element = null;
        set.contains(element);
    }

    @Test(expected = NullPointerException.class)
    public void testContainsAll() {
        Set<Stone> set = new StoneSet();
        Collection<Stone> collection = null;
        set.containsAll(collection);
    }

    @Test(expected = NullPointerException.class)
    public void testRemove() {
        Set<Stone> set = new StoneSet();
        Stone element = null;
        set.remove(element);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveAll() {
        Set<Stone> set = new StoneSet();
        Collection<Stone> collection = null;
        set.removeAll(collection);
    }

    @Test(expected = NullPointerException.class)
    public void testRetainAll() {
        Set<Stone> set = new StoneSet();
        Collection<Stone> collection = null;
        set.retainAll(collection);
    }

    @Test(expected = NullPointerException.class)
    public void testToArrayWithParam() {
        Set<Stone> set = new StoneSet();
        Stone[] array = null;
        set.toArray(array);
    }
}
