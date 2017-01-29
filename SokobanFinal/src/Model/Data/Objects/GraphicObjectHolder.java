package Model.Data.Objects;


public class GraphicObjectHolder extends GraphicObject implements Holder {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected GraphicObject obj;
	public GraphicObjectHolder(GraphicObject obj){
		setObj(obj);
	}
	public GraphicObjectHolder(){
		setObj(new GraphicObject());
	}
	
	@Override
	public char getDispChar(){
		return this.obj.getDispChar();
	}
	public GraphicObject getObj() {
		return obj;
	}
	public void setObj(GraphicObject obj) {
		if(this instanceof Destination){
			if(obj instanceof Player)
				obj.setDispChar('a');
			else if(obj instanceof Box)
				obj.setDispChar('$');
		}
		else if(obj instanceof Player)
			obj.setDispChar('A');
		else if(obj instanceof Box)
			obj.setDispChar('@');
		this.obj = obj;
	}
	
	

}
