/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package captcha;

import java.io.IOException;

/**
 *
 * @author zakir
 */
public class Captcha {

    /**
     * @param args the command line arguments
     */
  public static void main(String[] args) throws IOException {

    ImageGenerator initiateProgram = new ImageGenerator();
        try {
            initiateProgram.Generate();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
