package model;

public class Truck extends Vehicle
{
    public Truck( double weight, double fuelReserve )
    {
        super( weight, fuelReserve );
    }

    public double GetRange()
    {
        return m_fuelReserve / ( m_weigh * GetFuelRate() );
    }
    public double GetFuelRate()
    {
        return 0.1;
    }

    public String toString()
    {
        return Integer.toString( GetId() ) + ",Truck," +
                Double.toString( GetFuelRate() ) + "," +
                Double.toString( m_fuelReserve );
    }
}
