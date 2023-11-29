package BancoQuestoes;

public class QuestaoVerdadeiroFalso extends QuestaoObjetiva {
	private char itemCorretoA, itemCorretoB, itemCorretoC, itemSelecionadoA, itemSelecionadoB, itemSelecionadoC;
	
	public QuestaoVerdadeiroFalso(String enunciado, String itemA, String itemB, String itemC, double notaPadrao, char itemCorretoA, char itemCorretoB, char itemCorretoC) throws AnswerDoesNotExist {
		super(enunciado, itemA, itemB, itemC, notaPadrao);
		if(itemCorretoA != 'V' && itemCorretoA != 'F') {
			throw new AnswerDoesNotExist();
		}
		this.itemCorretoA = itemCorretoA;
		if(itemCorretoB != 'V' && itemCorretoB != 'F') {
			throw new AnswerDoesNotExist();
		}
		this.itemCorretoB = itemCorretoB;
		if(itemCorretoC != 'V' && itemCorretoC != 'F') {
			throw new AnswerDoesNotExist();
		}
		this.itemCorretoC = itemCorretoC;
	}
	
	
	public void responder(char letraItem, char respostaSelecionada) {
		switch(letraItem) {
			case 'A':
				this.itemSelecionadoA = respostaSelecionada;
				break;
			case 'B':
				this.itemSelecionadoB = respostaSelecionada;
				break;
			
			case 'C':
				this.itemSelecionadoC = respostaSelecionada;
				break;
		}
	}
	
	public double avaliar() {
		double avaliacao = 0;
		
		if(this.itemCorretoA == this.itemSelecionadoA) {
			avaliacao += this.getNotaPadrao() / 3;
		}else if(this.itemCorretoB == this.itemSelecionadoB) {
			avaliacao += this.getNotaPadrao() / 3;
		}else if(this.itemCorretoC == this.itemSelecionadoC) {
			avaliacao += this.getNotaPadrao() / 3;
		}
		
		return this.notaObtida = avaliacao;
	}
	
}
