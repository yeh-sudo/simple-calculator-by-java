package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();
        Scene scene = new Scene(root);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                try {
                    switch (keyEvent.getCode()) {
                        case A:
                            controller.clickAC();
                            break;
                        case C:
                            controller.clickCE();
                            break;
                        case ENTER:
                            controller.clickAnswer();
                            break;
                        case DIGIT0:
                            controller.clickZero();
                            break;
                        case DIGIT1:
                            controller.clickOne();
                            break;
                        case DIGIT2:
                            controller.clickTwo();
                            break;
                        case DIGIT3:
                            controller.clickThree();
                            break;
                        case DIGIT4:
                            controller.clickFour();
                            break;
                        case DIGIT5:
                            controller.clickFive();
                            break;
                        case DIGIT6:
                            controller.clickSix();
                            break;
                        case DIGIT7:
                            controller.clickSeven();
                            break;
                        case DIGIT8:
                            controller.clickEight();
                            break;
                        case DIGIT9:
                            controller.clickNine();
                            break;
                        case NUMPAD0:
                            controller.clickZero();
                            break;
                        case NUMPAD1:
                            controller.clickOne();
                            break;
                        case NUMPAD2:
                            controller.clickTwo();
                            break;
                        case NUMPAD3:
                            controller.clickThree();
                            break;
                        case NUMPAD4:
                            controller.clickFour();
                            break;
                        case NUMPAD5:
                            controller.clickFive();
                            break;
                        case NUMPAD6:
                            controller.clickSix();
                            break;
                        case NUMPAD7:
                            controller.clickSeven();
                            break;
                        case NUMPAD8:
                            controller.clickEight();
                            break;
                        case NUMPAD9:
                            controller.clickNine();
                            break;
                        case ADD:
                            controller.clickPlus();
                            break;
                        case SUBTRACT:
                            controller.clickMinus();
                            break;
                        case MULTIPLY:
                            controller.clickMulti();
                            break;
                        case DIVIDE:
                            controller.clickDiv();
                            break;
                        case DECIMAL:
                            controller.clickDot();
                            break;
                        case PERIOD:
                            controller.clickDot();
                            break;
                        case BACK_SPACE:
                            controller.clickBackspace();
                            break;
                        default:
                            break;
                    }
                }
                catch (Exception e){
                    return;
                }
            }
        });


        primaryStage.setResizable(false);
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
