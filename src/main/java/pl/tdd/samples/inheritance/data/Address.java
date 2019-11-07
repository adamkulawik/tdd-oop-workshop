package pl.tdd.samples.inheritance.data;

class Address {
    private final String address;

    Address(String address) {
        this.address = address;
    }

    String address() {
        return address;
    }
}
