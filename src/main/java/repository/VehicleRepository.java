package repository;
import model.*;
import service.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class VehicleRepository extends GenericRepo<Vehicle>
{
    public VehicleRepository()
    {
        super();
        LoadContent();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void LoadContent()
    {
        try {
            m_data.addAll(ReadDataBaseService.ReadVehicles( m_dbConnection ));
        } catch (Exception e)   {
            e.printStackTrace();
        }
    }

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
