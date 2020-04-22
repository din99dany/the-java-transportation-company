package repository;
import model.Cargo;
import model.Town;

public class CargoRepository extends GenericRepo<Cargo>
{

    public CargoRepository()
    {
        super();
        m_dataFile = "./Data/Cargo.txt";
        Loadontent();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Cargo GetCargoById( int id )
    {
        for( Cargo iterVehicle : m_data )
        {
            if ( id == iterVehicle.GetId() )
            {
                return iterVehicle;
            }
        }
        return null;
    }
}
