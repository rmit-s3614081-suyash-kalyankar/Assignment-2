package UIlayout;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GUI extends Application {

	private Stage firstStage,secondStage;
	private BorderPane pane,pane1;
	private MenuBar menuBar;
	private HBox bottom;
	private Menu menu;
	private Menu menu1;
	private MenuItem menuItem,menuItem1,menuItem2;
	private Scene scene,scene1;
	private Button btn1,btn2,btn3,btn4;
	private Label label1,label2;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		firstStage=primaryStage;
		
		/*
		 * Border Pane of primary Stage
		 */
		pane=new BorderPane();
		/*
		 * Menu Bar for the user to know more about game and help 
		 */
		
		 menuBar = new MenuBar();
		 menu = new Menu("Game Menu");
	     menu1 = new Menu("Help");
	     menuItem=new MenuItem("About Game");
	     menuItem1=new MenuItem("Rules");
	     menuItem2=new MenuItem("FAQ");
        
        menuBar.setStyle("-fx-background-color:CornFlowerBlue");
        
        menu.getItems().addAll(menuItem,menuItem1);
        menu1.getItems().add(menuItem2);
        menuBar.getMenus().addAll(menu,menu1);
       pane.setTop(menuBar);
        
        /*
         * Place Nodes in the Pane 
         */
        pane.setCenter(getCentre());
        pane.setBottom(getBottom());
        scene=new Scene(pane,800,500,Color.WHITESMOKE);
		firstStage.setTitle("Ozlympic Game");
		firstStage.setScene(scene);
		firstStage.show();
	
	/*
	 *  Pop up showing list of Athletes after Selecting a game
	 */
	
		pane1=new BorderPane();
		scene1=new Scene(pane1,500,500,Color.WHITESMOKE);
		
		secondStage= new Stage();
		secondStage.setScene(scene1);
		secondStage.initModality(Modality.APPLICATION_MODAL);
		secondStage.setTitle("List Of Athletes and Refree");
		
	}
	
	


	/**
	 * 
	 * @return the HBOX pane which consists of Image and Button 
	 * @throws FileNotFoundException
	 */
	private HBox getCentre() throws FileNotFoundException{
		HBox centre=new HBox(30);
		centre.setPadding(new Insets(50,30,30,30));
		centre.setStyle("-fx-background-color:white");
		
		ImageView imageView1 = new ImageView(new Image(new FileInputStream("/Users/suyashkalyankar/Documents/workspace/JavaFx/running.png")));
		imageView1.setFitHeight(300); 
	    imageView1.setFitWidth(200);
	    
	    ImageView imageView2 = new ImageView(new Image(new FileInputStream("/Users/suyashkalyankar/Documents/workspace/JavaFx/cyclist.png")));
		imageView2.setFitHeight(300); 
		imageView2.setFitWidth(200);         
		     
		ImageView imageView3 = new ImageView(new Image(new FileInputStream("/Users/suyashkalyankar/Documents/workspace/JavaFx/swimming.png")));
		imageView3.setFitHeight(300); 
	    imageView3.setFitWidth(200);
	    
	    btn1=new Button("Running",imageView1);
	    btn1.setStyle("-fx-base: Coral;");
	    btn1.setContentDisplay(ContentDisplay.TOP);
	    btn1.setOnAction(e->ButtonClicked(e));
	    
	    btn2=new Button("Cycling",imageView2);
	    btn2.setStyle("-fx-base: Coral;");
	    btn2.setContentDisplay(ContentDisplay.TOP);
	    btn2.setOnAction(e->ButtonClicked(e));
	    
	    btn3=new Button("Swimming",imageView3);
	    btn3.setStyle("-fx-base: Coral;");
	    btn3.setContentDisplay(ContentDisplay.TOP);
	    btn3.setOnAction(e->ButtonClicked(e));
	    
	    centre.getChildren().add(btn1);
		centre.getChildren().add(btn2);
		centre.getChildren().add(btn3);
		centre.getChildren().add(imageView1);
		centre.getChildren().add(imageView2);
		centre.getChildren().add(imageView3);
		return centre;
		
		}
	/**
	 * 
	 * @param SelectGame Action Event - will show list of athletes after selecting game
	 */
	private void ButtonClicked(ActionEvent SelectGame) {
		if(SelectGame.getSource()==btn1) {
			secondStage.showAndWait();
		} else if(SelectGame.getSource()==btn2) {
			secondStage.showAndWait();
		} else if(SelectGame.getSource()==btn3) {
			secondStage.showAndWait();
		} else {
			secondStage.close();
		}
			
	}


	/**
	 * 
	 * @return Label for user to Select the game and if user want to quit the game click on Exit
	 */
	
	private HBox getBottom(){
		bottom =new HBox(20);
		bottom.getChildren().add(new Label("Select Game to Run"));
		btn4=new Button("Exit");
		btn4.setTranslateX(580);
		btn4.setOnAction(e->System.exit(0));
		
		bottom.getChildren().add(btn4);
		bottom.setStyle("-fx-background-color:CornFlowerBlue");
		
		return bottom;
		
		
	}
	
	public static void main(String[]args){
		launch(args);
	}

}
