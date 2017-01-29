package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;

import javafx.scene.canvas.Canvas;
import view.canvases.BoxesCanvas;
import view.canvases.PlayerCanvas;
import view.canvases.SolidCanvas;



public class LevelPaintManager {
private SolidCanvas sc;
private PlayerCanvas pc;
private BoxesCanvas bc;
private int levelWidth;
private int levelHight;
private double canvasHight=0;
private double canvasWidth=0;
private double hCellSize=0;
private double wCellSize=0;

public LevelPaintManager(SolidCanvas levelDisplayerC, BoxesCanvas boxesC, PlayerCanvas playerC) {
	this.sc = levelDisplayerC;//TODO check all canvases size and pos. and make sure it the same.
	this.bc = boxesC;
	this.pc = playerC;
	this.canvasHight = sc.getHeight();
	this.canvasWidth = sc.getWidth();
	this.hCellSize = this.canvasHight/getLevelHight();
	this.wCellSize = this.canvasWidth/getLevelWidth();
}

public int paint(LinkedList<String> arg){
	String levelStr = arg.removeFirst();
	int moveNumber;
	if(arg.getFirst().matches(".*\\d+.*")){//Check if the string contain int.
		moveNumber = Integer.parseInt(arg.removeFirst());
		if(moveNumber==-1)
			paintLoadedLevel(levelStr);
		else if (moveNumber==1)
			paintPlayer(arg);
		else if(moveNumber==2||moveNumber==3)
			paintBoxAndPlayer(arg);
		
		return moveNumber;
	}
	return 0;
}

private void paintBoxAndPlayer(LinkedList<String> arg) {
	int[] pxy = paintPlayer(arg);
	if (pxy!=null)
		clearCell(bc, pxy[0], pxy[1]);
	pxy = getPosFromString(arg.removeFirst());
	char c = arg.removeFirst().charAt(0);
	if(c=='@')
		bc.drawBox(pxy[0]*wCellSize ,pxy[1]*hCellSize ,wCellSize ,hCellSize);
	else if(c=='$')
		bc.drawBoxOnDestination(pxy[0]*wCellSize ,pxy[1]*hCellSize ,wCellSize ,hCellSize);
}

private int[] paintPlayer(LinkedList<String> arg) {//Return last pos of player.. so we can delete the box from there.
	pc.clearCanvas();
	int[] xy = getPosFromString(arg.removeFirst());
	char c = arg.removeFirst().charAt(0);
	if(c=='a'){
		pc.drawPlayerOnDestination(xy[0]*wCellSize ,xy[1]*hCellSize ,wCellSize ,hCellSize);
		return xy;
	}else if(c=='A'){
		pc.drawPlayer(xy[0]*wCellSize ,xy[1]*hCellSize ,wCellSize ,hCellSize);
		return xy;
	}
	return null;
}


public int[] getPosFromString(String pos){
	String[] XY = pos.split(",");
	if(XY[0].matches(".*\\d+.*")&&XY[1].matches(".*\\d+.*")){
		int[] xy = {Integer.parseInt(XY[0]),Integer.parseInt(XY[1])};
		return xy;
	}
	return null;
}

private void clearCell(Canvas canvas,int x,int y) {
	canvas.getGraphicsContext2D().clearRect(x*wCellSize, y*hCellSize, wCellSize, hCellSize);
}



private void paintLoadedLevel(String str){//TODO make private
	BufferedReader br = new BufferedReader(new StringReader(str));
	setHightAndWidht(str);
	String line;

	hCellSize = canvasHight/getLevelHight();
	wCellSize = canvasWidth/getLevelWidth();
	int x=0,y=0;
	
	try {
				bc.clearCanvas();
				pc.clearCanvas();
				sc.clearCanvas();
		while ((line=br.readLine())!=null){
			for(char c:line.toCharArray()){
				sc.drawFloor(x*wCellSize, y*hCellSize, wCellSize, hCellSize);
					if(c=='A')
						pc.drawPlayer(x*wCellSize, y*hCellSize, wCellSize, hCellSize);
					else if(c=='a')
						pc.drawPlayerOnDestination(x*wCellSize, y*hCellSize, wCellSize, hCellSize);
					else if(c=='@')
						bc.drawBox(x*wCellSize, y*hCellSize, wCellSize, hCellSize);
					else if(c=='$')
						bc.drawBoxOnDestination(x*wCellSize, y*hCellSize, wCellSize, hCellSize);
					else if(c=='#')
						 sc.drawWall(x*wCellSize, y*hCellSize, wCellSize, hCellSize);
					else if(c=='o')
						sc.drawDestination(x*wCellSize, y*hCellSize, wCellSize, hCellSize);
				x++;
			}
			y++;
			x=0;
		}
	} catch (IOException e) {
		e.printStackTrace();
	}		
}


private void setHightAndWidht(String level){
	BufferedReader br = new BufferedReader(new StringReader(level));
	String line;
	int hight=0;
	try {
		while ((line=br.readLine())!=null){
			hight++;
			if(getLevelWidth()<line.length())
				setLevelWidth(line.length());
			}
		setLevelHight(hight);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

public int getLevelHight() {
	return levelHight;
}

public void setLevelHight(int levelHight) {
	this.levelHight = levelHight;
}

public int getLevelWidth() {
	return levelWidth;
}

public void setLevelWidth(int levelWidth) {
	this.levelWidth = levelWidth;
}


}
