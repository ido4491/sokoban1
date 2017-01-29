package Model.Data.Objects;


public class Destination extends GraphicObjectHolder implements Holder{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Destination(int x,int y){
		super.setX(x);
		super.setY(y);
		super.setObj(new Floor());
		this.setDispChar('o');
	}
	public Destination(int x,int y,GraphicObject obj){
		super.setX(x);
		super.setY(y);
		super.setObj(obj);
		this.setDispChar('o');
	}
	public Destination(){
		this.setDispChar('o');
	}
	@Override
	public char getDispChar(){
		if(this.obj instanceof Player)
			return 'a';
		else if(this.obj instanceof Box)
			return '$';
		else if(this.obj instanceof Floor)
			return 'o';
		
		return ' ';
	}
	public Destination(GraphicObject obj) {
			super.setX(obj.getX());
			super.setY(obj.getY());
			super.setObj(obj);
			this.setDispChar('o');
	}
}
