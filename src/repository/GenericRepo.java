package repository;

import java.util.ArrayList;
import java.util.List;

public class GenericRepo< T >
{
    public GenericRepo()
    {
        m_data = new ArrayList<>();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean AddObject( T toAdd )
    {
        if ( IsValid( toAdd ) )
        {
            m_data.add( toAdd );
        }
        return IsValid( toAdd );
    }

    public boolean RemoveObject( T toRemove )
    {
        boolean res = IsValid(toRemove);
        if ( res )
        {
            m_data.remove(toRemove);
        }
        return res;
    }

    public List<T> GetData()
    {
        return m_data;
    }

    public boolean IsValid( T toCheck )
    {
        return toCheck != null;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    protected List<T> m_data;
}
