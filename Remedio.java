package unidade;

import java.util.Date;

import unidade.Constantes.MedType;

public class Remedio {
	
	private MedType type;
	private Date validade;
	private int doses;
	private int price;
	
	public Remedio(MedType type) {
		this.type = type;
		validade = new Date((long) ((Constantes.validade[type.ordinal()]) * 365 * 24 * 60 * 60 * 1000) + System.currentTimeMillis());
	}
	
	public MedType getType() {
		return this.type;
	}
	public Date getValidade() {
		return this.validade;
	}
	public int getDoses() {
		return this.doses;
	}
	public int getPrice() {
		return this.price;
	}

}
