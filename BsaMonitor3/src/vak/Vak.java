package vak;

public class Vak {
	//constante
	final double GEHAALD_VAK = 5.5;
	
	//vars
	private String naam;
	private int punten;
	private double cijfer;
	
	//all-args constructor
	public Vak(String naam, int punten) {
		this.naam = naam;
		this.punten = punten;
	}
	
	//getter naam
	public String getNaam() {
		return this.naam;
	}
	
	//getter punten
	public int getPunten() {
		return this.punten;
	}
	
	//getter cijfer
	public double getCijfer() {
		return this.cijfer;
	}
	
	//setter cijfer
	public void setCijfer(double cijfer) {
		this.cijfer = cijfer;
	}
	
	//behavior gehaald
	public int behaaldePunten() {
		int behaaldePunten = 0;
		if (this.cijfer >= GEHAALD_VAK) {
			behaaldePunten = this.punten;
		}
		return behaaldePunten;
	}
}
