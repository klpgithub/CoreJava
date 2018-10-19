package java.awt;

import java.applet.Applet;

public class AppletDemo extends Applet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Button button1;
	Button button2;
	Button button3;

	@Override
	public void init() {
		button1 = new Button("OK");
		button2 = new Button("Open");
		button3 = new Button("Close");
		add(button1);
		add(button2);
		add(button3);
	}

	public static void main(String[] args) {
		AppletDemo demo = new AppletDemo();
//		demo.init();

	}

}
