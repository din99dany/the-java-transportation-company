package service;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DataBaseManipulationService extends Thread
{
    public DataBaseManipulationService( Connection dbConnection, String query)
    {
        m_dbConnection = dbConnection;
        m_query = query;
    }

    @Override
    public void run()
    {
        Logger.Log();
        try
        {
            PreparedStatement statemnt =  m_dbConnection.prepareStatement(m_query);
            statemnt.execute();
        }
        catch (Exception ex )
        {
            ex.printStackTrace();
        }

    }



    private Connection m_dbConnection;
    private String m_query;
}
