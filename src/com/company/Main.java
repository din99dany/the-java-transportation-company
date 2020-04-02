package com.company;
import model.*;
import service.*;

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

        //create some cargos
        cargoService.AddCargo( new Cargo( 10 ) );
        cargoService.AddCargo( new Cargo( 11 ) );
        cargoService.AddCargo( new Cargo( 12 ) );
        cargoService.AddCargo( new Cargo( 13 ) );

        //create some links
        linkService.CreateLink( townService.GetTownById( 0 ), townService.GetTownById( 1 ) );
        linkService.CreateLink( townService.GetTownById( 1 ), townService.GetTownById( 2 ) );
        linkService.CreateLink( townService.GetTownById( 2 ), townService.GetTownById( 3 ) );

        //create one route
        roteService.CreateRoute( vehicleService.GetCarById( 1 ) );
        roteService.AddLinkToRoute( 0, linkService.GetLinkById( 0 ) );
        roteService.AddLinkToRoute( 0, linkService.GetLinkById( 1 ) );
        roteService.AddLinkToRoute( 0, linkService.GetLinkById( 2 ) );

        // create some orders
        orderService.CreateOrder( cargoService.GetCargoById(1),
                townService.GetTownById( 0 ),
                townService.GetTownById( 2 ) );

        orderService.CreateOrder( cargoService.GetCargoById( 3 ),
                townService.GetTownById( 1 ),
                townService.GetTownById( 4 ) );

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
