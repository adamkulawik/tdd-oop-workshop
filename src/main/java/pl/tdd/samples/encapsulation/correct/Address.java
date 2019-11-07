package pl.tdd.samples.encapsulation.correct;

class Address {
    private final String address;

    Address(String address) {
        this.address = address;
    }

    String address() {
        return address;
    }
}
