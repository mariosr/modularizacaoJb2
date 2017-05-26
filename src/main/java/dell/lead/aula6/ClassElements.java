package dell.lead.aula6;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

@SuppressWarnings("restriction")
public class ClassElements extends Application {

	public static final String title = "JavaFx";

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage palco) throws Exception {
		circle(palco);
	}

	public void textBox(Stage palco) {

		VBox raiz = new VBox(10);
		raiz.setAlignment(Pos.CENTER);
		
		final TextField textBox = new TextField();
		textBox.setPromptText("Escreva aqui");

		textBox.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent ke) {
				System.out.println("Tecla pressionada: " + ke.getText());
			}
		});

		textBox.setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent ke) {
				System.out.println("Tecla liberada: " + ke.getText());
			}
		});

		raiz.getChildren().addAll(textBox);

		Scene cena = new Scene(raiz, 200, 140);
		palco.setTitle(title);
		palco.setScene(cena);
		palco.show();

	}

	public void circle(Stage palco) {

		VBox raiz = new VBox(10);
		raiz.setAlignment(Pos.CENTER);
		final Circle circle = new Circle(50, Color.RED);

		circle.setOnMouseEntered(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				System.out.println("Mouse dentro");
			}
		});

		circle.setOnMouseExited(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				System.out.println("Mouse fora");
			}
		});

		circle.setOnMousePressed(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent me) {
				System.out.println("Mouse pressionado");
			}
		});

		raiz.getChildren().addAll(circle);

		Scene cena = new Scene(raiz, 200, 140);
		palco.setTitle(title);
		palco.setScene(cena);
		palco.show();

	}

}
