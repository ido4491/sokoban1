package Model.LoadSaveCreator;

import java.io.InputStream;

import Model.Data.Level;
import Model.SaveLoad.SokobanXMLLevelLoader;


public class LoadXMLCreator implements LevelLoadCreator{

	@Override
	public Level create(InputStream in) {
		SokobanXMLLevelLoader xmlLoad = new SokobanXMLLevelLoader();
		return xmlLoad.loadLevel(in);
	}

}
