package BancoQuestoes;

public abstract class QuestaoObjetiva implements IQuestao{
	private static int ultimoId = 0;
	private int idQuestao;
	private String enunciado, itemA, itemB, itemC;
	private double notaPadrao;
	protected double notaObtida;
	
	public QuestaoObjetiva(String enunciado, String itemA, String itemB, String itemC, double notaPadrao) {
		this.enunciado = enunciado;
		this.itemA = itemA;
		this.itemB = itemB;
		this.itemC = itemC;
		this.notaPadrao = notaPadrao;
		
		this.idQuestao = ++ultimoId;
	}
	
	public int getIdQuestao() {
		return this.idQuestao;
	}
	
	public String getEnunciado() {
		return this.enunciado;
	}
	public String getItemA() {
		return this.itemA;
	}
	public String getItemB() {
		return this.itemB;
	}
	public String getItemC() {
		return this.itemC;
	}
	
	public double getNotaPadrao() {
		return this.notaPadrao;
	}
	public double getNotaObtida() {
		return this.notaObtida;
	}
}
