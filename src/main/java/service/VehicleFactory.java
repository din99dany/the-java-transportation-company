package service;

import model.Truck;
import model.Van;
import model.Vehicle;
import model.Car;

public class VehicleFactory
{
    static public Vehicle BuildVehicle( String type, double mass, double fuel )
    {
        if (type.equals("Car"))
        {
            return new Car( mass, fuel);
        }
        else if (type.equals("Van"))
        {
            return  new Van( mass, fuel );
        }
        else
        {
            return new Truck( mass, fuel);
        }
    }
}
