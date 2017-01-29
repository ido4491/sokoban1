package Model.Data.Objects;

public class Floor extends GraphicObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Floor(int x,int y){
		super.setX(x);
		super.setY(y);
		this.setDispChar(' ');
	}
	public Floor(){
		this.setDispChar(' ');
	}
}