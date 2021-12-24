package tp5.collections;

import java.util.Comparator;

public class NameComparator implements Comparator<Client> {
    @Override
    public int compare(Client o1, Client o2) {
        return String.CASE_INSENSITIVE_ORDER.compare(o1.name, o2.name);
    }
}

