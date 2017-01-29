package Controller.Commands;

import java.util.LinkedList;

import view.View;

public class LevelCompletedCommand extends Command{

	public LevelCompletedCommand(View v,LinkedList<String> params) {
	setV(v);
	setParams(params);
	}

	@Override
	public void execute() {
		v.LevelCompleted(params);
	}

}
