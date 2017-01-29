package Controller.CommandFactory;

import java.util.LinkedList;

import Controller.Commands.CommandInterface;
import Controller.Commands.LoadCommand;
import Model.Model;

public class LoadCMDCreator implements CommandCreator{
	@Override
	public CommandInterface create(Object m, LinkedList<String> params) {
		return new LoadCommand((Model)m, params);
	}
	
}
