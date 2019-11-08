package pl.tdd.samples.classes;

public class PersonObject {
    private final Identity identity;
    private PersonData personData;

    public PersonObject(Identity identity, PersonData personData) {
        this.identity = identity;
        this.personData = personData;
    }

    public void changeName(String name) {
        personData = personData.withName(name);
    }

    public void wakeUp() {

    }

    public void sleep() {

    }

    private class PersonData {
        private final String name;
        private final String surname;

        private PersonData(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public PersonData withName(String name) {
            return new PersonData(name, this.surname);
        }
    }

    private class Identity {
    }
}
