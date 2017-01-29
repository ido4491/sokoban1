package Model.ObjectsCreator;

import Model.Data.Level;
import Model.Data.Objects.GraphicObject;
import Model.Data.Objects.Player;

public class PlayerCreator implements GraphicObjectCreator{

	@Override
	public GraphicObject create(int x, int y,Level lvl) {
		Player player = new Player(x, y);
		lvl.setPlayer(player);
		return player;
	}

}
