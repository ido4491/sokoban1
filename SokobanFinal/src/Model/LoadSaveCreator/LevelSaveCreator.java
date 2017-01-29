package Model.LoadSaveCreator;

import java.io.OutputStream;

import Model.Data.Level;

public interface LevelSaveCreator {
	public void create(OutputStream out, Level lvl);
}
