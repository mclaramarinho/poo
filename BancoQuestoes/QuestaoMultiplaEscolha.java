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
}
