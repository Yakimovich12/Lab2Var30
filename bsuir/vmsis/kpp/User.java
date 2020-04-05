package bsuir.vmsis.kpp;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ListIterator;
import javax.swing.*;

class User {
	public static void CreateVideo(JFrame jframe1,List<Video> listVideo) 
	{
		
				jframe1.setVisible(false);
				JFrame jframe2= new JFrame("�������� �����");
				BaseInterfaceFunctions.Window(jframe2, jframe1);
				
				JLabel jl2=new JLabel("�������� ��� �����, ������� �� ������ �������");
				jl2.setBounds(45,50,290,20);
				jframe2.add(jl2);
				
				JButton jb4=new JButton("����� � ��������");
				jb4.setBounds(95,80,170,30);
				jframe2.add(jb4);
				jb4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent b) 
					{
						VideoCats catObj=new VideoCats();
						Video obj=catObj;
				        Video.CreateVideo(jframe2,jframe1,listVideo,obj);
				        System.out.println("������� ����� � ��������");
				        
					}});
				
				JButton jb6=new JButton("����� � ���������");
				jb6.setBounds(95,120,170,30);
		        jframe2.add(jb6);
		        jb6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent b) 
					{
						VideoDogs dogObj=new VideoDogs();
						Video obj=dogObj;
		                Video.CreateVideo(jframe2,jframe1,listVideo,obj); 
		                System.out.println("������� ����� � ���������");
					}});
		        
		        JButton jb5=new JButton("����������� �����");
				jb5.setBounds(95,160,170,30);
		        jframe2.add(jb5);
		        jb5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent b) 
					{
						MusicVideo musObj=new MusicVideo();
						Video obj=musObj;
		                Video.CreateVideo(jframe2,jframe1,listVideo,obj); 
		                System.out.println("������� ����������� �����");
					}});	
	} 
	
	public static void ShowVideo(JFrame jframe1,List<Video>listVideo) 
	{
		
				jframe1.setVisible(false);
				JFrame jframe5= new JFrame("�������� �����");
				BaseInterfaceFunctions.Window(jframe5, jframe1);
						
						JLabel jl2=new JLabel("��� �� ������ ������� � �����:");
						jl2.setBounds(70,50,220,20);
						jframe5.add(jl2);
						
						JButton jb4=new JButton("������������� �����");
						jb4.setBounds(80,80,200,30);
						jframe5.add(jb4);
						jb4.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent t) 
							{
								jframe5.setVisible(false);
								JFrame jframe2= new JFrame("����� �����");
								BaseInterfaceFunctions.Window(jframe2, jframe5);
							
								String str;
								ListIterator<Video> it=listVideo.listIterator();
								 int size=listVideo.size();
								 DefaultListModel<String> listModel=new DefaultListModel<>();
								 JList<String> jlist=new JList<>(listModel);
								 jlist.setVisibleRowCount(4);
								 jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
								 for(int i=0;i<size;i++)
								 {
									 str=it.next().getName();
									 listModel.addElement(str); 
								 }
								 JPanel jp=new JPanel();
								 jp.setBounds(130,50,100,100);
								 jframe2.add(jp);
								JScrollPane jsp=new JScrollPane(jlist);
								jp.add(jsp);
								jlist.addListSelectionListener(event->{
									
									System.out.println("������� ����� ��� ���������");
									jframe2.setVisible(false);
									JFrame jframe3=new JFrame("��������������� �����");
									BaseInterfaceFunctions.Window(jframe3,jframe2);
									
									String st=jlist.getSelectedValue();
									ListIterator<Video> iter=listVideo.listIterator();
									Video obj;
									for(int i=0;i<listVideo.size();i++)
									{
										obj=iter.next();
										if(obj.getName().equals(st))
										{
											VideoHosting.PlayVideo(jframe3,obj);
											System.out.println("������������� ��� �����");
										}
											
									}
								});
							}});
						
						JButton jb5=new JButton("������� ������ �����");
						jb5.setBounds(80,120,200,30);
						jframe5.add(jb5);
						jb5.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent x) 
						{
							jframe5.setVisible(false);
							JFrame jframe3=new JFrame("������� ������ �����");
							BaseInterfaceFunctions.Window(jframe3,jframe5);
						    VideoHosting.ShowVideoList(jframe3,listVideo);
						    System.out.println("������� ���� ������ �����");
						}});
	}
	
	public static void EraseVideo(JFrame jframe1,List<Video> listVideo) 
	{
		jframe1.setVisible(false);
		JFrame jframe5= new JFrame("�������� �����");
		BaseInterfaceFunctions.Window(jframe5, jframe1);
		
		JLabel jl1=new JLabel("�������� �������� �����,������� ����� �������");
		jl1.setBounds(30,50,300,20);
		jframe5.add(jl1);
			    
				String str;
				ListIterator<Video> it=listVideo.listIterator();
				 int size=listVideo.size();
				 DefaultListModel<String> listModel=new DefaultListModel<>();
				 JList<String> jlist=new JList<>(listModel);
				 jlist.setVisibleRowCount(4);
				 jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				 for(int i=0;i<size;i++)
				 {
					 str=it.next().getName();
					 listModel.addElement(str); 
				 }
				 JPanel jp=new JPanel();
				 jp.setBounds(130,80,100,100);
				 jframe5.add(jp);
				JScrollPane jsp=new JScrollPane(jlist);
				jp.add(jsp);
				jlist.addListSelectionListener(event->{
						
				System.out.println("������� ����� ��� ��������");
				JFrame jframe6= new JFrame("��������������");
				Toolkit kit=Toolkit.getDefaultToolkit();
				Dimension screensize=kit.getScreenSize();
				jframe6.setBounds(screensize.width/2-160,screensize.height/2-75,320,150);
				jframe6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jframe6.setVisible(true);
				jframe6.setLayout(null);
				jframe6.setResizable(false);
				
				System.out.println("������������ ��������");
				JLabel jl5=new JLabel("�� ������������� ��������� ������ ��������?");
				jl5.setBounds(10,10,300,20);
				jframe6.add(jl5);
				
				JButton jb10=new JButton("��");
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
								iter.remove();
						jframe5.setVisible(false);
						jframe6.setVisible(false);
						jframe1.setVisible(true);
						}
					}});
				
				JButton jb11=new JButton("���");
				jb11.setBounds(180,40,100,30);
				jframe6.add(jb11);
				
				jb11.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent y)
					{
						jframe6.setVisible(false);
					}});
				});
				
				
	}
	public static void CreatePlaylist(List<Video> playList,List<Video>listVideo,JFrame jframe1) 
	{
		Playlist pl=new Playlist();
		pl.AddVideoInPlaylist(playList,listVideo,jframe1);
		System.out.println("��������� ����� � ��������");
	}
	public static void AddInPlaylist(List<Video> playList,List<Video>listVideo,JFrame jframe1) 
	{
		ListIterator<Video> it=listVideo.listIterator();
		Playlist pl=it.next().getPlaylist();
		pl.AddVideoInPlaylist(playList,listVideo,jframe1);
		System.out.println("��������� ����� � ��������");
	}
	public static void Launch(JFrame jframe1,List<Video> playList)
	{
		ListIterator<Video> it=playList.listIterator();
		Playlist plist=it.next().getPlaylist();
		plist.LaunchPlaylist(jframe1,playList);
		System.out.println("������������� ����� �� ���������");
	}
}
