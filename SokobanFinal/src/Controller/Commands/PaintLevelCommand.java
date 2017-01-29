package Controller.Commands;

import java.util.LinkedList;

import view.View;

public class PaintLevelCommand extends Command{

	public PaintLevelCommand(View v, LinkedList<String> arg) {
		setV(v);
		setParams(arg);
	}
	@Override
	public void execute() {
		v.paintLevel(params);
	}

}
