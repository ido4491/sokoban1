package Controller.Server;


import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Observable;
import view.View;

public class SokobanClientHandler extends Observable implements ClientHandler,View{
private boolean stop = false;
private DataInputStream is;
private PrintStream os;
private String line;
	@Override
	public boolean stop() {
		this.stop = true;
		return stop;
	}

	@Override
	public void handleClient(InputStream in, OutputStream out) {
		try {
			is = new DataInputStream(in);
			os = new PrintStream(out);
			while(!stop){
				line = is.readLine();
				//os.println(line);
				setChanged();
				notifyObservers(line);
				//os.flush();
				//out.flush();
			}
			out.flush();
			} catch (IOException e){ 
				e.printStackTrace();
				}

	}

	@Override
	public void paintLevel(LinkedList<String> arg) {
		String all="";
		for (String s:arg)
			all+=s;
		os.println(all);
		os.flush();
	}

	@Override
	public void LevelCompleted(LinkedList<String> params) {
		System.out.println("handler "+params.removeFirst());
		
	}

	@Override
	public void exit() {
		os.println("exit");
		os.flush();
		stop();
	}

	@Override
	public void keyPressed(String direction) {
	}

	@Override
	public void saveLevel() {
	}

	@Override
	public void loadLevel() {
	}

	@Override
	public boolean isAlive() {
		return !stop;
	}

	@Override
	public void updateTimer(LinkedList<String> timer) {
		
	}

	@Override
	public void updateStepCount(LinkedList<String> timer) {

	}


	

}
