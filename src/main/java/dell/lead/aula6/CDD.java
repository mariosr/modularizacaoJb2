package dell.lead.aula6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class CDD extends Application {

	public static final String title = "JavaFx";

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage palco) throws Exception {
		topico2(palco);
	}

	@SuppressWarnings("unchecked")
	public void topico2(Stage palco){
		
		VBox raiz = new VBox(10);
		raiz.setPrefWidth(100.0);
		raiz.setSpacing(10);
		raiz.setPadding(new Insets(15, 50, 5, 50));
		raiz.setAlignment(Pos.TOP_CENTER);

		Button btn = new Button("OK");
		btn.setMinWidth(raiz.getPrefWidth());
		btn.setOnAction(new TratadorEvento());
		
		TextField campoTexto = new TextField("Digite algo"); 
		raiz.getChildren().addAll(campoTexto,btn);

		Scene cena = new Scene(raiz, 200, 140);
		palco.setTitle(title);
		palco.setScene(cena);
		palco.show();
		
		
	}
	
	@SuppressWarnings("unchecked")
	public void topico1(Stage palco) {

		VBox raiz = new VBox(10);
		raiz.setPrefWidth(100.0);
		raiz.setPadding(new Insets(10, 50, 5, 50));
		raiz.setAlignment(Pos.BOTTOM_CENTER);

		Button btn = new Button("OK");
		btn.setMinWidth(raiz.getPrefWidth());

		btn.setOnAction(new TratadorEvento());

		raiz.getChildren().addAll(btn);

		Scene cena = new Scene(raiz, 200, 140);
		palco.setTitle(title);
		palco.setScene(cena);
		palco.show();

	}

}
