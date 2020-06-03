package model;

import java.io.Serializable;
import java.sql.PreparedStatement;

public abstract class Vehicle implements Serializable, dataBaseInsertable {
    public Vehicle(double weight, double fuelReserve) {
        m_id = m_idCnt++;
        m_weigh = weight;
        m_fuelReserve = fuelReserve;
    }

    public String GetInsertQuery() {
        return "INSERT INTO vehicle VALUES (" +
                Integer.toString(GetId()) + ",'" +
                GetType() + "'," +
                Double.toString(GetWeight()) + "," +
                Double.toString(GetFuelReserve()) + ")";
    }

    public String GetDeleteQuery() {
        return "DELETE FROM vehicle where id == " + Integer.toString(GetId());
    }

    public String GetUpdateQuery() {
        return "UPDATE vehicle SET " +
                "Type=" + GetType() + "'," +
                "weight=" + Double.toString(GetWeight()) + "," +
                "fuel_reserve=" + Double.toString(GetFuelReserve()) +
                "WHERE id = " + Integer.toString(GetId()) + ";";
    }


    public int GetId() {
        return m_id;
    }

    public void SetId(int newId) {
        m_id = newId;
        if (m_id >= m_idCnt) {
            m_idCnt = m_id + 1;
        }
    }

    public double GetWeight() {
        return m_weigh;
    }

    public void SetWeight(double newWeight) {
        m_weigh = newWeight;
    }

    public double GetFuelReserve() {
        return m_fuelReserve;
    }

    public void SetFuelReserve(double newFuelRes) {
        m_fuelReserve = newFuelRes;
    }

    public abstract String GetType();

    public abstract double GetRange();

    public abstract double GetFuelRate();

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static int m_idCnt;
    private int m_id;
    protected double m_weigh;
    protected double m_fuelReserve;
}
