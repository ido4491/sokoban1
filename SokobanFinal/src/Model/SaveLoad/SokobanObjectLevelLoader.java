package Model.SaveLoad;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

import Model.Data.Level;

public class SokobanObjectLevelLoader implements LevelLoader{

	@Override
	public Level loadLevel(InputStream in) {
		try {
			ObjectInputStream objIn = new ObjectInputStream(in);
			return (Level)objIn.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static Level loadLevel2(InputStream in) {//WHY NOT STATIC
		try {
			ObjectInputStream objIn = new ObjectInputStream(in);
			return (Level)objIn.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
