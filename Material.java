package unidade;

import unidade.Constantes.MatType;

public class Material {
	
	private MatType type; //Tipo do Material
	private boolean usado; //True se o Material já foi consumido
	private int quantidade; //Total de Unidades do Material em um Conjunto/Kit
	private int price; //Preço total do Conjunto/Kit
	
	public Material(MatType type) {
		this.type = type;
		this.usado = false;
		this.quantidade = Constantes.qntMat[type.ordinal()];
		this.price = Constantes.matPrice[type.ordinal()];
	}
	
	public void use () {
		quantidade--;
		if (quantidade == 0) usado = true;
	}
	
	public MatType getType () {
		return this.type;
	}
	public boolean usado() {
		return this.usado;
	}
	public int getQnt() {
		return this.quantidade;
	}
	public int getPrice() {
		return this.price;
	}

}
