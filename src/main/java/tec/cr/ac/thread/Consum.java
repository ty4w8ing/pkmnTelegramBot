package tec.cr.ac.thread;

import java.util.concurrent.BlockingQueue;

import tec.cr.ac.key_controler.KeyFactory;

public class Consum implements Runnable{
	
	protected BlockingQueue<String> queue;
	protected KeyFactory factory;
	
	public Consum(BlockingQueue<String> queue) {
        this.queue = queue;
        factory = new KeyFactory();
}

	@Override
	public void run() {
		try {
			while (!false){
				factory.event(queue.take());
				//tThread.sleep(5);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
