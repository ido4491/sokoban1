package Controller.Commands;

import java.util.LinkedList;

import Model.Model;
import view.View;

public abstract class Command implements CommandInterface{
	protected Model m;
	protected View v;
	protected LinkedList<String> params;
	
	
	public Model getM() {
		return m;
	}
	public void setM(Model m) {
		this.m = m;
	}
	
	public void setParams(LinkedList<String> params){
		this.params=params;
	}
	
	public void setV(View v){
		this.v = v;
	}
	
	public View getV(){
		return this.v;
	}
}
