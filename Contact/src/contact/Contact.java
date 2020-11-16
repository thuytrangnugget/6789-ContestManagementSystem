/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contact;

/**
 *
 * @author trinh
 */
public class Contact {
    private int id;
    private String fullName;
    private String group;
    private String address;
    private String phone;
    private String firstName;
    private String lastName;

    public Contact() {
    }

    public Contact(int id, String fullName, String group, String address, String phone, String firstName, String lastName) {
        this.id = id;
        this.fullName = fullName;
        this.group = group;
        this.address = address;
        this.phone = phone;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    @Override
    public String toString() {
        return String.format("%5d%25s%10s%20s%10s%15s%15s", id,fullName,firstName,lastName,group,address,phone);
//        return id + "\t"+fullName+"\t"+firstName+"\t"+lastName+"\t"+group+"\t"+address+"\t"+phone;
    }
    
    
            
}
