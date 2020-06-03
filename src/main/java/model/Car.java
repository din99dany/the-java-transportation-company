package model;

import java.io.Serializable;

public class Car extends Vehicle implements Serializable {
    public Car(double weight, double fuelReserve) {
        super(weight, fuelReserve);
    }

    public double GetRange() {
        return m_fuelReserve / (m_weigh * GetFuelRate());
    }

    public double GetFuelRate() {
        return 0.01;
    }

    public String GetType() {
        return "Car";
    }

    public String toString() {
        return Integer.toString(GetId()) + ",Car," +
                Double.toString(GetFuelRate()) + "," +
                Double.toString(m_fuelReserve);
    }
}
