package tests;

import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import collection.ErrorHandler;
import stone.Stone;


public class ErrorHandlerTest {
    @Test(expected = NullPointerException.class)
    public void arrNullTest() {
        Stone[] array = null;
        ErrorHandler.checkArrForNull(array);
    }

    @Test
    public void arrTest() {
        Stone[] array = new Stone[3];
        ErrorHandler.checkArrForNull(array);
    }

    @Test(expected = NullPointerException.class)
    public void collNullTest() {
        Collection<Stone> collection = null;
        ErrorHandler.checkCollForNull(collection);
    }

    @Test
    public void collTest() {
        Set<Stone> collection = new HashSet<>();
        ErrorHandler.checkCollForNull(collection);
    }

    @Test(expected = NullPointerException.class)
    public void objNullTest() {
        Stone element = null;
        ErrorHandler.checkObjForNull(element);
    }

    @Test
    public void objTest() {
        Stone element = new Stone(1, 100, 1);
        ErrorHandler.checkObjForNull(element);
    }
}
