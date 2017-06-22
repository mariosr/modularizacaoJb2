package dell.lead.aula5;

import javafx.event.EventHandler;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.input.MouseEvent;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

@SuppressWarnings("restriction")
public class CDD extends Application {

	public static final String title = "JavaFx";
	private List<String> contatos = new ArrayList<String>();
	private final ListView<String> list = new ListView<String>();

	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage palco) throws Exception {
		tela(palco);
	}

	public void remover(int indexSelecionado) {
		if (indexSelecionado > -1) {
			System.out.println("Removendo contato "+contatos.get(indexSelecionado));
			contatos.remove(indexSelecionado);
			listar(contatos);
		} else {
			System.out.println("Selecione um nome...");
		}
	}

	public void adicionar(String nome) {
		if (nome != null && nome.equalsIgnoreCase("") == false) {
			contatos.add(nome);
			listar(contatos);
			System.out.println("Contato "+nome+" salvo com sucesso");
		} else {
			System.out.println("Digite um nome...");
		}
	}

	public List<String> listar(List<String> contatos) {
		ObservableList<String> items = FXCollections.observableArrayList(contatos);
		list.setItems(items);
		return contatos;
	}

	public void tela(Stage palco) {

		VBox raiz = new VBox(10);
		raiz.setTranslateX(2);
		raiz.setTranslateY(2);

		Label rotuloDemo = new Label("Digite o nome do seu contato abaixo: ");

		final TextField campoTexto = new TextField("");

		Separator separadorHorizontal = new Separator(Orientation.HORIZONTAL);

		list.setPrefWidth(100);
		list.setPrefHeight(150);

		HBox hbBt = new HBox(20);
		hbBt.setAlignment(Pos.CENTER);
		Button btnAdicionar = new Button("Adicionar");
		btnAdicionar.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				adicionar(campoTexto.getText());
			}
		});

		Button btnRemover = new Button("Remover");
		btnRemover.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				int indexSelecionado = list.getSelectionModel().getSelectedIndex();
				remover(indexSelecionado);
			}
		});

		Button btnCancelar = new Button("Cancelar");
		btnCancelar.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				campoTexto.clear();
			}
		});

		hbBt.getChildren().addAll(btnAdicionar, btnRemover, btnCancelar);
		raiz.getChildren().addAll(rotuloDemo, campoTexto, separadorHorizontal, list, hbBt);

		Scene cena = new Scene(raiz, 320, 285);
		palco.setTitle(title);
		palco.setScene(cena);
		palco.show();
	}

}