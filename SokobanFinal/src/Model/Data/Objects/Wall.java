package Model.Data.Objects;

public class Wall extends GraphicObject{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Wall(int x,int y){
		super.setX(x);
		super.setY(y);
		this.setDispChar('#');
	}
	public Wall(){
		this.setDispChar('#');
	}
}
