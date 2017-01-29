package view;

import java.util.LinkedList;

public interface View {

	public void paintLevel(LinkedList<String> arg);

	public void LevelCompleted(LinkedList<String> params);

	public void exit();

	public void keyPressed(String direction);

	public void saveLevel();

	public void loadLevel();

	public boolean isAlive();

	public void updateTimer(LinkedList<String> timer);

	public void updateStepCount(LinkedList<String> steps);

}
