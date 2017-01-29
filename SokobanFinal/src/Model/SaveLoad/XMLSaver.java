package Model.SaveLoad;

import java.beans.XMLEncoder;

import java.io.OutputStream;

import Model.Data.Level;

public class XMLSaver implements LevelSaver{
	private Level lvl;
	private String path;
public XMLSaver(){

}
public Level getLvl() {
	return lvl;
}
public void setLvl(Level lvl) {
	this.lvl = lvl;
}
public String getPath() {
	return path;
}
public void setPath(String path) {
	this.path = path;
}

@Override
public void save(OutputStream out,Level lvl){
	setPath(path);
	setLvl(lvl);
	  
		XMLEncoder e = new XMLEncoder(out);
		e.writeObject(lvl);
		e.close();
	
}
}
