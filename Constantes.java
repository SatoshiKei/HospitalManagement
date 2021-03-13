package unidade;

public class Constantes {
	
	public enum MatType {
		CERINGA,
		MASCARA,
		LUVA,
		TESOURA,
		ALCOOL
	}
	
	public enum EquipType {
		ULTRASOM,
		RAIO_X,
		BAROMETRO,
		ESTETOSCOPIO,
		CAMA,
		REANIMADOR
	}
	
	public enum MedType {
		ANALGESICO,
		ANFETAMINA,
		ANTIACIDO,
		ANTIBIOTICO,
		ASPIRINA,
		CALMANTE,
		INSULINA
	}
	
	//Tempo de vida útil dos Equipamentos em anos
	public static int[] vidaUtil = {5,8,4,2,10,15};
	//Período de validade dos Remédios em anos
	public static int[] validade = {6,3,4,5,9,15,2};
	
	//Preço dos Equipamentos
	public static int[] eqPrice = {10000, 15000, 1000, 500, 8000, 5000};
	//Preço dos Medicamentos
	public static int[] medPrice = {50, 30, 60, 100, 25, 80};
	//Preço dos Materiais 
	public static int[] matPrice = {50, 100, 80, 150, 70};
	
	//Quantidades por Conjunto
	public static int[] qntMat = {100, 100, 100, 7, 10};
}


