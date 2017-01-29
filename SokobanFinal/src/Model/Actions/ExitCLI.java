package Model.Actions;

public class ExitCLI {

	private boolean exit;
	
	public ExitCLI() {
		setExit(false);
	}
	
	public ExitCLI(boolean exit) {
		setExit(exit);
	}
	
	public void exit(boolean exit) {
		
		System.out.println();
		exit=false;
	}
	public boolean isExit() {
		return exit;
	}
	public void setExit(boolean exit) {
		this.exit = exit;
	}

}
