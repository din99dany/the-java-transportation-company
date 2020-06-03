package repository;
import model.Cargo;
import model.Town;
import java.sql.*;

public class CargoRepository extends GenericRepo<Cargo>
{

    public CargoRepository()
    {
        super();
        LoadContent();
        m_dataFile = "./Data/Cargo.txt";
    }

    public void LoadContent()
    {
        try {
            String sql = "SELECT * FROM cargo;";
            PreparedStatement statement = m_dbConnection.prepareStatement(sql);
            ResultSet res = statement.executeQuery();

            while ( res.next() )
            {
                Cargo toAdd = new Cargo( res.getDouble("weight") );
                toAdd.SetId( res.getInt("id") );
                m_data.add( toAdd );
            }

        } catch (Exception e)   {
            e.printStackTrace();
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Cargo GetCargoById( int id )
    {
        for( Cargo iterVehicle : m_data )
        {
            if ( id == iterVehicle.GetId() )
            {
                return iterVehicle;
            }
        }
        return null;
    }
}
