package bsuir.vmsis.kpp;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

import javax.swing.*;

class Video 
{
	
	private String name;
	private Double size;
	private static VideoHosting object;
	private static Playlist plist;
	static {object=new VideoHosting();plist=new Playlist();}
	Video(){}
	Video(String name, double size){this.name=name; this.size=size;}
	Video(Video object){this.name=object.name; this.size=object.size;}
	public String getName(){return this.name;}
	public double getSize(){return this.size;}
	public void setName(String name){this.name=name;}
	public void setSize(double size){this.size=size;}
	public Playlist getPlaylist() {return this.plist;}
	public void PrintInformation(JTextField jtf1,JTextField jtf2,JTextField jtf3) 
	{
		jtf2.setText(this.getName());
		jtf3.setText(String.valueOf(this.getSize()));
	}
	public static void CreateVideo(JFrame jframe2,JFrame jframe1,List<Video> listVideo,Video obj)
	{
				jframe2.setVisible(false);
				JFrame jframe3= new JFrame("Создание видео");
				BaseInterfaceFunctions.Window(jframe3, jframe1);

				JLabel jl3=new JLabel("Введите название видео");
				jl3.setBounds(10,50,200,20);
				jframe3.add(jl3);
				
				JTextField jtf1=new JTextField();
				jtf1.setBounds(10,80,200,20);
				jframe3.add(jtf1);
				
				JLabel jl4=new JLabel("Введите размер видео");
				jl4.setBounds(10,110,200,20);
				jframe3.add(jl4);       
				
				JTextField jtf2=new JTextField();
				jtf2.setBounds(10,140,200,20);
				jframe3.add(jtf2);
				
				JButton jb9=new JButton("Сохранить");
				jb9.setBounds(220,140,100,20);
				jframe3.add(jb9);
				 jb9.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent q) 
						{
							System.out.println("Выводим предупреждение");
							obj.setName(jtf1.getText());
							obj.setSize(Double.parseDouble(jtf2.getText()));
							JFrame jframe6= new JFrame("Предупреждение");
							Toolkit kit=Toolkit.getDefaultToolkit();
							Dimension screensize=kit.getScreenSize();
							jframe6.setBounds(screensize.width/2-160,screensize.height/2-75,320,150);
							jframe6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							jframe6.setVisible(true);
							jframe6.setLayout(null);
							jframe6.setResizable(false);
							
							JLabel jl5=new JLabel("Вы действительно выполнить данное действие?");
							jl5.setBounds(10,10,300,20);
							jframe6.add(jl5);
							
							JButton jb10=new JButton("Да");
							jb10.setBounds(10,40,100,30);
							jframe6.add(jb10);
							jb10.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent w)
								{
									jframe3.setVisible(false);
									jframe6.setVisible(false);
									jframe1.setVisible(true);
									object.AddVideo(obj,listVideo);
								}});
							
							JButton jb11=new JButton("Нет");
							jb11.setBounds(180,40,100,30);
							jframe6.add(jb11);
							jb11.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent w)
								{
									jframe6.setVisible(false);

								}});
						}});	
}
}
