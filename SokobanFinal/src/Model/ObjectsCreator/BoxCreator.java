package Model.ObjectsCreator;

import Model.Data.Level;
import Model.Data.Objects.Box;
import Model.Data.Objects.GraphicObject;

public class BoxCreator implements GraphicObjectCreator {

	@Override
	public GraphicObject create(int x, int y,Level lvl) {
		Box box = new Box(x,y);
		lvl.setBoxNumber(lvl.getBoxNumber()+1);
		return box;
	}

}
