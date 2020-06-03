package repository;
import model.IntercityLink;
import model.Order;
import model.Vehicle;
import service.TownService;
import service.VehicleFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class IntercityLinkRepository extends GenericRepo<IntercityLink>
{
    public IntercityLinkRepository()
    {
        super();
        LoadContent();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void LoadContent()
    {
        try {

            TownService townService = TownService.GetInstance();

            String sql = "SELECT * FROM intercitylink";
            PreparedStatement statement = m_dbConnection.prepareStatement(sql);
            ResultSet res = statement.executeQuery();

            while ( res.next() )
            {
                IntercityLink toAdd = new IntercityLink(
                        townService.GetTownById( res.getInt("town_start") ),
                        townService.GetTownById( res.getInt("town_end") )  );

                toAdd.SetId( res.getInt("id") );
                m_data.add( toAdd );
            }
        } catch (Exception e)   {
            e.printStackTrace();
        }

    }

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
