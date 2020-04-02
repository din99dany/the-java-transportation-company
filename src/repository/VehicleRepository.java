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
        AddObject( new Car( 11, 11 ) );
        AddObject( new Car( 22, 22 ) );
        AddObject( new Truck( 33, 33 ) );
        AddObject( new Truck( 44, 44 ) );
        AddObject( new Van( 55, 55 ) );
        AddObject( new Van( 66, 66 ) );
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
