package Controller.Server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

import Controller.Controller;
import Controller.ControllerInterface;


public class SokobanServer implements Runnable{
private int port;
private boolean isStopped = false;
private ServerSocket sockServer;
private LinkedList<SokobanClientHandler> ch = new LinkedList<SokobanClientHandler>();
private Controller sc;




public SokobanServer(Controller c){
	setSc(c);
}


private Thread t = new Thread(this);
	public SokobanServer(int port) {
		setPort(port);
	}


	public void start(){
		
		t.start();
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	@Override
	public void run() {

		try {
			sockServer = new ServerSocket(port,1);//setting the port and the backlog.
				sockServer.setSoTimeout(1000);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e.getMessage());
				sc.exit();
			}
			try {
			while(!isStopped){
				
					
				final Socket clientSocket = sockServer.accept();
				ch.add(new SokobanClientHandler());
				sc.addViewToController(ch.getLast());//add it to the controller view list.
				ch.getLast().addObserver(sc);//add the controller to observ this client handle.
			new Thread(new Runnable() { 
				public void run() {
				try {
				ch.getLast().handleClient(clientSocket.getInputStream(), clientSocket.getOutputStream());
				clientSocket.getInputStream().close();
				clientSocket.getOutputStream().close();
				clientSocket.close();
				} catch (IOException e) {}
				}
				}).start();
			sc.addViewToController(ch.getLast());

				
				}//end of while.
			sockServer.close();
			} catch (IOException e) {
				if(!(e.getMessage().matches("Accept timed out")))
					e.printStackTrace();
			}
		

	
		
		
	}


	public void stop() {
		stopAllClientHandlers();
		setStopped(true);
		try {
			sockServer.close();
		} catch (IOException e) {
		}
		
	}

	private void stopAllClientHandlers() {
		for(SokobanClientHandler c: ch)
			c.stop();
		
	}


	public boolean isStopped() {
		return isStopped;
	}

	public void setStopped(boolean isStopped) {
		this.isStopped = isStopped;
	}

	public ControllerInterface getSc() {
		return sc;
	}


	public void setSc(Controller sc) {
		this.sc = sc;
	}

}
