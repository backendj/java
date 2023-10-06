package dev.backendj;

public class SequencedCollections {


    public static class Inventory {

        private final SequencedCollection<Stock> stocks = new SequencedCollection<>();


        // add a new stock to the end of the list
        public void addStock(Stock stock) {
            stocks.add(stock);
        }

        // decrease the quantity of the stock at the given name
        public void decreaseStock(String name, int quantity) {
            for (Stock stock : stocks) {
                if (stock.name().equals(name)) {
                    if (stock.quantity() < quantity) {
                        throw new IllegalArgumentException("Not enough stock");
                    }
                    stocks.set(stock, new Stock(name, stock.quantity() - quantity));
                    return;
                }
            }
            throw new IllegalArgumentException("No such stock");
        }
        


    }
    


    public static record Stock(String name, int quantity) {
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
