package view;

import java.io.IOException;
import java.util.List;

import Controller.SokobanController;
import Controller.Server.SokobanServer;
import Model.SokobanModel;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class GUIApplication extends Application{
	
	public void run(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
	try {	
			FXMLLoader loader = new FXMLLoader(getClass().getResource("SokobanGUI.fxml"));
			BorderPane root = (BorderPane)loader.load();
			
			
			
			Scene scene = new Scene(root,743,582);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			List<String> args = getParameters().getRaw();
			
			//Set the MVC
			int port=0;
			final SokobanView ui = (SokobanView)loader.getController();
			SokobanModel m = new SokobanModel();
			SokobanController c = new SokobanController(ui, m);;
			
			if((port=checkIfServer(args))>0){//(
				SokobanServer sokoServer = new SokobanServer(port);
				sokoServer.setSc(c);
				c.setSokoServer(sokoServer);
				sokoServer.start();
			}
			
			ui.addObserver(c);
			m.addObserver(c);

			//Set override X button exit.
			primaryStage.setOnHiding(new EventHandler<WindowEvent>() {

	            @Override
	            public void handle(WindowEvent event) {
	                Platform.runLater(new Runnable() {
	                    @Override
	                    public void run() {
	                        ui.exit();
	                    }
	                });
	            }
	        });
			//Show the window.
			primaryStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
			
	}

	public void stop(){
		this.stop();
	}




	public int checkIfServer(List<String> string){
		int port;
		if(string.size()==2)
			if(string.get(0).matches("-server"))
				if(string.get(1).matches(".*\\d+.*")){
					port = Integer.parseInt(string.get(1));
						return port;
			}
		
		
		return 0;
	}

	

}
