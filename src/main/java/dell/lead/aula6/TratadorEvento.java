package dell.lead.aula6;

import javafx.event.Event;
import javafx.event.EventHandler;

@SuppressWarnings("restriction")
public class TratadorEvento implements EventHandler {

	@Override
	public void handle(Event arg0) {
		System.out.println("Evento tratado por uma classe externa");

	}

}