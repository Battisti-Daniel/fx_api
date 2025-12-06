package screens;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import database.migrations.Get;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Home {

    private Stage stage;
    private int width;
    private int height;

    public Home(Stage stage, int width, int height) {
        this.stage = stage;
        this.width = width;
        this.height = height;
    }

    private List<Button> makeBtn() {

        Get get = new Get();

        List<Map<String, String>> servers = get.getServer("servers");

        List<Button> buttons = new ArrayList<>();

        for (Map<String, String> server : servers) {
            Button btn = new Button(server.get("name"));
            btn.setPrefSize(150, 40);
            btn.setOnAction(e -> {
                System.out.println("Entrando no servidor " + server.get("name"));
                AccountLogin selectServer = new AccountLogin(stage, width, height);
                stage.setScene(new Scene(selectServer.getRoot(), width, height));
            });
            buttons.add(btn);
        }

        return buttons;
    }

    public Pane getRoot() {

        VBox container = new VBox(20);
        container.setLayoutX(width * 0.75);
        container.setLayoutY(height * 0.2);
        container.getChildren().addAll(makeBtn());

        Pane pane = new Pane();
        pane.getChildren().add(container);
        return pane;
    }

}
