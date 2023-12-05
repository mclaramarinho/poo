package BancoQuestoes;

public class QuestaoRespostaProporcional extends QuestaoObjetiva{
	private int percentItemA, percentItemB, percentItemC;
	private char itemSelecionado;
	
	public QuestaoRespostaProporcional(String enunciado, String itemA, String itemB, String itemC, double notaPadrao, int percentItemA, int percentItemB, int percentItemC) throws AnswerDoesNotExist{
		super(enunciado, itemA, itemB, itemC, notaPadrao);
		if(percentItemA != 25 && percentItemA != 50 && percentItemA != 100) {
			throw new AnswerDoesNotExist();
		}
		this.percentItemA = percentItemA;
		if(percentItemB != 25 && percentItemB != 50 && percentItemB != 100) {
			throw new AnswerDoesNotExist();
		}
		this.percentItemB = percentItemB;
		if(percentItemC != 25 && percentItemC != 50 && percentItemC != 100) {
			throw new AnswerDoesNotExist();
		}
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
		
		return this.notaObtida = Math.round(avaliacao * 100.0) / 100.0;
	}
	
	public String mostrarQuestaoSemResposta() {
		return("*** Questão de Resposta Proporcional ***"
				+ "\nNúmero: " + this.getIdQuestao()
				+ "\nEnunciado: " + this.getEnunciado()
				+ "\n\nA - " + this.getItemA()
				+ "\nB - " + this.getItemB()
				+ "\nC - " + this.getItemC()
				+ "\n\nNota da questão: " + this.getNotaPadrao()
				);
	}
	
	@Override
	public String toString() {
		return("*** Questão de Resposta Proporcional ***"
				+ "\nNúmero: " + this.getIdQuestao()
				+ "\nEnunciado: " + this.getEnunciado()
				+ "\n\nA - " + this.getItemA() + " " + this.percentItemA + "%"
				+ "\nB - " + this.getItemB() + " " + this.percentItemB + "%"
				+ "\nC - " + this.getItemC() + " " + this.percentItemC + "%"
				+ "\n\nNota da questão: " + this.getNotaPadrao()
				);
				
	}
}
