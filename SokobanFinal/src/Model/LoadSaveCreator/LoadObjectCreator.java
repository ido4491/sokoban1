package Model.LoadSaveCreator;

import java.io.InputStream;

import Model.Data.Level;
import Model.SaveLoad.SokobanObjectLevelLoader;


public class LoadObjectCreator implements LevelLoadCreator{

	@Override
	public Level create(InputStream in) {
		SokobanObjectLevelLoader objLoad = new SokobanObjectLevelLoader();
		return objLoad.loadLevel(in);
	}

}
