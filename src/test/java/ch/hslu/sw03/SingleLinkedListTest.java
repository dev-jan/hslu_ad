package ch.hslu.sw03;

import ch.hslu.ad.sw01.Allocation;
import ch.hslu.ad.sw02.Task;
import ch.hslu.ad.sw03.SingleLinkedList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

/**
 * Unittest for the @{@link ch.hslu.ad.sw03.SingleLinkedList}
 */
public class SingleLinkedListTest {
    private static final Logger LOG = LogManager.getLogger(Task.class);

    @Test
    public void test_addFirstElement() {
        // arrange
        Allocation element = new Allocation(1,1);
        SingleLinkedList<Allocation> list = new SingleLinkedList<>();

        // act
        list.add(element);

        // assert
        assertThat(list.get(0)).isEqualTo(element);
    }

    @Test
    public void test_size_EmptyList() {
        // arrange
        SingleLinkedList<Allocation> list = new SingleLinkedList<>();

        // act
        int size = list.size();

        // assert
        assertThat(size).isEqualTo(0);
    }

    @Test
    public void test_size_NonEmptyList() {
        // arrange
        SingleLinkedList<Allocation> list = new SingleLinkedList<>();
        list.add(new Allocation(1,1 ));
        list.add(new Allocation(2,1));
        list.add(new Allocation(3,1));

        // act
        int size = list.size();

        // assert
        assertThat(size).isEqualTo(3);
    }

    @Test
    public void test_get_existingItem() {
        // arrange
        SingleLinkedList<Allocation> list = new SingleLinkedList<>();
        list.add(new Allocation(1,1));
        Allocation secondElement = new Allocation(2,1);
        list.add(secondElement);

        // act
        Allocation allocationAtIndexOne = list.get(1);

        // assert
        assertThat(allocationAtIndexOne).isEqualTo(secondElement);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_get_notExistingItem() {
        // arrange
        SingleLinkedList<Allocation> list = new SingleLinkedList<>();
        list.add(new Allocation(1,1));
        list.add(new Allocation(2,1));

        // act
        list.get(2);
    }

    @Test
    public void test_contains_existingElement() {
        // arrange
        SingleLinkedList<Allocation> list = new SingleLinkedList<>();
        list.add(new Allocation(1,2));
        list.add(new Allocation(2,2));
        list.add(null);
        Allocation allocationToSearch = new Allocation(3,3);
        list.add(allocationToSearch);

        // act
        boolean containsResult = list.contains(allocationToSearch);

        // assert
        assertThat(containsResult).isTrue();
    }

    @Test
    public void test_contains_notExistingElement() {
        // arrange
        SingleLinkedList<Allocation> list = new SingleLinkedList<>();
        list.add(new Allocation(1,2));
        list.add(new Allocation(2,2));

        Allocation allocationToSearch = new Allocation(3,3);

        // act
        boolean containsResult = list.contains(allocationToSearch);

        // assert
        assertThat(containsResult).isFalse();
    }

    @Test
    public void test_contains_null() {
        // arrange
        SingleLinkedList<Allocation> list = new SingleLinkedList<>();
        list.add(new Allocation(1,1));
        list.add(new Allocation(2,2));
        list.add(null);

        // act
        boolean containsResult = list.contains(null);

        // assert
        assertThat(containsResult).isTrue();
    }

    @Test
    public void test_remove_lastElementOfList() {
        // arrange
        SingleLinkedList<Allocation> list = new SingleLinkedList<>();
        list.add(new Allocation(1,1));
        list.add(null);
        Allocation allocationToRemove = new Allocation(3,3);
        list.add(allocationToRemove);

        // act
        boolean returnFlag = list.remove(allocationToRemove);

        // assert
        assertThat(returnFlag).isTrue();
        assertThat(list.contains(allocationToRemove)).isFalse();
    }

    @Test
    public void test_iteration() {
        // arrange
        SingleLinkedList<Allocation> list = new SingleLinkedList<>();
        list.add(new Allocation(1,1));
        list.add(new Allocation(2,2));
        list.add(null);
        int counter = 0;

        // act
        for (Allocation a : list) {
            LOG.info("Current list element: " + a);
            counter++;
        }

        // assert
        assertThat(counter).isEqualTo(3);
    }

    @Test
    public void test_popFirstElement_elementExists() {
        // arrange
        SingleLinkedList<Allocation> list = new SingleLinkedList<>();
        Allocation firstAllocation = new Allocation(1,1);
        list.add(firstAllocation);
        list.add(new Allocation(2,2));

        // act
        Allocation returnValue = list.popFirstElement();

        // assert
        assertThat(list.size()).isEqualTo(1);
        assertThat(list.isEmpty()).isFalse();
        assertThat(returnValue).isEqualTo(firstAllocation);
    }

    @Test
    public void test_popFirstElement_emptyList() {
        // arrange
        SingleLinkedList<Allocation> list = new SingleLinkedList<>();

        // act
        Allocation returnValue = list.popFirstElement();

        // assert
        assertThat(list.isEmpty()).isTrue();
        assertThat(returnValue).isNull();
    }

}
