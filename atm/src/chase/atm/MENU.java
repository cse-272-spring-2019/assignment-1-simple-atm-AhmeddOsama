
package chase.atm;

import static java.sql.JDBCType.NULL;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class MENU {
    Stage stage;
    Scene mainmenu,transfer,information;
    Homepage Login;
    String value;
    float amount;
    ERRORS error = new ERRORS();
    Homepage Logout;
    
    public MENU(Stage stage1)
    {
        this.stage=stage1;
    }
    public String enter(ActionEvent event)
    {
        value=((Button)event.getSource()).getText();
        return value;
    }
    public void prepareScene(Account one)
    {
        Transaction money= new Transaction(one.getBal());
        
       
        //layout for atm home//
         VBox layout1 = new VBox();
         Button withdraw = new Button("Withdraw");
         Button deposit = new Button("Deposit  ");
         Button inquiry = new Button ("Balance Inquiry");
         Button history= new Button("History");
         Button logout= new Button("Logout");
         layout1.getChildren().addAll(withdraw,deposit,inquiry,history,logout);
         layout1.setAlignment(Pos.CENTER);
         mainmenu= new Scene(layout1,300,250);
         
         logout.setOnAction((ActionEvent log) -> {
            Logout = new Homepage(stage);
            Logout.prepareScene(one);
            Logout.setMenu(this);
            stage.setScene(Logout.getScene());
        });
         
         
         //Initializing buttons for atm use //
         
         TextField output = new TextField("");
         Button digit0 = new Button("0");
         Button digit1 = new Button("1");
         Button digit2 = new Button("2");
         Button digit3 = new Button("3");
         Button digit4 = new Button("4");
         Button digit5 = new Button("5");
         Button digit6 = new Button("6");
         Button digit7 = new Button("7");
         Button digit8= new Button("8");
         Button digit9 = new Button("9");
         Button delete = new Button("DEL");
         Button ok = new Button("Ok");
         
         digit0.setOnAction((ActionEvent t) -> {value=digit0.getText();
             output.setText(output.getText() + value);});
         digit1.setOnAction((ActionEvent t) -> {value=digit1.getText();
             output.setText(output.getText() + value);});
         digit2.setOnAction((ActionEvent t) -> {value=digit2.getText();
             output.setText(output.getText() + value);});
         digit3.setOnAction((ActionEvent t) -> {value=digit3.getText();
             output.setText(output.getText() + value);});
         digit4.setOnAction((ActionEvent t) -> {value=digit4.getText();
             output.setText(output.getText() + value);});
         digit5.setOnAction((ActionEvent t) -> {value=digit5.getText();
             output.setText(output.getText() + value);});
         digit6.setOnAction((ActionEvent t) -> {value=digit6.getText();
             output.setText(output.getText() + value);});
         digit7.setOnAction((ActionEvent t) -> {value=digit7.getText();
             output.setText(output.getText() + value);});
         digit8.setOnAction((ActionEvent t) -> {value=digit8.getText();
             output.setText(output.getText() + value);});
         digit9.setOnAction((ActionEvent t) -> {value=digit9.getText();
             output.setText(output.getText() + value);});
         delete.setOnAction((ActionEvent t) -> {
             output.setText("");
        });
         //---------------------------------------------------------------//
           Button back1 = new Button("Back"); 
           
         GridPane layout2=new GridPane();
         transfer= new Scene(layout2,300,250);
         
         
        //WITHDRAW SCENE//
         withdraw.setOnAction((ActionEvent t) -> {
             
         layout2.add(digit9,2,4);            //SETTING LAYOUT FOR WITHDRAW//
         layout2.add(digit8,2,3);
         layout2.add(digit7,2,2);
         layout2.add(digit6,3,4);
         layout2.add(digit5,3,3);
         layout2.add(digit4,3,2);
         layout2.add(digit3,4,4);
         layout2.add(digit2,4,3);
         layout2.add(digit1,4,2);
         layout2.add(output,5,5);
         layout2.add(ok,5,12);
         layout2.add(back1,4,12);
         layout2.add(digit0,3,5);
         layout2.add(delete, 4,5);                //----------------------------/
         
         ok.setOnAction((ActionEvent event) -> {       //OK BUTTON//
             if (output.getText().equals(""))
            {
                error.display("INVALID TRANSACTION","Enter valid amount");
                
            }  
             else {
               amount=Float.valueOf(output.getText());
               
               if(amount>one.getBal())
               {
                
                error.display("INVALID TRANSACTION","Amount to be withdrawn is invalid");
               }
           
            
               else if (amount<0)
               {
                error.display("INVALID TRANSACTION","Enter valid amount");
               }
               else
               {
                
                output.setText("");
                error.display("Withdraw","Withdraw Complete");
                one.setBal(money.withdraw(amount));
              
                }
             }
                  });                            //------------------------//
         
           back1.setOnAction((ActionEvent back) -> {  //BACK BUTTON//
           output.setText("");
           stage.setScene(mainmenu);
           layout2.getChildren().clear();
        });                                     //---------------------/
          
          stage.setScene(transfer);
          stage.setTitle("Withdraw");
         });
        //---------------------------------------------------/
         
         //DEPOSIT SCENE//
         deposit.setOnAction((ActionEvent t) -> {
           
       
         layout2.add(digit9,2,4);             //SETTING LAYOUT FOR DEPOSIT//
         layout2.add(digit8,2,3);
         layout2.add(digit7,2,2);
         layout2.add(digit6,3,4);
         layout2.add(digit5,3,3);
         layout2.add(digit4,3,2);
         layout2.add(digit3,4,4);
         layout2.add(digit2,4,3);
         layout2.add(digit1,4,2);
         layout2.add(output,5,5);
         layout2.add(ok,5,12);
         layout2.add(back1,4,12);
         layout2.add(digit0,3,5);   
         layout2.add(delete, 4,5);                  //-------------------//
         
         
         ok.setOnAction((ActionEvent event) -> {           //OK BUTTON//
         if(output.getText().equals(""))
         {
             error.display("INVALID TRANSACTION","Enter valid amount");
         }
         
         
         else{
            amount=Float.valueOf(output.getText());
            if (amount<0)
            {
                error.display("INVALID TRANSACTION","Enter valid amount");
            }
            else
         {
         output.setText("");
         one.setBal(money.deposit(amount));
         error.display("Deposit","Deposit Complete");
         }
                 }
           });                                     //------------------------//
         
         back1.setOnAction((ActionEvent back) -> {     //BACK BUTTON //
           output.setText("");
           stage.setScene(mainmenu);
           layout2.getChildren().clear();
        });                                               //----------------//
          stage.setScene(transfer);
          stage.setTitle("Deposit");
          });
         //------------------------------------------------------//
         
         //BALANCE INQUIRY SCENE//
         inquiry.setOnAction((ActionEvent event3) -> {
             
         money.historySave("Balance inquiry",0);
         
         VBox layout3=new VBox();
         Label name = new Label(" Name: "+one.getName());
         Label balance = new Label("Balance: "+one.getBal());
         Label age = new Label("Age: "+one.getAge());
         Label gender = new Label("Gender: "+one.getGender());
         Button back = new Button("Back");
         
          back.setOnAction((ActionEvent event) -> {
            layout3.getChildren().clear();
            stage.setScene(mainmenu);
                });
                layout3.getChildren().addAll(name,balance,age,gender,back);
                layout3.setAlignment(Pos.CENTER);
         
         information = new Scene(layout3,300,250);
          stage.setScene(information);
         });
        //--------------------------------------------------------------//
         
         //HISTORY SCENE//
         history.setOnAction((ActionEvent hist) -> {
          
           Button previous = new Button("Previous transaction");
           Button next = new Button("Next transaction");
           Button back2 = new Button("Back");
           Label type = new Label("Transaction");
           Label amnt = new Label("Amount");
           layout2.add(type,1,3);
           layout2.add(amnt,1,4);
           
           previous.setOnAction((ActionEvent prev) -> {
             money.prevhist();
             type.setText("Transaction type: "+money.prevhistype);
             amnt.setText("Transaction amount: "+money.prevhisam);
             
           });
           next.setOnAction((ActionEvent t) -> {
               money.nexthist();
               type.setText("Transaction type: "+money.nexthistype);
               amnt.setText("Transaction amount: "+money.nexthisam);
           });
            back2.setOnAction((ActionEvent event) -> {
            layout2.getChildren().clear();
            stage.setScene(mainmenu);
                });
           layout2.add(previous, 1,1 );
           layout2.add(next,4,1);
           layout2.add(back2,3,5);
           stage.setScene(transfer);
           
        });
         //-------------------------------------------//
         
    }

    public void setLogin(Homepage login) {
        this.Login = login;
    }
    
     public Scene getScene()
        {
            return mainmenu;
        }
}
