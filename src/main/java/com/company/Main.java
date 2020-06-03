package com.company;
import gui.MainWindow;
import model.*;
import runner.StartupLoad;
import service.*;

import javax.swing.*;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {

        StartupLoad loader = new StartupLoad();
        loader.start();
        try {
            loader.join();
        } catch ( Exception ex )
        {
            ex.printStackTrace();
        }

        MainWindow.main();
    }
}
