package runner;

import service.CargoService;
import service.TownService;
import service.VehicleService;

public class levelOneDB extends Thread {
    @Override
    public void run() {
        VehicleService vehicleService = VehicleService.GetInstance();
        TownService townService = TownService.GetInstance();
        CargoService cargoServ = CargoService.GetInstance();
    }
}
