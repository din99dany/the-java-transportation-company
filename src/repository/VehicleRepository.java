package repository;
import model.Vehicle;
import model.Truck;
import model.Car;
import model.Van;

public class VehicleRepository extends GenericRepo<Vehicle>
{
    public VehicleRepository()
    {
        super();
        m_dataFile = "./Data/Vehicle.txt";
        Loadontent();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Vehicle GetVehicleById( int id )
    {
        for( Vehicle iterVehicle : m_data )
        {
            if ( id == iterVehicle.GetId() )
            {
                return iterVehicle;
            }
        }
        return null;
    }

    public boolean SetWeight( Vehicle toChange, double newWeight )
    {
        if ( IsValid(toChange) )
        {
            toChange.SetWeight( newWeight );
        }
        return IsValid(toChange);
    }

    public boolean SetFuelReserve( Vehicle toChange, double newFuelReserve )
    {
        if ( IsValid(toChange) )
        {
            toChange.SetWeight( newFuelReserve );
        }
        return IsValid(toChange);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
