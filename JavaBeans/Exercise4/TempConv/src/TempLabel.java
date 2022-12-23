
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;
import javax.swing.JLabel;

/**
 *
 * @author mamarino
 */
public class TempLabel extends JLabel {
    
    private VetoableChangeSupport mVcs = new VetoableChangeSupport(this);
    
    @Override
    public void setText(String text) {
        if (mVcs == null) {
            super.setText(text);
            return;
        }

        String textToReplace = text;
        try {
            mVcs.fireVetoableChange(
                    "tempLabelTextProperty",
                    this.getText(),
                    text
            );

            Double fahrenheitValue = (Double.parseDouble(text) * 1.8) + 32;
    
            textToReplace = String.valueOf(fahrenheitValue);
            
        } catch(PropertyVetoException pve) {
            System.out.println("VetoExc: " + pve.getMessage());
            textToReplace = "0.0";
        } finally {
            super.setText(textToReplace);
        }
    }
    
    public void addVetoableChangeListener(VetoableChangeListener listener) {
        mVcs.addVetoableChangeListener(listener);
    }
    
    public void removeVetoableChangeListener(VetoableChangeListener listener) {
        mVcs.removeVetoableChangeListener(listener);
    }
}
