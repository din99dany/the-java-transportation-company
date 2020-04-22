package com.company;
import model.*;
import service.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        TownService townService = TownService.GetInstance();
        VehicleService vehicleService = VehicleService.GetInstance();
        IntercityLinkService linkService = IntercityLinkService.GetInstance();
        CargoService cargoService = CargoService.GetInstance();
        OrderService orderService = OrderService.GetInstance();
        RouteService roteService = RouteService.GetInstance();

        Route routeForA = roteService.GetOrderRoute( orderService.GetOrderById( 0 ) );
        Route routeForB = roteService.GetOrderRoute( orderService.GetOrderById( 1 ) );

        if ( routeForA != null )
        {
            System.out.println( routeForA.toString() );
        }
        else
        {
            System.out.println( "Cant route order " + orderService.GetOrderById( 0 ).toString() );
        }

        if ( routeForB != null )
        {
            System.out.println( routeForB.toString() );
        }
        else
        {
            System.out.println( "Cant route order " + orderService.GetOrderById( 1 ).toString() );
        }

    }
}
