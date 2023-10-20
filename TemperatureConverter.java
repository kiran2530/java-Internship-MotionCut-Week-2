import java.awt.*; 
import java.awt.event.ActionEvent; 
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame; 
import javax.swing.JLabel; 
import javax.swing.JTextField;  
import java.awt.event.ActionListener;

public class TemperatureConverter implements ActionListener {
    JFrame frame = new JFrame(); 
    JLabel lblTitle = new JLabel("Temperature Converter"); 
    String Types[] = {"Celsius","Fahrenheit"}; 
    JComboBox select1 = new JComboBox<>(Types);
    JComboBox select2 = new JComboBox<>(Types);
    JTextField txtInputTemp = new JTextField(); 
    JTextField txtResult = new JTextField(""); 
    JButton btnConvert = new JButton("Convert");
    

    TemperatureConverter() {
        prepareGui();
        AddComponent();
        AddActionEvent();
    }

    public void prepareGui() {
        frame.setTitle("Temperature Converter"); 
        frame.setSize(400,400); 
        frame.getContentPane().setLayout(null);
        frame.setResizable(false); 
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }
    public void AddComponent() {
        
        lblTitle.setBounds(0, 25, 400, 50);
        lblTitle.setHorizontalAlignment(0);
        lblTitle.setFont(new Font("Arial",Font.BOLD,20));
        frame.add(lblTitle);

        select1.setBounds(80, 100, 100, 25);
        frame.add(select1);

        txtInputTemp.setBounds(230, 100, 100, 25);
        frame.add(txtInputTemp);

        btnConvert.setBounds(150, 170, 100, 25);
        frame.add(btnConvert);

        select2.setBounds(80, 250, 100, 25);
        frame.add(select2);

        txtResult.setBounds(230, 250, 100, 25);
        txtResult.setEditable(false);
        frame.add(txtResult);
    }
    
    public void AddActionEvent(){
        btnConvert.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if(source == btnConvert) {
            String s1 = "";
            s1 += select1.getItemAt(select1.getSelectedIndex());
            
            String s2 = "";
            s2 += select2.getItemAt(select2.getSelectedIndex());

            if(s1.equals(s2)) {
                txtResult.setText(txtInputTemp.getText());
            }
            else {
                double data = Double.parseDouble(txtInputTemp.getText());
                double data1;
                if(s1.equals("Celsius")) {
                    data1 = (data * ((double)9/5)) + 32;
                    String str = String.valueOf(data1);
                    txtResult.setText(str);
                }
                else {
                    data1 = (data - 32) * ((double)5/9);
                    String str = String.valueOf(data1);
                    txtResult.setText(str);
                }
            }
        }
    }
    public static void main(String[] args) {
        new TemperatureConverter();
    }
}