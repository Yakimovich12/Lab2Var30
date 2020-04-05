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
		List<Video> list_video=new LinkedList<>();
		List<Video>play_list=new LinkedList<>();
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
		         User.Create_video(jframe1,list_video);
		         System.out.println("Создаем видео");
			}});
		
		JButton jb2= new JButton("Просмотреть видео");
		jb2.setBounds(80,80,200,30);
		jframe1.add(jb2);
		jb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent b) 
			{
		        User.Show_video(jframe1,list_video);
		        System.out.println("Просматриваем видео");
			}});
		
		JButton jb3=new JButton("Удалить видео");
		jb3.setBounds(80,120,200,30);
		jframe1.add(jb3);
		jb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c)
			{
				User.Erase_video(jframe1,list_video);
				System.out.println("Удаляем видео");
			}});
		
		JButton jb4=new JButton("Создать плейлист");
		jb4.setBounds(80,160,200,30);
		jframe1.add(jb4);
		jb4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c)
			{
				User.Create_Playlist(play_list,list_video,jframe1);
				System.out.println("Создаем плейлист");
			}});
		
		JButton jb5=new JButton("Добавить видео в плейлист");
		jb5.setBounds(80,200,200,30);
		jframe1.add(jb5);
		jb5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c)
			{
				User.Add_in_Playlist(play_list,list_video,jframe1);
				System.out.println("Добавляем видео в плейлист");
			}});
		
		JButton jb6=new JButton("Воспроизвести плейлист");
		jb6.setBounds(80,240,200,30);
		jframe1.add(jb6);
		jb6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c)
			{
				User.Launch(jframe1,play_list);
				System.out.println("Воспоизводим плейлист");
			}});

	});
}
}
class Base_interface_functions
{
	public static void Back_function(JFrame jframe1, JFrame jframe2)
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
		         Base_interface_functions.Back_function(jframe2,jframe3);
		         System.out.println("Выполняем операцию назад");
			}});
	}
}


class User
{
	public static void Create_video(JFrame jframe1,List<Video> list_video) 
	{
		
				jframe1.setVisible(false);
				JFrame jframe2= new JFrame("Создание видео");
				Base_interface_functions.Window(jframe2, jframe1);
				
				JLabel jl2=new JLabel("Выберите тип видео, которое вы хотите создать");
				jl2.setBounds(45,50,290,20);
				jframe2.add(jl2);
				
				JButton jb4=new JButton("Видео с котиками");
				jb4.setBounds(105,80,150,30);
				jframe2.add(jb4);
				jb4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent b) 
					{
						Video_cats cat_obj=new Video_cats();
						Video obj=cat_obj;
				        Video.Create_Video(jframe2,jframe1,list_video,obj);
				        System.out.println("Создаем видео с котиками");
				        
					}});
				
				JButton jb6=new JButton("Видео с собачками");
				jb6.setBounds(105,120,150,30);
		        jframe2.add(jb6);
		        jb6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent b) 
					{
						Video_dogs dog_obj=new Video_dogs();
						Video obj=dog_obj;
		                Video.Create_Video(jframe2,jframe1,list_video,obj); 
		                System.out.println("Создаем видео с собачками");
					}});
		        
		        JButton jb5=new JButton("Музыкальное видео");
				jb5.setBounds(105,160,150,30);
		        jframe2.add(jb5);
		        jb5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent b) 
					{
						Music_video mus_obj=new Music_video();
						Video obj=mus_obj;
		                Video.Create_Video(jframe2,jframe1,list_video,obj); 
		                System.out.println("Создаем музыкальное видео");
					}});	
	} 
	
	public static void Show_video(JFrame jframe1,List<Video>list_video) 
	{
		
				jframe1.setVisible(false);
				JFrame jframe5= new JFrame("Просмотр видео");
				Base_interface_functions.Window(jframe5, jframe1);
						
						JLabel jl2=new JLabel("Что вы хотите сделать с видео:");
						jl2.setBounds(70,50,220,20);
						jframe5.add(jl2);
						
						JButton jb4=new JButton("Воспроизвести видео");
						jb4.setBounds(80,80,200,30);
						jframe5.add(jb4);
						jb4.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent t) 
							{
								jframe5.setVisible(false);
								JFrame jframe2= new JFrame("Выбор видео");
								Base_interface_functions.Window(jframe2, jframe5);
							
								String str;
								ListIterator<Video> it=list_video.listIterator();
								 int size=list_video.size();
								 DefaultListModel<String> listModel=new DefaultListModel<>();
								 JList<String> jlist=new JList<>(listModel);
								 jlist.setVisibleRowCount(4);
								 jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
								 for(int i=0;i<size;i++)
								 {
									 str=it.next().get_name();
									 listModel.addElement(str); 
								 }
								 JPanel jp=new JPanel();
								 jp.setBounds(130,50,100,100);
								 jframe2.add(jp);
								JScrollPane jsp=new JScrollPane(jlist);
								jp.add(jsp);
								jlist.addListSelectionListener(event->{
									
									System.out.println("Выбрали видео для просмотра");
									jframe2.setVisible(false);
									JFrame jframe3=new JFrame("Воспроизведение видео");
									Base_interface_functions.Window(jframe3,jframe2);
									
									String st=jlist.getSelectedValue();
									ListIterator<Video> iter=list_video.listIterator();
									Video obj;
									for(int i=0;i<list_video.size();i++)
									{
										obj=iter.next();
										if(obj.get_name().equals(st))
										{
											Video_hosting.Play_video(jframe3,obj);
											System.out.println("Воспроизводим это видео");
										}
											
									}
								});
							}});
						
						JButton jb5=new JButton("Вывести список видео");
						jb5.setBounds(80,120,200,30);
						jframe5.add(jb5);
						jb5.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent x) 
						{
							jframe5.setVisible(false);
							JFrame jframe3=new JFrame("Вывести список видео");
							Base_interface_functions.Window(jframe3,jframe5);
						    Video_hosting.Show_video_list(jframe3,list_video);
						    System.out.println("Выводим весь список видео");
						}});
	}
	
	public static void Erase_video(JFrame jframe1,List<Video> list_video) 
	{
		jframe1.setVisible(false);
		JFrame jframe5= new JFrame("Просмотр видео");
		Base_interface_functions.Window(jframe5, jframe1);
		
		JLabel jl1=new JLabel("Выберите название видео,которое нужно удалить");
		jl1.setBounds(30,50,300,20);
		jframe5.add(jl1);
			    
				String str;
				ListIterator<Video> it=list_video.listIterator();
				 int size=list_video.size();
				 DefaultListModel<String> listModel=new DefaultListModel<>();
				 JList<String> jlist=new JList<>(listModel);
				 jlist.setVisibleRowCount(4);
				 jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				 for(int i=0;i<size;i++)
				 {
					 str=it.next().get_name();
					 listModel.addElement(str); 
				 }
				 JPanel jp=new JPanel();
				 jp.setBounds(130,80,100,100);
				 jframe5.add(jp);
				JScrollPane jsp=new JScrollPane(jlist);
				jp.add(jsp);
				jlist.addListSelectionListener(event->{
						
				System.out.println("Выбрали видео для удаления");
				JFrame jframe6= new JFrame("Предупреждение");
				Toolkit kit=Toolkit.getDefaultToolkit();
				Dimension screensize=kit.getScreenSize();
				jframe6.setBounds(screensize.width/2-160,screensize.height/2-75,320,150);
				jframe6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				jframe6.setVisible(true);
				jframe6.setLayout(null);
				jframe6.setResizable(false);
				
				System.out.println("Подтверждаем действие");
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
						ListIterator<Video> iter=list_video.listIterator();
						Video obj;
						for(int i=0;i<list_video.size();i++)
						{
							obj=iter.next();
							if(obj.get_name().equals(st))
								iter.remove();
						jframe5.setVisible(false);
						jframe6.setVisible(false);
						jframe1.setVisible(true);
						}
					}});
				
				JButton jb11=new JButton("Нет");
				jb11.setBounds(180,40,100,30);
				jframe6.add(jb11);
				
				jb11.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent y)
					{
						jframe6.setVisible(false);
					}});
				});
				
				
	}
	public static void Create_Playlist(List<Video> play_list,List<Video>list_video,JFrame jframe1) 
	{
		Playlist pl=new Playlist();
		pl.Add_video_in_playlist(play_list,list_video,jframe1);
		System.out.println("Добавляем видео в плейлист");
	}
	public static void Add_in_Playlist(List<Video> play_list,List<Video>list_video,JFrame jframe1) 
	{
		ListIterator<Video> it=list_video.listIterator();
		Playlist pl=it.next().get_Playlist();
		pl.Add_video_in_playlist(play_list,list_video,jframe1);
		System.out.println("Добавляем видео в плейлист");
	}
	public static void Launch(JFrame jframe1,List<Video> play_list)
	{
		ListIterator<Video> it=play_list.listIterator();
		Playlist plist=it.next().get_Playlist();
		plist.Launch_Playlist(jframe1,play_list);
		System.out.println("Воспроизводим видео из плейлиста");
	}
}

class Video_hosting
{
	public Video_hosting(){}
	public void Add_video(Video obj,List<Video> list_video) 
	{
		list_video.add(obj);
		System.out.println("Добавили видео");
	}
	public static void Play_video(JFrame jframe3,Video obj) 
	{
		JLabel jl3=new JLabel("Тип видео");
		jl3.setBounds(10,50,200,20);
		jframe3.add(jl3);
		
		JTextField jtf1=new JTextField();
	    jtf1.setBounds(10,80,200,20);
	    jframe3.add(jtf1);
	    
	    JLabel jl4=new JLabel("Название видео");
		jl4.setBounds(10,110,200,20);
		jframe3.add(jl4);
		
		JTextField jtf2=new JTextField();
	    jtf2.setBounds(10,140,200,20);
	    jframe3.add(jtf2);
	    
	    JLabel jl5=new JLabel("Размер видео");
		jl5.setBounds(10,170,200,20);
		jframe3.add(jl5);
		
		JTextField jtf3=new JTextField();
	    jtf3.setBounds(10,200,200,20);
	    jframe3.add(jtf3);
	    
	    obj.Print_information(jtf1,jtf2,jtf3);
	}
	public static void Show_video_list(JFrame jframe5,List<Video> list_video) 
	{
		String str;
		ListIterator<Video> it=list_video.listIterator();
		 int size=list_video.size();
		 DefaultListModel<String> listModel=new DefaultListModel<>();
		 JList<String> jlist=new JList<>(listModel);
		 jlist.setVisibleRowCount(4);
		 jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		 for(int i=0;i<size;i++)
		 {
			 str=it.next().get_name();
			 listModel.addElement(str); 
		 }
		 JPanel jp=new JPanel();
		 jp.setBounds(130,50,100,100);
		 jframe5.add(jp);
		JScrollPane jsp=new JScrollPane(jlist);
		jp.add(jsp);
	}
}

class Video
{
	private String name;
	private Double size;
	private static Video_hosting object;
	private static Playlist plist;
	static {object=new Video_hosting();plist=new Playlist();}
	Video(){}
	Video(String name, double size){this.name=name; this.size=size;}
	Video(Video object){this.name=object.name; this.size=object.size;}
	public String get_name(){return this.name;}
	public double get_size(){return this.size;}
	public void set_name(String name){this.name=name;}
	public void set_size(double size){this.size=size;}
	public Playlist get_Playlist() {return this.plist;}
	public void Print_information(JTextField jtf1,JTextField jtf2,JTextField jtf3) 
	{
		jtf2.setText(this.get_name());
		jtf3.setText(String.valueOf(this.get_size()));
	}
	public static void Create_Video(JFrame jframe2,JFrame jframe1,List<Video> list_video,Video obj)
	{
				jframe2.setVisible(false);
				JFrame jframe3= new JFrame("Создание видео");
				Base_interface_functions.Window(jframe3, jframe1);

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
							obj.set_name(jtf1.getText());
							obj.set_size(Double.parseDouble(jtf2.getText()));
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
									object.Add_video(obj,list_video);
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
class Video_cats extends Video
{
	public Video_cats(){super();}
	public Video_cats(String name,double size){super(name,size);}
	public void set_name(String name) {super.set_name(name);}	
	public void Print_information(JTextField jtf1,JTextField jtf2,JTextField jtf3)
	{
		jtf1.setText("Видео с котиками");
		jtf2.setText(this.get_name());
		jtf3.setText(String.valueOf(this.get_size()));
	}
}

class Video_dogs extends Video
{
	public Video_dogs(){super();}
	public Video_dogs(String name,double size) {super(name,size);}
	public void Print_information(JTextField jtf1,JTextField jtf2,JTextField jtf3) 
	{
		jtf1.setText("Видео с собачками");
		jtf2.setText(this.get_name());
		jtf3.setText(String.valueOf(this.get_size()));
	}
}

class Music_video extends Video
{
	public Music_video(){super();}
	public Music_video(String name,double size) {super(name,size);}
	public void Print_information(JTextField jtf1,JTextField jtf2,JTextField jtf3) 
	{
		jtf1.setText("Музыкальное видео");
		jtf2.setText(this.get_name());
		jtf3.setText(String.valueOf(this.get_size()));
	}
}

class Playlist
{
	public Playlist() {}
	public void Add_video_in_playlist(List<Video>play_list,List<Video>list_video,JFrame jframe1) 
	{
		jframe1.setVisible(false);
		JFrame jframe2=new JFrame("Добавление видео в плейлист");
		Base_interface_functions.Window(jframe2, jframe1);
		ListIterator<Video> it_video=list_video.listIterator();
		int video_size=list_video.size();
		 DefaultListModel<String> listModel=new DefaultListModel<>();
		 JList<String> jlist=new JList<>(listModel);
		 jlist.setVisibleRowCount(4);
		 jlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		String str;
		for(int i=0;i<video_size;i++)
		{
			str=it_video.next().get_name();
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
				ListIterator<Video> iter=list_video.listIterator();
				Video obj;
				for(int i=0;i<list_video.size();i++)
				{
					obj=iter.next();
					if(obj.get_name().equals(st))
						play_list.add(obj);
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
	public void Launch_Playlist(JFrame jframe1,List<Video> play_list) 
	{
		ListIterator<Video> it=play_list.listIterator();
		
		Video obj;
		obj=it.next();
		jframe1.setVisible(false);
		JFrame jframe3=new JFrame("Воспроизведение видео");
		Base_interface_functions.Window(jframe3,jframe1);
		Video_hosting.Play_video(jframe3,obj);
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
					Next_video(it,jframe3);
				}
				else
					System.out.println("Больше нет видео для воспроизведения");
				
			}});
	}
	private void Next_video(ListIterator<Video> it,JFrame jframe3) 
	{
		Video_hosting.Play_video(jframe3, it.next());
		System.out.println("Воспроизведение видео");
	}
}


