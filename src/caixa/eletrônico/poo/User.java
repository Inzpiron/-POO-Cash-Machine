/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caixa.eletrônico.poo;

public class User {
    private String name;
    private String accountNumber;
    private String pinCode;
    private float accountBalance;
    
    public User(String name, String accountNumber, String pinCode, float accountBalance){
        this.name = name;
        this.accountNumber = accountNumber;
        this.pinCode = pinCode;
        this.accountBalance = accountBalance;
    }
    
    public String GetAccountName(){
        return this.name;
    }
    
    public String GetAccountNumber(){
        return this.accountNumber;
    }
    
    public String GetPinCode(){
        return this.pinCode;
    }
    
    public float GetAccountBalance(){
        return this.accountBalance;
    }
    
    public void IncrementBalance(float inc){
        this.accountBalance += inc;
    }
}
