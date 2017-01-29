package Model.SaveLoad;

import java.io.InputStream;

import Model.Data.Level;

public interface LevelLoader {
	public Level loadLevel(InputStream in);
}
