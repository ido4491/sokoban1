package Controller.Commands;

import java.util.LinkedList;

import view.View;

public class TimerCommand extends Command{
	public TimerCommand(View v, LinkedList<String> arg) {
		setV(v);
		setParams(arg);
	}
	@Override
	public void execute() {
		v.updateTimer(super.params);
	}

}
