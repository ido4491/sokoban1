package Controller.CommandFactory;
import java.util.HashMap;
import java.util.LinkedList;
import Controller.Commands.CommandInterface;

public class CommandFactory {
	private HashMap<String ,CommandCreator> cmd;
	
	public CommandFactory(){
		cmd = new HashMap<String,CommandCreator>();
		cmd.put("load", new LoadCMDCreator());
		cmd.put("save", new SaveCMDCreator());
		cmd.put("move", new MoveCMDCreator());
		cmd.put("paint", new PaintLevelCMDCreator());
		cmd.put("completed", new levelCompletedCMDCreator());
		cmd.put("timer",new TimeCMDCreator());
		cmd.put("steps",new StepsCMDCreator());
	}
	
	public CommandInterface createCommand(String key,LinkedList<String> params,Object modelView){
		CommandCreator cc = cmd.get(key);
		if (cc!=null)
			return cc.create(modelView, params);
		else 
			return null;
	}
}
