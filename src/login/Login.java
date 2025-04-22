/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package login;

/**
 *
 * @author ceeyah
 */
//Import all necessary packages 
import javax.swing.JOptionPane;
import java.util.Scanner;


public class Login {
    String username;
    String password;
    String cellPhoneNumber;
    boolean isRegistered = false;
    Scanner scanner = new Scanner(System.in);

    // Main method to run the registration process
    public static void main(String[] args) {
        Login registration = new Login();
        registration.registerUser();
    }

    // Method to register the user 
    public String registerUser() {
        // Use a While Loop until valid username is entered
        while (true) {
            username = JOptionPane.showInputDialog("Enter your username (must contain underscore and be equal to 5 characters):");
            if (checkUserName()) {
                break;
            } else {
                JOptionPane.showMessageDialog(null, 
                    "Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.",
                    "Invalid Username", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Loop until valid password is entered
        while (true) {
            password = JOptionPane.showInputDialog("Enter your password (must be equal to 8 characters, with capital, number, and special character):");
            if (checkPassword()) {
                break;
            } else {
                JOptionPane.showMessageDialog(null, 
                    "Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.",
                    "Invalid Password", JOptionPane.ERROR_MESSAGE);
            }
        }

        // Loop until valid cell phone number is entered
        while (true) {
            cellPhoneNumber = JOptionPane.showInputDialog("Enter your cell phone number +27:");
            if (checkCellPhoneNumber()) {
                break;
            } else {
                JOptionPane.showMessageDialog(null, 
                    "Cellphone number is not correctly formatted, please ensure it has +27 followed by 8 digits.",
                    "Invalid Cellphone", JOptionPane.ERROR_MESSAGE);
            }
        }
        // Messeage If the User has input the correct details
        isRegistered = true;
        String message = returnLoginStatus();
        System.out.println(message);
        return message;
    }

    // Creat a boolean Method to check username if User is valid
    public boolean checkUserName() {
        // Username must contain underscore and be no more than 5 characters long
        return username != null && username.contains("_") && username.length() <= 5;
    }

    // Create a Method to check password has the right conditions 
    public boolean checkPassword() {
        if (password == null || password.length() < 8) {
            return false;
        }

        // Check for at least one capital letter
        boolean hasCapital = !password.equals(password.toLowerCase());
        // Check for at least one number
        boolean hasNumber = password.matches(".*\\d.*");
        // Check for at least one special character
        boolean hasSpecial = !password.matches("[A-Za-z0-9 ]*");

        return hasCapital && hasNumber && hasSpecial;
    }

    // Method to check cell phone number validity
    public boolean checkCellPhoneNumber() {
        // Cell phone must start with +27 (international code 27+) followed by 9 digits
        return 
               cellPhoneNumber != null && 
               cellPhoneNumber.matches("0\\d{9}") && 
               cellPhoneNumber.length() == 10;
    }

    // Method to simulate user login 
    public boolean loginUser() {
        if (!isRegistered) {
            return false;
        }

        System.out.println("\nLogin");
        System.out.print("Enter your username to login: ");
        String inputUsername = scanner.nextLine();
        System.out.print("Enter your password to login: ");
        String inputPassword = scanner.nextLine();

        return inputUsername.equals(username) && inputPassword.equals(password);
    }

    // Method to return login status message  in system.out.println 
    public String returnLoginStatus() {
        boolean success = loginUser();
        if (success) {
            return "Welcome " + username + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}
