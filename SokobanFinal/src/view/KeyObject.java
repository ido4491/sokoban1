package view;

import javafx.scene.input.KeyCode;

public class KeyObject {
private KeyCode keyC;
public KeyObject(KeyCode key){
	setKey(key);
}
public KeyCode getKey() {
	return keyC;
}

public void setKey(KeyCode key) {
	this.keyC = key;
}

@Override
public String toString(){
	return this.keyC.toString();
}

}
