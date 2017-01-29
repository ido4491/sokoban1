package Model.LoadSaveCreator;


import java.io.OutputStream;
import java.util.HashMap;

import Model.Data.Level;



public class SaveFactory {
	private HashMap<String, LevelSaveCreator> saverCreator;
	
	public SaveFactory(){
		saverCreator = new HashMap<String,LevelSaveCreator>();
		saverCreator.put("txt", new SaveTextCreator());
		saverCreator.put("xml", new SaveXMLCreator());
		saverCreator.put("obj", new SaveObjectCreator());
	}
	
	public void saveLevel(String type, OutputStream out, Level lvl) throws Exception{
		String typeS = ""+type;
		LevelSaveCreator lvlSave = saverCreator.get(typeS);
		if(lvlSave!=null)
			lvlSave.create(out,lvl);
		else throw new Exception("Unknown file.");
		
	}
	
}
