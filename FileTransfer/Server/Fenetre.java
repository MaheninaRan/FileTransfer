package all;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
public class Fenetre extends JFrame{
    Graphique grp;
    public Fenetre() throws Exception{
        try{
            JFrame jFrame = new JFrame("Server");
            this.grp=new Graphique();
            jFrame.add(grp);
            jFrame.setSize(500, 500);
            jFrame.setLayout(new BoxLayout(jFrame.getContentPane(), BoxLayout.Y_AXIS));
            jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
            jFrame.setFocusable(false);
            jFrame.setVisible(true);    
        }catch (Exception e) {
            System.out.println(e);
        }
        
    }
}