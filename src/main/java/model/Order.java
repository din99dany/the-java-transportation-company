package model;

import java.io.Serializable;

public class Order implements Serializable, dataBaseInsertable {
    public Order(Cargo cargo, Town sourceTown, Town destTown) {
        m_id = m_idCnt++;
        m_sourceTown = sourceTown;
        m_destTown = destTown;
        m_cargo = cargo;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String GetInsertQuery() {
        return "INSERT INTO order_t VALUES( " + Integer.toString(GetId()) + ","
                + Integer.toString(GetCargo().GetId()) + ",'" +
                GetSourceTown().GetName() + "' , ' " +
                GetDestTown().GetName() + "')";
    }


    public String GetDeleteQuery() {
        return "Delete from order_t where id == " +
                Integer.toString(GetId()) + ";";
    }

    public String GetUpdateQuery() {
        return "UPDATE order_t SET " +
                "id_cargo" + Integer.toString(GetCargo().GetId()) + "'," +
                "id_town_start=" + Integer.toString(GetSourceTown().GetId()) + "," +
                "id_town_end=" + Integer.toString(GetDestTown().GetId()) +
                "WHERE id = " + Integer.toString(GetId()) + ";";
    }


    public int GetId() {
        return m_id;
    }

    public void SetId(int newId) {
        m_id = newId;
    }

    public final Cargo GetCargo() {
        return m_cargo;
    }

    public final Town GetSourceTown() {
        return m_sourceTown;
    }

    public final Town GetDestTown() {
        return m_destTown;
    }

    public String toString() {
        return "([" + Integer.toString(m_id) + "],[" +
                m_cargo.toString() + "],[" +
                m_sourceTown.toString() + "],[" +
                m_destTown.toString() + "])";
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static int m_idCnt;
    private int m_id;
    private Cargo m_cargo;
    private Town m_sourceTown, m_destTown;
}
