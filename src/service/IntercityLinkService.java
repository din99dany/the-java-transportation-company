package service;

import model.IntercityLink;
import model.Town;
import repository.IntercityLinkRepository;

import java.util.List;

public class IntercityLinkService
{

    public static IntercityLinkService GetInstance()
    {
        if ( m_instance == null )
        {
            m_instance = new IntercityLinkService();
            m_repo = new IntercityLinkRepository();
        }
        return m_instance;
    }

    public boolean CreateLink( Town source, Town dest )
    {
        if ( source == null || dest == null )
        {
            return  false;
        }
        AddLink( new IntercityLink( source, dest ) );
        return true;
    }

    public IntercityLink GetLinkById( int id )
    {
        return m_repo.GetLinkById( id );
    }

    public void AddLink( IntercityLink toAdd )
    {
        m_repo.AddObject( toAdd );
    }

    public void RemoveLink( IntercityLink toRem )
    {
        m_repo.RemoveObject( toRem );
    }

    public List<IntercityLink> GetLinks()
    {
        return m_repo.GetData();
    }

    private IntercityLinkService()
    {
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static IntercityLinkService m_instance;
    private static IntercityLinkRepository m_repo;
}
