
package expensetracker;

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author bejgum akshara
 */
public class tracker extends JFrame {
    private final expensetable tableModel;
    private final JTable table;
    private final JTextField dateField;
    private final JTextField dataField;
    private final JTextField amtField;
    private final JComboBox<String> typeCombobox;
    private final JButton addButton;
    private final JLabel balanceLabel;
    private double balance;
    
    public tracker(){
      try{
         UIManager.setLookAndFeel(new FlatDarkLaf());
      }
      catch(Exception ex){
          System.err.println("Failed to set FlatDarkLaf LookAndFeel");
      }
      UIManager.put("TextField.foreground", Color.WHITE);
      UIManager.put("TextField.background", Color.DARK_GRAY);
      UIManager.put("TextField.careforeground", Color.RED);
      UIManager.put("ComboBox.forground", Color.YELLOW);
      UIManager.put("ComboBox.selectionForeground", Color.WHITE);
      UIManager.put("ComboBox.selectionBackground", Color.BLACK);
      UIManager.put("Button.foreground", Color.WHITE);
      UIManager.put("Button.background", Color.ORANGE);
      UIManager.put("Label.foreground", Color.WHITE);
      
      Font customFont=new Font("Arial",Font.PLAIN,10);
      UIManager.put("Label.font", customFont);
      UIManager.put("TextField.font", customFont);
      UIManager.put("ComboBox.font", customFont);
      UIManager.put("Button.font", customFont);
        
        balance =0.0;
        tableModel=new expensetable();
        table =new JTable(tableModel);
        JScrollPane scrollPane=new JScrollPane(table);
        table.setFillsViewportHeight(true);
        
        dateField = new JTextField(10);
         dataField = new JTextField(20);
                  amtField = new JTextField(10);

                           typeCombobox = new JComboBox<>(new String[]{"Expense","Income"});

                                    addButton = new JButton("Add");
                                    addButton.addActionListener(e ->addentry());
                                    balanceLabel=new JLabel("balance: $"+balance);
                                    
                                    
                                    JPanel inputPanel=new JPanel();
                                    inputPanel.add(new JLabel("Date"));
                                    inputPanel.add(dateField);
                                    
                                    inputPanel.add(new JLabel("Data"));
                                    inputPanel.add(dataField);
                                    
                                    inputPanel.add(new JLabel("Amount"));
                                    inputPanel.add(amtField);
                                    
                                    inputPanel.add(new JLabel("Type"));
                                    inputPanel.add(typeCombobox);
                                    
                                    inputPanel.add(addButton);
                                    JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                                    bottomPanel.add(balanceLabel);
                                    setLayout(new BorderLayout());
                                    
                                    
                                    add(inputPanel,BorderLayout.NORTH);
                                    add(scrollPane,BorderLayout.CENTER);
                                    add(bottomPanel,BorderLayout.SOUTH);
                                    
                                    
                                    setTitle("Expenses Tracker");
                                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                    pack();
                                    setVisible(true);
                                    
                                    
                                    
                                    

        
        
      } 
    private void addentry(){
        String date=dateField.getText();
        String data=dataField.getText();
        String amtStr=amtField.getText();
        String type=(String)typeCombobox.getSelectedItem();
        double amt;
        if(amtStr.isEmpty())
        {        
         JOptionPane.showMessageDialog(this, "Enter the Amount","Error",JOptionPane.ERROR_MESSAGE);
         return;
        }
        try{
            amt=Double.parseDouble(amtStr);
        }
        catch(NumberFormatException ex){
           JOptionPane.showMessageDialog(this, "Invalid Amount","Error",JOptionPane.ERROR_MESSAGE);
         return; 
        }
        if(type.equals("Expense")){
            amt*=-1;
        }
        expenseentry entry=new expenseentry(date,data,amt,type);
        tableModel.addEntry(entry);
        balance+=amt;
        balanceLabel.setText("balance: $"+balance);
        clearInputFields();
    }
    private void clearInputFields(){
        dataField.setText("");
        dataField.setText(" ");
        amtField.setText(" ");
        typeCombobox.setSelectedIndex(0);
        
    }
    
    
}