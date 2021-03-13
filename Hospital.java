package unidade;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import unidade.Constantes.EquipType;
import unidade.Constantes.MatType;
import unidade.Constantes.MedType;

public class Hospital {
	
	public enum EstoqueType {
		EQUIPAMENTO,
		MATERIAL,
		REMEDIO
	}
	
	private Map<EquipType, ArrayList<Equipamento>> estoqueEquip;
	private Map<MatType, ArrayList<Material>> estoqueMat;
	private Map<MedType, ArrayList<Remedio>> estoqueMed;
	
	private String nome;
	private int codigo;
	private int budget;
	private int saldo;
	private int vacancia;
	
	private static final int LOTE = 10;
	
	public Hospital(String nome, int codigo, int budget) {
		estoqueEquip = new HashMap<>();
		estoqueMat = new HashMap<>();
		estoqueMed = new HashMap<>();
		this.nome = nome;
		this.codigo = codigo;
		this.budget = budget;
		this.saldo = budget;
		this.vacancia = 100;
		
		for (EquipType type : EquipType.values()) {
			estoqueEquip.put(type, new ArrayList<Equipamento>());
		}
		for (MatType type : MatType.values()) {
			estoqueMat.put(type, new ArrayList<Material>());
		}
		for (MedType type : MedType.values()) {
			estoqueMed.put(type, new ArrayList<Remedio>());
		}
		
	}
	
	public String getNome() {return this.nome;}
	public int getCodigo() {return this.codigo;}
	public int getBudget() {return this.budget;}
	public int getSaldo() {return this.saldo;}
	
	public int comprarEquip(EquipType type, int quantidade) {
		int price = Constantes.eqPrice[type.ordinal()];
		if (price*quantidade > saldo || vacancia < quantidade) return 1;
		for (int i = 0; i < quantidade; i++) this.estoqueEquip.get(type).add(new Equipamento(type));
		saldo -= price*quantidade;
		vacancia -= quantidade;
		return 0;
	}
	
	public int comprarMat (MatType type, int quantidade) {
		int price = Constantes.matPrice[type.ordinal()];
		if (price*quantidade > saldo || vacancia < quantidade) return 1;
		for (int i = 0; i < quantidade; i++) this.estoqueMat.get(type).add(new Material(type));
		saldo -= price*quantidade;
		vacancia -= quantidade;
		return 0;
		
	}
	
	public int comprarMed (MedType type, int quantidade) {
		int price = Constantes.medPrice[type.ordinal()];
		if (price*quantidade > saldo || vacancia < quantidade) return 1;
		for (int i = 0; i < quantidade; i++) this.estoqueMed.get(type).add(new Remedio(type));
		saldo -= price*quantidade;
		vacancia -= quantidade;
		return 0;
	}
	
	public void monitorar() {
		
		for (EquipType type : EquipType.values()) {
			int index = 0;
			for (Equipamento equip : estoqueEquip.get(type)) {
				if (equip.getVidaUtil().before(new Date())) estoqueEquip.get(type).remove(index);
				index++;
			}
			if (estoqueEquip.get(type).size() == 0) {
				if (this.comprarEquip(type, LOTE) == 1) this.comprarEquip(type, vacancia);
			}
		}
		
		for (MatType type : MatType.values()) {
			int index = 0;
			for (Material mat : estoqueMat.get(type)) {
				if (mat.usado()) estoqueMat.get(type).remove(index);
				index++;
			}
			if (estoqueMat.get(type).size() == 0) {
				if (this.comprarMat(type, LOTE) == 1) this.comprarMat(type, vacancia);
			}
		}
		for (MedType type : MedType.values()) {
			int index = 0;
			for (Remedio med : estoqueMed.get(type)) {
				if (med.getValidade().before(new Date())) estoqueMed.get(type).remove(index);
				index++;
			}
			if (estoqueMed.get(type).size() == 0) {
				if (this.comprarMed(type, LOTE) == 1) this.comprarMed(type, vacancia);
			}
		}
		
	}
	
	
	
}
