package com.tele.evluation.uma.controlers;

import java.net.URL;
import java.util.ResourceBundle;

import com.tele.evluation.uma.model.view.TableQuestion;
import com.tele.evluation.uma.model.view.TableQuestionaire;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class EpreuveControler implements Initializable {

	@FXML
	private TableView<TableQuestion> tableAnswer;
	
	@FXML
	private TableView<TableQuestionaire> tableQuestion;
	
	@FXML
	private TableColumn<TableQuestion, Integer> tableNColom;
	
	@FXML
	private TableColumn<TableQuestion, CheckBox> tableAColom;
	
	@FXML
	private TableColumn<TableQuestion,CheckBox> tableBColom;
	
	@FXML
	private TableColumn<TableQuestion, CheckBox> tableCColom;
	
	@FXML
	private TableColumn<TableQuestion, CheckBox> tableDColom;
	
	@FXML
	private TableColumn<TableQuestionaire, WebView> tableImpaireColom;
	
	@FXML
	private TableColumn<TableQuestionaire, WebView> tablePaireColom;
	
	@FXML
	private Button termineComposition;
	
	@FXML
	private Label labelOfTimeOfComposition;
	@FXML
	private Label note;
	
	int i = 300;
	
	private boolean stopable = true;
	
	private ObservableList<TableQuestion> data = FXCollections.observableArrayList();
	
	private ObservableList<TableQuestionaire> dataQuestionaire = FXCollections.observableArrayList();
	
	private String [] [] Question = {
										{"Sur MongoDB, un sous document  ","admet forcément un ObjectID","peut admettre un ObjectID","l’ObjectID du sous document est l’ObjectID du document qui le contient","n’admet pas un ObjectID"},
										{"Pour définir une relation de type AMI depuis le nœud a vers le nœud b on utilise","(a:AMI:b","(a)-[:AMI]->(b) ","(a)--AMI(b)","Aucune réponse"},
										{"_______ NameNode est utilisé lorsque le NameNode primaire ne fonctionne plus","Seondaire","Data","Rack","Aucune des réponses précédentes"},
										{"L'interface __________	 réduit	un ensemble de valeurs	 intermédiaires	qui partagent une clé avec un ensemble plus petit de valeurs","Reducer","Mapper","Writable","Readable"},
										{"La machine est un point d'échec unique pour un cluster HDFS","DataNode","ActionNode","NameNode","Toutes les réponses précédentes"},
										{"Choisissez la bonne réponse :","Hadoop a besoin de matériel spécialisé pour traiter les données","Aucune des réponses suivantes","Dans le cadre de programmation Hadoop, les fichiers de sortie sont divisés en lignes ou enregistrements ","Hadoop 2.0 permet le traitement en temps réel des données en temps rée"},
										{"Mongodb est écrit en C++ et comporte un certain nombre d'outils en standard qui sont ","Le serveur, Le shell javascript (le client) et les pilotes pour les langages hôtes ","Le serveur et Le shell javascript (le client) seulement ;","Les pilotes pour les langages hôtes","Aucune réponse"},
										{"Le besoin d’application de données peut se produire dans divers scénarios comme :","Le facteur de réplication est modifié","DataNode ne fonctionne plus","Les blocs de données sont corrompus","Tous les réponses précédentes"},
										{"Lequel des éléments suivants fournit l'interface de programmation orientée objet","RDD","Trame de données","Base de données","Aucune de ces réponses"},
										{"Lesquels des éléments suivants utilisent un encodeur pour la sérialisation.","RDD","Trame de données","Base de données","Aucune de ces réponses"}
										
									};
	private String [] correction = {"b","b","a","a","c","d","a","b","ac","ac"};
	
	
	public EpreuveControler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		for (int i = 1; i <= 10; i++) {
			data.add(new TableQuestion(i, new CheckBox(), new CheckBox(), new CheckBox(), new CheckBox()));
			
		}
		tableAnswer.setItems(data);
		tableNColom.setCellValueFactory(new PropertyValueFactory<TableQuestion, Integer>("numero"));
		tableAColom.setCellValueFactory(new PropertyValueFactory<TableQuestion, CheckBox>("a"));
		tableBColom.setCellValueFactory(new PropertyValueFactory<TableQuestion, CheckBox>("b"));
		tableCColom.setCellValueFactory(new PropertyValueFactory<TableQuestion, CheckBox>("c"));
		tableDColom.setCellValueFactory(new PropertyValueFactory<TableQuestion, CheckBox>("d"));
		
		String text1 = "";
		String text2 = "";
		for (int i = 0; i < 5; i++) {
			
			text1+="<h4>"+(2*i+1)+"°) " +Question[2*i][0]+" </h4>"+
					"<p style='padding:0px 10px;'>a- " +Question[2*i][1]+" </p>"+
					"<p style='padding:0px 10px;'>b- " +Question[2*i][2]+" </p>"+
					"<p style='padding:0px 10px;'>c- " +Question[2*i][3]+" </p>"+
					"<p style='padding:0px 10px;'>d- " +Question[2*i][4]+" </p>";
					
			text2+="<h4>"+(2*(i+1))+"°) "+Question[2*i+1][0]+" </h4>"+
					"<p style='padding:0px 10px;'>a- "+Question[2*i+1][1]+"</p>"+
					"<p style='padding:0px 10px;'>b- "+Question[2*i+1][2]+"</p>"+
					"<p style='padding:0px 10px;'>c- "+Question[2*i+1][3]+"</p>"+
					"<p style='padding:0px 10px;'>d- "+Question[2*i+1][4]+"</p>";
					
		}
		
		WebView impaire = new WebView();
		WebEngine impaireEngine = impaire.getEngine();
		impaireEngine.loadContent("<html>"+text1+"</html>");
		
		WebView paire = new WebView();
		WebEngine paireEngine = paire.getEngine();
		paireEngine.loadContent("<html>"+text2+"</html>");
		
		dataQuestionaire.add(new TableQuestionaire(impaire,paire));
		tableQuestion.setItems(dataQuestionaire);
		tableImpaireColom.setCellValueFactory(new PropertyValueFactory<TableQuestionaire, WebView>("impaireQuestion"));
		tablePaireColom.setCellValueFactory(new PropertyValueFactory<TableQuestionaire, WebView>("paireQuestion"));
		
		new Thread(() -> {
			try {
				Thread.sleep(5000);
				while (i>=0&&stopable) {
					Platform.runLater(()->{
						int h = i/3600;
						int min = (i%3600)/60;
						int sec =  (i%3600)%60;
						if(min<=1)
							labelOfTimeOfComposition.setTextFill(Color.RED);
						labelOfTimeOfComposition.setText((h<10? "0"+h:h)+":"+(min<10? "0"+min:min)+":"+(sec<10? "0"+sec:sec));
						i--;
						
					});
					
					Thread.sleep(999);
				}
				Platform.runLater(()->this.evaluationTerminer());
				
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}).start();
		
		
		
	}
	
	
	@FXML
	public void compositionTerminerAction(ActionEvent e) {
		
		stopable = false;
		this.evaluationTerminer();
	}
	
	private void evaluationTerminer() {
		double noteFinale = 0;
		int i =0;
		for (TableQuestion answer : tableAnswer.getItems()) {
			noteFinale+= answer.corriger(correction[i]);
			answer.getA().setDisable(true);
			answer.getB().setDisable(true);
			answer.getC().setDisable(true);
			answer.getD().setDisable(true);
			i++;
		}
		
		note.setText("Note : "+noteFinale+" / 20");
		
		
	}
	
	

}
