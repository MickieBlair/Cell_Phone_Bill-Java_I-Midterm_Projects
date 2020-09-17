//Mickie Blair
//Java I – CIST 2371
//Mid-Project - Cell Phone - Part 2

/*
 * Write a program that calculates and prints the bill
 * for a cellular telephone company.  
 */

package cellphonepart2;

import javax.swing.JOptionPane;

public class CellPhonePart2 {

    /**
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        
        String input;                           //input from user before conversion
        int accountNumber;                      //account number
        char serviceCode;                       //service code
        double amountDue = 0;                   //amount due
        int totalMinutes;                       //total minutes - regular service
        int dayMinutes;                         //day minutes - premium service
        int nightMinutes;                       //night minutes - premium service
        
    

        //Display introduction
        JOptionPane.showMessageDialog(null,"\nCellular Bill Calculator\n"
                                     + "\nThe program will calculate the "
                                     + "cell phone bill using data gathered\n "
                                     + "from the user.  After all data has "
                                     + "been entered, a bill will be printed.\n");
        
        //Ask user for account number and store in variable
        input = JOptionPane.showInputDialog("Enter Account Number: ");
        
        //Convert input to int and store in account number variable
        accountNumber = Integer.parseInt(input);
        
        //Ask user for service code and store in variable
        input = JOptionPane.showInputDialog("\nType of Service:\n " 
                                    + "\nFor Regular Service - Enter R\n"
                                    + "\nFor Premium Service - Enter P\n"
                                    + "\n");
        
        //convert input to uppercase
        input = input.toUpperCase();
        
        //Convert input to char and store in service code variable
        serviceCode = input.charAt(0);
               
        //validation loop for service code
        while ((serviceCode != 'R') && (serviceCode != 'P'))
        {
        // Display Error message and ask user for service code and store in variable
        input = JOptionPane.showInputDialog("\nThe Service Code is Invalid.\n"
                                    + "\nPlease Try Again.\n"
                                    + "\n\nType of Service:\n " 
                                    + "\nFor Regular Service - Enter R\n"
                                    + "\nFor Premium Service - Enter P\n"
                                    + "\n");
        
        //convert input to uppercase
        input = input.toUpperCase();
        
        //Convert input to char and store in service code variable
        serviceCode = input.charAt(0); 
        }
        
        //if  statements for regular service
        if (serviceCode =='R')
        {
            //Ask user for the number of minutes and store in variable
            input = JOptionPane.showInputDialog("Enter the number of minutes "
                                    + "the service was used. " );
        
            //Convert input to int and store in account number variable
            totalMinutes = Integer.parseInt(input);
            
            //call nethod for the amount due
            amountDue = regularBill(totalMinutes);
              
        }
        
        if (serviceCode =='P')
        {
            //Ask user for the number of minutes used from 6am to 6pm
            input = JOptionPane.showInputDialog("Enter the number of minutes "
                                    + "the service \nwas used from "
                                    + "6:00am to 6:00pm." );
        
            //Convert input to int and store in account number variable
            dayMinutes = Integer.parseInt(input);
            
            //Ask user for the number of minutes used from 6pm to 6am
            input = JOptionPane.showInputDialog("Enter the number of minutes "
                                    + "the service \nwas used from "
                                    + "6:00pm to 6:00am." );
        
            //Convert input to int and store in account number variable
            nightMinutes = Integer.parseInt(input);
            
            //call nethod for the amount due
            amountDue = premiumBill(dayMinutes, nightMinutes);
        }

    //Print Bill
    
    System.out.println( "\nCellular Telephone Bill");
    System.out.println( "-----------------------");
    
    System.out.println("Account Number:  " + accountNumber);
    
    if (serviceCode == 'R')
    {
      System.out.println("Type of Service: Regular" );  
    }
    
    if (serviceCode == 'P')
    {
      System.out.println("Type of Service: Premium" );  
    }
    
    System.out.println();
    
    System.out.printf("Amount Due:     $%5.2f\n" , amountDue);
    
    System.out.println();
    
    System.exit(0);
    }
    
     /**
     *
     * @param totalMinutes total minutes service was used
     * @return amountDue Amount of Bill
     */
    public static double regularBill(int totalMinutes)
    {
        //Declare and initialize constants 
        final double REG_FEE = 10.00;       //Constant - regular base fee
        final int REG_FREE_MM = 50;         //Constant - free regular minutes
        final double REG_MM_CHARGE = .20;   //Regular Service - per minute charge
        
        //declare local variable
        int billableRegMinutes;             //billable minutes Regular Service
        double minutesUsedFee;              //fee for minutes used
        double billTotal = 0;               //amount due to be returned
        
        //calculate bill if minutes do not exceed free minutes
        if (totalMinutes <= REG_FREE_MM)
            {
                //calculate the amount Due
                billTotal = REG_FEE ;
            }

        //calculate bill if minutes exceed free minutes
        else if (totalMinutes > REG_FREE_MM)
            {
                //calculate the billable minutes
                billableRegMinutes = totalMinutes - REG_FREE_MM;

                //calculate the fee for minutes used
                minutesUsedFee = billableRegMinutes * REG_MM_CHARGE;

                //calculate the amount Due
                billTotal = REG_FEE + minutesUsedFee;

            }  
        
        //return amount due
        return billTotal;
    }

    
     /**
     *
     * @param dayMinutes minutes service was used between 6:00am and 6:00pm
     * @param nightMinutes minutes service was used between 6:00pm and 6:00am
     * @return amountDue Amount of Bill
     */
    public static double premiumBill(int dayMinutes, int nightMinutes)
    {
        //Declare and initialize constants 
        final double PREM_FEE = 25.00;          //Constant - premium  base fee
        final int PREM_FREE_DAY_MM = 75;        //Constant - free premium day minutes
        final int PREM_FREE_NIGHT_MM = 100;     //Constant - free premium night minutes
        final double PREM_DAY_MM_CHARGE = .10;  //Regular Service - per minute charge
        final double PREM_NIGHT_MM_CHARGE = .05;//Regular Service - per minute charge
        
        //declare local variable
        int billableDayMinutes;                 //Variable for billable minutes Day Minutes(Premium)
        double dayMinutesFee;                   //Variable for day minutes fee
        int billableNightMinutes;               //Variable for billable minutes Night Minutes(Premium)
        double nightMinutesFee;                 //Variable for night minutes
        double billTotal;                   //amount due to be returned
        
            // set day and night billable minutes 
            if (dayMinutes < PREM_FREE_DAY_MM)
                {
                   dayMinutesFee = 0;
                }
            else
                {
                    billableDayMinutes = dayMinutes - PREM_FREE_DAY_MM;
                    dayMinutesFee = billableDayMinutes * PREM_DAY_MM_CHARGE;
                }
                
            if (nightMinutes < PREM_FREE_NIGHT_MM)
                {
                    nightMinutesFee = 0;
                }
            
            else
                {
                    billableNightMinutes = nightMinutes - PREM_FREE_NIGHT_MM;
                    nightMinutesFee = billableNightMinutes * PREM_NIGHT_MM_CHARGE;
                }

            //calculate bill
            if (dayMinutesFee==0 && nightMinutesFee==0)
                {                  
                    //calculate the amount Due
                    billTotal = PREM_FEE ;
                }
            
            else
                {
                    //calculate the amount Due
                    billTotal = PREM_FEE + dayMinutesFee + nightMinutesFee;
                }
        
        //return amount due
        return billTotal;
    }
  
}
