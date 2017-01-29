package Model.ObjectsCreator;

import Model.Data.Level;
import Model.Data.Objects.GraphicObject;

public interface GraphicObjectCreator {
	public GraphicObject create(int x,int y,Level lvl);


}
