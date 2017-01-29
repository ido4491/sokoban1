package Model.SaveLoad;

import java.io.OutputStream;

import Model.Data.Level;

public interface LevelSaver {
	public void save(OutputStream out,Level lvl);
}
