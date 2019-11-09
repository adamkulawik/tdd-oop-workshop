package pl.tdd.samples.solid.l;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RecentlyUsedListTest {

    @Test
    public void addingItemToArrayList () {
        // given
        List<String> list = new ArrayList<>();
        addThreeElementsToList(list);

        // when
        list.add("name3");

        // then
        assertThat(list).hasSize(4);
        assertThat(list).containsExactly("name1", "name2", "name3", "name3");
    }

    @Test
    public void addingItemToLinkedList () {
        // given
        List<String> list = new LinkedList<>();
        addThreeElementsToList(list);

        // when
        list.add("name3");

        // then
        assertThat(list).hasSize(4);
        assertThat(list).containsExactly("name1", "name2", "name3", "name3");
    }

    @Test
    public void addingItemToRecentylUsedList () {
        // given
        List<String> list = new RecentlyUsedList();
        addThreeElementsToList(list);

        // when
        list.add("name3");

        // then
        assertThat(list).hasSize(4);
        assertThat(list).containsExactly("name1", "name2", "name3", "name3");
    }

    private void addThreeElementsToList(List<String> list) {
        list.add("name1");
        list.add("name2");
        list.add("name3");
    }
}