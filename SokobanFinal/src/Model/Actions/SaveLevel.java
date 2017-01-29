package Model.Actions;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import Model.Data.Level;
import Model.LoadSaveCreator.SaveFactory;

public class SaveLevel {
	public void save(String arg,Level lvl){
		SaveFactory sf=new SaveFactory();
		String[] s=arg.split("\\.");
		String last3=s[s.length - 1];
		try {
			sf.saveLevel(last3, new FileOutputStream(arg),lvl);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
