package tec.cr.ac.key_controler;

import java.awt.AWTException;
import java.awt.Robot;

public class KeyPusher {
	


	public void pressKey(int key){
		try{
			Robot robot = new Robot();
			robot.keyPress(key);
			Thread.sleep(50);
			robot.keyRelease(key);
		} catch (AWTException | InterruptedException e){
			e.printStackTrace();
		}
	}
	
	
}
