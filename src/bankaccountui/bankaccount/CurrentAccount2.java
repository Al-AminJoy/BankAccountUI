package bankaccountui.bankaccount;

import bankaccountui.Client;

/**
 *
 * @author Al-Amin Islam <alaminislam3555@gmail.com>
 */
public class CurrentAccount2 extends BankAccount{
    private int id;
    private Client client;
    private double balance;
   public CurrentAccount2(int id, Client client, double balance) {
        super(id,client,balance);
    }
    @Override
    public void widthraw(double amount){
        amount=amount*1.01;
        super.widthraw(amount);
    }
}
