import database.Migrations;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import screens.Home;

public class Main extends Application {

    static Migrations migrations = new Migrations();

    private int width = 800;
    private int height = 600;

    private Stage stage;

    @Override   
    public void start(Stage primaryStage) {

        this.stage = primaryStage;
        Home home = new Home(stage, width, height);
        
        stage.setTitle("Test");
        stage.setScene(new Scene(home.getRoot(), width, height));
        stage.show();

    }

    public static void main(String[] args) {

        migrations.makeMigration();

        launch(args);
    }

}
