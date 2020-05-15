package Package;

import javax.swing.*;
import java.awt.*;

abstract public class MainWindow extends JFrame {
    MainWindow(){
        this.setTitle("Minesweeper");
        this.setSize(600,800);
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        int screenWidth = this.getSize().width;
        int screenHeight = this.getSize().height;
        this.setLocation((width-screenWidth)/2,(height-screenHeight)/2);

        this.setDefaultCloseOperation(3);
    }
}
