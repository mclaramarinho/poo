package BancoQuestoes;

public class QuestaoMultiplaEscolha extends QuestaoObjetiva{
	private char itemCorreto, itemSelecionado;
	
	public QuestaoMultiplaEscolha(String enunciado, String itemA, String itemB, String itemC, double notaPadrao, char itemCorreto) throws AnswerDoesNotExist {
		super(enunciado, itemA, itemB, itemC, notaPadrao);
		if(itemCorreto != 'A' && itemCorreto != 'B' && itemCorreto != 'C') {
			throw new AnswerDoesNotExist();
		}
		this.itemCorreto = itemCorreto;
	}
	
	public void responder(char letraItem) {
		this.itemSelecionado = letraItem;
	}
	
	public double avaliar() {
		double avaliacao = 0;
		if(this.itemSelecionado == this.itemCorreto) {
			avaliacao = this.getNotaPadrao();
		}
		
		return this.notaObtida = avaliacao;
	}
	public String mostrarQuestaoSemResposta() {
		return ("*** Questão de Múltipla Escolha ***"
				+ "\nNúmero     : " + this.getIdQuestao()
				+ "\nEnunciado  : " + this.getEnunciado()
				+ "\n\nA - " + this.getItemA()
				+ "\nB - " + this.getItemB()
				+ "\nC - " + this.getItemC()
				+ "\n\nNota da questão  : " + this.getNotaPadrao() 
				);
	}
	@Override
	public String toString() {
		
		
		return ("*** Questão de Múltipla Escolha ***"
				+ "\nNúmero     : " + this.getIdQuestao()
				+ "\nEnunciado  : " + this.getEnunciado()
				+ "\n\nA - " + this.getItemA() + (this.itemCorreto == 'A' ? " Correta" : "")
				+ "\nB - " + this.getItemB() + (this.itemCorreto == 'B' ? " Correta" : "")
				+ "\nC - " + this.getItemC() + (this.itemCorreto == 'C' ? " Correta" : "")
				+ "\n\nNota da questão  : " + this.getNotaPadrao() 
				);
	}
}
