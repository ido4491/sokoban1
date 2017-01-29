package Model.LoadSaveCreator;

import java.io.OutputStream;

import Model.Data.Level;
import Model.SaveLoad.XMLSaver;


public class SaveXMLCreator implements LevelSaveCreator{

	@Override
	public void create(OutputStream out, Level lvl) {
		XMLSaver xmlSave = new XMLSaver();
		xmlSave.save(out, lvl);
	}

}
