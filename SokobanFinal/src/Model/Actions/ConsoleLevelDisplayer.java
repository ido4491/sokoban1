package Model.Actions;

import java.util.ArrayList;

import Model.Data.Level;
import Model.Data.Objects.GraphicObjectHolder;

public class ConsoleLevelDisplayer implements Displayer{

	@Override
	public void display(Level lvl) {
		System.out.println("Number of boxes: "+lvl.getBoxNumber());
		System.out.println("Number of dest: "+lvl.getDestNumber());
		System.out.println("Number of box on dest: "+lvl.getBoxOnDest());
		if(lvl.getDestNumber() != lvl.getBoxNumber())
			System.out.println("This game is unsolveable.");
		else if(lvl.getDestNumber()==lvl.getBoxOnDest())
			System.out.println("The level is completed. :D");
		System.out.println(getStringFromLevel(lvl));
	}
	
	public StringBuilder getStringFromLevel(Level lvl){
		StringBuilder sb = new StringBuilder();
		String line = "\r\n";
		for(ArrayList<GraphicObjectHolder> arrLine:lvl.getArr()){
			for(GraphicObjectHolder h:arrLine){
				sb.append(h.getDispChar());
			}//End of for loop.
			sb.append(line);
		}
		return sb;
	}


}
