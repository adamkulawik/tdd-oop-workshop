package pl.tdd.customers;

public class CustomerID {
    private final String raw;

    public CustomerID(String raw) {
        this.raw = raw;
    }

    public String raw() {
        return raw;
    }
}
