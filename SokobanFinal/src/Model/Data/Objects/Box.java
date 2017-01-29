package Model.Data.Objects;

public class Box extends MovingObject {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public Box(int x,int y){
		super.setX(x);
		super.setY(y);
		this.setDispChar('@');
	}
	public Box(){
		this.setDispChar('@');
	}
	public boolean isOnDest() {
		return super.onDest;
	}
	public void setOnDest(boolean onDest) {
		super.onDest = onDest;
	}
}
