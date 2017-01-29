package Model.Actions;

import Model.Data.Level;
import Model.Data.Objects.GraphicObject;

public interface Policy {
	public int checkMoveAbilty(GraphicObject obj,int xMovement, int yMovement,Level lvl);
	public int move(Level lvl, String direction);
	
}
