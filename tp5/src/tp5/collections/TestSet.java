package tp5.collections;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TestSet {
    public static void main(String[] args) {
        System.out.println("========== B - Sets");
        set1();
        set2();
        set3();
        set4();
        set5();
        set5Lambda();
        set6();
        set6Lambda();
    }

    private static void set6Lambda() {
        System.out.println("========== Set 6 tree client lambda");
        Set<Client> set6 =
                new TreeSet<>((o1,o2) -> String.CASE_INSENSITIVE_ORDER.compare(o1.name, o2.name));
        set6.add(new Client(4,"OMAR"));
        set6.add(new Client(3,"SAID"));
        set6.add(new Client(2,"HASSAN"));
        set6.forEach(i-> System.out.println(i));
    }

    private static void set5Lambda() {
        System.out.println("========== Set 5 tree client lambda");
        Set<Client> set5 = new TreeSet<>((o1,o2) -> o1.code - o2.code);
        set5.add(new Client(4,"OMAR"));
        set5.add(new Client(3,"SAID"));
        set5.add(new Client(2,"HASSAN"));
        set5.forEach(i-> System.out.println(i));
    }

    private static void set6() {
        System.out.println("========== Set 6 tree client compare by name");
        Comparator<Client> c = new NameComparator();
        Set<Client> set6 = new TreeSet<>(c);
        set6.add(new Client(4,"OMAR"));
        set6.add(new Client(3,"SAID"));
        set6.add(new Client(2,"HASSAN"));
        set6.forEach(i-> System.out.println(i));
    }

    private static void set5() {
        System.out.println("========== Set 5 tree client");
        Comparator<Client> c = new CodeComparator();
        Set<Client> set5 = new TreeSet<>(c);
        set5.add(new Client(4,"OMAR"));
        set5.add(new Client(3,"SAID"));
        set5.add(new Client(2,"HASSAN"));
        set5.forEach(i-> System.out.println(i));
    }

    private static void set4() {
        try {
            System.out.println("========== Set 4 tree client");
            Set<Client> set4 = new TreeSet<>();
            set4.add(new Client(1, "OMAR"));
            set4.add(new Client(3, "SAID"));
            set4.add(new Client(2, "HASSAN"));
            set4.forEach(i -> System.out.println(i));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void set3() {
        System.out.println("========== Set 3 tree");
        Set<Integer> set3 = new TreeSet<>();
        set3.add(22);
        set3.add(11);
        set3.add(15);
        set3.add(9);
        set3.forEach(i-> System.out.println(i));

    }

    private static void set2() {
        System.out.println("========== Set 2 client");
        Set<Client> set2 = new HashSet<Client>();
        set2.add(new Client(1,"ALAMI"));
        set2.add(new Client(1,"ALAMI"));
        set2.add(new Client(2,"SOUHAIL"));
        set2.forEach(i-> System.out.println(i));
    }


    private static void set1() {
        System.out.println("========== Set 1");
        Set<String> set1 = new HashSet<String>();
        set1.add("ABC1");
        set1.add("ABC2");
        set1.add("ABC3");
        set1.add("ABC1");
        set1.add("ABC4");
        set1.add("ABC5");
        set1.forEach(i-> System.out.println(i));

    }
}
