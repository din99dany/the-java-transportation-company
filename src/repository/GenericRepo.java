package repository;

import model.Town;
import service.Logger;
import service.SerializeStorage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GenericRepo< T extends Serializable>
{
    public GenericRepo()
    {
        Logger.Log();
        m_data = new ArrayList<>();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean AddObject( T toAdd )
    {
        Logger.Log();
        if ( IsValid( toAdd ) )
        {
            m_data.add( toAdd );
        }
        return IsValid( toAdd );
    }

    public boolean RemoveObject( T toRemove )
    {
        Logger.Log();
        boolean res = IsValid(toRemove);
        if ( res )
        {
            m_data.remove(toRemove);
        }
        return res;
    }

    public void WriteContent()
    {
        try {

            FileWriter myWriter = new FileWriter(m_dataFile);
            SerializeStorage serService = SerializeStorage.GetInstance();
            for ( T iter : m_data )
            {
                String toString = new String( serService.<T>SerializeToString(iter) );
                myWriter.write( toString + "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("I/O error");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
    }

    public void Loadontent()
    {
        Logger.Log();
        try {

            SerializeStorage serService = SerializeStorage.GetInstance();
            BufferedReader reader = new BufferedReader(new FileReader( m_dataFile));
            String line = reader.readLine();
            while( line != null )
            {
                AddObject( serService.<T>GetObjectFromString(line) ) ;
                line = reader.readLine();
            }
            reader.close();

        } catch (IOException e) {
            System.out.println("I/O error");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
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
}
