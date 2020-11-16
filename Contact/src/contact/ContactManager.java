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
public class ContactManager {
    
    public static void main(String[] args) {
        int choice = 0;
        Validation v = new Validation();
        Option op = new Option();
        ArrayList<Contact> list = new ArrayList<>();
        list.add(new Contact(1, "Iker Casillas", "Star", "Ha Noi", "0123012312", "Iker", "Casillas"));
        list.add(new Contact(2, "Iker Casillas anton", "Star", "Ha Noi", "0123012312", "Iker", "Casillas anton"));
        list.add(new Contact(3, "Iker Casillas adam", "Star", "Ha Noi", "0123012312", "Iker", "Casillas adam"));
        list.add(new Contact(4, "Iker Casillas 3", "Star", "Ha Noi", "0123012312", "Iker", "Casillas 3"));
        list.add(new Contact(5, "Iker Casillas 4", "Star", "Ha Noi", "0123012312", "Iker", "Casillas 4"));
        while(true){
            v.menu();
            choice = v.getChoice();
            switch(choice){
                case 1:
                    //add
                    int id = v.getIdToAdd(list);
                    String name = v.getString("input name: ", "invalid name, please input again: ");
                    String group = v.getString("input group: ", "invalid group, please input again: ");
                    String address = v.getString("input address: ", "invalid address, please input again: ");
                    String phone = v.getPhone();
                    //Iker Casillas adam
                    String txt[] = name.split(" ",2);
                    String firstName = txt[0];
                    String lastName = txt[1];
                    op.add(list, id, name, group, address, phone, firstName, lastName);
                    //
                    break;
                case 2:
                    //display
                    op.display(list);
                    break;
                case 3:
                    int idDelete = v.getIdToDelete();
                    op.delete(list, idDelete);
                    //delete
                    break;
                case 4:
                    break;
            }
        }
    }
}
