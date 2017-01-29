package Model.ObjectsCreator;

import java.util.HashMap;

import Model.Data.Level;
import Model.Data.Objects.GraphicObject;

public class GraphicObjectFactory {
private HashMap<String ,GraphicObjectCreator> gObjCreator;

public GraphicObjectFactory(){
	gObjCreator = new HashMap<String,GraphicObjectCreator>();
	gObjCreator.put("#", new WallCreator());
	gObjCreator.put("@", new BoxCreator());
	gObjCreator.put("A", new PlayerCreator());
	gObjCreator.put(" ", new FloorCreator());
}

public GraphicObject createGraphicObject(char type,int x,int y,Level lvl){
	String typeS = ""+type;
	GraphicObjectCreator c=gObjCreator.get(typeS);
if(c!=null) 
		return c.create(x,y,lvl);
return null;
}

}
