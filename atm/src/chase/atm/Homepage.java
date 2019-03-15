
package chase.atm;

import java.awt.Font;

import java.awt.Image;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import static javafx.scene.control.Alert.AlertType.ERROR;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



public class Homepage {
        
    MENU menu;
    private ImageView image1;
    Stage Stage1,Stage2;
    Scene login,invalid;
     ERRORS error;
    public Homepage(Stage stage)
    {
        Stage1=stage;
    }
    
    int bool;
       
        public void prepareScene(Account one){
            
        
        //Buttons and Labels//
        Button Login = new Button("LOGIN");
        Label cardnumberlbl =new Label("Cardnumber");
        Label passwordlbl =new Label("Password");
        TextField cardnumberfld = new TextField();
        PasswordField passwordfld = new PasswordField();
        Label success= new Label();
        //-----------------------------/
  
        //layout for login page//
         GridPane layout0 = new GridPane();
        layout0.add(cardnumberlbl,0,1);
        layout0.add(passwordlbl,1,1);
        layout0.add(cardnumberfld,0,2);
        layout0.add(passwordfld,1,2);
        layout0.add(Login,1,3);
        layout0.add(success,1,4);
        login = new Scene(layout0, 300, 250);
        //-----------------------------------//
         
        
        
        
        
        
         
        //Verification//
        Login.setOnAction((ActionEvent login1) -> {
            String cardnumber = cardnumberfld.getText();
            String password = passwordfld.getText();
            bool=one.checkuser(cardnumber, password);
            if(bool==1)
            {
                
                Stage1.setTitle("Home");
                Stage1.setScene(menu.getScene());
                
            } 
            else
                error.display("ERROR","Invalid Username or Password");
        });
        }
        public Scene getScene()
        {
            return this.login;
        }

    public void setMenu(MENU menu) {
        this.menu = menu;
    }
        
        
}
        
       

        

    
    


    
    

