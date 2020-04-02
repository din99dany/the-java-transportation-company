package repository;

import model.Cargo;
import model.Order;

public class OrderRepository extends GenericRepo<Order>
{
    public OrderRepository()
    {
        super();
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
