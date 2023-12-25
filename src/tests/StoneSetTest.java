package tests;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import collection.StoneSet;
import stone.*;

public class StoneSetTest {
    @Test
    public void testEmptyConstructor() {
        //Act Arrange
        Set<Stone> set = new StoneSet();

        //Assert
        assertEquals(0, set.size());
    }

    @Test
    public void testObjectConstructor() {
        //Act Arrange
        Set<Stone> set = new StoneSet(new Emerald(1, 2));

        //Assert
        assertEquals(1, set.size());
        assertTrue(set.contains(new Emerald(1, 2)));
    }

    @Test
    public void testCollectionConstructor() {
        //Arrange
        Set<Stone> hashSet = new HashSet<>();
        hashSet.add(new Emerald(1, 2));
        hashSet.add(new    Ruby(3, 9));

        //Act
        Set<Stone> set = new StoneSet(hashSet);

        //Assert
        assertEquals(2, set.size());
        assertTrue(set.contains(new Emerald(1, 2)));
        assertTrue(set.contains(new    Ruby(3, 9)));
    }

    @Test
    public void testAdd() {
        //Arrange
        Set<Stone> set = new StoneSet();

        //Act
        boolean addition1 = set.add(new Emerald(1, 2));
        boolean addition2 = set.add(new Emerald(1, 2));
        boolean addition3 = set.add(new    Opal(3, 2));

        //Assert
        assertTrue(addition1);
        assertFalse(addition2);
        assertTrue(addition3);

        assertEquals(2, set.size());
        assertTrue(set.contains(new Emerald(1, 2)));
        assertTrue(set.contains(new    Opal(3, 2)));
    }

    @Test
    public void testAddAll() {
        //Arrange
        Set<Stone> hashSet = new HashSet<>();
        hashSet.add(new Emerald(1, 2));
        hashSet.add(new    Ruby(3, 9));

        //Act
        Set<Stone> set = new StoneSet();
        boolean addition1 = set.addAll(hashSet);
        boolean addition2 = set.addAll(hashSet);

        //Assert
        assertTrue(addition1);
        assertFalse(addition2);

        assertEquals(2, set.size());
        assertTrue(set.contains(new Emerald(1, 2)));
        assertTrue(set.contains(new Ruby(3, 9)));
    }

    @Test
    public void testClear() {
        //Arrange
        Set<Stone> set = new StoneSet();
        set.add(new Emerald(1, 2));
        set.add(new    Ruby(3, 9));
        int initialSize = set.size();

        //Act
        set.clear();

        //Assert
        assertEquals(2, initialSize);
        assertEquals(0, set.size());
    }

    @Test
    public void testContains() {
        //Arrange
        Set<Stone> set = new StoneSet();
        set.add(new Emerald(1, 2));
        set.add(new    Ruby(3, 9));

        //Act
        boolean containing1 = set.contains(new Emerald(1, 2));
        boolean containing2 = set.contains(new    Ruby(3, 9));
        boolean containing3 = set.contains(new    Onyx(4, 8));

        //Assert
        assertTrue(containing1);
        assertTrue(containing2);
        assertFalse(containing3);
    }

    @Test
    public void testContainsAll() {
        //Arrange
        Set<Stone> set = new StoneSet();
        set.add(new Emerald(1, 2));
        set.add(new    Ruby(3, 9));

        Set<Stone> set2 = new StoneSet();
        set2.add(new Emerald(1, 2));
        set2.add(new    Ruby(3, 9));

        Set<Stone> set3 = new StoneSet();
        set3.add(new Emerald(1, 2));
        set3.add(new    Ruby(3, 9));
        set3.add(new    Onyx(1, 2));

        //Act
        boolean containing1 = set.containsAll(set2);
        boolean containing2 = set.containsAll(set3);

        //Assert
        assertTrue(containing1);
        assertFalse(containing2);
    }

    @Test
    public void testEquals() {
        //Arrange
        Set<Stone> set = new StoneSet();
        set.add(new Emerald(1, 2));
        set.add(new    Ruby(3, 9));

        Set<Stone> equalSet = new StoneSet();
        equalSet.add(new Emerald(1, 2));
        equalSet.add(new    Ruby(3, 9));

        Set<Stone> otherSet = new StoneSet();
        otherSet.add(new Emerald(1, 2));
        otherSet.add(new    Ruby(2, 8));

        Set<Stone> hashSet = new HashSet<>();
        hashSet.add(new Emerald(1, 2));
        hashSet.add(new    Ruby(3, 9));

        //Act
        boolean equality1 = set.equals(equalSet);
        boolean equality2 = set.equals(otherSet);
        boolean equality3 = set.equals(hashSet);

        //Assert
        assertTrue(equality1);
        assertFalse(equality2);
        assertTrue(equality3);
    }

    @Test
    public void testHashCode() {
        //Arrange
        Set<Stone> set = new StoneSet();
        set.add(new Emerald(1, 2));
        set.add(new    Ruby(3, 9));

        Set<Stone> equalSet = new StoneSet();
        equalSet.add(new Emerald(1, 2));
        equalSet.add(new    Ruby(3, 9));

        Set<Stone> hashSet = new HashSet<>();
        hashSet.add(new Emerald(1, 2));
        hashSet.add(new    Ruby(3, 9));

        Set<Stone> otherSet = new StoneSet();
        otherSet.add(new Emerald(1, 2));
        otherSet.add(new    Ruby(2, 8));

        //Act
        int code  = set.hashCode();

        int code1 = equalSet.hashCode();
        int code2 =  hashSet.hashCode();
        int code3 = otherSet.hashCode();

        //Assert
        assertEquals(code, code1);
        assertEquals(code, code2);
        assertNotEquals(code, code3);
    }

    @Test
    public void testIsEmpty() {
        //Arrange
        Set<Stone> set = new StoneSet();

        //Act
        boolean before = set.isEmpty();
        set.add(new Emerald(1, 2));
        set.add(new Emerald(1, 2));
        set.add(new    Opal(3, 2));
        boolean after = set.isEmpty();

        //Assert
        assertTrue(before);
        assertFalse(after);
    }

    @Test
    public void testIteratorIterating() {
        //Arrange
        Set<Stone> set = new StoneSet();
        set.add(new Emerald(1, 2));
        set.add(new    Opal(3, 2));
        set.add(new    Onyx(1, 2));

        //Act
        int pos = 0;
        Stone[] array = new Stone[3];

        Iterator<Stone> iterator = set.iterator();
        while (iterator.hasNext()) {
            Stone element = iterator.next();
            array[pos] = element;
            pos++;
        }

        boolean equality0 = array[0].equals(new Emerald(1, 2));
        boolean equality1 = array[1].equals(new    Opal(3, 2));
        boolean equality2 = array[2].equals(new    Onyx(1, 2));

        //Assert
        assertTrue(equality0);
        assertTrue(equality1);
        assertTrue(equality2);
    }

    @Test
    public void testIteratorRemoving() {
        //Arrange
        Set<Stone> set = new StoneSet();
        set.add(new Emerald(1, 2));
        set.add(new    Opal(3, 2));
        set.add(new    Onyx(1, 2));

        //Act
        Iterator<Stone> iterator = set.iterator();
        while (iterator.hasNext()) {
            Stone element = iterator.next();
            if (element.equals(new Opal(3, 2))) {
                iterator.remove();
            }
        }

        //Assert
        assertFalse(set.contains(new Opal(3, 2)));
        assertEquals(2, set.size());
    }

    @Test
    public void testRemove() {
        //Arrange
        Set<Stone> set = new StoneSet();
        set.add(new Emerald(1, 2));
        set.add(new    Opal(3, 2));

        //Act
        boolean removing1 = set.remove(new Emerald(1, 2));
        boolean removing2 = set.remove(new Onyx(1, 2));

        //Assert
        assertTrue(removing1);
        assertFalse(removing2);
        assertEquals(1, set.size());
    }

    @Test
    public void testRemoveAll() {
        //Arrange
        Set<Stone> set = new StoneSet();
        set.add(new Emerald(1, 2));
        set.add(new    Ruby(3, 9));

        Set<Stone> set1 = new StoneSet();
        set1.add(new Emerald(2, 3));

        Set<Stone> set2 = new StoneSet();
        set2.add(new Emerald(1, 2));
        set2.add(new    Opal(3, 6));

        //Act
        boolean changed1 = set.removeAll(set1);
        boolean changed2 = set.removeAll(set2);

        //Assert
        assertFalse(changed1);
        assertTrue(changed2);
        assertEquals(1, set.size());
    }

    @Test
    public void testRetainAll() {
        //Arrange
        Set<Stone> set = new StoneSet();
        set.add(new Emerald(1, 2));
        set.add(new    Ruby(3, 9));

        Set<Stone> set1 = new StoneSet();
        set1.add(new Emerald(1, 2));
        set1.add(new    Ruby(3, 9));

        Set<Stone> set2 = new StoneSet();
        set2.add(new Ruby(3, 10));

        //Act
        boolean changed1 = set.retainAll(set1);
        int     size1 = set.size();

        boolean changed2 = set.retainAll(set2);
        int     size2 = set.size();

        //Assert
        assertFalse(changed1);
        assertEquals(2, size1);

        assertTrue(changed2);
        assertEquals(0, size2);
    }

    @Test
    public void testSize() {
        //Arrange
        Set<Stone> set = new StoneSet();

        //Act
        int before = set.size();
        set.add(new Emerald(1, 2));
        set.add(new    Opal(3, 2));
        int after = set.size();

        //Assert
        assertEquals(0, before);
        assertEquals(2, after);
    }

    @Test
    public void testToArray() {
        //Arrange
        Set<Stone> set = new StoneSet();
        set.add(new Emerald(1, 2));
        set.add(new    Ruby(3, 9));
        set.add(new    Onyx(2, 8));


        //Act
        Object[] array = set.toArray();
        Stone stone0 = (Stone) array[0];
        Stone stone1 = (Stone) array[1];
        Stone stone2 = (Stone) array[2];

        boolean equality0 = stone0.equals(new Emerald(1, 2));
        boolean equality1 = stone1.equals(new    Ruby(3, 9));
        boolean equality2 = stone2.equals(new    Onyx(2, 8));

        //Assert
        assertTrue(equality0);
        assertTrue(equality1);
        assertTrue(equality2);
    }

    @Test
    public void testToArrayWithParamLess() {
        //Arrange
        Set<Stone> set = new StoneSet();
        set.add(new Emerald(1, 2));
        set.add(new    Ruby(3, 9));
        set.add(new    Onyx(2, 8));


        //Act
        Object[] array = set.toArray(new Stone[2]);
        Stone stone0 = (Stone) array[0];
        Stone stone1 = (Stone) array[1];

        boolean equality0 = stone0.equals(new Emerald(1, 2));
        boolean equality1 = stone1.equals(new    Ruby(3, 9));
        boolean equality2 = array.length == 2;

        //Assert
        assertTrue(equality0);
        assertTrue(equality1);
        assertTrue(equality2);
    }

    @Test
    public void testToArrayWithParamEqual() {
        //Arrange
        Set<Stone> set = new StoneSet();
        set.add(new Emerald(1, 2));
        set.add(new    Ruby(3, 9));
        set.add(new    Onyx(2, 8));


        //Act
        Object[] array = set.toArray(new Stone[3]);
        Stone stone0 = (Stone) array[0];
        Stone stone1 = (Stone) array[1];
        Stone stone2 = (Stone) array[2];

        boolean equality0 = stone0.equals(new Emerald(1, 2));
        boolean equality1 = stone1.equals(new    Ruby(3, 9));
        boolean equality2 = stone2.equals(new    Onyx(2, 8));
        boolean equality3 = array.length == 3;

        //Assert
        assertTrue(equality0);
        assertTrue(equality1);
        assertTrue(equality2);
        assertTrue(equality3);
    }

    @Test
    public void testToArrayWithParamMore() {
        //Arrange
        Set<Stone> set = new StoneSet();
        set.add(new Emerald(1, 2));
        set.add(new    Ruby(3, 9));
        set.add(new    Onyx(2, 8));


        //Act
        Object[] array = set.toArray(new Stone[5]);
        Stone stone0 = (Stone) array[0];
        Stone stone1 = (Stone) array[1];
        Stone stone2 = (Stone) array[2];

        boolean equality0 = stone0.equals(new Emerald(1, 2));
        boolean equality1 = stone1.equals(new    Ruby(3, 9));
        boolean equality2 = stone2.equals(new    Onyx(2, 8));
        boolean equality3 = array[3] == null;
        boolean equality4 = array[4] == null;
        boolean equality5 = array.length == 5;

        //Assert
        assertTrue(equality0);
        assertTrue(equality1);
        assertTrue(equality2);
        assertTrue(equality3);
        assertTrue(equality4);
        assertTrue(equality5);
    }
}
