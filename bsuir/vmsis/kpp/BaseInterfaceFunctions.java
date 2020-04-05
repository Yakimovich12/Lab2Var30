package bsuir.vmsis.kpp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class BaseInterfaceFunctions {
	public static void BackFunction(JFrame jframe1, JFrame jframe2)
	{
				jframe1.setVisible(true);
				jframe2.setVisible(false);
	}
	
	public static void Window(JFrame jframe3,JFrame jframe2)
	{
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screensize=kit.getScreenSize();
		jframe3.setBounds(screensize.width/2-180,screensize.height/2-125,360,250);
		jframe3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe3.setVisible(true);
		jframe3.setLayout(null);
		jframe3.setResizable(false);
		
		JButton jb3=new JButton("Назад");
		jb3.setBounds(250,10,100,30);
		jframe3.add(jb3);
	    
		jb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent b) 
			{
		         BaseInterfaceFunctions.BackFunction(jframe2,jframe3);
		         System.out.println("Выполняем операцию назад");
			}});
	}
}
