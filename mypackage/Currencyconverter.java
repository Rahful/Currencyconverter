package mypackage;
//B.m Rahful hasan Shawon Id-18-38270-2//
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public final class Currencyconverter  extends JFrame implements ActionListener{
    
    private Container container;
    private JLabel title;
    private Font font, font2;
    private JComboBox box;
    private JTextField get;
    private JTextArea area;
    private JScrollPane pane;
    private JButton  Convert, Clear;
    
    private final String[] money = {"BD TO USD", "USD TO BD", "BD TO EURO", "EURO TO BD", "EURO TO USD", "USD TO EURO", "POUND TO EURO", "POUND TO USD", "POUND TO BD",  "BD TO POUND", "POUND TO CAD","USD TO POUND","BD TO INDIAN","INDIAN TO BD","BD TO PAK","BD TO RIYAL","BD TO YUAN"};
     //array//
    
   public Currencyconverter(){     //constructor 
        this.setBounds(300, 200, 500, 400);
        this.setTitle("Currency Converter Developed by Shawon");
        initComponenets();         //Method
    }

    public void initComponenets(){    //create background
        container = this.getContentPane();
        container.setLayout(null);
        container.setBackground(Color.green);
        
        //Create  Font Style///
        font = new Font("Arial", Font.BOLD,35);
        font2 = new Font("Arial", Font.BOLD, 20);
        
        
       //title create in currency converter application//
        title=new JLabel("Currency Converter");
        title.setBounds(0,0,500,80);
        title.setOpaque(true);
        title.setBackground(Color.red);
        title.setForeground(Color.black);
        title.setFont(font);
        title.setHorizontalAlignment(JLabel.CENTER );
        container.add(title);
        
        //Create JCombobox
        box = new JComboBox(money);
        box.setBounds(25,110,200,50);
        box.setEditable(false);
        box.setFont(font2);
        box.setBackground(Color.orange);
        box.setForeground(Color.black);
        container.add(box);
        
        //Create JText Field
        get = new JTextField();
        get.setBounds(25,180,200,50);
        get.setFont(font2);
        container.add(get);
        
        //Create Text Area
        area = new JTextArea();
        area.setFont(font2);
        area.setBackground(Color.red);
        area.setForeground(Color.yellow);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setEditable(false);
        
        //Create JScrollPane
        pane = new JScrollPane(area);
        pane.setBounds(245,110,220,120);
        container.add(pane);
        
        //Create button///
        
        Convert = new JButton("CONVERT");
        Convert.setBounds(20,260,220,50);
        Convert.setFont(font);
        Convert.setBackground(Color.BLUE);
        Convert.setForeground(Color.BLACK);
        container.add(Convert);
        //Create Clear Button//
        Clear = new JButton("CLEAR");
        Clear.setBounds(245,260,220,50);
        Clear.setFont(font);
        Clear.setBackground(Color.RED);
        Clear.setForeground(Color.BLACK);
        container.add(Clear);
        
        Convert.addActionListener(this); //interface
        Clear.addActionListener(this);
        get.addActionListener(this);
        
    }
    
    
    
    public void actionPerformed(ActionEvent e) {  //Abstract method//
        if(e.getSource()==Convert)
        {
            try{
                SetCalculation();//method
            }
            catch(Exception excep)
            {
                JOptionPane.showMessageDialog(null, excep+"Try again", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(e.getSource()==get)
        {
            try{
                SetCalculation();
            }
            catch(Exception excep)
            {
                JOptionPane.showMessageDialog(null, excep+"Try again", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if(e.getSource()==Clear)
        {
            area.setText("");
            get.setText("");
        }
        
    }
    
    
    public void SetCalculation(){    //method
        
        String s = box.getSelectedItem().toString();
        DecimalFormat formate = new DecimalFormat("0.0000");
        
        String d = get.getText();
        
        if(d.isEmpty()){
            JOptionPane.showMessageDialog(null, "Please Enter Any Number", "Error", JOptionPane.ERROR_MESSAGE);
            
        }else{
            if(s==money[0])
            {
                double BD = Double.valueOf(get.getText());
                
                double USD = BD * 0.012;
                String output = String.valueOf(formate.format(USD));
                this.area.setText("$" +output);
            }
            else if(s==money[1])
            {
                double USD = Double.valueOf(get.getText());
                
                double BD = USD / 0.012;
                String output = String.valueOf(formate.format(BD));
                this.area.setText(output+ "Tk");
            }
            else if(s==money[2])
            {
                double BD = Double.valueOf(get.getText());
                
                double Euro = BD * 0.011;
                String output = String.valueOf(formate.format(Euro));
                this.area.setText(output+" Euro");
            }
            else if(s==money[3])
            {
                double Euro = Double.valueOf(get.getText());
                
                double BD = Euro / 0.011;
                String output = String.valueOf(formate.format(BD));
                this.area.setText(output+ " Tk");
            }
            else if(s==money[4])
            {
                double Euro = Double.valueOf(get.getText());
                
                double USD = Euro / 0.93;
                String output = String.valueOf(formate.format(USD));
                this.area.setText("$ " +output);
            }
            else if(s==money[5])
            {
                double USD = Double.valueOf(get.getText());
                
                double Euro = USD * 0.93;
                String output = String.valueOf(formate.format(Euro));
                this.area.setText(output+ "Euro");
            }
            else if(s==money[6])
            {
                double pound = Double.valueOf(get.getText());
                
                double Euro = pound * 1.14;
                String output = String.valueOf(formate.format(Euro));
                this.area.setText(output+"Euro");
            }
            else if(s==money[7])
            {
                double pound = Double.valueOf(get.getText());
                
                double USD = pound * 1.23;
                String output = String.valueOf(formate.format(USD));
                this.area.setText("$ "+output);
            }
            else if(s==money[8])
            {
                double pound = Double.valueOf(get.getText());
                
                double BD = pound * 104.16;
                String output = String.valueOf(formate.format(BD));
                this.area.setText(output+" Tk");
            }
            else if(s==money[9])
            {
                double BD = Double.valueOf(get.getText());
                
                double pound = BD * 0.0096;
                String output = String.valueOf(formate.format(pound));
                this.area.setText(output+" pound");
            }
            else if(s==money[10])
            {
                double pound = Double.valueOf(get.getText());
                
                double CAD = pound * 1.75;
                String output = String.valueOf(formate.format(CAD));
                this.area.setText(output+" CAD");
            }
            
            
            else if(s==money[11])
            {
                double USD = Double.valueOf(get.getText());
                
                double pound = USD * 0.81;
                String output = String.valueOf(formate.format(pound));
                this.area.setText(output+" pound");
            }
            else if(s==money[12])
            {
                double BD = Double.valueOf(get.getText());
                
                double INDIAN = BD * 0.90;
                String output = String.valueOf(formate.format(INDIAN));
                this.area.setText(output+ " Rupee");
            }
            else if(s==money[13])
            {
                double INDIAN = Double.valueOf(get.getText());
                
                double BD = INDIAN / 0.90;
                String output = String.valueOf(formate.format(BD));
                this.area.setText(output+" TK");
            }
            else if(s==money[14])
            {
                double BD = Double.valueOf(get.getText());
                
                double PAK = BD * 1.96;
                String output = String.valueOf(formate.format(PAK));
                this.area.setText(output+" Rupee");
            }
            else if(s==money[15])
            {
                double BD = Double.valueOf(get.getText());
                
                double RIYAL = BD * 0.44;
                String output = String.valueOf(formate.format(RIYAL));
                this.area.setText(output+" Riyal");
            }
            else if(s==money[16])
            {
                double BD = Double.valueOf(get.getText());
                
                double YUAN = BD * 0.084;
                String output = String.valueOf(formate.format(YUAN));
                this.area.setText(output+" YUAN");
            }
        }
        
    }


}
