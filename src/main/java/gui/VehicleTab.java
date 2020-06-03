package gui;

import model.Order;
import model.Vehicle;
import service.OrderService;
import service.VehicleFactory;
import service.VehicleService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;

public class VehicleTab extends JPanel {
    public VehicleTab()
    {
        super();
        this.setLayout(new GridLayout());

        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Type");
        model.addColumn( "Weight" );

        table = new JTable(model);
        scrollPane = new  JScrollPane(table);

        AddVehiclesTable();
        AddInsertFuntionality();

    }

    private void AddVehiclesTable()
    {
        LoadTable();
        this.add(scrollPane);
    }

    public void LoadTable()
    {
        VehicleService vehicleService = VehicleService.GetInstance();

        for ( Vehicle ord : vehicleService.GetVehicles() )
        {
            JFrame temp = new JFrame();
            model.addRow( new Object[]{Integer.toString(ord.GetId()),
                    ord.GetType(),
                    ord.GetWeight()
            } );
        }
    }

    public void AddInsertFuntionality()
    {

        JPanel addPannel = new JPanel();
        addPannel.setLayout(new GridLayout(20, 4));

        JTextField typeVeh = new JTextField("Type");
        JTextField weight = new JTextField("Weight");
        JTextField fuel = new JTextField("Fuel");
        JButton addButton = new JButton("Add");

        addButton.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                VehicleService vehicleService = VehicleService.GetInstance();
                Vehicle toAdd = VehicleFactory.BuildVehicle(
                        typeVeh.getText(),
                        Double.parseDouble( weight.getText() ),
                        Double.parseDouble( fuel.getText() ));

                System.out.println(toAdd.GetInsertQuery());
                vehicleService.AddVehicle(
                        toAdd
                );
                model.setRowCount(0);

                LoadTable();
                scrollPane.revalidate();
                scrollPane.repaint();
                revalidate();
            }
        } );

        addPannel.add(typeVeh);
        addPannel.add(weight);
        addPannel.add(fuel);
        addPannel.add( addButton );

        this.add(addPannel);


    }
    /////////////////////////////////////////
    private  JScrollPane scrollPane;
    private  DefaultTableModel model;
    private  JTable table;
}
