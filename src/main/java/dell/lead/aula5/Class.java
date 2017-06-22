package dell.lead.aula5;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.Circle;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class Class extends Application {

	public static final String title = "JavaFx";
	
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage palco) throws Exception {
		//controllers(palco);
		stack(palco);
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

		String esportes[] = { "Vôlei", "Basquete", "Muay Thai", "Futebol"};
		HBox opcoes = new HBox(10);
		opcoes.setAlignment(Pos.CENTER_LEFT);
		ComboBox<String> cbEsportes = new ComboBox<String>(); 
		cbEsportes.getItems().addAll(esportes);
		cbEsportes.getSelectionModel().selectFirst();
		opcoes.getChildren().addAll(new Label("Esporte: "),cbEsportes);

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

	public void borderPane(Stage palco) {
		BorderPane borderPane = new BorderPane();
		Label lblTop, lblBaixo;
		// 1
		borderPane.setTop(lblTop = new Label("Norte"));
		borderPane.setLeft(new Label("Oeste"));
		borderPane.setBottom(lblBaixo = new Label("Sul"));
		borderPane.setRight(new Label("Leste"));
		borderPane.setCenter(new Label("Centro"));
		// 2
		BorderPane.setAlignment(lblTop, Pos.CENTER);
		BorderPane.setAlignment(lblBaixo, Pos.CENTER);

		Scene cena = new Scene(borderPane, 250, 150);
		palco.setTitle(title);
		palco.setScene(cena);
		palco.show();
	}

	public void gridPane(Stage palco) {

		GridPane gridPane = new GridPane();
		// 1
		gridPane.add(new Label("0 X 0"), 0, 0);
		gridPane.add(new Label("0 X 1"), 0, 1);
		gridPane.add(new Label("1 X 0"), 1, 0);
		gridPane.add(new Label("1 X 1"), 1, 1);
		// 2
		gridPane.setVgap(20);
		gridPane.setHgap(20);
		// 3
		gridPane.setAlignment(Pos.CENTER);

		Scene cena = new Scene(gridPane, 250, 150);
		palco.setTitle(title);
		palco.setScene(cena);
		palco.show();

	}

	public void flowPane(Stage palco) {

		// 1
		FlowPane flowPane = new FlowPane();
		// 2
		flowPane.setAlignment(Pos.CENTER);

		for (int i = 0; i < 9; i++) {
			// 3
			flowPane.getChildren().add(new Label("Java " + i + " - "));
		}

		Scene cena = new Scene(flowPane, 250, 150);
		palco.setTitle(title);
		palco.setScene(cena);
		palco.show();

	}

	public void stack(Stage palco) {
		StackPane painelEmpilhador = new StackPane();
		Rectangle retangulo = new Rectangle(220, 120);
		retangulo.setFill(Color.GREEN);

		Polygon losango = new Polygon();
		losango.getPoints().addAll(new Double[] { 50.0, 50.0, 150.0, 0.0, 250.0, 50.0, 150.0, 100.0, 50.0, 50.0 });
		losango.setFill(Color.YELLOW);
		Path arco = new Path();
		MoveTo moveTo = new MoveTo();
		moveTo.setX(0.0);
		moveTo.setY(0.0);

		ArcTo arcTo = new ArcTo();
		arcTo.setX(55.0);
		arcTo.setY(0.0);
		arcTo.setRadiusX(50.0);
		arcTo.setRadiusY(50.0);

		arco.getElements().add(moveTo);
		arco.getElements().add(arcTo);
		arco.setStroke(Color.WHITE);

		arco.setRotate(180);
		arco.setStrokeWidth(5);

		Circle circulo = new Circle(30, Color.BLUE);

		painelEmpilhador.getChildren().addAll(retangulo, losango, circulo, arco);

		Scene cena = new Scene(painelEmpilhador, 250, 150);
		palco.setTitle(title);
		palco.setScene(cena);
		palco.show();

	}

	public void hbox(Stage palco) {

		HBox caixaHorizontal = new HBox(); // 1
		caixaHorizontal.setSpacing(5); // 2
		caixaHorizontal.setAlignment(Pos.CENTER); // 3

		// 4
		caixaHorizontal.setTranslateX(10);
		caixaHorizontal.setTranslateY(0);

		// 5
		Rectangle retanguloRosa = new Rectangle(60, 40);
		Rectangle retanguloLimao = new Rectangle(60, 40);
		Rectangle retanguloChocolate = new Rectangle(60, 40);

		retanguloRosa.setFill(Color.PINK);
		retanguloLimao.setFill(Color.CHARTREUSE);
		retanguloChocolate.setFill(Color.CHOCOLATE);

		// 6
		caixaHorizontal.getChildren().addAll(retanguloRosa, retanguloLimao, retanguloChocolate);

		Scene cena = new Scene(caixaHorizontal, 250, 150);
		palco.setTitle(title);
		palco.setScene(cena);
		palco.show();

	}

	public void vbox(Stage palco) {

		VBox caixaVertical = new VBox(); // 1
		caixaVertical.setSpacing(5); // 2
		caixaVertical.setAlignment(Pos.CENTER); // 3

		// 4
		caixaVertical.setTranslateX(10);
		caixaVertical.setTranslateY(5);

		// 5
		Rectangle retanguloRosa = new Rectangle(150, 20);
		Rectangle retanguloLimao = new Rectangle(150, 20);
		Rectangle retanguloChocolate = new Rectangle(150, 20);

		retanguloRosa.setFill(Color.PINK);
		retanguloLimao.setFill(Color.CHARTREUSE);
		retanguloChocolate.setFill(Color.CHOCOLATE);

		// 6
		caixaVertical.getChildren().addAll(retanguloRosa, retanguloLimao, retanguloChocolate);

		Scene cena = new Scene(caixaVertical, 250, 150);
		palco.setTitle(title);
		palco.setScene(cena);
		palco.show();

	}

}