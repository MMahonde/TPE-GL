package com.tele.evluation.uma.model.view;

import javafx.scene.web.WebView;

public class TableQuestionaire {
	private WebView impaireQuestion;
	
	private WebView paireQuestion;
	

	public TableQuestionaire() {
		// TODO Auto-generated constructor stub
	}


	public TableQuestionaire(WebView impaireQuestion, WebView paireQuestion) {
		super();
		this.impaireQuestion = impaireQuestion;
		this.paireQuestion = paireQuestion;
	}


	/**
	 * @return the impaireQuestion
	 */
	public WebView getImpaireQuestion() {
		return impaireQuestion;
	}


	/**
	 * @param impaireQuestion the impaireQuestion to set
	 */
	public void setImpaireQuestion(WebView impaireQuestion) {
		this.impaireQuestion = impaireQuestion;
	}


	/**
	 * @return the paireQuestion
	 */
	public WebView getPaireQuestion() {
		return paireQuestion;
	}


	/**
	 * @param paireQuestion the paireQuestion to set
	 */
	public void setPaireQuestion(WebView paireQuestion) {
		this.paireQuestion = paireQuestion;
	}

	
}
