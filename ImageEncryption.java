package ImageOP;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/*XOR Cipher*/
public class ImageEncryption {

    public static void operate(int key)
    {

        JFileChooser fileChooser=new JFileChooser();
        fileChooser.showOpenDialog(null);			//null to open filechooser in center
        File file = fileChooser.getSelectedFile();	
       
        //file FileInputStream
        try
        {

            FileInputStream fis=new FileInputStream(file);	//reads byte of data from input stream

            byte[] data=new byte[fis.available()];
            fis.read(data);
            int i=0;
            for(byte b:data)
            {
                System.out.println(b);	//prints stream of bytes in image file
                data[i]=(byte)(b^key);	//xor each databyte(b) with key 
                i++;
            }

            FileOutputStream fos=new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Done");

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    
    public static void main(String[] args) {
        
        JFrame f=new JFrame();
        f.getContentPane().setForeground(new Color(0, 0, 0));
        f.getContentPane().setBackground(new Color(255, 127, 80));
        f.setTitle("Image Security");
        f.setSize(400,400);
        f.setLocationRelativeTo(null);
        
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Font font=new Font("Roboto",Font.BOLD,25);
        

       //creating a label
        JLabel lable1 = new JLabel("Enter the key : ");
        lable1.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
        
       //creating text field
        JTextField textField=new JTextField(10);
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setFont(new Font("Dialog", Font.BOLD, 25));
       // textField.setSize(10, 10);
        
      //creating button
        JButton btnChooseImage=new JButton();
        btnChooseImage.setText("Choose Image");
        btnChooseImage.setFont(new Font("Lucida Calligraphy", Font.BOLD, 20));

        
        btnChooseImage.addActionListener(e->{			//e->lambda function-for anonymous class
            System.out.println("button clicked");
            String text=textField.getText();
            int temp=Integer.parseInt(text);
            operate(temp);
        });
        f.getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        f.getContentPane().add(lable1);
        f.getContentPane().add(textField);
        f.getContentPane().add(btnChooseImage);
        f.setVisible(true);

    }
}


	
	
	

