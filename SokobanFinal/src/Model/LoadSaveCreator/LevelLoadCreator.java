package Model.LoadSaveCreator;

import java.io.InputStream;

import Model.Data.Level;

public interface LevelLoadCreator {
	public Level create(InputStream in);
}
