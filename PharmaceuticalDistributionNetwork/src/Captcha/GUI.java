/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package captcha;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.JPanel;

/**
 *
 * @author zakir
 */

public class GUI {


    public static void display(String captcha) throws IOException {

        // Example user for the sake of testing, replace with fetching user information from database etc
        String user = "panna";
        String pass = "cotta";

        // GUI components declarations
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        JLabel lblUsername = new JLabel("Username:");
        JLabel lblPassword = new JLabel("Password:");
        JLabel lblCaptcha = new JLabel("Enter captcha (case sensitive):");
        JTextField username = new JTextField(20);
        JPasswordField password = new JPasswordField(20);
        JTextField enterCaptcha = new JTextField(20);
        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(e -> {
            String givenUsername = username.getText();
            String givenPassword = password.getText();
            String givenCaptcha = enterCaptcha.getText();

            Boolean correctUser = user.equals(givenUsername);
            Boolean correctPassword = pass.equals(givenPassword);
            Boolean correctCaptcha = captcha.equals(givenCaptcha);

            if(correctUser && correctPassword && correctCaptcha){
                JOptionPane.showMessageDialog(null, "Correct user");
                System.exit(0);
            }
            else{
                JOptionPane.showMessageDialog(null, "Incorrect user");
                System.exit(0);
            }
        });

        BufferedImage image = ImageIO.read(new File("./Text.png"));
        JLabel loadedImage = new JLabel(new ImageIcon(image));

        // Adding GUI components to panel
//        panel.add(lblUsername);
//        panel.add(username);
//        panel.add(lblPassword);
//        panel.add(password);
        panel.add(lblCaptcha);
        panel.add(loadedImage);
        panel.add(enterCaptcha);
        panel.add(new JLabel("  "));
        panel.add(btnLogin);
        frame.getContentPane().add(BorderLayout.CENTER,panel);
        frame.setSize(300,300);
        frame.setVisible(true);

    }
}

