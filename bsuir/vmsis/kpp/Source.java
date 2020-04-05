package bsuir.vmsis.kpp;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.util.List;
import java.util.*;

public class Source {

public static void main(String[] args)
{
	EventQueue.invokeLater(()->
	{
		List<Video> listVideo=new LinkedList<>();
		List<Video>playList=new LinkedList<>();
		JFrame jframe1= new JFrame("Lab3Var30");
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screensize=kit.getScreenSize();
		jframe1.setBounds(screensize.width/2-180,screensize.height/2-160,360,320);
		jframe1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe1.setVisible(true);
		jframe1.setLayout(null);
		jframe1.setResizable(false);
		
		JLabel jl1=new JLabel("Выберите операцию");
		jl1.setBounds(120,10,120,20);
		jframe1.add(jl1);
		
		JButton jb1= new JButton("Создать видео");
		jb1.setBounds(80,40,200,30);
		jframe1.add(jb1);
		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) 
			{
		         User.CreateVideo(jframe1,listVideo);
		         System.out.println("Создаем видео");
			}});
		
		JButton jb2= new JButton("Просмотреть видео");
		jb2.setBounds(80,80,200,30);
		jframe1.add(jb2);
		jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent b) 
			{
		        User.ShowVideo(jframe1,listVideo);
		        System.out.println("Просматриваем видео");
			}});
		
		JButton jb3=new JButton("Удалить видео");
		jb3.setBounds(80,120,200,30);
		jframe1.add(jb3);
		jb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c)
			{
				User.EraseVideo(jframe1,listVideo);
				System.out.println("Удаляем видео");
			}});
		
		JButton jb4=new JButton("Создать плейлист");
		jb4.setBounds(80,160,200,30);
		jframe1.add(jb4);
		jb4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c)
			{
				User.CreatePlaylist(playList,listVideo,jframe1);
				System.out.println("Создаем плейлист");
			}});
		
		JButton jb5=new JButton("Добавить видео в плейлист");
		jb5.setBounds(80,200,200,30);
		jframe1.add(jb5);
		jb5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c)
			{
				User.AddInPlaylist(playList,listVideo,jframe1);
				System.out.println("Добавляем видео в плейлист");
			}});
		
		JButton jb6=new JButton("Воспроизвести плейлист");
		jb6.setBounds(80,240,200,30);
		jframe1.add(jb6);
		jb6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c)
			{
				User.Launch(jframe1,playList);
				System.out.println("Воспоизводим плейлист");
			}});

	});
}
}





