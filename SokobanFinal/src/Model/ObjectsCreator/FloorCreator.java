package Model.ObjectsCreator;

import Model.Data.Level;
import Model.Data.Objects.Floor;
import Model.Data.Objects.GraphicObject;

public class FloorCreator implements GraphicObjectCreator{

	@Override
	public GraphicObject create(int x, int y,Level lvl) {
		return new Floor(x, y);
	}

}
