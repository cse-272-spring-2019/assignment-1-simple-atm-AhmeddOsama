
package chase.atm;
import java.awt.Image;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.Scanner;
import javafx.application.Application;
import static javafx.application.Application.launch;

public class CHASEATM extends Application{
    
     
    public static void main(String[] args) {
   
     launch(args);
    }
     public void start(Stage primaryStage) {
         Stage PStage;
         PStage=primaryStage;
         Account one = new Account("Ahmed Osama");
         one.setBal(5000);
         one.setAge(19);
         one.setCardnumber(5935);
         one.setGender("Male");
         one.setPassword("password");
         
        String action,password,cardnum;
       
       Homepage Login= new Homepage(PStage);
       MENU menu= new MENU(PStage);
       Login.setMenu(menu);
       Login.prepareScene(one);
       menu.prepareScene(one);
       
      primaryStage.setScene(Login.getScene());
     
      PStage.show();
      PStage.setTitle("ATM Login");
     
     /**/ }
     
    
}
