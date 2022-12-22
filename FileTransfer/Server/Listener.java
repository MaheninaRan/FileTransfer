package all;
import java.awt.event.*;
import java.io.*;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.util.List;
import java.io.*;
import java.awt.Component.*;
import javax.swing.border.*;
public class Listener implements ActionListener {
    Graphique grp;
    String parametre="Download";
    DataInputStream dataInputStream;
    String fileName;
    JPanel jpFileRow;
    JLabel jlFileName;
    Fenetre frame;
    byte[] fileContentBytes;
    String port;
    int fileId = 0;
    String fileExtension;

    public String getStringFileName() {return this.fileName;}
    public byte[] getFileContentBytes() {return this.fileContentBytes;}
    public String getPort(){return this.port;}   
    public Listener(){}
    public void getGraphe(Graphique gg) {
       this.grp=gg; 
    }
    public void actionPerformed(ActionEvent e) {
        try {
        if (e.getSource()==grp.getButtonValide()){
            while(true){
                port=grp.getTextFieldPort().getText();
                System.out.println( "Port connected : " +  port); 
                int castPort= Integer.valueOf(port);
                ServerSocket serverSocket = new ServerSocket(castPort);
                Socket socket = serverSocket.accept();
                dataInputStream = new DataInputStream(socket.getInputStream());
                int FileLenght = dataInputStream.readInt();
                if (FileLenght > 0){
                    byte[] filenameBytes = new byte[FileLenght];
                    dataInputStream.readFully(filenameBytes, 0, filenameBytes.length);
                    fileName = new String(filenameBytes);
                    int fileContentLength = dataInputStream.readInt();
                if (fileContentLength > 0){
                    fileContentBytes = new byte[fileContentLength];
                    dataInputStream.readFully(fileContentBytes, 0, fileContentLength);
                    if (getFileExtension(fileName).equalsIgnoreCase("txt")) {
                        grp.getpanelReceive().setName(String.valueOf(fileId));
                        grp.add(grp.getLabelFilename());
                    }else {
                        grp.getpanelReceive().setName(String.valueOf(fileId));
                    }
                }
                }
                }
            }
             fileExtension= getFileExtension(fileName);
            
             if (e.getSource()==grp.getButtonDown()) {
                if(parametre=="Download"){
                    grp.getLabelFilename().setText( "Choose another file");
                }
                else{
                    System.out.println("Download");
                    File fileToDownloand = new File(fileName);   
                    FileOutputStream fileOutputStream = new FileOutputStream(fileToDownloand);
                    fileOutputStream.write(fileContentBytes);
                    grp.getLabelFilename().setText( "Download succes");
                    fileOutputStream.close();
                }
             }
              if (e.getSource()==grp.getButtonReceive()){
                parametre="Receive";
                System.out.println("File receive");
                 grp.getLabelFilename().setText(fileName);
              }
             if(e.getSource()==grp.getButtonEffacer()) {
                this.parametre="Delete";
                System.out.println("Effacer");   
                fileName="Choose another file";
                grp.getLabelFilename().setText("");
                
             }
             if (fileExtension.equalsIgnoreCase("txt")){
                grp.getContenue().setText("<html>" + new String(fileContentBytes)+"</html>");
             } else {
                grp.getContenue().setIcon(new ImageIcon(fileContentBytes));
             }
        } catch (Exception e2) {
            System.out.println(e2);
        }  
    }
    public static String getFileExtension(String filename) {
        int i = filename.lastIndexOf('.');       
        if (i>0) {
            return filename.substring(i + 1);
        } else {
            return "No extension found";
        }
    }
}   