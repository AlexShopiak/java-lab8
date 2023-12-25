import collection.StoneSet;
import stone.*;
import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        try {
            Set<Stone> set = new StoneSet(new Emerald(1, 2));
            set.add(new Pearl(1, 2));
            set.add(new Ruby(1, 10));

            //Size before
            int res1 = set.size();
            System.out.println("Size: " + res1);//3

            //Removing
            boolean res2 = set.remove(new Emerald(1, 2));
            System.out.println("Removed: " + res2);//true

            //Containing
            boolean res3 = set.contains(new Ruby(1, 10));
            System.out.println("Contains: " + res3);//true

            //Size after
            int res5 = set.size();
            System.out.println("Size: " + res5);//2

            //AllContaining
            HashSet<Stone> set2 = new HashSet<>();
            set2.add(new Pearl(1, 2));
            set2.add(new Ruby(1, 10));

            boolean res6 = set.containsAll(set2);
            System.out.println("ContainsAll: " + res6);//true

            //AllAdding
            set2.add(new Opal(2,3));
            set2.add(new Opal(3,2));
            set.addAll(set2);
            int res7 = set.size();
            System.out.println("Size: " + res7);//4

            //Clearing
            set.clear();
            int res8 = set.size();
            System.out.println("Size: " + res8);//0

            //Comparing
            set.add(new Ruby(1,1));
            set.add(new Opal(2,3));

            Set<Stone> set3 = new StoneSet();
            set3.add(new Ruby(1,1));
            set3.add(new Opal(2,3));

            Set<Stone> set4 = new HashSet<>();
            set4.add(new Ruby(1,1));
            set4.add(new Opal(2,3));

            int res9 = set.hashCode();
            int res10 = set3.hashCode();
            int res11 = set4.hashCode();

            boolean res12 = set.equals(set3);
            boolean res13 = set.equals(set4);
            System.out.println("HashCode: " + res9);
            System.out.println("HashCode: " + res10);
            System.out.println("HashCode: " + res11);
            System.out.println("Equals: " + res12);//true
            System.out.println("Equals: " + res13);//true

            //ToArray
            Object[] arr = set.toArray();
            for (Object stone : arr) {
                System.out.println(stone);
            }

            //Iterating
            Iterator<Stone> iterator = set.iterator();
            while (iterator.hasNext()) {
                Stone s = iterator.next();
                System.out.println("ToDelete: " + s);
                iterator.remove();
            }
            System.out.println("Size: " + set.size()); //0

            //Сatching
            Set<Stone> nullSet = null;
            set.addAll(nullSet);
        } catch (Exception err) {
            System.out.println("Error: " + err);//NullPointerException
        }
    }
}
