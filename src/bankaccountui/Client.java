package bankaccountui;

import java.time.LocalDate;

/**
 *
 * @author Al-Amin Islam <alaminislam3555@gmail.com>
 */
public class Client {

    private int clientId;
    private Name clientName;
    private LocalDate dob;

    public Client(int clientId, Name clientName, LocalDate dob) {
        this.clientId = clientId;
        this.clientName = clientName;
        this.dob = dob;
    }

    public int getClientId() {
        return clientId;
    }

    public Name getClientName() {
        return clientName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setClientName(Name clientName) {
        this.clientName = clientName;
    }

    public String toString() {
        return String.format("%d,%s,%s,%s", clientId,clientName.getFirstName(),clientName.getLastName(),dob);

    }

}
