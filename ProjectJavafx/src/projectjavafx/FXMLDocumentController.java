/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package projectjavafx;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.PreparedStatement;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 *
 * @author dell
 */
public class FXMLDocumentController implements Initializable {
    
     @FXML
    private Button btnok;

    @FXML
    private PasswordField pass;

    @FXML
    private Label passlable;


    @FXML
    private TextField userid;

    @FXML
    private Label userlable;

    Connection con;
    PreparedStatement pat; 
    ResultSet rs;

    @FXML
    void login(ActionEvent event) {
       String uname = userid.getText();
       String pass1 = pass.getText();
  if(uname.equals("")&& pass1.equals(""))
{
JOptionPane.showMessageDialog(null, "username or password Blank");
}
else{
try
{Class.forName("com.mysql.jdbc.Driver" );
   con=DriverManager.getConnection("jdbc:mysql://localhost:3307/employee2","root","");
  pat=con.prepareStatement("select * from admin where username=? and password=? ");
  pat.setString(1, uname);
  pat.setString(2, pass1);
  rs=pat.executeQuery();

if(rs.next())
{
JOptionPane.showMessageDialog(null, "login success");
}
else{
JOptionPane.showMessageDialog(null, "login failed");
userid.setText("");
pass.setText("");
userid.requestFocus();;
}
}
catch(ClassNotFoundException  ex){
    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE,null,ex);
}
catch(SQLException ex){
    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE,null,ex);
}

}
     }
//public void close(){
//System.exit(0);
//}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
