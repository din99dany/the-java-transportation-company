package model;

import java.io.Serializable;

public class Cargo implements Serializable, dataBaseInsertable {

    public Cargo(double weight) {
        m_id = m_idCnt++;
        m_weight = weight;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int GetId() {
        return m_id;
    }

    public void SetId(int newId) {
        m_id = newId;
    }

    public double GetWeight() {
        return m_weight;
    }

    public String toString() {
        return Integer.toString(m_id) + "," + Double.toString(m_weight);
    }

    public String GetInsertQuery() {
        return "Insert into cargo values ( " +
                Integer.toString( GetId() ) + "," +
                Double.toString(m_weight) + ");";
    }

    public String GetDeleteQuery() {
        return "Delete from cargo where id == " +
                Integer.toString(GetId()) + ";";
    }

    public String GetUpdateQuery() {
        return "UPDATE cargo SET " + "weight="+Double.toString(m_weight) +
                "where id = " + Integer.toString(GetId()) + ";";
    }

    public String GetCreateQuery() {
        return "";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static int m_idCnt;
    private int m_id;
    private double m_weight;
}
