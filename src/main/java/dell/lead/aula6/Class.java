package dell.lead.aula6;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class Class extends Application {

	public static final String title = "JavaFx";

	public static void main(String[] args) {
		launch();	
	}

	@Override
	public void start(Stage palco) throws Exception {
		controllers(palco);
	}

	public void controllers(Stage palco) {

		VBox raiz = new VBox(10); // 1
		raiz.setTranslateX(2);
		raiz.setTranslateY(2);

		Label rotuloDemo = new Label("TEXTO TESTE"); // 3
		rotuloDemo.setTooltip(new Tooltip("Esse é um rótulo para mostrar textos de forma simples")); // 4

		TextField campoTexto = new TextField("Digite algo"); // 5
		campoTexto.setTooltip(new Tooltip("Campo de texto para entrada de uma só linha "));

		Separator separadorHorizontal = new Separator(Orientation.HORIZONTAL); // 7
		Separator separadorVertical = new Separator(Orientation.VERTICAL); // 8

		Slider deslizante = new Slider(); // 9
		deslizante.setTooltip(new Tooltip("O controle deslizante tem um valor numérico de acordo com sua posição"));

		ToggleGroup generos = new ToggleGroup();
		HBox hbGeneros = new HBox(20);
		RadioButton masculino = new RadioButton("M"); // 6
		masculino.setSelected(true);
		RadioButton feminino = new RadioButton("F");
		generos.getToggles().addAll(masculino, feminino);
		hbGeneros.getChildren().addAll(new Label("Sexo: "), masculino, feminino);

		CheckBox chkMoraSozinho = new CheckBox("Mora sozinho?"); // 7
		CheckBox chkCasado = new CheckBox("É casado?");
		CheckBox chkPet = new CheckBox("Tem cachorro?");

		HBox hbSo = new HBox(20);
		ToggleButton tbIniciante = new ToggleButton("Iniciante"); // 3
		tbIniciante.setSelected(true);
		ToggleButton tbIntermediario = new ToggleButton("Intermediário");
		ToggleButton tbAvancado = new ToggleButton("Avançado");
		ToggleGroup tgSo = new ToggleGroup(); // 4
		tgSo.getToggles().addAll(tbIniciante, tbIntermediario, tbAvancado); // 5
		hbSo.getChildren().addAll(new Label("Usuário: "), tbIniciante, tbIntermediario, tbAvancado);

		String esportes[] = { "Vôlei", "Basquete", "Muay Thai", "Futebol" };
		HBox opcoes = new HBox(10);
		opcoes.setAlignment(Pos.CENTER_LEFT);
		ComboBox<String> cbEsportes = new ComboBox<String>();
		cbEsportes.getItems().addAll(esportes);
		cbEsportes.getSelectionModel().selectFirst();
		opcoes.getChildren().addAll(new Label("Esporte: "), cbEsportes);

		Separator separadorHorizontal2 = new Separator(Orientation.HORIZONTAL);

		HBox hbBt = new HBox(20);
		hbBt.setAlignment(Pos.CENTER);
		Button btnConfirmar = new Button("Confirmar");
		Button btnCancelar = new Button("Cancelar");
		hbBt.getChildren().addAll(btnConfirmar, btnCancelar);

		raiz.getChildren().addAll(rotuloDemo, campoTexto, separadorVertical, separadorHorizontal, deslizante, hbGeneros,
				chkMoraSozinho, chkCasado, chkPet, hbSo, separadorHorizontal2, opcoes, hbBt);

		Scene cena = new Scene(raiz, 400, 345);
		palco.setTitle(title);
		palco.setScene(cena);
		palco.show();
	}

}