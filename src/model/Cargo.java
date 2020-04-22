package model;

import java.io.Serializable;

public class Cargo implements Serializable
{

    public Cargo( double weight )
    {
        m_id = m_idCnt++;
        m_weight = weight;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int GetId()
    {
        return m_id;
    }

    public double GetWeight()
    {
        return m_weight;
    }

    public  String toString()
    {
        return Integer.toString( m_id ) + "," + Double.toString( m_weight );
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static int m_idCnt;
    private int m_id;
    private double m_weight;
}
