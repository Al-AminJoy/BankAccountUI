/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankaccountui;

import bankaccountui.bankaccount.CreditCard;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author Al-Amin Islam <alaminislam3555@gmail.com>
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField clientIDField;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private DatePicker datePickerField;
    @FXML
    private Label statusLabel;
   // ArrayList<Client> clients;
    ObservableList<Client> clients;
    @FXML
    private ListView<Client> clientListView;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        readFile();
        printClients();
        accountDemo();
    }

    @FXML
    private void handleAddClientAction(ActionEvent event) throws IOException {
        int clientId = Integer.parseInt(clientIDField.getText());
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        LocalDate dob = datePickerField.getValue();
        Name name = new Name(firstName, lastName);
        Client client = new Client(clientId, name, dob);
        // String clientAll=client.toStrting();
        //System.out.println(clientAll);
        try (RandomAccessFile output = new RandomAccessFile("client.txt", "rw")) {
            long length = output.length();
            output.seek(length);
            output.writeBytes(client.toString() + "\n");
            clients.add(client);
            statusLabel.setText("Client ID : " + client.getClientId());
            clearForm();
        } catch (IOException ex) {
            System.out.println("IOException : " + ex.getMessage());
        }

    }

    private void printClients() {
       for(Client i:clients)
            System.out.println(i);
    }

    private void clearForm() {
        clientIDField.clear();
        firstNameField.clear();
        lastNameField.clear();
        datePickerField.setValue(null);
    }

    private void readFile() {
        //clients = new ArrayList<>();
        clients = FXCollections.observableArrayList();
  
        try (RandomAccessFile raf = new RandomAccessFile("client.txt", "r")) {

            String line;

            while (true) {
                line = raf.readLine();
                if (line == null) {
                    break;
                }
                String data[] = line.split("\\,");
                int id = Integer.parseInt(data[0]);
                String firstName = data[1];
                String lastName = data[2];
                LocalDate dob = LocalDate.parse(data[3]);
                Name name = new Name(firstName, lastName);
                Client client = new Client(id, name, dob);
                clients.add(client);
                

            }
            clientListView.setItems(clients);
        } catch (FileNotFoundException e) {
            System.err.println("File Not Found");
        } catch (IOException e) {
            System.err.println("I/O Error");
        }
    }

    private void accountDemo() {
        CreditCard c=new CreditCard(1,clients.get(0),50000);
        System.out.println(c);
        c.widthraw(5000);
        System.out.println(c);
    }

}
