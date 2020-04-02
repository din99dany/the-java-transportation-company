package repository;
import model.Town;
import model.Vehicle;

public class TownRepository extends  GenericRepo<Town>
{
    public TownRepository()
    {
        super();
        AddObject( new Town( "Bucuresti", 45, 60 ) );
        AddObject( new Town( "Londa", 30, 0  ) );
        AddObject( new Town( "Craiova", 45, 33 ) );
        AddObject( new Town( "Dragasani", 45, 22 ) );
        AddObject( new Town( "Reactivi Cernaturi", 45, 11 ) );
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Town GetTownById(int id )
    {
        for( Town iterVehicle : m_data )
        {
            if ( id == iterVehicle.GetId() )
            {
                return iterVehicle;
            }
        }
        return null;
    }

    public boolean SetName( Town toSet, String newName )
    {
        if( IsValid(toSet) )
        {
            toSet.SetName( newName );
        }
        return IsValid(toSet);
    }

    public boolean SetCordinates( Town toSet, double newLat, double newLong )
    {
        if( IsValid(toSet) )
        {
            toSet.SetCordinates( newLat, newLong );
        }
        return IsValid(toSet);
    }
}
