package Model.LoadSaveCreator;

import java.io.OutputStream;

import Model.Data.Level;
import Model.SaveLoad.ObjectSaver;


public class SaveObjectCreator implements LevelSaveCreator{

	@Override
	public void create(OutputStream out, Level lvl) {
		ObjectSaver objSave = new ObjectSaver();
		objSave.save(out, lvl);
	}

}
