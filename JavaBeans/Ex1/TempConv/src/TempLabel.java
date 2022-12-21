
import javax.swing.JLabel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mamarino
 */
public class TempLabel extends JLabel {
    
    @Override
    public void setText(String text) {
        
        try {
            Double fahrenheitValue = (Double.parseDouble(text) * 1.8) + 32;
           
            super.setText(String.valueOf(fahrenheitValue));
            
        } catch(Exception e) {           
            super.setText("0.0");
        }
    }
    
}
