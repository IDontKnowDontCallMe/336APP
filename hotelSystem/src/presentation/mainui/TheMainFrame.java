package presentation.mainui;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Stack;
import bussinesslogic.factory.BLFactory;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TheMainFrame extends Application {

	private static Stack<Parent> parentStack;
	private static Scene scene;
	private BLFactory blFactory;

	public static void jumpTo(Parent parent) {

		parentStack.push(scene.getRoot());
		scene.setRoot(parent);

	}

	public static void backTo() {
		scene.setRoot(parentStack.pop());
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		linkToServer();
		scene = new Scene(new LoginPane(), 1100, 700);
		parentStack = new Stack<Parent>();

		primaryStage.setScene(scene);

		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	private void linkToServer() {
		try {
			blFactory = BLFactory.getInstance();
			blFactory.setRemote(Naming.lookup("rmi://localhost:8888/controllerRemoteFactory"));
			System.out.println("linked");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

}
