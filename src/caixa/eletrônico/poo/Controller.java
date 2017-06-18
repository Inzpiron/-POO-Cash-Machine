/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caixa.eletrônico.poo;

public class Controller {
    public static class Transaction{
        public static String accountNumber;
        public static String getAccountNumber(){
            return Transaction.accountNumber;
        }
    }
    
    public static class BalanceInquiry extends Transaction{
        public static boolean execute(){
            if(Transaction.getAccountNumber() != null){
                Transaction.getAccountNumber();
                return true;
            } else return false;
        }
    }
    
    public static class WithDraw extends Transaction{
        private static float amount;
        
        public static void setAmount(float tmp){
            amount = tmp;
        }
        
        public static boolean execute(){
            for(User usr : DataBase.UserDataBase){
                if(usr.GetAccountNumber().equals(Transaction.getAccountNumber())){
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
    
    public static class Deposit extends Transaction{
        public static float amount;
        
        public static void setAmount(float tmp){
            amount = tmp;
        }
        
        public static boolean execute(){
            for(User usr : DataBase.UserDataBase){
                if(usr.GetAccountNumber().equals(Transaction.getAccountNumber())){
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
            if(UserDataBase.GetAccountNumber().equals(Main.mainGUI.getAccountNumber())){
                if(UserDataBase.GetPinCode().equals(pinCode)){
                    Main.mainGUI.setAccountName(UserDataBase.GetAccountName());
                    Main.mainGUI.setAccountBalance(UserDataBase.GetAccountBalance());
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public static boolean verifyAccountNumber(){
        for (User UserDataBase : DataBase.UserDataBase) {
            if (UserDataBase.GetAccountNumber().equals(Main.mainGUI.getEntry())) {
                Main.mainGUI.setAccountName(UserDataBase.GetAccountName());
                Main.mainGUI.setAccountBalance(UserDataBase.GetAccountBalance());
                return true;
            }
        }
        return false;
    }
}
