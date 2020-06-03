package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Route implements Serializable, dataBaseInsertable {
    public Route(Vehicle vehicle) {
        m_id = m_idCnt++;
        m_vehicle = vehicle;
        m_points = new ArrayList<IntercityLink>();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public String GetInsertQuery() {
        return "";
    }


    public String GetDeleteQuery() {
        return "Delete from route where id == " +
                Integer.toString(GetId()) + ";";
    }

    public String GetUpdateQuery() {
        return "";
    }


    public int GetId() {
        return m_id;
    }

    public void SetId(int newId) {
        m_id = newId;
    }

    public void AddLink(IntercityLink toAdd) {
        // check the integrity of the link
        if (m_points.isEmpty()) {
            m_points.add(toAdd);
        } else if (m_points.get(m_points.size() - 1).GetDest().GetId() ==
                toAdd.GetSource().GetId()) {
            m_points.add(toAdd);
        }
    }

    public ArrayList<IntercityLink> GetPoints() {
        return m_points;
    }

    public final Vehicle GetVehicle() {
        return m_vehicle;
    }

    public String toString() {
        StringBuilder res = new StringBuilder("([" + m_vehicle.toString() + "]");
        for (IntercityLink iterLink : m_points) {
            res.append("[").append(iterLink.toString()).append("]");
        }
        return res.toString();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static int m_idCnt;
    private int m_id;
    private Vehicle m_vehicle;
    private ArrayList<IntercityLink> m_points;
}
