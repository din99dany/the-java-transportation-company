package service;

import model.Order;
import model.Town;
import model.Vehicle;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReadDataBaseService
{
    public ReadDataBaseService()
    {

    }

    static public ArrayList<Vehicle> ReadVehicles(Connection dbConnection )
    {
        try {

            Logger.Log();
            ArrayList<Vehicle> resVal = new ArrayList<Vehicle>();

            String sql = "SELECT * FROM vehicle";
            PreparedStatement statement = dbConnection.prepareStatement(sql);
            ResultSet res = statement.executeQuery();

            while (res.next() )
            {
                Vehicle toAdd = VehicleFactory.BuildVehicle(res.getString("type"),
                        res.getDouble("weight"),
                        res.getDouble("fuel_reserve"));

                toAdd.SetId(res.getInt("id"));
                resVal.add(toAdd);
            }

            return  resVal;
        }
        catch (Exception e)   {
            e.printStackTrace();
        }
        return null;
    }

    static public ArrayList<Town> ReadTowns(Connection dbConnection )
    {
        try {

            Logger.Log();
            ArrayList<Town> resVal = new ArrayList<Town>();
            String sql = "SELECT * FROM town";
            PreparedStatement statement = dbConnection.prepareStatement(sql);
            ResultSet res = statement.executeQuery();

            while ( res.next() )
            {
                Town toAdd = new Town( res.getString("townName"),
                        res.getDouble("latitude"),
                        res.getDouble("longitude") );

                toAdd.SetId( res.getInt("id") );
                resVal.add( toAdd );
            }
            return  resVal;
        } catch (Exception e)   {
            e.printStackTrace();
        }
        return  null;
    }

    static public ArrayList<Order> ReadOrders(Connection dbConnection )
    {
        try {

            Logger.Log();
            ArrayList<Order> resVal = new ArrayList<Order>();

            CargoService cargoService = CargoService.GetInstance();
            TownService townService = TownService.GetInstance();

            String sql = "SELECT * FROM order_t";
            PreparedStatement statement = dbConnection.prepareStatement(sql);
            ResultSet res = statement.executeQuery();

            while ( res.next() )
            {
                Order toAdd = new Order( cargoService.GetCargoById( res.getInt("id_cargo") ),
                        townService.GetTownById( res.getInt("id_town_start") ),
                        townService.GetTownById( res.getInt("id_town_end") ) );
                toAdd.SetId( res.getInt("id") );
                resVal.add( toAdd );
            }

            return resVal;

        } catch (Exception e)   {
            e.printStackTrace();
        }
        return  null;
    }

}
