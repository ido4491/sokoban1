package Controller.Commands;

import java.util.LinkedList;

import Model.Model;


public class SaveCommand extends Command{

	public SaveCommand(Model m,LinkedList<String> params){
		setM(m);
		setParams(params);
	}

	@Override
	public void execute() {
		m.save(params);
	}
}
