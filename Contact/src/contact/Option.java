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
public class Option implements IOption{
    @Override
    public boolean add(ArrayList<Contact> list, int id, String name, String group,
            String address, String phone, String firstName, String lastname){
        Contact c = new Contact(id, name, group, address, phone, firstName, lastname);
        list.add(c);
        return true;
    }
    @Override
    public void display(ArrayList<Contact> list){
        for (Contact o : list) {
            System.out.println(o);
        }
    }
    @Override
    public boolean delete(ArrayList<Contact> list, int id){
        boolean check = true;
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            if(id==list.get(i).getId()){
                list.remove(i);
                check = false;
                index = i;
                System.out.println("Delete an contact successful");
                break;
            }
        }
        if(check){
            System.out.println("Delete an contact fail");
        }
        return true;
    }
    
}
