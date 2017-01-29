package Controller.Commands;

import java.util.LinkedList;

import Model.Model;



public class MoveCommand extends Command{

	public MoveCommand(Model m,LinkedList<String> direction){
		setM(m);
		setParams(direction);
	}
	@Override
	public void execute() {
		m.move(params);
	}

}
