package BancoQuestoes;

public class App {
	public static void main (String [] args) {
		QuestaoMultiplaEscolha me = null;
		try {
			me = new QuestaoMultiplaEscolha("enunciado", "item a", "item b", "item c", 2.0, 'C');
			
		} catch (AnswerDoesNotExist e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		me.responder('C');
		me.avaliar();
		System.out.println(me.getNotaObtida());
		
		QuestaoVerdadeiroFalso vf = null;
		
		try {
			vf = new QuestaoVerdadeiroFalso("enunciado vf", "item a vf", "item b vf", "item c vf", 3.0, 'V', 'F', 'F');
		}catch(AnswerDoesNotExist e) {
			System.out.println(e.getMessage());
		}
		System.out.println(vf.getEnunciado());
	}
}
