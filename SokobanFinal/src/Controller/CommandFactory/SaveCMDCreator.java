package Controller.CommandFactory;

import java.util.LinkedList;

import Controller.Commands.CommandInterface;
import Controller.Commands.SaveCommand;
import Model.Model;

public class SaveCMDCreator implements CommandCreator{

	@Override
	public CommandInterface create(Object m, LinkedList<String> params) {
		return new SaveCommand((Model)m, params);
	}

}
