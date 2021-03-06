package com.ictproject.student;

import com.ictproject.student.controller.AdminManagerController;
import com.ictproject.student.controller.ControllerConstants;
import com.ictproject.student.controller.DashboardController;
import com.ictproject.student.controller.LoginController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

    /*
    Login Stage
     */
    private Stage primaryStage;

    private AnchorPane rootLayout;


    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle(ControllerConstants.APP_TITLE);

        primaryStage.getIcons().add(new Image("img/icons8_Graduation_Cap_32px.png"));

//        connectDatabaseAndGetStudentDetail();
//        connectDB();
        showLoginLayout();
        initLoginLayout();
    }



    // TODO: 09/03/2018 adding something
    private void initLoginLayout() {

    }

    /**
     * Load and show Login Screen
     */
    private void showLoginLayout() {
        try {
            // Load the fxml file and create a new stage for Login
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(ControllerConstants.VIEWPATH + ControllerConstants.LOGIN_VIEW));
            AnchorPane loginLayout = loader.load();

            // Create the dialog stage
            Stage loginStage = new Stage();
            loginStage.setTitle("Login");
            loginStage.initModality(Modality.APPLICATION_MODAL);
            loginStage.initOwner(primaryStage);

            Scene scene = new Scene(loginLayout);
            loginStage.setScene(scene);

            // Give the controller access to the main app
            LoginController controller = loader.getController();
            controller.setMainApp(this);
            controller.setLoginStage(loginStage);

            loginStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Show the Admin management root layout
     */
    public void showAdminManagerRoot() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("view/AdminManager.fxml"));
            rootLayout = loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);

            // Set manager controller
            AdminManagerController controller = loader.getController();
            controller.setMainApp(this);
//            controller.setManagerStage(primaryStage);
            // do something
            primaryStage.setOnCloseRequest(e -> Platform.exit());
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void showDashboard() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(ControllerConstants.VIEWPATH + ControllerConstants.DASH_BOARD_VIEW));
            Parent dashboard = loader.load();

            Scene scene = new Scene(dashboard);
            primaryStage.setScene(scene);

            // Set manager controller
            DashboardController controller = loader.getController();
            controller.setMainApp(this);
//            controller.setManagerStage(primaryStage);
            // do something
            primaryStage.setOnCloseRequest(e -> Platform.exit());
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
