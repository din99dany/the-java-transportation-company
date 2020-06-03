package gui;

import model.IntercityLink;
import model.Order;
import model.Route;
import model.Town;
import service.OrderService;
import service.RouteService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class OrderTab extends JPanel {

    public OrderTab()
    {
        super();

        OrderService orderService = OrderService.GetInstance();
        this.setLayout( new GridLayout(2, 2));

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Start Town");
        model.addColumn( "End Town" );
        model.addColumn( "Route" );

        JTable table = new JTable(model);
        JScrollPane scrollPane= new  JScrollPane(table);

        for ( Order ord : orderService.GetOrders() )
        {
            JFrame temp = new JFrame();
            model.addRow( new Object[]{Integer.toString(ord.GetId()),
                    ord.GetSourceTown().GetName(),
                    ord.GetDestTown().GetName(),
                    "Route "+Integer.toString(ord.GetId())
            } );
            table.getColumn("Route").setCellRenderer(new ButtonRenderer());
            table.getColumn("Route").setCellEditor( new ButtonEditor(new JCheckBox()));
        }

        this.add(scrollPane);

        AddSearchFunctonality();
        AddIdSearchFunctionality();
    }

    public void AddIdSearchFunctionality()
    {
        JPanel panSearch = new JPanel();
        panSearch.setLayout(new GridLayout(10, 1));

        JTextField searchTown = new JTextField();
        JButton searchButtonTown = new JButton( "Search Id" );
        JLabel result = new JLabel();
        JLabel result2 = new JLabel();

        searchButtonTown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                OrderService orderService = OrderService.GetInstance();

                Order ordr = orderService.GetOrderById( Integer.parseInt(searchTown.getText() ) );
                if ( ordr == null ) {
                    result.setText("Invalid");
                    result2.setText("");
                }
                else {
                    String res = "Start Town : " + ordr.GetSourceTown().GetName();
                    String res2 = "End Town : " + ordr.GetDestTown().GetName();
                    result.setText(res);
                    result2.setText(res2);
                }
            }
        });

        panSearch.add(searchButtonTown);
        panSearch.add(searchTown);
        panSearch.add(result);
        panSearch.add(result2);


        this.add(panSearch);
    }

    public void AddSearchFunctonality()
    {
        JPanel panSearch = new JPanel();
        panSearch.setLayout(new GridLayout(10, 1));

        JTextField searchTown = new JTextField();
        JButton searchButtonTown = new JButton( "Search Town" );
        JLabel result = new JLabel();

        searchButtonTown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                OrderService orderService = OrderService.GetInstance();
                StringBuilder res = new StringBuilder("Reulsts Ids: ");
                for ( Order ordr : orderService.SearchTown(searchTown.getText()) )
                {
                    res.append(Integer.toString(ordr.GetId())).append(" ");
                }
                result.setText(res.toString());
            }
        });


        panSearch.add(searchButtonTown);
        panSearch.add(searchTown);
        panSearch.add(result);

        this.add(panSearch);
    }

}


class ButtonRenderer extends JButton implements TableCellRenderer {

    public ButtonRenderer() {
        setOpaque(true);
    }

    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
        } else {
            setForeground(table.getForeground());
            setBackground(UIManager.getColor("Button.background"));
        }
        setText((value == null) ? "" : value.toString());
        return this;
    }
}

class ButtonEditor extends DefaultCellEditor {
    protected JButton button;

    private String label;

    private boolean isPushed;

    public ButtonEditor(JCheckBox checkBox) {
        super(checkBox);
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
            }
        });
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
                                                 boolean isSelected, int row, int column) {
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getForeground());
            button.setBackground(table.getBackground());
        }
        label = (value == null) ? "" : value.toString();
        button.setText(label);
        isPushed = true;
        return button;
    }

    public Object getCellEditorValue() {
        if (isPushed) {
           String forId = button.getText();
           forId = forId.replaceAll("[^-?0-9]+", " ");
           int id = Integer.parseInt(Arrays.asList(forId.trim().split(" ")).get(0));

           RouteService routeService = RouteService.GetInstance();
           OrderService orderService = OrderService.GetInstance();

           Order toRoute = orderService.GetOrderById( id );
           if ( toRoute != null )
           {
               Route ruta = routeService.GetOrderRoute(toRoute);
               String toShow = "";
               for ( IntercityLink link: ruta.GetPoints() )
               {
                   toShow += "From " + link.GetSource().GetName() + " to " +
                           link.GetDest().GetName() + " by " +
                           ruta.GetVehicle().GetType() + " " +
                           Integer.toString( ruta.GetVehicle().GetId() ) + "\n";
               }

               JOptionPane.showMessageDialog(button, toShow);

           }

        }

        isPushed = false;
        return new String(label);
    }

    public boolean stopCellEditing() {
        isPushed = false;
        return super.stopCellEditing();
    }

    protected void fireEditingStopped() {
        super.fireEditingStopped();
    }
}