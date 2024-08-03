package dz.currencyconverter;

import javafx.application.Application;
import javafx.fxml.FXMLLoader; // Loads UI layouts defined in FXML files
import javafx.scene.Parent; // Represents the "root node of the scene graph hierarchy
import javafx.scene.Scene; // Represents the container for all content in a scene graph of a JavaFX application
import javafx.stage.Stage; // Represents the primary stage (window) of a JavaFX application


public class DzCurrencyConverter extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        launch(args);
       }

    @Override
    public void start(Stage stage) throws Exception {
      Parent root=FXMLLoader.load(getClass()
              .getResource("/dz/currencyconverter/views/Dashboard.fxml"));
      String css=this.getClass().getResource(
               "/dz/currencyconverter/views/css/styling.css").toExternalForm();
        Scene scene=new  Scene(root);
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.setTitle("Currency Changing"); //setting the title to Currency Changing"
        stage.show();
    }

   
  
    
}
