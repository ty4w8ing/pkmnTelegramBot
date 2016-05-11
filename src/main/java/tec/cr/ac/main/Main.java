package tec.cr.ac.main;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
//import tec.cr.ac.key_controler.KeyFactory;
import tec.cr.ac.thread.*;

public class Main {

	public static void main(String[] args) {
		
		final BlockingQueue<String> queue = new LinkedBlockingQueue<String>(1024);
		int i;
		for (i = 1; i<= 10; i++){
			new Thread(new Producer(queue,i)).start();
			System.out.println("Thread: "+i);
		}
		new Thread(new Consum(queue)).start();
	}
	
}
