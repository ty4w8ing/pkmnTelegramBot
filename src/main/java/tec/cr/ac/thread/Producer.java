package tec.cr.ac.thread;

import java.io.IOException;
import java.util.concurrent.BlockingQueue;

import me.shib.java.lib.jtelebot.models.types.ChatId;
import me.shib.java.lib.jtelebot.models.updates.Message;
import me.shib.java.lib.jtelebot.models.updates.Update;
import me.shib.java.lib.jtelebot.service.TelegramBot;
//import tec.cr.ac.key_controler.KeyFactory;
import tec.cr.ac.key_controler.KeyChecker;

public class Producer implements Runnable{
	
	protected BlockingQueue <String> queue;
	private int hilo;
	
	public int getHilo(){
		return this.hilo;
	}

	public Producer(BlockingQueue<String> queue, int hilo) {
	        this.queue = queue;
	        this.hilo = hilo;
	}

	
	synchronized  void listener() throws IOException{
		
		TelegramBot bot = TelegramBot.getInstance("221650877:AAH7rd9DFIZ_v1XFUImZgqmUDazZBjxX-l8");
		Update[] updates;
		KeyChecker check =  new KeyChecker();
		try {
			while((updates = bot.getUpdates()) != null) {
			    for (Update update : updates) {
			        Message message = update.getMessage();
			        if(message != null) {
			        	String input = (message.getText()).toLowerCase();
			        	String response = "Message sent by: "+ message.getChat().getUsername()+"\nYou typed: "+message.getText();
			            bot.sendMessage(new ChatId(message.getChat().getId()), response);
			            check.check(input);
			            if (!check.isValid()){
			            	bot.sendMessage(new ChatId(message.getChat().getId()), "Sorry, That's an invalid input");
			            }
			            else{
			            	queue.put(input);
			            	System.out.println(message.getChat().getFirst_name()+" "+message.getChat().getLast_name()+
			            			" typed "+message.getText()+" using Thread #"+getHilo()+".");
			            }
			        }
			    }
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void run() {
		try {
			listener();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
