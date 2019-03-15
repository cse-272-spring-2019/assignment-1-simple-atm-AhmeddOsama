
package chase.atm;

import java.util.Scanner;


public class Transaction {
    public float newbal;
    public static int i=0; //index for history save//
    public int j; 
    public int h; //indiex for history navigation//
     float[] hisbal = new float[5];
     String[]   histran = new String[5];
     ERRORS error;
     String prevhistype;
     String prevhisam;
     String nexthistype;
     String nexthisam;
    
    public Transaction (float amnt )
    {
        this.newbal=amnt;
    }
    public float withdraw(float amount)
   {
       
            newbal-=amount;
            historySave("Withdraw",amount);
            return newbal;
   }
   public float deposit (float amount)
   {
       
       
         newbal+= amount;
         historySave("Deposit",amount);
         return newbal;
   }
   public void historySave(String operation, float bal)
   {   h=i;
       if(i==5)
       {
           
           for(j=0;j<=3;j++)
           {
               hisbal[j]=hisbal[j+1];
               histran[j]=histran[j+1];
               
           }
               hisbal[4]=bal;
               histran[4]=operation;
               
       }
       else
          {
              
       hisbal[i]=bal;
       histran[i]=operation;
       i++;
       
          }
     }
   
   public void prevhist()
   {
       
        
           if(h==0)
           {
               
               error.display("History", "End of history");
           
           }
           else
           {
               if(h==5)
               {
                   h=4;
               }
               h--;
               prevhistype=histran[h];
               prevhisam=String.valueOf(hisbal[h]);
               
           }
        
   }
     public void nexthist(){ 
               if(h==4)
             {
               error.display("History", "End of history");
             }
              else
               {
                   h++;
                   nexthistype=histran[h];
                   nexthisam=String.valueOf(hisbal[h]);
               }
           }
               
           }

 

