package pl.tdd.samples.classes;

public class AddressValue {
    private final Town town;
    private final Street street;
    private final HouseNumber houseNumber;

    public AddressValue(Town town, Street street, HouseNumber houseNumber) {
        this.town = town;
        this.street = street;
        this.houseNumber = houseNumber;
    }

    private static class Town {
        private final String name;

        Town(String name) {
            this.name = name;
        }
    }

    private static class Street {
        private final String name;

        Street(String name) {
            this.name = name;
        }
    }

    private static class HouseNumber {
        private final String name;

        private HouseNumber(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Town town = new Town("London");
        Street street = new Street("Baker Street");
        HouseNumber houseNumber = new HouseNumber("221b");

        AddressValue sherlockAddress = new AddressValue(town, street, houseNumber);
    }
}

