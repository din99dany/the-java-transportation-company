package model;

public class Order
{
    public Order( Cargo cargo, Town sourceTown, Town destTown )
    {
        m_id = m_idCnt++;
        m_sourceTown = sourceTown;
        m_destTown = destTown;
        m_cargo = cargo;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public int GetId()
    {
        return m_id;
    }

    public final Cargo GetCargo()
    {
        return m_cargo;
    }

    public final Town GetSourceTown()
    {
        return m_sourceTown;
    }

    public final Town GetDestTown()
    {
        return m_destTown;
    }

    public String toString()
    {
        return "([" + Integer.toString( m_id ) + "],[" +
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
