package pl.tdd.samples.encapsulation.module.stations;

import java.util.List;

public class ChargingStationFacade {
    private Readmodel readmodel;
    private StationInstaller installer;

    public void install(Long stationId, AddressDto addressDto, Long customerId) {
        installer.install(stationId, addressDto, customerId);
    }

    public void uninstall(Long stationId, Long customerId) {
        installer.uninstall(stationId, customerId);
    }

    public List<StationDto> viewAll() {
        return readmodel.all();
    }

    public static final class AddressDto {
        private final String address;

        public AddressDto(String address) {
            this.address = address;
        }
    }

    public static final class StationDto {
        private final String data;

        public StationDto(String data) {
            this.data = data;
        }
    }
}
