package collection;

import java.util.Collection;

public class ErrorHandler {
    public static void checkObjForNull(Object element) {
        if (element == null) {
            throw new NullPointerException();
        }
    }

    public static void checkCollForNull(Collection<?> collection) {
        if (collection == null) {
            throw new NullPointerException();
        }

    }

    public static <T> void checkArrForNull(T[] array) {
        if (array == null) {
            throw new NullPointerException();
        }
    }
}
