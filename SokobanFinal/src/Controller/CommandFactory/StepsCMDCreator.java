package Controller.CommandFactory;

import java.util.LinkedList;
import Controller.Commands.CommandInterface;
import Controller.Commands.StepCounterCommand;
import view.View;

public class StepsCMDCreator implements CommandCreator{

	@Override
	public CommandInterface create(Object modelView, LinkedList<String> params) {
		return new StepCounterCommand((View)modelView, params);
	}

}
