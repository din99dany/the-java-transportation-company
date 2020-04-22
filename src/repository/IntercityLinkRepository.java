package repository;
import model.IntercityLink;
import model.Order;

public class IntercityLinkRepository extends GenericRepo<IntercityLink>
{
    public IntercityLinkRepository()
    {
        super();
        m_dataFile = "./Data/InterCity.txt";
        Loadontent();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public IntercityLink GetLinkById(int id )
    {
        for( IntercityLink iterVehicle : m_data )
        {
            if ( id == iterVehicle.GetId() )
            {
                return iterVehicle;
            }
        }
        return null;
    }
}
