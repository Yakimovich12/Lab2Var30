package bsuir.vmsis.kpp;

import java.util.List;
import java.util.ListIterator;

import javax.swing.*;

class VideoHosting
{
	public VideoHosting(){}
	public void AddVideo(Video obj,List<Video> listVideo) 
	{
		listVideo.add(obj);
		System.out.println("Добавили видео");
	}
	public static void PlayVideo(JFrame jframe3,Video obj) 
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
	    
	    obj.PrintInformation(jtf1,jtf2,jtf3);
	}
	public static void ShowVideoList(JFrame jframe5,List<Video> listVideo) 
	{
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
		 jframe5.add(jp);
		JScrollPane jsp=new JScrollPane(jlist);
		jp.add(jsp);
	}
}
