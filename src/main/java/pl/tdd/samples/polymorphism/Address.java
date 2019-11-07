package pl.tdd.samples.polymorphism;

class Address {
    private final String address;

    Address(String address) {
        this.address = address;
    }

    String address() {
        return address;
    }
}
