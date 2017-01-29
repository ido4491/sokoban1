package Model.LoadSaveCreator;

import java.io.OutputStream;

import Model.Data.Level;
import Model.SaveLoad.TextSaver;


public class SaveTextCreator implements LevelSaveCreator{

	@Override
	public void create(OutputStream out, Level lvl) {
		TextSaver txtSave = new TextSaver();
		txtSave.save(out, lvl);
	}

}
