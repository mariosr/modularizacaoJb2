package dell.lead.aula6;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

@SuppressWarnings({ "restriction", "rawtypes" })
public class Class extends Application implements EventHandler {

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage palco) throws Exception {
		VBox raiz = new VBox(20);
		raiz.setAlignment(Pos.CENTER);
		raiz.setTranslateY(5);

		Button botao1 = new Button("Clique em mim! (Tratador externo)");
		Button botao2 = new Button("Clique em mim! (Class Anônima)");
		Button botao3 = new Button("Clique em mim! (Própria classe)");

		botao1.setOnAction(new TratadorEvento());
		botao2.setOnAction(new EventHandler() {

			public void handle(ActionEvent evento) {
				System.out.println("Evento tratado por uma classe anônima!");
			}

			@Override
			public void handle(Event arg0) {
				// TODO Auto-generated method stub
				System.out.println("Evento tratado por uma classe anônima!");
			}
		});

		botao3.setOnAction(this);

		raiz.getChildren().addAll(botao1, botao2, botao3);

		Scene cena = new Scene(raiz, 300, 200);
		palco.setTitle("Tratando eventos");
		palco.setScene(cena);
		palco.show();

	}

	public void handle(ActionEvent evento) {
		System.out.println("Evento tratado na própria classe!");
	}

	@Override
	public void handle(Event arg0) {
		// TODO Auto-generated method stub
		System.out.println("Evento tratado na própria classe!");
	}
}
