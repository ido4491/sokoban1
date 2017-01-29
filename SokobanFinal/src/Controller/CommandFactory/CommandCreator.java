package Controller.CommandFactory;

import java.util.LinkedList;

import Controller.Commands.CommandInterface;

public interface CommandCreator {
	public CommandInterface create(Object modelView, LinkedList<String> params);
}
