package Model.Data.Objects;

public class Player extends MovingObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Player(int x,int y){
		super.setX(x);
		super.setY(y);
		this.setDispChar('A');
	}
	public Player(){
		this.setDispChar('A');
	}
	public int getX(){
		return super.x;
	}
	public int getY(){
		return super.y;
	}
	
	public void setX(int x){
		super.x=x;
	}
	
	public void setY(int y){
		super.y=y;
	}
	
}
