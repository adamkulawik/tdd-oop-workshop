package pl.tdd.samples.polymorphism;

class Owner {

    private final String name;

    Owner(String name) {
        this.name = name;
    }

    String name() {
        return name;
    }
}
