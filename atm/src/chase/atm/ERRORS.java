
package chase.atm;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Osama PC
 */
public class ERRORS {
   
    
    public static void display(String title,String message)
    {
        Stage error = new Stage();
        Scene scene;
        error.setTitle(title);
        
        error.initModality(Modality.APPLICATION_MODAL);
        
        VBox layout1 = new VBox();
        Label inv = new Label(message);
        Button ok = new Button("OK");
        ok.setOnAction((ActionEvent t) -> {error.close();});
        
        layout1.getChildren().addAll(inv,ok);
        layout1.setAlignment(Pos.CENTER);
        
        
        scene= new Scene(layout1,300,200);
        error.setScene(scene);
        error.showAndWait();
    }
}