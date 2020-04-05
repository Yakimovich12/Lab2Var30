package bsuir.vmsis.kpp;

import javax.swing.JTextField;

class VideoCats extends Video
{
	public VideoCats(){super();}
	public VideoCats(String name,double size){super(name,size);}
	public void setName(String name) {super.setName(name);}	
	public void PrintInformation(JTextField jtf1,JTextField jtf2,JTextField jtf3)
	{
		jtf1.setText("Видео с котиками");
		jtf2.setText(this.getName());
		jtf3.setText(String.valueOf(this.getSize()));
	}
}
