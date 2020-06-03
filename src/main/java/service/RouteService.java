package service;

import model.*;
import repository.RouteRepository;

import java.util.ArrayList;
import java.util.List;

public class RouteService {
    public static RouteService GetInstance()
    {
        if ( m_instance == null )
        {
            m_instance = new RouteService();
            m_repo = new RouteRepository();
        }
        return m_instance;
    }

    public boolean CreateRoute( Vehicle driverVehicle )
    {
        if ( driverVehicle == null )
        {
            return  false;
        }

        AddRoute( new Route( driverVehicle ) );
        return true;
    }

    public void Write(){

    }
    public void Update(Route toUpdate, Route updated )
    {
        m_repo.UpdateItem( toUpdate, updated );
    }
    public Route GetOrderRoute( Order toShip )
    {
        Logger.Log();
        List<Route> routes = GetRoutes();
        for ( Route route : routes )
        {
            boolean hasStart = false;
            boolean hasDest = false;
            for ( IntercityLink iterLink : route.GetPoints() )
            {
                if( iterLink.GetSource().GetId() == toShip.GetSourceTown().GetId() )
                {
                    hasStart = true;
                }
                if( iterLink.GetDest().GetId() == toShip.GetDestTown().GetId() )
                {
                    hasDest = true;
                }
            }

            if ( hasDest && hasStart )
            {
                return route;
            }
        }
        return  null;
    }

    public boolean AddLinkToRoute( int id, IntercityLink linkToAdd )
    {
        Route workingRoute = GetRouteById( id );
        if ( workingRoute == null || linkToAdd == null )
        {
            return false;
        }
        workingRoute.AddLink( linkToAdd );
        return  true;
    }

    public Route GetRouteById(int id )
    {
        return m_repo.GetRouteById( id );
    }

    public void AddRoute( Route toAdd )
    {
        m_repo.AddObject( toAdd );
    }

    public void RemoveRoute( Route toRem )
    {
        m_repo.RemoveObject( toRem );
    }

    public List<Route> GetRoutes()
    {
        return m_repo.GetData();
    }

    private RouteService()
    {
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private static RouteService m_instance;
    private static RouteRepository m_repo;

}
