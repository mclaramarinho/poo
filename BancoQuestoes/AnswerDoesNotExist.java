package BancoQuestoes;
import java.util.*;
public class AnswerDoesNotExist extends Exception{
	@Override
	public String getMessage() {
		return "Resposta indicada não existe!";
	}
	
	
}
