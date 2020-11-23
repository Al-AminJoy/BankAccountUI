package bankaccountui.bankaccount;

import bankaccountui.Client;

/**
 *
 * @author Al-Amin Islam <alaminislam3555@gmail.com>
 */
public class CreditCard extends BankAccount{
    private double creditLimit;

    public CreditCard(int id, Client client,double creditLimit) {
        super(id, client);
        this.creditLimit=creditLimit;
    }
    @Override
    public void widthraw(double amount){
        if(amount>0 && amount<=balance+creditLimit)
            balance=balance-amount;
        
    }
    @Override
    public String toString(){
         return String.format("%d,%.2f,%.2f", this.getId(),this.getBalance(),creditLimit);
     }
}
