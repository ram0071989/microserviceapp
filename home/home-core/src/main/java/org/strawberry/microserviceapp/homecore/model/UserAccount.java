package org.strawberry.microserviceapp.homecore.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/*******************************************************************************
 * @author sriram
 * @version 1.0
 * Class: UserAccount
 * Description: Model class for UserAccount object
 ******************************************************************************/

@Document( collection="UserAccount" )
public class UserAccount {

    /******************************************************
     *
     * Class Attribute(s)
     *
     *****************************************************/

    @Id
    private String id;
    private String username;
    private int accountNumber;
    private int customerId;
    private String firstName;
    private String lastName;

    /******************************************************
     *
     * Class Attribute(s)
     *
     *****************************************************/
    public UserAccount(String username, int accountNumber, int customerId, String firstName, String lastName) {
        this.username = username;
        this.accountNumber = accountNumber;
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    /******************************************************
     *
     * Getter(s)/Setter(s)
     *
     *****************************************************/
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /******************************************************
     *
     * Public Method(s)
     *
     *****************************************************/
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append( getUsername() ).append( '\n' );
        stringBuilder.append( getFirstName() ).append( '\n' );
        stringBuilder.append( getLastName() );
        return stringBuilder.toString();
    }
}
