/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caixa.eletrônico.poo;

import static caixa.eletrônico.poo.GUI.entry;
import javax.swing.JOptionPane;

public class Controller {
    public static class Transiction{
        public static String accountNumber;
        public static String getAccountNumber(){
            return Transiction.accountNumber;
        }
    }
    
    public static class BalanceInquiry extends Transiction{
        public static boolean execute(){
            if(Transiction.getAccountNumber() != null){
                Transiction.getAccountNumber();
                return true;
            } else return false;
        }
    }
    
    public static class WithDraw extends Transiction{
        private static float amount;
        
        public static void setAmount(float tmp){
            amount = tmp;
        }
        
        public static boolean execute(){
            for(User usr : DataBase.UserDataBase){
                if(usr.GetAccountNumber().equals(Transiction.getAccountNumber())){
                    if(amount <= usr.GetAccountBalance()){
                        usr.IncrementBalance(-amount);
                        return true;
                    }else
                        return false;
                }
            }
            return false;
        }
    }
    
    public static class Deposit extends Transiction{
        public static float amount;
        
        public static void setAmount(float tmp){
            amount = tmp;
        }
        
        public static boolean execute(){
            for(User usr : DataBase.UserDataBase){
                if(usr.GetAccountNumber().equals(Transiction.getAccountNumber())){
                    try{
                        usr.IncrementBalance(amount); //Incrementando amount  no balanço atual
                    }catch(Exception e){
                    }
                }
            }
            return false;
        }
    }
    
    public static boolean verifyAccountPin(String pinCode){
        for(User UserDataBase : DataBase.UserDataBase){
            if(UserDataBase.GetAccountNumber().equals(GUI.accountNumber)){
                if(UserDataBase.GetPinCode().equals(pinCode)){
                    GUI.accountName = UserDataBase.GetAccountName();
                    GUI.accountBalance = UserDataBase.GetAccountBalance();
                    return true;   
                }
            }
        }
        
        return false;
    }
    
    public static boolean verifyAccountNumber(){
        for (User UserDataBase : DataBase.UserDataBase) {
            if (UserDataBase.GetAccountNumber().equals(entry)) {
                GUI.accountName = UserDataBase.GetAccountName();
                GUI.accountBalance = UserDataBase.GetAccountBalance();
                return true;
            }
        }
        return false;
    }
}
