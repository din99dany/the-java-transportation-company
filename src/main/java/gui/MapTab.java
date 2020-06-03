package gui;

import model.IntercityLink;
import model.Order;
import model.Route;
import model.Town;
import service.IntercityLinkService;
import service.OrderService;
import service.RouteService;
import service.TownService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.geom.Line2D;

public class MapTab extends JPanel {
    public MapTab()
    {
        super();
        this.setLayout( null );

        TownService townService = TownService.GetInstance();
        for ( Town link : townService.GetTowns() ) {

            JLabel labStart = new JLabel(link.GetName());

            labStart.setBounds(
                    (int)link.GetLatitude(),
                    (int)link.GetLongitude()
                    ,70, 30);

            labStart.setVisible(true);
            this.add(labStart);
        }
        this.setVisible(true);

    }

    public void paint(Graphics g )
    {
        super.paint( g );
        Graphics2D g2 = (Graphics2D) g ;

        IntercityLinkService intercityLinkService = IntercityLinkService.GetInstance();
        RouteService routeService = RouteService.GetInstance();

        for ( IntercityLink link : intercityLinkService.GetLinks() )
        {
            g2.draw( GetLinkLine( link ) );
        }


        for ( Route rate : routeService.GetRoutes() ) {
            for (IntercityLink link : rate.GetPoints()) {
                Line2D line2D = GetLinkLine( link );
                g2.setColor( Color.red );
                g2.draw( line2D );
            }
        }
    }

    private Line2D GetLinkLine( IntercityLink link )
    {
        Line2D line2D = new Line2D.Double(
                (int)link.GetSource().GetLatitude() ,
                (int)link.GetSource().GetLongitude() ,
                (int)link.GetDest().GetLatitude(),
                (int)link.GetDest().GetLongitude()
        );
        return line2D;
    }

}
