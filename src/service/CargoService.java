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
    }

    public void RemoveCargo( Cargo toRem )
    {
        m_repo.RemoveObject( toRem );
    }

    public List<Cargo> GetCargos()
    {
        return m_repo.GetData();
    }

    private CargoService()
    {
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static CargoService m_instance;
    private static CargoRepository m_repo;
}
