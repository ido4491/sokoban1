package Model.SaveLoad;

import java.beans.XMLDecoder;
import java.io.InputStream;

import Model.Data.Level;

public class SokobanXMLLevelLoader implements LevelLoader {

	@Override
	public Level loadLevel(InputStream in) {
		XMLDecoder d = new XMLDecoder(in);
		Level result = (Level)d.readObject();
		d.close();
		return result;
	}

}
