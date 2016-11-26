package presentation.mainui;

import java.util.Stack;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TheMainFrame extends Application{

	private static Stack<Parent> parentStack;
	private static Scene scene;
	
	public static void jumpTo(Parent parent){
		
		parentStack.push(scene.getRoot());
		scene.setRoot(parent);
		
	}
	
	public static void backTo(){
		scene.setRoot(parentStack.pop());
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		scene = new Scene(new LoginPane(),500,500);
		parentStack = new Stack<Parent>();
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args){
		launch(args);
	}

}
