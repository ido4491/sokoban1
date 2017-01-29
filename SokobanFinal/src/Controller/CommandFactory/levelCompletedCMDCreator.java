package Controller.CommandFactory;

import java.util.LinkedList;

import Controller.Commands.CommandInterface;
import Controller.Commands.LevelCompletedCommand;
import view.View;

public class levelCompletedCMDCreator implements CommandCreator{

	@Override
	public CommandInterface create(Object v, LinkedList<String> params) {
		return new LevelCompletedCommand((View) v,params);
	}

}
