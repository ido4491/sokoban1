package Model.LoadSaveCreator;

import java.io.InputStream;
import java.util.HashMap;

import Model.Data.Level;



public class LoadFactory {
	private HashMap<String ,LevelLoadCreator> loaderCreator;
	
	public LoadFactory(){
		loaderCreator = new HashMap<String,LevelLoadCreator>();
		loaderCreator.put("txt", new LoadTextCreator());
		loaderCreator.put("xml", new LoadXMLCreator());
		loaderCreator.put("obj", new LoadObjectCreator());
	}
	
	public Level loadLevel(String type, InputStream in) throws Exception{
		String typeS = ""+type;
		LevelLoadCreator lvlLoad = loaderCreator.get(typeS);
		if(lvlLoad!=null)
			return lvlLoad.create(in);
		else throw new Exception("Unknown file.");
		
	}
	
}
