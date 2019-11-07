package pl.tdd.samples.solid.l;

import java.util.ArrayList;

public class RecentlyUsedList extends ArrayList<String> {
    @Override
    public boolean add(String name) {
        if(this.contains(name)) {
            this.remove(name);
            this.add(0, name);
        } else {
            super.add(name);
        }
        return true;
    }
}
