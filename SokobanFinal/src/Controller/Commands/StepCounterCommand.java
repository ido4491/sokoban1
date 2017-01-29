package Controller.Commands;

import java.util.LinkedList;

import view.View;

public class StepCounterCommand extends Command{
	public StepCounterCommand(View v, LinkedList<String> arg) {
		setV(v);
		setParams(arg);
	}
	@Override
	public void execute() {
		v.updateStepCount(super.params);
	}

}
