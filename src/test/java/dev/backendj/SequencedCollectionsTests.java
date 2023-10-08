package dev.backendj;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * SequencedCollection is a collection that further guarantees that its iterator will
 * traverse the collection in either the forward or reverse direction.
 * <p>
 * <a href="https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/SequencedCollection.html">SequencedCollection</a>
 */
class SequencedCollectionsTests {

    private LinkedList<Stock> stocks;

    @BeforeEach
    void setUp() {
        stocks = new LinkedList<>();
    }

    @Test
    void testAddFirstAndLastFeature() {
        Stock example1Stock = new Stock("Example1", 5);
        stocks.add(example1Stock);
        Stock example2Stock = new Stock("Example2", 8);
        stocks.add(example2Stock);
        Stock firstStock = new Stock("First", 10);
        stocks.addFirst(firstStock);
        Stock lastStock = new Stock("Last", 20);
        stocks.addLast(lastStock);

        assertEquals(firstStock, stocks.getFirst());
        assertEquals(lastStock, stocks.getLast());
    }

    @Test
    void testRemoveFirstAndLastFeature() {
        Stock example1Stock = new Stock("Example1", 5);
        stocks.add(example1Stock);
        Stock example2Stock = new Stock("Example2", 8);
        stocks.add(example2Stock);
        Stock firstStock = new Stock("First", 10);
        stocks.addFirst(firstStock);
        Stock lastStock = new Stock("Last", 20);
        stocks.addLast(lastStock);

        stocks.removeFirst();
        stocks.removeLast();

        assertEquals(example1Stock, stocks.getFirst());
        assertEquals(example2Stock, stocks.getLast());
    }

    @Test
    void testReversedFeature() {
        Stock example1Stock = new Stock("Example1", 5);
        stocks.add(example1Stock);
        Stock example2Stock = new Stock("Example2", 8);
        stocks.add(example2Stock);
        Stock firstStock = new Stock("First", 10);
        stocks.addFirst(firstStock);
        Stock lastStock = new Stock("Last", 20);
        stocks.addLast(lastStock);

        List<Stock> reversedList = stocks.reversed();

        assertEquals(lastStock, reversedList.get(0));
        assertEquals(example2Stock, reversedList.get(1));
        assertEquals(example1Stock, reversedList.get(2));
        assertEquals(firstStock, reversedList.get(3));
    }

    private record Stock(String name, int quantity) {
        public Stock {
            if (name == null) {
                throw new IllegalArgumentException("Name must not be null");
            }
            if (quantity < 0) {
                throw new IllegalArgumentException("Quantity must be positive");
            }
        }
    }

}
