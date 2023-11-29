package BancoQuestoes;

public class QuestaoRespostaProporcional extends QuestaoObjetiva{
	private int percentItemA, percentItemB, percentItemC;
	private char itemSelecionado;
	
	public QuestaoRespostaProporcional(String enunciado, String itemA, String itemB, String itemC, double notaPadrao, int percentItemA, int percentItemB, int percentItemC) {
		super(enunciado, itemA, itemB, itemC, notaPadrao);
		this.percentItemA = percentItemA;
		this.percentItemB = percentItemB;
		this.percentItemC = percentItemC;
	}
	
	public void responder(char itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
	}
	
	public double avaliar() {
		double avaliacao = 0;
		
		switch(this.itemSelecionado) {
		case 'A':
			avaliacao = (this.getNotaPadrao() * this.percentItemA) / 100;
			break;
		case 'B':
			avaliacao = (this.getNotaPadrao() * this.percentItemB) / 100;
			break;
		case 'C':
			avaliacao = (this.getNotaPadrao() * this.percentItemC) / 100;
			break;
		}
		
		return this.notaObtida = avaliacao;
	}
	
}
