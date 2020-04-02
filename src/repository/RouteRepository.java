package repository;
import model.Route;

public class RouteRepository extends GenericRepo<Route>
{
    public RouteRepository()
    {
        super();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Route GetRouteById(int id )
    {
        for( Route iterVehicle : m_data )
        {
            if ( id == iterVehicle.GetId() )
            {
                return iterVehicle;
            }
        }
        return null;
    }
}
