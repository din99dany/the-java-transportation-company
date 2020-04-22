package repository;
import model.Town;
import model.Vehicle;

public class TownRepository extends  GenericRepo<Town>
{
    public TownRepository()
    {
        super();
        m_dataFile = "./Data/Town.txt";
        Loadontent();
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
