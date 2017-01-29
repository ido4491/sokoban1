package Controller.CommandFactory;

import java.util.LinkedList;

import Controller.Commands.CommandInterface;
import Controller.Commands.TimerCommand;
import view.View;

public class TimeCMDCreator implements CommandCreator{

	@Override
	public CommandInterface create(Object modelView, LinkedList<String> params) {
		return new TimerCommand((View)modelView, params);
	}

}
