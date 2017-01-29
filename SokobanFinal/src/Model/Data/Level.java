package Model.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;

import Model.Data.Objects.Box;
import Model.Data.Objects.Destination;
import Model.Data.Objects.Floor;
import Model.Data.Objects.GraphicObject;
import Model.Data.Objects.GraphicObjectHolder;
import Model.Data.Objects.Player;

public class Level extends Observable implements Serializable{
	/**
	 * 
	 */
	private boolean stopTimer=false;
	private int timer = 0;
	private static final long serialVersionUID = 1L;
	private String name="Default";//TODO Set from the file name.
	private Player player=new Player();//To get player location.
	private Box lastMovedBox = new Box();//To get the position of last moved box.
	private ArrayList<ArrayList<GraphicObjectHolder>> arr;//Dynamic two dimension array.
	private int destNumber=0;
	private int boxNumber=0;
	private int boxOnDest=0;
	private int stepCounter=0;

	public Level(){
		this.setName("Default");
		setArr(new ArrayList<ArrayList<GraphicObjectHolder>>());
	}
	public Level(Level lvl){
		this.setName("Default");
		setArr(new ArrayList<ArrayList<GraphicObjectHolder>>());
		setLevel(lvl);
	}
	
	public ArrayList<ArrayList<GraphicObjectHolder>> getArr() {
		return arr;
	}

	public void setArr(ArrayList<ArrayList<GraphicObjectHolder>> arr) {
		this.arr = arr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void moveObjectToHolder(int xMovement,int yMovement,GraphicObject obj){//TODO CHANGE
		int x = obj.getX();
		int y = obj.getY();
		int newX = x+xMovement;
		int newY = y+yMovement;
		if(obj instanceof Box)
			this.lastMovedBox = (Box)obj;
		getHolderByLocation(newX, newY).setObj(obj);//Copy GraphicObj to new place.
		getHolderByLocation(x, y).setObj(new Floor());//Set empty at old place.
		obj.setX(newX);//Set new x pos.
		obj.setY(newY);//Set new y pos.
		//UPDATE THE DEST COUNTER IF NEEDED.
		if(obj instanceof Box){
			if(getHolderByLocation(newX, newY) instanceof Destination){
				if(!((Box)obj).isOnDest()){
				((Box)obj).setOnDest(true);
				this.setBoxOnDest(this.getBoxOnDest()+1);
					}
			}else if(getHolderByLocation(newX, newY) instanceof GraphicObjectHolder&&((Box)obj).isOnDest()){
				((Box)obj).setOnDest(false);
				this.setBoxOnDest(this.getBoxOnDest()-1);
			}		
		}
		
	}

	public GraphicObject getObjectByLocation(int x,int y){
		if(( arr.get(y).get(x)).getClass()==new Destination().getClass())
		return (((Destination) arr.get(y).get(x)).getObj());
		else if (( arr.get(y).get(x)).getClass()==new GraphicObjectHolder().getClass())
			return (((GraphicObjectHolder) arr.get(y).get(x)).getObj());
		return null;
	}
	
	public GraphicObjectHolder getHolderByLocation(int x,int y){
		return (((GraphicObjectHolder) arr.get(y).get(x)));
	}
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int getDestNumber() {
		return destNumber;
	}

	public void setDestNumber(int destNumber) {
		this.destNumber = destNumber;
	}

	public int getBoxNumber() {
		return boxNumber;
	}

	public void setBoxNumber(int boxNumber) {
		this.boxNumber = boxNumber;
	}

	public int getBoxOnDest() {
		return boxOnDest;
	}

	public void setBoxOnDest(int boxOnDest) {
		this.boxOnDest = boxOnDest;
	}
	
	public int getStepCounter() {
		return stepCounter;
	}
	
	public void setStepCounter(int stepCounter) {
		this.stepCounter = stepCounter;
	}

	public void setLevel(Level lvl) {
		setPlayer(lvl.getPlayer());
		setArr(lvl.getArr());
		setName(lvl.getName());
		setDestNumber(lvl.getDestNumber());
		setBoxNumber(lvl.getBoxNumber());
		setBoxOnDest(lvl.getBoxOnDest());
		setStepCounter(getStepCounter());
	}

	public Box getLastMovedBox() {
		return lastMovedBox;
	}
	
	public void setLastMovedBox(Box lastMovedBox) {
		this.lastMovedBox = lastMovedBox;
	}
	
public void increaseStepCounterBy(int i) {
	this.stepCounter+=i;
	setChanged();
	notifyObservers("steps:"+this.stepCounter);
}

public void startTimer(){
	this.stopTimer=false;
	Thread timerThread = new Thread(new Runnable() {

		@Override
		public void run() {
			timer=0;
			while(!stopTimer){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			timer++;
			setChanged();
			notifyObservers("timer:"+timer);
			}
		}
	});
	timerThread.start();
}
public void stopTimer(){
	this.stopTimer = true;
}

public int getTimer() {
	return timer;
}

public void setTimer(int timer) {
	this.timer = timer;
}

}
