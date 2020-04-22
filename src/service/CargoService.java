package service;

import model.Cargo;
import repository.CargoRepository;

import java.util.List;

public class CargoService
{
    public static CargoService GetInstance()
    {
        if ( m_instance == null )
        {
            m_instance = new CargoService();
            m_repo = new CargoRepository();
        }
        return m_instance;
    }

    public Cargo GetCargoById(int id )
    {
        return m_repo.GetCargoById( id );
    }

    public void AddCargo( Cargo toAdd )
    {
        m_repo.AddObject( toAdd );
        Logger.Log();
    }

    public void RemoveCargo( Cargo toRem )
    {
        Logger.Log();
        m_repo.RemoveObject( toRem );
    }

    public List<Cargo> GetCargos()
    {
        return m_repo.GetData();
    }

    public void Write()
    {
        Logger.Log();
        m_repo.WriteContent();
    }

    private CargoService()
    {
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static CargoService m_instance;
    private static CargoRepository m_repo;
}
