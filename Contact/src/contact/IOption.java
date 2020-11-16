/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contact;

import java.util.ArrayList;

/**
 *
 * @author trinh
 */
public interface IOption {
    public boolean add(ArrayList<Contact> list, int id, String name, String group,
            String address, String phone, String firstName, String lastname);
    public void display(ArrayList<Contact> list);
    public boolean delete(ArrayList<Contact> list, int id);
}
