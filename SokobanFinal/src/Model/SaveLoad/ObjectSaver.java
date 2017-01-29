package Model.SaveLoad;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import Model.Data.Level;

public class ObjectSaver implements LevelSaver{

	@Override
	public void save(OutputStream out, Level lvl) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(out);
			oos.writeObject(lvl);
			oos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
