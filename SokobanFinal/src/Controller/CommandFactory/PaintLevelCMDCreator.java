package Controller.CommandFactory;

import java.util.LinkedList;

import Controller.Commands.CommandInterface;
import Controller.Commands.PaintLevelCommand;
import view.View;

public class PaintLevelCMDCreator implements CommandCreator{

	@Override
	public CommandInterface create(Object v, LinkedList<String> params) {
		return new PaintLevelCommand((View) v,params);
	}

}
