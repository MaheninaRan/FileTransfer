package all;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.util.List;
import java.io.*;
import javax.swing.border.*;
public class Graphique extends JPanel{
   
    JTextField textFieldPort;
    JButton buttonValide;
    Listener ecouteur =new Listener();
    JLabel jlTitle;
    JButton buttonDown;
    JButton buttonEffacer;
    JLabel labelFilename;
    JPanel panelReceive;
    JLabel contenue;
    String br;
    String stringContenue="";
    JButton buttonReceive;
    public JTextField getTextFieldPort() {return this.textFieldPort;}
    public JButton getButtonValide() {return this.buttonValide;}
    public JLabel getLabelTitle() {return this.jlTitle;}
    public JButton getButtonDown() {return this.buttonDown;}
    public JButton getButtonEffacer() {return this.buttonEffacer;}
    public JLabel getLabelFilename() {return this.labelFilename;}
    public JPanel getpanelReceive() {return this.panelReceive;}
    public JLabel getContenue() {return this.contenue;}
    public JButton getButtonReceive() {return this.buttonReceive;}

    public Graphique() {
        Graphe();
        ecouteur.getGraphe(this);
        this.setLayout(null);
        
    }
    public void Graphe() {

        this.textFieldPort=new JTextField("1766");
        this.textFieldPort.setBounds(150,50,70,20);
        this.textFieldPort.addActionListener(ecouteur);
        
        this.add(this.textFieldPort);   

        this.buttonValide=new JButton();
        this.buttonValide.setBounds(250, 50, 70,20);
        this.buttonValide.setBackground(Color.green);
        this.buttonValide.setFont(new Font("Arial" , Font.BOLD , 15) );
        this.buttonValide.setText("<html><color=white><b>Valider</b></font></html>");
        this.buttonValide.addActionListener(ecouteur);
        this.add(this.buttonValide);

        this.jlTitle = new JLabel("Boite de reception");
        this.jlTitle.setFont(new Font("Arial", Font.BOLD, 25));
        this.jlTitle.setBounds(140, 10, 400, 40);
        this.add(jlTitle);

        this.buttonDown=new JButton();
        this.buttonDown.setFont(new Font("Arial", Font.BOLD, 20));
        this.buttonDown.setBounds(80, 350, 120, 30);
        this.buttonDown.setBackground(Color.green);
        this.buttonDown.setText("<html><color=white><b>Download</b></font></html>");
        this.buttonDown.addActionListener(ecouteur);
        this.add(buttonDown);

        this.buttonEffacer=new JButton();
        this.buttonEffacer.setFont(new Font("Arial", Font.BOLD, 20));
        this.buttonEffacer.setBounds(250, 350, 120,30);
        this.buttonEffacer.setBackground(Color.red);
        this.buttonEffacer.setText("<html><color=white><b>Effacer</b></font></html>");
        this.buttonEffacer.addActionListener(ecouteur);
        this.add(buttonEffacer);
        
        this.panelReceive = new JPanel();
        this.panelReceive.setBackground(Color.CYAN);
        this.panelReceive.setBounds(80,100,320,200);
        this.panelReceive.setLayout(new BoxLayout(panelReceive, BoxLayout.Y_AXIS));
        this.panelReceive.setLayout(null);
        this.add(panelReceive);

        this.labelFilename=new JLabel();
        this.labelFilename.setFont(new Font("Arial", Font.CENTER_BASELINE, 20));
        this.labelFilename.setBounds(80, 70, 320,30);
        this.labelFilename.setBackground(Color.red);
        this.labelFilename.setText("FileName");       
        this.panelReceive.add(labelFilename);
     
        this.contenue=new JLabel();
        this.contenue.setFont(new Font("Arial", Font.BOLD, 16));
        this.contenue.setBounds(0, 30, 400,30);
        this.panelReceive.add(contenue);

        this.buttonReceive=new JButton();
        this.buttonReceive.setFont(new Font("Arial", Font.BOLD, 16));
        this.buttonReceive.setText("File Receive");
        this.buttonReceive.setBounds(75, 10, 170, 25);
        this.buttonReceive.addActionListener(ecouteur);
        this.panelReceive.add(buttonReceive);
}
}