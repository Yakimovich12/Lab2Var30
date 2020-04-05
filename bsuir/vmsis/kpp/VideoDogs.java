package bsuir.vmsis.kpp;

import javax.swing.JTextField;

class VideoDogs extends Video
{
	public VideoDogs(){super();}
	public VideoDogs(String name,double size) {super(name,size);}
	public void PrintInformation(JTextField jtf1,JTextField jtf2,JTextField jtf3) 
	{
		jtf1.setText("Видео с собачками");
		jtf2.setText(this.getName());
		jtf3.setText(String.valueOf(this.getSize()));
	}
}
