package Model.Data.Objects;

import java.io.Serializable;

public class GraphicObject implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected boolean onDest=false;//false-not on point. true-on point. IF START AT DEST NEED TO SET AT LOADER.
	protected int x,y;
	protected char displayChar;
	public GraphicObject(){
		setDispChar(' ');
		setX(0);
		setY(0);
	}
	public void setDispChar(char c){
		this.displayChar=c;
	}
	public char getDispChar(){
		return this.displayChar;
	}
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	
	/**
	 Return position of graphic object as String.
	 Like so: "x,y" 
	 */
	public String getPos(){
		return (this.x+","+this.y);
	}
	public void setX(int x){
		this.x=x;
	}
	
	public void setY(int y){
		this.y=y;
	}
	
	public boolean isOnDest() {
		return this.onDest;
	}
	public void setOnDest(boolean onDest) {
		this.onDest = onDest;
	}
}
