package service;
import java.util.*;
import java.io.*;

public class SerializeStorage
{

    private SerializeStorage()
    {

    }

    public static SerializeStorage GetInstance()
    {
        if ( m_instance == null )
        {
            m_instance = new SerializeStorage();
        }
        return m_instance;
    }

    public <T extends   Serializable> String SerializeToString( T toSerr )
            throws IOException,
            ClassNotFoundException
    {
        return toString( toSerr );
    }

    public < T extends  Serializable > T GetObjectFromString( String toDes )
            throws IOException ,
            ClassNotFoundException
    {
        return (T) fromString(toDes);
    }

    private Object fromString( String s ) throws IOException ,
            ClassNotFoundException {
        byte [] data = Base64.getDecoder().decode( s );
        ObjectInputStream ois = new ObjectInputStream(
                new ByteArrayInputStream(  data ) );
        Object o  = ois.readObject();
        ois.close();
        return o;
    }

    private String toString( Serializable o ) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream( baos );
        oos.writeObject( o );
        oos.close();
        return Base64.getEncoder().encodeToString(baos.toByteArray());
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static SerializeStorage m_instance;
}

