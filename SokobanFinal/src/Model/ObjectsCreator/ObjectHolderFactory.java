package Model.ObjectsCreator;

import java.util.HashMap;

import Model.Data.Level;
import Model.Data.Objects.GraphicObjectHolder;


public class ObjectHolderFactory {
private HashMap<String ,ObjectHolderCreator> hObjCreator;

public ObjectHolderFactory(){
	
	hObjCreator = new HashMap<String,ObjectHolderCreator>();
	hObjCreator.put("o", new DestinationCreator(' '));
	hObjCreator.put("a", new DestinationCreator('A'));
	hObjCreator.put("$", new DestinationCreator('@'));
}

public GraphicObjectHolder createGraphicObject(char type,int x,int y,Level lvl){
	String typeS = ""+type;
	GraphicObjectFactory c = new GraphicObjectFactory();
	ObjectHolderCreator h = this.hObjCreator.get(typeS);
	if(h==null){
		return new GraphicObjectHolder(c.createGraphicObject(type, x, y,lvl));
	}
	else
		return h.create(x, y,lvl);
}


}
