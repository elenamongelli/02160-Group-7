package OldGUI_Victor;

 

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

 

public class ContainerClientHistory implements ActionListener {

 

    private static JButton buttonAdd;
    private static JButton buttonRemove;
    private static JFrame frame;
    private static JScrollPane jt;
    

 

    public static void main(String[] args) {
        frame = new JFrame();
        JPanel panel = new JPanel();
        
        frame.setSize(900, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        
        panel.setLayout(null);

 

        String data[][]={ {"101","Amit","670000","670000","101","Amit"},    
                {"101","Amit","670000","670000","101","Amit"},     
                {"101","Amit","670000","670000","101","Amit"}};    
        String column[]={"Journey ID","Date","Position","Temperature","Humidity","Pressure"};         
        JTable jt=new JTable(data,column);
        
        jt.setBounds(30,40,200,300);          
        JScrollPane sp=new JScrollPane(jt); 
        frame.add(sp);
        
        buttonAdd = new JButton("Add measurements");
        buttonAdd.setBounds(300, 400, 50, 50);
        buttonAdd.addActionListener(new ContainerClientHistory());
        panel.add(buttonAdd);
        
        buttonRemove = new JButton("Remove measurements");
        buttonRemove.setBounds(300, 400, 200, 50);
        buttonRemove.addActionListener(new ContainerClientHistory());
        panel.add(buttonRemove);
        
        frame.setVisible(true);

 

    }

 


    public void actionPerformed(ActionEvent e) {
    }

 

}
 