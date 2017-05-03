package UIlayout;

/**
 * @author suyashkalyankar
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GUI extends Application {

	private Stage firstStage,secondStage;
	private BorderPane pane;
	private GridPane pane1;
	private MenuBar menuBar;
	private HBox bottom;
	private Menu menu;
	private Menu menu1;
	private MenuItem menuItem,menuItem1,menuItem2;
	private Scene scene,scene1;
	private Button btn1,btn2,btn3,btn4;
	Connection conn;
	
	private Label label1,label2;
	
	public static void main(String[]args){
		launch(args);
	}
	
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
	
		pane1=new GridPane();
		pane1.setPadding(new Insets (5));
		pane1.setHgap(10);
		pane1.setVgap(10);
		scene1=new Scene(pane1,500,500,Color.WHITESMOKE);
		secondStage= new Stage();
		secondStage.setScene(scene1);
		secondStage.initModality(Modality.APPLICATION_MODAL);
		secondStage.setTitle("List Of Athletes and Refree");
		//Contains list of Athletes in columns
		ColumnConstraints column1 = new ColumnConstraints(150, 150,
		        Double.MAX_VALUE);
		ColumnConstraints column2 = new ColumnConstraints(50);
	    ColumnConstraints column3 = new ColumnConstraints(150, 150,
	        Double.MAX_VALUE);
	    column1.setHgrow(Priority.ALWAYS);
	    column3.setHgrow(Priority.ALWAYS);
	    pane1.getColumnConstraints().addAll(column1,column2,column3);
	    Label Participant = new Label("Participants");
	    GridPane.setHalignment(Participant, HPos.CENTER);
	    pane1.add(Participant, 0, 0);

	    Label selectedLbl = new Label("selected");
	    pane1.add(selectedLbl, 2, 0);
	    GridPane.setHalignment(selectedLbl, HPos.CENTER);
	    
	    final ObservableList<String> candidates = FXCollections
	            .observableArrayList("Officer", "Athlete1 ", "Athlete2", "Athlete3", "Athlete4");
	        final ListView<String> candidatesListView = new ListView<>(candidates);
	        pane1.add(candidatesListView, 0, 1);

	        final ObservableList<String> selected = FXCollections.observableArrayList();
	        final ListView<String> heroListView = new ListView<>(selected);
	        pane1.add(heroListView, 2, 1);

	        Button sendRightButton = new Button(" > ");
	        sendRightButton.setOnAction((ActionEvent event) -> {
	          String potential = candidatesListView.getSelectionModel()
	              .getSelectedItem();
	          if (potential != null) {
	            candidatesListView.getSelectionModel().clearSelection();
	            candidates.remove(potential);
	            selected.add(potential);
	          }
	        });

	        Button sendLeftButton = new Button(" < ");
	        sendLeftButton.setOnAction((ActionEvent event) -> {
	          String s = heroListView.getSelectionModel().getSelectedItem();
	          if (s != null) {
	            heroListView.getSelectionModel().clearSelection();
	            selected.remove(s);
	            candidates.add(s);
	          }
	        });
	        VBox vbox = new VBox(5);
	        vbox.getChildren().addAll(sendRightButton, sendLeftButton);

	        pane1.add(vbox, 1, 1);
	    	CheckConnection();
	        }

	/**
	 * @return If connection is sucessful or not
	 */
	public void CheckConnection(){
		conn = SqlConnection.DbConnector();
		if	(conn==null){
			System.out.println("Connection is not Sucessful");
			System.exit(1);
			
		}
		else {
			System.out.println("Connection is Sucessful");
		}
		
		
	}
	
	
	


	/**
	 * 
	 * @return the HBOX pane which consists of Image and Button for selecting the game 
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
	
	

}
