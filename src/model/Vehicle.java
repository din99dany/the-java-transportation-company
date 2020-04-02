package model;

public abstract class Vehicle
{
    public Vehicle( double weight, double fuelReserve )
    {
        m_id = m_idCnt++;
        m_weigh = weight;
        m_fuelReserve = fuelReserve;
    }

    public int GetId()
    {
        return  m_id;
    }

    public double GetWeight()
    {
        return m_weigh;
    }

    public void SetWeight( double newWeight )
    {
        m_weigh = newWeight;
    }

    public double GetFuelReserve()
    {
        return m_fuelReserve;
    }

    public void SetFuelReserve( double newFuelRes)
    {
        m_fuelReserve = newFuelRes;
    }

    public abstract  double GetRange();
    public abstract  double GetFuelRate();

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static int m_idCnt;
    private int m_id;
    protected double m_weigh;
    protected double m_fuelReserve;
}
