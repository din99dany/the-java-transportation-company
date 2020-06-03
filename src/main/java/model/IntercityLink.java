package model;

import java.io.Serializable;

public class IntercityLink implements Serializable, dataBaseInsertable {
    public IntercityLink(Town sourceTown, Town destTown) {
        m_id = m_idCnt++;
        m_sourceTown = sourceTown;
        m_destTown = destTown;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String GetInsertQuery() {
        return "";
    }

    public String GetDeleteQuery() {
        return "";
    }

    public String GetUpdateQuery() {
        return "";
    }

    public String GetCreateQuery() {
        return "";
    }

    public int GetId() {
        return m_id;
    }

    public void SetId(int newId) {
        m_id = newId;
    }

    public final Town GetSource() {
        return m_sourceTown;
    }

    public final Town GetDest() {
        return m_destTown;
    }

    public String toString() {
        return "(id_link:" + Integer.toString(m_id) + ")," +
                m_sourceTown.toString() + "," +
                m_destTown.toString();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static int m_idCnt;
    private int m_id;
    private Town m_sourceTown, m_destTown;
}
