package Model.SaveLoad;

import java.io.OutputStream;
import java.io.PrintWriter;

import Model.Actions.ConsoleLevelDisplayer;
import Model.Data.Level;

public class TextSaver implements LevelSaver{
	private Level lvl;
	private String path;
public TextSaver(){

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
	StringBuilder sb = new ConsoleLevelDisplayer().getStringFromLevel(lvl);
	PrintWriter pw = new PrintWriter(out);
	pw.print(sb);
	pw.close();
}



}
