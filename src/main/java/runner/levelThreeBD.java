package runner;

import service.RouteService;

public class levelThreeBD extends Thread {
    @Override
    public void run() {
        // level 3 data structures
        RouteService routeService = RouteService.GetInstance();
    }
}
