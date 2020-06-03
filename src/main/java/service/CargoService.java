package service;

import model.Cargo;
import model.IntercityLink;
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

    public void Update(Cargo toUpdate, Cargo updated )
    {
        m_repo.UpdateItem( toUpdate, updated );
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
    }

    private CargoService()
    {
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static CargoService m_instance;
    private static CargoRepository m_repo;
}
