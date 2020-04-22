package model;

import java.io.Serializable;

public class Van extends  Vehicle implements Serializable
{
    public Van( double weight, double fuelReserve )
    {
        super( weight, fuelReserve );
    }

    public double GetRange()
    {
        return m_fuelReserve / ( m_weigh * GetFuelRate() );
    }
    public double GetFuelRate()
    {
        return 0.05;
    }

    public String toString()
    {
        return Integer.toString( GetId() ) + ",Van," +
                Double.toString( GetFuelRate() ) + "," +
                Double.toString( m_fuelReserve );
    }

}
