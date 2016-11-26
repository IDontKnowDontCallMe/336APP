package presentation.mainui;

import java.util.Stack;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TheMainFrame extends Application{

	private static Stack<Scene> sceneStack;
	private static Stage stage;
	
	public static void jumpTo(Parent parent){
		
		Scene scene = new Scene(parent, 500, 500);
		sceneStack.push(stage.getScene());
		stage.setScene(scene);
		
	}
	
	public static void backTo(){
		stage.setScene(sceneStack.pop());
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		sceneStack = new Stack<Scene>();
		stage = primaryStage;
		
		Scene scene = new Scene(new LoginPane(),500, 500);
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args){
		launch(args);
	}

}
