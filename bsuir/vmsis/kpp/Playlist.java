package bsuir.vmsis.kpp;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ListIterator;

import javax.swing.*;

class Playlist
{
	public Playlist() {}
	public void AddVideoInPlaylist(List<Video>playList,List<Video>listVideo,JFrame jframe1) 
	{
		jframe1.setVisible(false);
		JFrame jframe2=new JFrame("Добавление видео в плейлист");
		BaseInterfaceFunctions.Window(jframe2, jframe1);
		ListIterator<Video> itvideo=listVideo.listIterator();
		int video_size=listVideo.size();
		 DefaultListModel<String> listModel=new DefaultListModel<>();
		 JList<String> jlist=new JList<>(listModel);
		 jlist.setVisibleRowCount(4);
		 jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		String str;
		for(int i=0;i<video_size;i++)
		{
			str=itvideo.next().getName();
			 listModel.addElement(str); 
		 }
		 JPanel jp=new JPanel();
		 jp.setBounds(130,80,100,100);
		 jframe2.add(jp);
		JScrollPane jsp=new JScrollPane(jlist);
		jp.add(jsp);
		jlist.addListSelectionListener(event->{
				
			System.out.println("Выводим предупреждение");
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
				String st=jlist.getSelectedValue();
				ListIterator<Video> iter=listVideo.listIterator();
				Video obj;
				for(int i=0;i<listVideo.size();i++)
				{
					obj=iter.next();
					if(obj.getName().equals(st))
						playList.add(obj);
				jframe2.setVisible(false);
				jframe6.setVisible(false);
				jframe1.setVisible(true);
				}
			}});
		
		JButton jb11=new JButton("Нет");
		jb11.setBounds(180,40,100,30);
		jframe6.add(jb11);
		jb11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent w)
			{
				jframe6.setVisible(false);
			}});
		});
	}
	public void LaunchPlaylist(JFrame jframe1,List<Video> playList) 
	{
		ListIterator<Video> it=playList.listIterator();
		
		Video obj;
		obj=it.next();
		jframe1.setVisible(false);
		JFrame jframe3=new JFrame("Воспроизведение видео");
		BaseInterfaceFunctions.Window(jframe3,jframe1);
		VideoHosting.PlayVideo(jframe3,obj);
		System.out.println("Воспроизведение видео");
		
		JButton jb0=new JButton("Следующий");
		jb0.setBounds(230,180,120,30);
		jframe3.add(jb0);
		jb0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent w)
			{
				
				if(it.hasNext())
				{
					System.out.println("Воспроизведение следующего видео");
					NextVideo(it,jframe3);
				}
				else
					System.out.println("Больше нет видео для воспроизведения");
				
			}});
	}
	private void NextVideo(ListIterator<Video> it,JFrame jframe3) 
	{
		VideoHosting.PlayVideo(jframe3, it.next());
		System.out.println("Воспроизведение видео");
	}
}