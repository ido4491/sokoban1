package Model;

import java.util.LinkedList;

public interface Model {

	public void save(LinkedList<String> arg);

	public void move(LinkedList<String> direction);

	public void load(LinkedList<String> filePath);

	public void display();
}
