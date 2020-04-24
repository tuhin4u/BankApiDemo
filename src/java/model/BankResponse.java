/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author sanket
 */
public class BankResponse {
    
   Account accountDetails;
   int status;

    public BankResponse(Account accountDetails, int status) {
        this.accountDetails = accountDetails;
        this.status = status;
    }
   

   
    public BankResponse() {}

    public Account getAccountDetails() {
        return accountDetails;
    }

    public void setAccountDetails(Account accountDetails) {
        this.accountDetails = accountDetails;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    
    
    
}

