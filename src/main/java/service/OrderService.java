package service;

import model.Cargo;
import model.Order;
import model.Route;
import model.Town;
import repository.OrderRepository;


import java.util.ArrayList;
import java.util.List;

public class OrderService {
    public static OrderService GetInstance()
    {
        if ( m_instance == null )
        {
            m_instance = new OrderService();
            m_repo = new OrderRepository();
        }
        return m_instance;
    }

    public ArrayList<Order> SearchTown( String toSeach )
    {
        ArrayList<Order> res = new ArrayList<Order>();
        for ( Order ord : GetOrders() )
        {
            if ( toSeach.equals( ord.GetSourceTown().GetName() ) || toSeach.equals( ord.GetDestTown().GetName() ) )
            {
                res.add(ord);
            }
        }
        return res;
    }

    public boolean CreateOrder(Cargo toShip, Town source, Town dest )
    {
        if ( toShip == null || source == null || dest == null )
        {
            System.out.println("something null");
            return false;
        }
        AddOrder( new Order( toShip, source, dest ) );
        return true;
    }

    public void Update(Order toUpdate, Order updated )
    {
        m_repo.UpdateItem( toUpdate, updated );
    }
    public Order GetOrderById(int id )
    {
        return m_repo.GetOrderById( id );
    }

    public void AddOrder( Order toAdd )
    {
        m_repo.AddObject( toAdd );
    }

    public void RemoveOrder( Order toRem )
    {
        m_repo.RemoveObject( toRem );
    }

    public List<Order> GetOrders()
    {
        return m_repo.GetData();
    }

    private OrderService()
    {
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static OrderService m_instance;
    private static OrderRepository m_repo;

}
