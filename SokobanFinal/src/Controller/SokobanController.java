package Controller;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observable;
import Controller.CommandFactory.CommandFactory;

import Controller.Server.SokobanServer;
import Model.Model;
import view.View;


public class SokobanController extends Controller{
	private SokobanServer sokoServer;
	public SokobanServer getSokoServer() {
		return sokoServer;
	}

	public void setSokoServer(SokobanServer sokoServer) {
		this.sokoServer = sokoServer;
	}
	private LinkedList<String> ls;
	private Model model;
	private ArrayList<View> views = new ArrayList<View>();//to handle more than two views in the future.
	private CommandFactory cf = new CommandFactory();
	private CommandController cmdController;
	
	public SokobanController(View ui, Model m) {//Constructor without server.
		addViewToController(ui);
		setModel(m);
		cmdController = new CommandController();
		cmdController.start();
	}

	
	@Override
	public void update(Observable o, Object arg) {
		ls = new LinkedList<String>();
		if (arg.getClass() == new String().getClass()){
			ls = getStringToLinkedList(arg);
		}else if(arg instanceof LinkedList){
			ls = (LinkedList<String>)arg;
		}
			String key = ls.removeFirst();
			if (key.matches("exit"))
				exit();
		else if(o instanceof Model)
			notifyAllViews(key,ls);
		else if (o instanceof View)//TODO Change it.. it gonna be just another viewer.
			cmdController.insertCommand(cf.createCommand(key, ls, model));
		else
			System.out.println("Arg is not a linkedlist. Sent from "+o.getClass());
	}
	
	
	private void notifyAllViews(String key, LinkedList<String> ls2) {
		int x=0;
		for(View v:views){
			if(v.isAlive())
				cmdController.insertCommand(cf.createCommand(key, ls, v));
			else
				views.remove(x);
			x++;
		}
		
	}

	private LinkedList<String> getStringToLinkedList(Object arg) {
		if (arg instanceof String){
			LinkedList<String> ls = new LinkedList<String>();
			String[] strings = ((String)arg).split(" ");
			for(String s:strings)
				ls.add(s);
			return ls;
		}
		return null;
	}

	public Model getModel() {
		return model;
	}
	public void setModel(Model m) {
		this.model = m;
	}

	public CommandFactory getCf() {
		return cf;
	}
	public void setCf(CommandFactory cf) {
		this.cf = cf;
	}
	@Override
	public void exit() {
		cmdController.stop();
		if (sokoServer!=null)
			sokoServer.stop();
		try {
			Thread.sleep(1005);//wait for server to shut down.
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.exit(0);
	}
	
	public void addViewToController(View v){
		this.views.add(v);
	}

}
