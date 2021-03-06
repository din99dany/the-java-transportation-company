package model;

public class Town
{
    public Town( String name, double latitude, double longitude )
    {
        m_id = m_idCnt++;
        m_name = name;
        m_latitude = latitude;
        m_longitude = longitude;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int GetId() { return m_id; }

    public String GetName() { return m_name; }
    public void SetName( String newName ) { m_name = newName; }

    public double GetLatitude() { return m_latitude; }
    public void SetLatitude( double newLatitude ) { m_latitude = newLatitude; }

    public double GetLongitude() { return m_longitude; }
    public void SetLongitude( double newLongitude ) { m_longitude = newLongitude; }

    public void SetCordinates( double latitude, double longitude )
    {
        SetLatitude( latitude );
        SetLongitude( longitude );
    }

    public String toString()
    {
        return Integer.toString( m_id ) + "," +
                m_name + "," +
                Double.toString( m_latitude ) + "," +
                Double.toString( m_longitude );
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static int m_idCnt;
    private int m_id;
    private String m_name;
    private double m_latitude, m_longitude;
}
