package TP3;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class BoutonHandler implements EventHandler<ActionEvent> {
	public void handle(ActionEvent event) {
		System.out.println("bouton click");
	}
}