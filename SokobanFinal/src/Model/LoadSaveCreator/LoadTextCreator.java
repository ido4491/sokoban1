package Model.LoadSaveCreator;

import java.io.InputStream;

import Model.Data.Level;
import Model.SaveLoad.SokobanTextLevelLoader;


public class LoadTextCreator implements LevelLoadCreator{

	@Override
	public Level create(InputStream in) {
		SokobanTextLevelLoader txtLoad = new SokobanTextLevelLoader();
		return txtLoad.loadLevel(in);
	}

}
