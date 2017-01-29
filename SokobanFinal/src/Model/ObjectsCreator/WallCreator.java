package Model.ObjectsCreator;

import Model.Data.Level;
import Model.Data.Objects.GraphicObject;
import Model.Data.Objects.Wall;

public class WallCreator implements GraphicObjectCreator{


	@Override
	public GraphicObject create(int x,int y,Level lvl) {
		return new Wall(x,y);
	}


}
