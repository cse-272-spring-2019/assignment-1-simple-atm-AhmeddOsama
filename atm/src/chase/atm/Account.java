
package chase.atm;

import java.util.Scanner;
import javafx.event.ActionEvent;


public class Account {

    private String name;
    private int age;
    private String gender;
    private  int cardnumber;
    private float bal;
    private String password;
    
    public Account(String name)
    {
        this.name=name;
    }
     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getCardnumber() {
        return cardnumber;
    }

    public void setCardnumber(int cardnumber) {
        this.cardnumber = cardnumber;
    }

    
    public float getBal() {
        return bal;
    }

    
    public void setBal(float bal) {
        this.bal = bal;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
   public void balInq()
   {
       System.out.println("Name:"+getName());
       System.out.println("Age:"+getAge());
       System.out.println("Gender:"+getGender());
       System.out.println("Card Number:"+getCardnumber());
       System.out.println("Balance:"+getBal());
       
    }
   public int checkuser (String cardnum, String inpass )
   {
     if(cardnum.equals("5935")&&inpass.equals("password"))
     {
         return 1;
     }
     else
     {
         return 0;
     }
   }
   public void handle(ActionEvent login)
    {
        
    }
}

     
    
    
    
    

