package com.daniel.core.screens;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import com.daniel.core.database.migrations.Get;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.daniel.core.validations.ValidateLogin;

public class AccountLogin {

    private Stage stage;
    private int width;
    private int height;

    public AccountLogin(Stage stage, int width, int height) {
        this.stage = stage;
        this.width = width;
        this.height = height;
    }

    private boolean validateUsername(String username) {

        return username.matches("^[a-zA-Z0-9]{3,20}$");
    }

    private boolean validatePassword(String password) {
        return password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*]).{8,}$");
    }

    private void handleLogin(String username, String password, Label lblErro) {

        lblErro.setText("");

        if (username.isEmpty() || password.isEmpty()) {
            lblErro.setText("Preencha todos os campos");
            return;
        }

        
        if (!validateUsername(username)) {
            lblErro.setText("Usuário/Senha inválido");
            return;
        }

        
        if (!validatePassword(password)) {
            lblErro.setText("Usuário/Senha inválido");
            return;
        }

        

            ValidateLogin validateLogin = new ValidateLogin(username, password);
            System.out.println("USUARIO: " + username + " SENHA: " + password);

            if(!validateLogin.validate()){
                lblErro.setText("Usuário/Senha inválido");
                System.out.println("FALHOU");
                return;

            }
            System.out.println("LOGOU");
        

        Home home = new Home(stage, width, height);
        stage.setScene(new Scene(home.getRoot(), width, height));
    }

    public Pane getRoot() {

        Label lblErro = new Label();
        lblErro.setStyle("-fx-text-fill: red; -fx-font-size: 12px;");
        lblErro.setWrapText(true);
        lblErro.setMaxWidth(300);

        VBox container = new VBox(15);

        Pane pane = new Pane();

        TextField usernameField = new TextField();
        usernameField.setPromptText("User");
        usernameField.setPrefWidth(300);

        usernameField.textProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue.length() > 20) {
                usernameField.setText(oldValue);
            }

            if (!newValue.matches("[a-zA-Z0-9_]*")) {
                usernameField.setText(newValue.replaceAll("[^a-zA-Z0-9_]", ""));
            }
        });

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");
        passwordField.setPrefWidth(300);

        Button loginBtn = new Button("Entrar");
        loginBtn.setDefaultButton(true);
        loginBtn.setPrefWidth(300);
        loginBtn.setOnAction(e -> handleLogin(
                usernameField.getText(),
                passwordField.getText(),
                lblErro));

        container.getChildren().addAll(lblErro, usernameField, passwordField, loginBtn);

        container.setLayoutX((width / 2) - 150);
        container.setLayoutY((height / 2) - 100);

        pane.getChildren().add(container);
        return pane;
    }
}
