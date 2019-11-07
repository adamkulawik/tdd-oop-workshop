package pl.tdd.samples.solid.l;

import java.util.ArrayList;

class RecentlyUsedListComposed {
    private final ArrayList<String> names = new ArrayList<>();

    public void add(String name) {
        if(names.contains(name)) {
            names.remove(name);
            names.add(0, name);
        }
    }
}
