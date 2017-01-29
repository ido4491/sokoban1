package Model.ObjectsCreator;

import Model.Data.Level;
import Model.Data.Objects.GraphicObjectHolder;


public interface ObjectHolderCreator {
	public GraphicObjectHolder create(int x,int y,Level lvl);


}
