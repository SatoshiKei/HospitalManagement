package unidade;



import java.util.Date;

import unidade.Constantes.EquipType;

public class Equipamento {
	
	private EquipType type;
	private Date vidaUtil;
	private boolean funcionando;
	private int price;
	
	public Equipamento (EquipType type) {
		this.type = type;
		vidaUtil = new Date((long) ((Constantes.vidaUtil[type.ordinal()]) * 365 * 24 * 60 * 60 * 1000) + System.currentTimeMillis());
		this.funcionando = true;
		this.price = Constantes.eqPrice[type.ordinal()];
	}
	
	public EquipType getType() {
		return this.type;
	}
	public Date getVidaUtil() {
		return this.vidaUtil;
	}
	public boolean funcionando() {
		return this.funcionando;
	}
	public int getPrice() {
		return this.price;
	}
	


}
