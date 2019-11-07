package pl.tdd.samples.inheritance.data;

class Owner {

    private final String name;

    Owner(String name) {
        this.name = name;
    }

    String name() {
        return name;
    }
}
