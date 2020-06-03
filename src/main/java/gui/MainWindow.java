package gui;

import model.Order;
import model.Route;
import model.Vehicle;
import service.OrderService;
import service.RouteService;
import service.VehicleService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow
{
    public static void main(){
        JFrame frame= new JFrame();
        frame.setSize(700,700);

        JTabbedPane tabbedPane = new JTabbedPane();

        OrderTab orderTab = new OrderTab();
        VehicleTab vehicleTab = new VehicleTab();
        MapTab mapTab = new MapTab();


        tabbedPane.addTab("Orders", orderTab);
        tabbedPane.addTab("Vehicles", vehicleTab);
        tabbedPane.addTab("Map Route", mapTab);

        frame.add(tabbedPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
