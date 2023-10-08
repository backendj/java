package dev.backendj;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SequencedCollectionsTests {

    private LinkedList<Stock> stocks;

    @BeforeEach
    void setUp() {
        stocks = new LinkedList<>();
    }

    @Test
    void testAddFirstFeature() {
        stocks.add(new Stock("First", 5));
        stocks.addFirst(new Stock("Apple", 10));

        assertEquals("Apple", stocks.getFirst().name());
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
