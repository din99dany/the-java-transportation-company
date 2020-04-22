package repository;
import model.Route;
import service.Logger;

public class RouteRepository extends GenericRepo<Route>
{
    public RouteRepository()
    {
        super();
        m_dataFile = "./Data/Route.txt";
        Loadontent();
        Logger.Log();
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
