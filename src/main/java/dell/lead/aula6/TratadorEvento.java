package dell.lead.aula6;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;

public class TratadorEvento implements EventHandler { // 1

	public void handle(ActionEvent evento) { // 2
		System.out.println("Evento tratado por uma classe externa");
	}

	@Override
	public void handle(Event arg0) {
		// TODO Auto-generated method stub
		
	}

}