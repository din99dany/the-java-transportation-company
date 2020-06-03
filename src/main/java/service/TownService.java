package service;

import model.Town;
import model.Vehicle;
import repository.TownRepository;

import java.util.List;

public class TownService
{
    public static TownService GetInstance()
    {
        if ( m_instance == null )
        {
            m_instance = new TownService();
            m_repo = new TownRepository();
        }
        return m_instance;
    }


    public Town GetTownById(int id )
    {
        Logger.Log();
        return m_repo.GetTownById( id );
    }

    public void AddTown( Town toAdd )
    {
        Logger.Log();
        m_repo.AddObject( toAdd );
    }

    public void RemoveTown( Town toRem )
    {
        Logger.Log();
        m_repo.RemoveObject( toRem );
    }

    public List<Town> GetTowns()
    {
        Logger.Log();
        return m_repo.GetData();
    }
    public void Update(Town toUpdate, Town updated )
    {
        m_repo.UpdateItem( toUpdate, updated );
    }
    private TownService()
    {
        Logger.Log();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static TownService m_instance;
    private static TownRepository m_repo;
}
