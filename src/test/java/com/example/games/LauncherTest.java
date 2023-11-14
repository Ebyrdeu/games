package com.example.games;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;
import org.testfx.matcher.base.WindowMatchers;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testfx.api.FxAssert.verifyThat;

class LauncherTest extends ApplicationTest {
    private Stage stage;

    @Override
    public void init() throws Exception {
        FxToolkit.registerStage(Stage::new);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        new Launcher().start(primaryStage);
        stage = primaryStage;
    }


    @Override
    public void stop() throws Exception {
        FxToolkit.hideStage();
    }


    @Nested
    @DisplayName("GameTest")
    class GameTest {
        @Test
        @DisplayName("Single player on button 1 click disable that button")
        void singlePlayerOnButton1ClickDisableThatButton() {
            clickOn("#single");

            Button button = lookup("#btn1").query();

            assertFalse(button.isDisabled());

            clickOn(button);

            assertTrue(button.isDisabled());


        }

        @Test
        @DisplayName("Game over and you can Restart")
        void gameOverAndYouCanRestart() {
            clickOn("#single");

            Label gameStatus = lookup("#gameStatus").query();
            Label gameScore = lookup("#gameScore").query();

            Button btn1 = lookup("#btn1").queryButton();
            Button btn2 = lookup("#btn2").queryButton();
            Button btn3 = lookup("#btn3").queryButton();
            Button btn4 = lookup("#btn4").queryButton();
            Button btn5 = lookup("#btn5").queryButton();
            Button btn6 = lookup("#btn6").queryButton();
            Button btn7 = lookup("#btn7").queryButton();
            Button btn8 = lookup("#btn8").queryButton();
            Button btn9 = lookup("#btn9").queryButton();

            Platform.runLater(() -> {
                btn1.setText("X");
                btn2.setText("O");
                btn3.setText("X");
                btn4.setText("X");
                btn5.setText("O");
                btn7.setText("O");
                btn8.setText("X");
                btn9.setText("O");

                btn1.setDisable(true);
                btn2.setDisable(true);
                btn3.setDisable(true);
                btn4.setDisable(true);
                btn5.setDisable(true);
                btn7.setDisable(true);
                btn8.setDisable(true);
                btn9.setDisable(true);
            });


            clickOn("#btn6");

            verifyThat(gameStatus, label -> label.getText().equals("It's a Tie!"));
            verifyThat(gameScore, label -> label.getText().equals("0:0"));

            clickOn("#restart");

            List.of(btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9).forEach(button -> verifyThat(button, button1 -> button.getText().isEmpty() && !button1.isDisabled()));
        }

        @Test
        @DisplayName("Game over is tie")
        void testIfGameOverIsTie() {
            clickOn("#single");

            Label gameStatus = lookup("#gameStatus").query();
            Label gameScore = lookup("#gameScore").query();

            Button btn1 = lookup("#btn1").queryButton();
            Button btn2 = lookup("#btn2").queryButton();
            Button btn3 = lookup("#btn3").queryButton();
            Button btn4 = lookup("#btn4").queryButton();
            Button btn5 = lookup("#btn5").queryButton();
            Button btn7 = lookup("#btn7").queryButton();
            Button btn8 = lookup("#btn8").queryButton();
            Button btn9 = lookup("#btn9").queryButton();

            Platform.runLater(() -> {
                btn1.setText("X");
                btn2.setText("O");
                btn3.setText("X");
                btn4.setText("X");
                btn5.setText("O");
                btn7.setText("O");
                btn8.setText("X");
                btn9.setText("O");

                btn1.setDisable(true);
                btn2.setDisable(true);
                btn3.setDisable(true);
                btn4.setDisable(true);
                btn5.setDisable(true);
                btn7.setDisable(true);
                btn8.setDisable(true);
                btn9.setDisable(true);
            });


            clickOn("#btn6");

            verifyThat(gameStatus, label -> label.getText().equals("It's a Tie!"));
            verifyThat(gameScore, label -> label.getText().equals("0:0"));
        }

    }


    @Nested
    @DisplayName("Win Test")
    class WinTest {
        @Test
        @DisplayName("Horizontally first row")
        void horizontallyFirstRow() {
            clickOn("#single");

            Label gameStatus = lookup("#gameStatus").query();
            Label gameScore = lookup("#gameScore").query();

            Button btn1 = lookup("#btn1").queryButton();
            Button btn2 = lookup("#btn2").queryButton();
            Button btn5 = lookup("#btn5").queryButton();
            Button btn9 = lookup("#btn9").queryButton();

            Platform.runLater(() -> {
                btn1.setText("X");
                btn2.setText("X");
                btn5.setText("O");
                btn9.setText("O");

                btn1.setDisable(true);
                btn2.setDisable(true);
                btn5.setDisable(true);
                btn9.setDisable(true);
            });


            clickOn("#btn3");

            verifyThat(gameStatus, label -> label.getText().equals("You Won!"));
            verifyThat(gameScore, label -> label.getText().equals("1:0"));
        }

        @Test
        @DisplayName("Horizontally second Row")
        void horizontallySecondRow() {
            clickOn("#single");

            Label gameStatus = lookup("#gameStatus").query();
            Label gameScore = lookup("#gameScore").query();

            Button btn1 = lookup("#btn1").queryButton();
            Button btn2 = lookup("#btn2").queryButton();
            Button btn5 = lookup("#btn5").queryButton();
            Button btn6 = lookup("#btn6").queryButton();

            Platform.runLater(() -> {
                btn1.setText("O");
                btn2.setText("O");
                btn5.setText("X");
                btn6.setText("X");

                btn1.setDisable(true);
                btn2.setDisable(true);
                btn5.setDisable(true);
                btn6.setDisable(true);
            });


            clickOn("#btn4");

            verifyThat(gameStatus, label -> label.getText().equals("You Won!"));
            verifyThat(gameScore, label -> label.getText().equals("1:0"));
        }

        @Test
        @DisplayName("Horizontally third row")
        void horizontallyThirdRow() {
            clickOn("#single");

            Label gameStatus = lookup("#gameStatus").query();
            Label gameScore = lookup("#gameScore").query();

            Button btn1 = lookup("#btn1").queryButton();
            Button btn2 = lookup("#btn2").queryButton();
            Button btn7 = lookup("#btn7").queryButton();
            Button btn9 = lookup("#btn9").queryButton();

            Platform.runLater(() -> {
                btn1.setText("O");
                btn2.setText("O");
                btn7.setText("X");
                btn9.setText("X");

                btn1.setDisable(true);
                btn2.setDisable(true);
                btn7.setDisable(true);
                btn9.setDisable(true);
            });


            clickOn("#btn8");

            verifyThat(gameStatus, label -> label.getText().equals("You Won!"));
            verifyThat(gameScore, label -> label.getText().equals("1:0"));
        }

        @Test
        @DisplayName("Vertically first column")
        void verticallyFirstColumn() {
            clickOn("#single");

            Label gameStatus = lookup("#gameStatus").query();
            Label gameScore = lookup("#gameScore").query();
            Button btn1 = lookup("#btn1").queryButton();
            Button btn4 = lookup("#btn4").queryButton();
            Button btn5 = lookup("#btn5").queryButton();
            Button btn9 = lookup("#btn9").queryButton();

            Platform.runLater(() -> {
                btn1.setText("X");
                btn4.setText("X");
                btn5.setText("O");
                btn9.setText("O");

                btn1.setDisable(true);
                btn4.setDisable(true);
                btn5.setDisable(true);
                btn9.setDisable(true);
            });


            clickOn("#btn7");

            verifyThat(gameStatus, label -> label.getText().equals("You Won!"));
            verifyThat(gameScore, label -> label.getText().equals("1:0"));
        }

        @Test
        @DisplayName("Vertically second column")
        void verticallySecondColumn() {
            clickOn("#single");

            Label gameStatus = lookup("#gameStatus").query();
            Label gameScore = lookup("#gameScore").query();
            Button btn1 = lookup("#btn1").queryButton();
            Button btn4 = lookup("#btn4").queryButton();
            Button btn2 = lookup("#btn2").queryButton();
            Button btn5 = lookup("#btn5").queryButton();

            Platform.runLater(() -> {
                btn1.setText("O");
                btn4.setText("O");
                btn2.setText("X");
                btn5.setText("X");

                btn1.setDisable(true);
                btn4.setDisable(true);
                btn2.setDisable(true);
                btn5.setDisable(true);
            });


            clickOn("#btn8");

            verifyThat(gameStatus, label -> label.getText().equals("You Won!"));
            verifyThat(gameScore, label -> label.getText().equals("1:0"));
        }

        @Test
        @DisplayName("Vertically third column")
        void verticallyThirdColumn() {
            clickOn("#single");

            Label gameStatus = lookup("#gameStatus").query();
            Label gameScore = lookup("#gameScore").query();
            Button btn1 = lookup("#btn1").queryButton();
            Button btn4 = lookup("#btn4").queryButton();
            Button btn6 = lookup("#btn6").queryButton();
            Button btn9 = lookup("#btn9").queryButton();

            Platform.runLater(() -> {
                btn1.setText("O");
                btn4.setText("O");
                btn6.setText("X");
                btn9.setText("X");

                btn1.setDisable(true);
                btn4.setDisable(true);
                btn6.setDisable(true);
                btn9.setDisable(true);
            });


            clickOn("#btn3");

            verifyThat(gameStatus, label -> label.getText().equals("You Won!"));
            verifyThat(gameScore, label -> label.getText().equals("1:0"));
        }

        @Test
        @DisplayName("Diagonally top left to bottom right")
        void diagonallyTopLeftToBottomRight() {
            clickOn("#single");

            Label gameStatus = lookup("#gameStatus").query();
            Label gameScore = lookup("#gameScore").query();
            Button btn3 = lookup("#btn3").queryButton();
            Button btn4 = lookup("#btn4").queryButton();
            Button btn5 = lookup("#btn5").queryButton();
            Button btn9 = lookup("#btn9").queryButton();

            Platform.runLater(() -> {
                btn3.setText("O");
                btn4.setText("O");
                btn5.setText("X");
                btn9.setText("X");

                btn3.setDisable(true);
                btn4.setDisable(true);
                btn5.setDisable(true);
                btn9.setDisable(true);
            });


            clickOn("#btn1");

            verifyThat(gameStatus, label -> label.getText().equals("You Won!"));
            verifyThat(gameScore, label -> label.getText().equals("1:0"));
        }

        @Test
        @DisplayName("Diagonally top right to bottom left")
        void diagonallyTopRightToBottomLeft() {
            clickOn("#single");

            Label gameStatus = lookup("#gameStatus").query();
            Label gameScore = lookup("#gameScore").query();
            Button btn3 = lookup("#btn3").queryButton();
            Button btn4 = lookup("#btn4").queryButton();
            Button btn5 = lookup("#btn5").queryButton();
            Button btn9 = lookup("#btn9").queryButton();

            Platform.runLater(() -> {
                btn3.setText("X");
                btn4.setText("O");
                btn5.setText("X");
                btn9.setText("O");

                btn3.setDisable(true);
                btn4.setDisable(true);
                btn5.setDisable(true);
                btn9.setDisable(true);
            });


            clickOn("#btn7");

            verifyThat(gameStatus, label -> label.getText().equals("You Won!"));
            verifyThat(gameScore, label -> label.getText().equals("1:0"));
        }

    }

    @Nested
    @DisplayName("Lost Test")
    class LostTest {
        @Test
        @DisplayName("Horizontally first row")
        void horizontallyFirstRow() {
            clickOn("#single");

            Label gameStatus = lookup("#gameStatus").query();
            Label gameScore = lookup("#gameScore").query();

            Button btn1 = lookup("#btn1").queryButton();
            Button btn2 = lookup("#btn2").queryButton();
            Button btn4 = lookup("#btn4").queryButton();
            Button btn5 = lookup("#btn5").queryButton();
            Button btn6 = lookup("#btn6").queryButton();
            Button btn7 = lookup("#btn7").queryButton();
            Button btn9 = lookup("#btn9").queryButton();

            Platform.runLater(() -> {
                btn1.setText("O");
                btn2.setText("O");
                btn4.setText("X");
                btn5.setText("O");
                btn6.setText("O");
                btn7.setText("O");
                btn9.setText("O");

                btn1.setDisable(true);
                btn2.setDisable(true);
                btn4.setDisable(true);
                btn5.setDisable(true);
                btn6.setDisable(true);
                btn7.setDisable(true);
                btn9.setDisable(true);
            });


            clickOn("#btn8");


            verifyThat(gameStatus, label -> label.getText().equals("You Lost!"));
            verifyThat(gameScore, label -> label.getText().equals("0:1"));
        }

        @Test
        @DisplayName("Horizontally second row")
        void horizontallySecondRow() {
            clickOn("#single");

            Label gameStatus = lookup("#gameStatus").query();
            Label gameScore = lookup("#gameScore").query();

            Button btn1 = lookup("#btn1").queryButton();
            Button btn2 = lookup("#btn2").queryButton();
            Button btn3 = lookup("#btn3").queryButton();
            Button btn5 = lookup("#btn5").queryButton();
            Button btn6 = lookup("#btn6").queryButton();
            Button btn7 = lookup("#btn7").queryButton();
            Button btn9 = lookup("#btn9").queryButton();

            Platform.runLater(() -> {
                btn1.setText("X");
                btn2.setText("X");
                btn3.setText("O");
                btn5.setText("O");
                btn6.setText("O");
                btn7.setText("O");
                btn9.setText("O");

                btn1.setDisable(true);
                btn2.setDisable(true);
                btn3.setDisable(true);
                btn5.setDisable(true);
                btn6.setDisable(true);
                btn7.setDisable(true);
                btn9.setDisable(true);
            });


            clickOn("#btn8");


            verifyThat(gameStatus, label -> label.getText().equals("You Lost!"));
            verifyThat(gameScore, label -> label.getText().equals("0:1"));
        }

        @Test
        @DisplayName("Horizontally Third row")
        void horizontallyThirdRow() {
            clickOn("#single");

            Label gameStatus = lookup("#gameStatus").query();
            Label gameScore = lookup("#gameScore").query();

            Button btn1 = lookup("#btn1").queryButton();
            Button btn2 = lookup("#btn2").queryButton();
            Button btn3 = lookup("#btn3").queryButton();
            Button btn5 = lookup("#btn5").queryButton();
            Button btn6 = lookup("#btn6").queryButton();
            Button btn7 = lookup("#btn7").queryButton();
            Button btn9 = lookup("#btn9").queryButton();

            Platform.runLater(() -> {
                btn1.setText("X");
                btn2.setText("X");
                btn3.setText("O");
                btn5.setText("O");
                btn6.setText("X");
                btn7.setText("O");
                btn9.setText("O");

                btn1.setDisable(true);
                btn2.setDisable(true);
                btn3.setDisable(true);
                btn5.setDisable(true);
                btn6.setDisable(true);
                btn7.setDisable(true);
                btn9.setDisable(true);
            });


            clickOn("#btn4");


            verifyThat(gameStatus, label -> label.getText().equals("You Lost!"));
            verifyThat(gameScore, label -> label.getText().equals("0:1"));
        }

        @Test
        @DisplayName("Vertically first column")
        void verticallyFirstColumn() {
            clickOn("#single");

            Label gameStatus = lookup("#gameStatus").query();
            Label gameScore = lookup("#gameScore").query();

            Button btn2 = lookup("#btn2").queryButton();
            Button btn3 = lookup("#btn3").queryButton();
            Button btn4 = lookup("#btn4").queryButton();
            Button btn5 = lookup("#btn5").queryButton();
            Button btn7 = lookup("#btn7").queryButton();
            Button btn8 = lookup("#btn8").queryButton();
            Button btn9 = lookup("#btn9").queryButton();

            Platform.runLater(() -> {
                btn2.setText("X");
                btn3.setText("O");
                btn4.setText("O");
                btn5.setText("O");
                btn7.setText("O");
                btn8.setText("O");
                btn9.setText("X");

                btn2.setDisable(true);
                btn3.setDisable(true);
                btn4.setDisable(true);
                btn5.setDisable(true);
                btn7.setDisable(true);
                btn8.setDisable(true);
                btn9.setDisable(true);
            });


            clickOn("#btn6");


            verifyThat(gameStatus, label -> label.getText().equals("You Lost!"));
            verifyThat(gameScore, label -> label.getText().equals("0:1"));
        }

        @Test
        @DisplayName("Vertically second column")
        void verticallySecondColumn() {
            clickOn("#single");

            Label gameStatus = lookup("#gameStatus").query();
            Label gameScore = lookup("#gameScore").query();

            Button btn1 = lookup("#btn1").queryButton();
            Button btn2 = lookup("#btn2").queryButton();
            Button btn3 = lookup("#btn3").queryButton();
            Button btn4 = lookup("#btn4").queryButton();
            Button btn7 = lookup("#btn7").queryButton();
            Button btn8 = lookup("#btn8").queryButton();
            Button btn9 = lookup("#btn9").queryButton();

            Platform.runLater(() -> {
                btn1.setText("O");
                btn2.setText("O");
                btn3.setText("X");
                btn4.setText("X");
                btn7.setText("X");
                btn8.setText("O");
                btn9.setText("O");

                btn1.setDisable(true);
                btn2.setDisable(true);
                btn3.setDisable(true);
                btn4.setDisable(true);
                btn7.setDisable(true);
                btn8.setDisable(true);
                btn9.setDisable(true);
            });


            clickOn("#btn6");


            verifyThat(gameStatus, label -> label.getText().equals("You Lost!"));
            verifyThat(gameScore, label -> label.getText().equals("0:1"));
        }

        @Test
        @DisplayName("Vertically third column")
        void verticallyThirdColumn() {
            clickOn("#single");

            Label gameStatus = lookup("#gameStatus").query();
            Label gameScore = lookup("#gameScore").query();

            Button btn1 = lookup("#btn1").queryButton();
            Button btn2 = lookup("#btn2").queryButton();
            Button btn3 = lookup("#btn3").queryButton();
            Button btn4 = lookup("#btn4").queryButton();
            Button btn5 = lookup("#btn5").queryButton();
            Button btn6 = lookup("#btn6").queryButton();
            Button btn7 = lookup("#btn7").queryButton();

            Platform.runLater(() -> {
                btn1.setText("X");
                btn2.setText("O");
                btn3.setText("O");
                btn4.setText("X");
                btn5.setText("X");
                btn6.setText("O");
                btn7.setText("O");


                btn1.setDisable(true);
                btn2.setDisable(true);
                btn3.setDisable(true);
                btn4.setDisable(true);
                btn5.setDisable(true);
                btn6.setDisable(true);
                btn7.setDisable(true);
            });


            clickOn("#btn8");


            verifyThat(gameStatus, label -> label.getText().equals("You Lost!"));
            verifyThat(gameScore, label -> label.getText().equals("0:1"));
        }

        @Test
        @DisplayName("Diagonally top left to bottom right")
        void diagonallyTopLeftToBottomRight() {
            clickOn("#single");

            Label gameStatus = lookup("#gameStatus").query();
            Label gameScore = lookup("#gameScore").query();

            Button btn3 = lookup("#btn3").queryButton();
            Button btn4 = lookup("#btn4").queryButton();
            Button btn5 = lookup("#btn5").queryButton();
            Button btn6 = lookup("#btn6").queryButton();
            Button btn7 = lookup("#btn7").queryButton();
            Button btn8 = lookup("#btn8").queryButton();
            Button btn9 = lookup("#btn9").queryButton();

            Platform.runLater(() -> {
                btn3.setText("X");
                btn4.setText("X");
                btn5.setText("O");
                btn6.setText("X");
                btn7.setText("X");
                btn8.setText("X");
                btn9.setText("O");

                btn3.setDisable(true);
                btn4.setDisable(true);
                btn5.setDisable(true);
                btn6.setDisable(true);
                btn7.setDisable(true);
                btn8.setDisable(true);
                btn9.setDisable(true);
            });


            clickOn("#btn2");

            verifyThat(gameStatus, label -> label.getText().equals("You Lost!"));
            verifyThat(gameScore, label -> label.getText().equals("0:1"));
        }

        @Test
        @DisplayName("Diagonally top right to bottom right")
        void diagonallyTopRightToBottomLeft() {
            clickOn("#single");

            Label gameStatus = lookup("#gameStatus").query();
            Label gameScore = lookup("#gameScore").query();

            Button btn2 = lookup("#btn2").queryButton();
            Button btn3 = lookup("#btn3").queryButton();
            Button btn4 = lookup("#btn4").queryButton();
            Button btn5 = lookup("#btn5").queryButton();
            Button btn6 = lookup("#btn6").queryButton();
            Button btn8 = lookup("#btn8").queryButton();
            Button btn9 = lookup("#btn9").queryButton();

            Platform.runLater(() -> {
                btn2.setText("X");
                btn3.setText("O");
                btn4.setText("X");
                btn5.setText("O");
                btn6.setText("X");
                btn8.setText("O");
                btn9.setText("X");


                btn2.setDisable(true);
                btn3.setDisable(true);
                btn4.setDisable(true);
                btn5.setDisable(true);
                btn6.setDisable(true);
                btn8.setDisable(true);
                btn9.setDisable(true);
            });


            clickOn("#btn1");

            verifyThat(gameStatus, label -> label.getText().equals("You Lost!"));
            verifyThat(gameScore, label -> label.getText().equals("0:1"));
        }
    }

    @Nested
    @DisplayName("Menu Test")
    class MenuTest {
        @Test
        @DisplayName("Close on X button")
        void closeOnXButton() {
            clickOn("#close");

            assertFalse(stage.isShowing());
        }

        @Test
        @DisplayName("Minimized on - Button")
        void minimizedOnButton() {
            clickOn("#minimize");

            assertTrue(stage.isIconified());
        }

        @Test
        @DisplayName("Go back after it changed scene on button 戻")
        void goBackAfterItChangedSceneOnButton() {
            clickOn("#single");
            clickOn("#backToMainMenu");

            verifyThat(window("Main menu"), WindowMatchers.isShowing());
        }

        @Test
        @DisplayName("Open logs on button 録")
        void openLogsOnButton() {
            clickOn("#logWindow");

            verifyThat(window("Log menu"), WindowMatchers.isShowing());

        }

        @Test
        @DisplayName("Switch to single player on button single")
        void switchToSinglePlayerOnButtonSingle() {
            clickOn("#single");

            verifyThat(window("Single player"), WindowMatchers.isShowing());
        }

        @Nested
        @DisplayName("Drag Window")
        class DragWindow {
            @Nested
            @DisplayName("2560x1400")
            class Resolution2k {
                @Test
                @DisplayName("right")
                void right() {
                    drag("#menu").moveBy(300, 0);
                    assertTrue(stage.getX() == 1280.0 && stage.getY() == 268.0);
                }

                @Test
                @DisplayName("left")
                void left() {
                    drag("#menu").moveBy(-300, 0);
                    assertTrue(stage.getX() == 680.0 && stage.getY() == 268.0);
                }

                @Test
                @DisplayName("bottom")
                void bottom() {
                    drag("#menu").moveBy(0, 300);
                    assertTrue(stage.getY() == 568.0 && stage.getX() == 980.0);
                }

                @Test
                @DisplayName("top")
                void top() {
                    drag("#menu").moveBy(0, -100);
                    assertTrue(stage.getY() == 168.0 && stage.getX() == 980.0);
                }
            }
        }
    }
}
