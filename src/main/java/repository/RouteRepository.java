package repository;
import model.IntercityLink;
import model.Route;
import service.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RouteRepository extends GenericRepo<Route>
{
    public RouteRepository()
    {
        super();
        LoadContent();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void LoadContent()
    {
        try {

            VehicleService vehicleService = VehicleService.GetInstance();
            IntercityLinkService intercityLinkService = IntercityLinkService.GetInstance();

            String sql = "SELECT * FROM route";
            PreparedStatement statement = m_dbConnection.prepareStatement(sql);
            ResultSet res = statement.executeQuery();

            while ( res.next() )
            {
                Route toAdd = new Route( vehicleService.GetCarById( res.getInt("id_car") ) );

                String stops = res.getString("stop_list");
                String[] arrOfStr = stops.split("," );

                for ( String itereaza : arrOfStr )
                {
                    toAdd.AddLink( intercityLinkService.GetLinkById( Integer.parseInt(itereaza) ) );
                }

                toAdd.SetId( res.getInt("id") );
                m_data.add( toAdd );
            }
        } catch (Exception e)   {
            e.printStackTrace();
        }
    }

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
