package repository;
import model.Cargo;
import model.Town;

public class CargoRepository extends GenericRepo<Cargo>
{

    public CargoRepository()
    {
        super();
        AddObject( new Cargo( 12 ) );
        AddObject( new Cargo( 13 ) );
        AddObject( new Cargo( 14 ) );
        AddObject( new Cargo( 15 ) );
        AddObject( new Cargo( 16 ) );
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
