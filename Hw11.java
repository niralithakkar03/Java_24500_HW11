/*
 * Nirali Thakkar
 * 11/15/2020
 * This is a program that explain the basic fo Serialization.
 * This program will get Name, Phone Number, Date of Birth, 
 * and Email Address from the user.  
 */

package hw11;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Hw11 {

    /*
     * @param args the command line arguments
    */

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        ArrayList<Customer> arrCustomer = new ArrayList<>(); 
        for (int i = 0; i<5; i++){
            Customer xCustomer = new Customer();
            System.out.println("___________________");
            System.out.println("Customer: " + (i+1));
            System.out.println("-------------------");
            
            System.out.print("Enter the First Name: ");
            xCustomer.setName(sc.next());
            System.out.print("Enter the Phone Number: ");
            xCustomer.setPhone(sc.nextInt());
            System.out.print("Enter the DOB: ");
            xCustomer.setBirthday(sc.next());
            System.out.print("Enter the Email Address: ");
            xCustomer.setEmailAddress(sc.next());     
            
            try{
                writeToFile(xCustomer);
            } catch (IOException e){
                System.out.println(e.getMessage());
            }
            try{
                readFromFile();
            } catch (IOException | ClassNotFoundException e){
                System.out.println(e.getMessage());
            }
            xCustomer.toString();
        }
            
    }
    
    public static void writeToFile(Customer x) throws FileNotFoundException, IOException{
        ObjectOutputStream objectOutputStream = new ObjectOutputStream (new FileOutputStream("customer.bin"));
        objectOutputStream.writeObject(x);
    }
    public static void readFromFile() throws FileNotFoundException, IOException, ClassNotFoundException{
        ObjectInputStream objectInputStream = new ObjectInputStream (new FileInputStream("customer.bin"));
        Customer newCustomer = (Customer) objectInputStream.readObject();
        System.out.println (newCustomer.toString());
    }
    
}

class Customer implements Serializable{
    private String name;
    private int phone;
    private String birthday;
    private String emailAddress;

    @Override
    public String toString() {
        return "Customer{" + "name=" + name + ", phone=" + phone + ", birthday=" + birthday + ", email address=" + emailAddress + '}';
    }

    public Customer(String name, int phone, String birthday, String address) {
        this.name = name;
        this.phone = phone;
        this.birthday = birthday;
        this.emailAddress = address;
    }

    public Customer() {
    }

    public String getName() {
        return name;
    }

    public int getPhone() {
        return phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setEmailAddress(String address) {
        this.emailAddress = address;
    }
}