package service;

import model.Vehicle;
import repository.VehicleRepository;
import java.util.List;

public class VehicleService
{
    public static VehicleService GetInstance()
    {
        if ( m_instance == null )
        {
            m_instance = new VehicleService();
            m_repo = new VehicleRepository();
        }
        return m_instance;
    }

    public void Update( Vehicle toUpdate, Vehicle updated )
    {
        m_repo.UpdateItem( toUpdate, updated );
    }

    public Vehicle GetCarById(int id )
    {
        return m_repo.GetVehicleById( id );
    }

    public void AddVehicle( Vehicle toAdd )
    {
        m_repo.AddObject( toAdd );
    }

    public void RemoveVehicle( Vehicle toRem )
    {
        m_repo.RemoveObject( toRem );
    }

    public List<Vehicle> GetVehicles()
    {
        return m_repo.GetData();
    }

    private VehicleService()
    {
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static VehicleService m_instance;
    private static VehicleRepository m_repo;
}
