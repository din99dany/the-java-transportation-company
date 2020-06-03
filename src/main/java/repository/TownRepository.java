package repository;
import model.Order;
import model.Town;
import model.Vehicle;
import service.CargoService;
import service.ReadDataBaseService;
import service.TownService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TownRepository extends  GenericRepo<Town>
{
    public TownRepository()
    {
        super();
        m_dataFile = "./Data/Town.txt";
        LoadContent();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void LoadContent()
    {
        try {
            m_data.addAll(ReadDataBaseService.ReadTowns( m_dbConnection ));
        } catch (Exception e)   {
            e.printStackTrace();
        }
    }

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
