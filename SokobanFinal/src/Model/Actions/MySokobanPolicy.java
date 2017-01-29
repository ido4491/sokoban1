package Model.Actions;

import Model.Data.Level;
import Model.Data.Objects.Box;
import Model.Data.Objects.Destination;
import Model.Data.Objects.Floor;
import Model.Data.Objects.GraphicObject;
import Model.Data.Objects.GraphicObjectHolder;
import Model.Data.Objects.Player;
import Model.Data.Objects.Wall;

public class MySokobanPolicy implements Policy {
	private boolean lvlCompleted=false;
	
	@Override
	public int move(Level lvl,String arg){
		int moveNumber;
		if (lvl.getStepCounter()==0){
			lvl.startTimer();
		}
		
		arg=arg.toLowerCase();
		switch (arg){
			case "up":
				moveNumber = makeMove(0,-1,lvl.getPlayer(),lvl);
				checkCompleted(lvl);
				return moveNumber;
			case "down":
				moveNumber = makeMove(0, 1, lvl.getPlayer(),lvl);
				checkCompleted(lvl);
				return moveNumber;
			case "right":
				moveNumber = makeMove(1, 0, lvl.getPlayer(),lvl);
				checkCompleted(lvl);
				return 	moveNumber;
			case "left":
				moveNumber = makeMove(-1, 0, lvl.getPlayer(),lvl);
				checkCompleted(lvl);
				return moveNumber;
			default : 
				System.out.println("Error movement input.");
				break;
		}
		return 0;
		
	}

	private void checkCompleted(Level lvl) {
		if(lvl.getBoxOnDest()==lvl.getDestNumber()){//check if completed
			lvl.stopTimer();
			setLvlCompleted(true);
		}
	}

	private int makeMove(int xMovement, int yMovement, GraphicObject obj, Level lvl) {
		GraphicObject checkObj = lvl.getObjectByLocation( (obj.getX()+xMovement) , (obj.getY()+yMovement));
		int moveNum;//0-none. 1-player. 2-box+player. 3-box to dest.
		 if(checkObj instanceof Box){
					if((moveNum = checkMoveAbilty(checkObj, xMovement, yMovement, lvl))>0){
						lvl.moveObjectToHolder(xMovement, yMovement, checkObj);
						lvl.moveObjectToHolder(xMovement, yMovement, obj);
						return moveNum;
					}
			}else if(obj instanceof Player){
				if (checkMoveAbilty(obj, xMovement, yMovement, lvl)>0){
					lvl.moveObjectToHolder(xMovement, yMovement, obj);
					return 1;
				}
		}
		return 0;
	}
	@Override
	public int checkMoveAbilty(GraphicObject obj, int xMovement, int yMovement,Level lvl) {
		GraphicObject checkObj = lvl.getObjectByLocation( (obj.getX()+xMovement) , (obj.getY()+yMovement));
		GraphicObjectHolder checkHolder = lvl.getHolderByLocation((obj.getX()+xMovement) , (obj.getY()+yMovement));
		if(checkObj instanceof Wall)
			return 0;
		else if(checkObj instanceof Floor){
				if(checkHolder instanceof Destination)
					return 3;
				return 2;
		}
		return 0;
	}

	public boolean isLvlCompleted() {
		return lvlCompleted;
	}

	public void setLvlCompleted(boolean lvlCompleted) {
		this.lvlCompleted = lvlCompleted;
	}




}
