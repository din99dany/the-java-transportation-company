package runner;

import service.IntercityLinkService;
import service.OrderService;

public class levelTwoBd extends Thread {

    @Override
    public void run() {
        // level 2 data structures
        OrderService orderService = OrderService.GetInstance();
        IntercityLinkService intercityLinkService = IntercityLinkService.GetInstance();
    }
}
