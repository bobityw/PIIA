package TP4;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import java.time.Instant;

public class TestMenu extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Application");
		
		MenuBar menuBar = new MenuBar();
		Menu menu1 = new Menu("Fichier");
		Menu menu2 = new Menu("Edition");
		Menu menu3 = new Menu("Insertion");
		Menu menu4 = new Menu("Outils");
		Menu menu5 = new Menu("Aide");
				
		MenuItem menu1Item1 = new MenuItem("Créer un nouveau fichier ex-nihilo");
		MenuItem menu1Item2 = new MenuItem("Ouvrir un fichier");
		MenuItem menu1Item3 = new MenuItem("Enregistrer le fichier");
		MenuItem menu1Item4 = new MenuItem("Fermer le fichier");
		MenuItem menu1Item5 = new MenuItem("Imprimer le fichier");
		MenuItem menu1Item6 = new MenuItem("Quitter l’application");
		
		/** --------------------------------------**/
		MenuItem menu2Item1 = new MenuItem("Annuler");
		MenuItem menu2Item2 = new MenuItem("Rétablir");
		Menu subMenu2 = new Menu("Modifier");
		Menu subMenu21 = new Menu("Action texte");
		MenuItem menu2Item3 = new MenuItem("Mettre en majuscule ou en minuscule");
		
		MenuItem subMenu2Item1 = new MenuItem("Modifier la police de caractères");
		MenuItem subMenu2Item2 = new MenuItem("Modifier leur taille");
		MenuItem subMenu2Item3 = new MenuItem("Modifier le style...");
		
		MenuItem subMenu21Item1 = new MenuItem("Copier");
		MenuItem subMenu21Item2 = new MenuItem("Couper");
		MenuItem subMenu21Item3 = new MenuItem("Coller");
		
		MenuItem menu3Item1 = new MenuItem("Insérer une image ou dessin");
		MenuItem menu3Item2 = new MenuItem("Insérer un tableau");
		MenuItem menu3Item3 = new MenuItem("Insérer une table des matières");
		MenuItem menu3Item4 = new MenuItem("Insertion de caractères spéciaux");
		MenuItem menu3Item5 = new MenuItem("Insérer des numéros de page");
		MenuItem menu3Item6 = new MenuItem("Insérer une note de bas de page");
		
		MenuItem menu4Item1 = new MenuItem("Chercher un segment de texte");
		MenuItem menu4Item2 = new MenuItem("Remplacer un segment de texte");
		MenuItem menu4Item3 = new MenuItem("Compter le nombre de mots ou de caractères dans le texte");
		MenuItem menu4Item4 = new MenuItem("Vérifier l’orthographe");
		MenuItem menu4Item5 = new MenuItem("Zoomer");
		
		menu1Item1.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				
				System.out.println("Menu Item1: "+Instant.now().toEpochMilli());
			}
		});
		
		menu1Item3.setOnAction(new EventHandler<ActionEvent>() {
			@Override 
			public void handle(ActionEvent e) {
				
				System.out.println("Menu Item2: "+Instant.now().toEpochMilli());
			}
		});
		
		menu1.getItems().add(menu1Item1);
		menu1.getItems().add(menu1Item2);
		menu1.getItems().add(menu1Item3);
		menu1.getItems().add(menu1Item4);
		menu1.getItems().add(menu1Item5);
		menu1.getItems().add(menu1Item6);
		
		menu2.getItems().add(menu2Item1);
		menu2.getItems().add(menu2Item2);
		menu2.getItems().add(subMenu2);
		menu2.getItems().add(subMenu21);
		menu2.getItems().add(menu2Item3);

		subMenu2.getItems().add(subMenu2Item1);
		subMenu2.getItems().add(subMenu2Item2);
		subMenu2.getItems().add(subMenu2Item3);
		
		subMenu21.getItems().add(subMenu21Item1);
		subMenu21.getItems().add(subMenu21Item2);
		subMenu21.getItems().add(subMenu21Item3);
		
		menu3.getItems().add(menu3Item1);
		menu3.getItems().add(menu3Item2);
		menu3.getItems().add(menu3Item3);
		menu3.getItems().add(menu3Item4);
		menu3.getItems().add(menu3Item5);
		menu3.getItems().add(menu3Item6);
		
		menu4.getItems().add(menu4Item1);
		menu4.getItems().add(menu4Item2);
		menu4.getItems().add(menu4Item3);
		menu4.getItems().add(menu4Item4);
		menu4.getItems().add(menu4Item5);
		
		menuBar.getMenus().add(menu1);
		menuBar.getMenus().add(menu2);
		menuBar.getMenus().add(menu3);
		menuBar.getMenus().add(menu4);
		menuBar.getMenus().add(menu5);
		
		Label label1 = new Label("Bonjour!!");
		TextArea txtarea= new TextArea();
		VBox vbox = new VBox(menuBar,label1,txtarea);
		
		Scene scene = new Scene(vbox);
		primaryStage.setScene(scene);

		
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
	
}
