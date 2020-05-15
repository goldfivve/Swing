package Package;
import java.awt.*;
import java.awt.event.*;
public class BegiWin extends MainWindow  {

    BegiWin(){
        super();
        setComponents();

        this.setDefaultCloseOperation(3);
    }

    void setComponents(){Container container = new Container();


        Beginner beginner = new Beginner();
        Board board = new Board(beginner);
        this.setContentPane(board);



    }


}
