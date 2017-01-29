package Model.SaveLoad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import Model.Data.Level;
import Model.Data.Objects.GraphicObjectHolder;
import Model.ObjectsCreator.ObjectHolderFactory;

public class SokobanTextLevelLoader implements LevelLoader{

	private Level lvl = new Level();
	
	@Override
	public Level loadLevel(InputStream in) {
		BufferedReader buffer = new BufferedReader(new InputStreamReader(in));
		ArrayList<ArrayList<GraphicObjectHolder>> arr = new ArrayList<ArrayList<GraphicObjectHolder>>();
		String line;
		int lineNumber=0;//Use as Y.
		try {
			while((line=buffer.readLine()) != null)
			{
				arr.add(readLineToArrayList(line,lineNumber));
				lineNumber++;
			}
			lvl.setArr(arr);
						in.close();
			return lvl;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private ArrayList<GraphicObjectHolder> readLineToArrayList(String line,int lineNumber) throws Exception{
		int x=0;
		ObjectHolderFactory gf = new ObjectHolderFactory();
		ArrayList<GraphicObjectHolder> holder = new ArrayList<GraphicObjectHolder>();
		for(Character c:line.toCharArray()){
			holder.add(gf.createGraphicObject(c, x, lineNumber,this.lvl));	
		x++;
		}
		return holder;
	}

}
