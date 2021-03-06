package bankaccountui.bankaccount;

import bankaccountui.Client;
import bankaccountui.Name;
import java.time.LocalDate;

/**
 *
 * @author Al-Amin Islam <alaminislam3555@gmail.com>
 */
public class CurrentAccount {
     private int id;
    private Client client;
    private double balance;
     public CurrentAccount(CurrentAccount that) {
        this.id = that.id;
        this.client = new Client(that.getId(),new Name(that.client.getClientName().getFirstName(),that.client.getClientName().getLastName()),LocalDate.of(that.client.getDob().getYear(),
                that.client.getDob().getMonth(), that.client.getDob().getDayOfMonth()));
        this.balance = that.balance;
    }
    public CurrentAccount(int id, Client client) {
        this.id = id;
        this.client = client;
        this.balance = 0;
    }
    public CurrentAccount(int id, Client client, double balance) {
        this.id = id;
        this.client = client;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public double getBalance() {
        return balance;
    }
    public void widraw(double amount){
        amount=amount*1.01;
        if(amount>0 && amount<=balance)
            balance=balance-amount;
        
    }
    
     public void deposite(double amount){
         if(amount>0)
             balance=balance+amount;
        
    }
    
}
