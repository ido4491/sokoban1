package Model.Actions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import Model.Data.Level;
import Model.LoadSaveCreator.LoadFactory;

public class LoadLevel {

	public void load(Level lvl,String path){
		String[] s = path.split("\\.");
		String last3=s[s.length - 1];
		String[] name = path.split("\\\\");
		lvl.setName(name[name.length-1]);
		lvl.setLevel(loader(lvl,path,last3));
	}

	private Level loader(Level lvl, String arg, String last3) {
		LoadFactory lf = new LoadFactory();
		try {
			return lf.loadLevel(last3, new FileInputStream(arg));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
