package Model.ObjectsCreator;

import Model.Data.Level;
import Model.Data.Objects.Box;
import Model.Data.Objects.Destination;
import Model.Data.Objects.GraphicObject;
import Model.Data.Objects.GraphicObjectHolder;

public class DestinationCreator implements ObjectHolderCreator{
private char obj;
public DestinationCreator(char obj){
	setObj(obj);
}
public DestinationCreator(){
	setObj(' ');
}
	@Override
	public GraphicObjectHolder create(int x, int y,Level lvl) {
		lvl.setDestNumber(lvl.getDestNumber()+1);;
		GraphicObjectFactory c = new GraphicObjectFactory();
		GraphicObject gObj = c.createGraphicObject(obj, x, y, lvl);
		if(gObj.getClass()== new Box().getClass()){
			lvl.setBoxOnDest(lvl.getBoxOnDest()+1);
			gObj.setOnDest(true);
		}
		return new Destination(gObj);
	}
	
	public char getObj() {
		return obj;
	}
	public void setObj(char obj) {
		this.obj = obj;
	}

}
