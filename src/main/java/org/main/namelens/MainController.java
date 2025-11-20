package org.main.namelens;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.StackPane;
import javafx.scene.Node;
import java.io.IOException;

public class MainController {
    @FXML
    private StackPane contentArea;

    @FXML
    public void initialize() {
        // Load home page by default
        loadPage("home-page.fxml");
    }

    @FXML
    protected void showHomePage() {
        loadPage("home-page.fxml");
    }

    @FXML
    protected void showProfilePage() {
        loadPage("profile-page.fxml");
    }

    @FXML
    protected void showSettingsPage() {
        loadPage("settings-page.fxml");
    }

    @FXML
    protected void showAboutPage() {
        loadPage("about-page.fxml");
    }

    private void loadPage(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Node page = loader.load();
            contentArea.getChildren().clear();
            contentArea.getChildren().add(page);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}