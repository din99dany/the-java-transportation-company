package model;

import java.io.Serializable;

public class Truck extends Vehicle implements Serializable, dataBaseInsertable {
    public Truck(double weight, double fuelReserve) {
        super(weight, fuelReserve);
    }

    public double GetRange() {
        return m_fuelReserve / (m_weigh * GetFuelRate());
    }

    public double GetFuelRate() {
        return 0.1;
    }

    public String GetType() {
        return "Truck";
    }

    public String toString() {
        return Integer.toString(GetId()) + ",Truck," +
                Double.toString(GetFuelRate()) + "," +
                Double.toString(m_fuelReserve);
    }
}
