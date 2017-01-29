package Controller.Commands;

import java.util.LinkedList;

import Model.Model;

public class LoadCommand extends Command{

	public LoadCommand(Model m,LinkedList<String> arg){
		setM(m);
		setParams(arg);
	}

	@Override
	public void execute() {
		m.load(params);
	}
}
