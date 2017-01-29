package Controller.CommandFactory;

import java.util.LinkedList;

import Controller.Commands.CommandInterface;
import Controller.Commands.MoveCommand;
import Model.Model;

public class MoveCMDCreator implements CommandCreator{

	@Override
	public CommandInterface create(Object m, LinkedList<String> params) {
		return new MoveCommand((Model)m, params);
	}

}
