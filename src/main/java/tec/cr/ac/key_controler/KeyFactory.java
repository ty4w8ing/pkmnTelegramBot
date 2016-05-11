package tec.cr.ac.key_controler;

import java.awt.event.KeyEvent;

public class KeyFactory {
	
	private KeyPusher push = new KeyPusher();
	
	public void event(String key){
		switch (key){
			case "a": 
				push.pressKey(KeyEvent.VK_A);
				break;
			case "b": 
				push.pressKey(KeyEvent.VK_B);
				break;
			case "up": 
				push.pressKey(KeyEvent.VK_T);
				break;
			case "down": 
				push.pressKey(KeyEvent.VK_Y);
				break;
			case "left": 
				push.pressKey(KeyEvent.VK_U);
				break;
			case "right": 
				push.pressKey(KeyEvent.VK_I);
				break;
			case "start": 
				push.pressKey(KeyEvent.VK_G);
				break;
			case "select": 
				push.pressKey(KeyEvent.VK_H);
				break;
			default:
				break;
		}
	}
	
}
