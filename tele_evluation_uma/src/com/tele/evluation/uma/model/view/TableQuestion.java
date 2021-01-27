package com.tele.evluation.uma.model.view;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javafx.scene.control.CheckBox;

public class TableQuestion {

	private int numero;

	private CheckBox a;

	private CheckBox b;

	private CheckBox c;

	private CheckBox d;

	public TableQuestion() {
		// TODO Auto-generated constructor stub
	}

	public TableQuestion(int numero, CheckBox a, CheckBox b, CheckBox c, CheckBox d) {
		super();
		this.numero = numero;
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	/**
	 * @return the numero
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * @param numero the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return the a
	 */
	public CheckBox getA() {
		return a;
	}

	/**
	 * @param a the a to set
	 */
	public void setA(CheckBox a) {
		this.a = a;
	}

	/**
	 * @return the b
	 */
	public CheckBox getB() {
		return b;
	}

	/**
	 * @param b the b to set
	 */
	public void setB(CheckBox b) {
		this.b = b;
	}

	/**
	 * @return the c
	 */
	public CheckBox getC() {
		return c;
	}

	/**
	 * @param c the c to set
	 */
	public void setC(CheckBox c) {
		this.c = c;
	}

	/**
	 * @return the d
	 */
	public CheckBox getD() {
		return d;
	}

	/**
	 * @param d the d to set
	 */
	public void setD(CheckBox d) {

		this.d = d;
	}

	public double corriger(String reponse) {

		if (!this.a.isSelected() && !this.b.isSelected() && !this.c.isSelected() && !this.d.isSelected())
			return 0;
		if(isCorrect(reponse))
			return 2;

		return -0.5;
	}

	private boolean isCorrect(String bonneReponse) {
		Class<? extends TableQuestion> table = (Class<? extends TableQuestion>) this.getClass();
		bonneReponse = bonneReponse.toUpperCase();
		String br = "ABCD";
		boolean result = true;
		for(int i =0;i<br.length();i++) {
			try {
				Method methode = table.getDeclaredMethod("get"+br.charAt(i));
				CheckBox box = (CheckBox) methode.invoke(this);
				if((box.isSelected()&&!bonneReponse.contains(""+br.charAt(i))) || (!box.isSelected()&&bonneReponse.contains(""+br.charAt(i))))
					result = false;
				if((box.isSelected()&&bonneReponse.contains(""+br.charAt(i))))
					box.setStyle("-fx-border-color : green;");
				else if((box.isSelected()&&!bonneReponse.contains(""+br.charAt(i))))
					box.setStyle("-fx-border-color : red;");
				
			} catch (NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
