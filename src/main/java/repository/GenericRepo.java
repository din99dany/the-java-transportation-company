package repository;
import model.dataBaseInsertable;
import service.DataBaseManipulationService;
import service.Logger;
import java.util.ArrayList;
import java.util.List;

import java.sql.*;

public class GenericRepo < T extends dataBaseInsertable >
{
    public GenericRepo()
    {
        Logger.Log();
        m_data = new ArrayList<>();
        if ( m_dbConnection == null )
        {
            ConnectToDB();
        }
    }

    public void ConnectToDB()
    {
        String url = "jdbc:mysql://localhost/transportdb";
        String username = "root";
        String password = "";
        try {
            m_dbConnection = DriverManager.getConnection(url, username, password);
        } catch (Exception e)   {
            e.printStackTrace();
        }

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean AddObject( T toAdd )
    {
        if ( IsValid( toAdd ) )
        {
            try{
                DataBaseManipulationService dataBaseManipulationService =
                        new DataBaseManipulationService( m_dbConnection, toAdd.GetInsertQuery() );
                dataBaseManipulationService.start();
                dataBaseManipulationService.join();
                m_data.add(toAdd);
            }
            catch (Exception ex )
            {
                ex.printStackTrace();
            }

        }
        return IsValid( toAdd );
    }

    public boolean RemoveObject( T toRemove )
    {
        Logger.Log();
        boolean res = IsValid(toRemove);
        if ( res )
        {
            try{
                DataBaseManipulationService dataBaseManipulationService =
                        new DataBaseManipulationService( m_dbConnection, toRemove.GetInsertQuery() );
                dataBaseManipulationService.start();
                dataBaseManipulationService.join();
                m_data.remove(toRemove);
            } catch (Exception ex )
            {
                ex.printStackTrace();
            }
        }
        return res;
    }

    public boolean UpdateItem( T toUpdate, T updated )
    {
        Logger.Log();
        boolean res = IsValid(toUpdate);
        if ( res )
        {
            try{
                DataBaseManipulationService dataBaseManipulationService =
                        new DataBaseManipulationService( m_dbConnection, updated.GetUpdateQuery() );
                dataBaseManipulationService.start();
                dataBaseManipulationService.join();

                m_data.remove( toUpdate);
                m_data.add( updated );

            } catch (Exception ex )
            {
                ex.printStackTrace();
            }
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
    protected String m_dataFile;
    protected static Connection m_dbConnection;
}
