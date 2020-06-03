package repository;

import model.Cargo;
import model.Order;
import model.Town;
import service.CargoService;
import service.OrderService;
import service.ReadDataBaseService;
import service.TownService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class OrderRepository extends GenericRepo<Order>
{
    public OrderRepository()
    {
        super();
        LoadContent();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void LoadContent()
    {
        try {
            m_data.addAll(ReadDataBaseService.ReadOrders( m_dbConnection ));
        } catch (Exception e)   {
            e.printStackTrace();
        }
    }

    public Order GetOrderById( int id )
    {
        for( Order iterOrder : m_data )
        {
            if ( id == iterOrder.GetId() )
            {
                return iterOrder;
            }
        }
        return null;
    }
}
