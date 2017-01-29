package Controller;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import Controller.Commands.CommandInterface;

public class CommandController {
	private BlockingQueue<CommandInterface> queue;
	private boolean isStopped = false;
	
	public CommandController() {
		queue = new ArrayBlockingQueue<CommandInterface>(10);		
	}
	
	public void insertCommand(CommandInterface command) {
		try {
			if(command!=null)
				queue.put(command);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}
	
	
	public void start() {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (!isStopped) {
					try {
						CommandInterface cmd = queue.poll(1, TimeUnit.SECONDS);
						if (cmd != null)
							cmd.execute();						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});
		thread.start();
	}
	
	public void stop() {
		isStopped = true;
	}
}
