package com.daniel.core;

import com.daniel.core.database.Migrations;
import com.daniel.core.screens.Home;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

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
