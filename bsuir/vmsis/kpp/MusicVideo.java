package bsuir.vmsis.kpp;

import javax.swing.JTextField;

class MusicVideo extends Video
{
	public MusicVideo(){super();}
	public MusicVideo(String name,double size) {super(name,size);}
	public void PrintInformation(JTextField jtf1,JTextField jtf2,JTextField jtf3) 
	{
		jtf1.setText("Музыкальное видео");
		jtf2.setText(this.getName());
		jtf3.setText(String.valueOf(this.getSize()));
	}
}
