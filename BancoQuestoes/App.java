package BancoQuestoes;

import java.util.Scanner;

public class App {
	
		static Scanner sc = new Scanner(System.in);

		static QuestaoMultiplaEscolha questaoME = null;
		static QuestaoVerdadeiroFalso questaoVF = null;
		static QuestaoRespostaProporcional questaoRP = null;

		public static void main(String[] args) {
			
			int opcao = 0;
			do {
				System.out.println("\n*** Seletor de Opções ***\n");
				System.out.println("1 - Criar questão de múltipla escolha");
				System.out.println("2 - Criar questão de verdadeiro ou falso");
				System.out.println("3 - Criar questão de resposta proporcional");
				System.out.println("4 - Responder a questão de múltipla escolha");
				System.out.println("5 - Responder a questão de verdadeiro ou falso");
				System.out.println("6 - Responder a questão de resposta proporcional");			
				System.out.println("0 - Finalizar");
				System.out.print("\nOpção: ");
				opcao = sc.nextInt();
				
				switch (opcao) {
				case 1: 
					criarQuestaoME();
					break;
				case 2: 
					criarQuestaoVF();
					break;
				case 3: 
					criarQuestaoRP();
					break;
				case 4: 
					responderQuestaoME();
					break;
				case 5: 
					responderQuestaoVF();
					break;
				case 6: 
					responderQuestaoRP();
					break;
				case 0: 
					break;
				default:
					System.out.println("Opção inválida");
				}
				if (opcao == 0) {
					break;
				}
			} while (true);
			System.out.println("Programa finalizado");
			sc.close();
		}
		
	
		public static void criarQuestaoME() {
			sc.nextLine();
			if(questaoME != null) {
				return;
			}else {
				System.out.flush();
				System.out.println("Digite o enunciado da questão: ");
				String enunciado = sc.nextLine();
				
				System.out.println("Digite a alternativa A: ");
				String itemA = sc.nextLine();
				System.out.println("Digite a alternativa B: ");
				String itemB = sc.nextLine();
				System.out.println("Digite a alternativa C: ");
				String itemC = sc.nextLine();
				
				System.out.println("Digite a alternativa correta: ");
				char itemCorreto = sc.next().charAt(0);
				
				System.out.println("Digite a nota máxima da questão: ");
				double notaPadrao = sc.nextDouble();
				
				try {
					questaoME = new QuestaoMultiplaEscolha(enunciado, itemA, itemB, itemC, notaPadrao, itemCorreto);
					System.out.println(questaoME.toString());
				}catch(AnswerDoesNotExist err) {
					System.out.println(err.getMessage());
				}catch(Exception err) {
					System.out.println(err.getMessage());
				}
			}
		}
		
		public static void criarQuestaoVF() {
			sc.nextLine();
			if(questaoVF != null) {
				return;
			}else {
				System.out.flush();
				System.out.println("Digite o enunciado da questão: ");
				String enunciado = sc.nextLine();
			
				System.out.println("Digite o item A: ");
				String itemA = sc.nextLine();
				System.out.println("Digite a resposta correta do item A: ");
				char itemCorretoA = sc.next().charAt(0); 
				sc.nextLine();
				
				System.out.println("Digite o item B: ");
				String itemB = sc.nextLine();
				sc.nextLine();
				System.out.println("Digite a resposta correta do item B: ");
				char itemCorretoB = sc.next().charAt(0);
				sc.nextLine();
				
				System.out.println("Digite o item C: ");
				String itemC = sc.nextLine();
				sc.nextLine();
				System.out.println("Digite a resposta correta do item C: ");
				char itemCorretoC = sc.next().charAt(0);
				sc.nextLine();
				
				System.out.println("Digite a nota máxima da questão: ");
				double notaPadrao = sc.nextDouble();
				
				try {
					questaoVF = new QuestaoVerdadeiroFalso(enunciado, itemA, itemB, itemC, notaPadrao, itemCorretoA, itemCorretoB, itemCorretoC);
					System.out.println(questaoVF.toString());
				}catch(AnswerDoesNotExist err) {
					System.out.println(err.getMessage());
				}catch(Exception err) {
					System.out.println(err.getMessage());
				}
			}
		}

		public static void criarQuestaoRP() {
			sc.nextLine();
			if(questaoRP != null) {
				return;
			}else {
				System.out.flush();
				System.out.println("Digite o enunciado da questão: ");
				String enunciado = sc.nextLine();
				
				System.out.println("Digite o item A: ");
				String itemA = sc.nextLine();
				System.out.println("Digite o percentual do item A: ");
				int pItemA = sc.nextInt();
				sc.nextLine();
				
				System.out.println("Digite o item B: ");
				String itemB = sc.nextLine();
				System.out.println("Digite o percentual do item B: ");
				int pItemB = sc.nextInt();
				sc.nextLine();
				
				System.out.println("Digite o item C: ");
				String itemC = sc.nextLine();
				System.out.println("Digite o percentual do item C: ");
				int pItemC = sc.nextInt();
				sc.nextLine();
				
				System.out.println("Digite a nota máxima da questão: ");
				double notaPadrao = sc.nextDouble();
				
				try {
					questaoRP = new QuestaoRespostaProporcional(enunciado, itemA, itemB, itemC, notaPadrao, pItemA, pItemB, pItemC);
					System.out.println(questaoRP.toString());
				}catch(AnswerDoesNotExist err) {
					System.out.println(err.getMessage());
				}catch(Exception err) {
					System.out.println(err.getMessage());
				}
			}
		}
		
		public static void responderQuestaoME() {
			sc.nextLine();
			if(questaoME == null) {
				System.out.println("Questão ainda não criada!");
				return;
			}else {
				System.out.println(questaoME.mostrarQuestaoSemResposta());
				
				while(true) {
					System.out.println("Insira a resposta para a questão acima: ");
					char res = sc.next().charAt(0);
					
					if(res != 'A' && res != 'B' && res != 'C' ) {
						System.out.println("Resposta inválida! A resposta deve ser A/B/C.");
					}else {
						System.out.println("Respondendo...");
						questaoME.responder(res);
						break;
					}
				}
				System.out.println("Questão respondida com sucesso!");
				System.out.println("Nota obtida: " + questaoME.avaliar());
			}
		}	

		public static void responderQuestaoVF() {
			sc.nextLine();
			if(questaoVF == null) {
				System.out.println("Questão ainda não criada!");
				return;
			}else {
				System.out.println(questaoVF.mostrarQuestaoSemResposta());
				
				for(int i = 0; i < 3; i++) {
					char itemAtual = (i == 0 ? 'A' : i == 1 ? 'B' : 'C');
					while(true) {
						System.out.printf("\nInsira a resposta para o item %c: ", itemAtual);
						char res = sc.next().charAt(0);
						System.out.println();
						
						if(res != 'V' && res != 'F') {
							System.out.println("Resposta inválida! Respostas válidas: V ou F.");
						}else {
							System.out.println("Respondendo...");
							questaoVF.responder(itemAtual, res);
							break;
						}
					}
				}
				System.out.println("Questão respondida com sucesso!");
				
				System.out.println("Nota obtida: " + questaoVF.avaliar());
			}
		}	

		public static void responderQuestaoRP() {
			sc.nextLine();
			if(questaoRP == null) {
				System.out.println("Questão ainda não criada!");
				return;
			}else {
				System.out.println(questaoRP.mostrarQuestaoSemResposta());
				
				while(true) {
					System.out.println("Insira a resposta para a questão acima: ");
					char res = sc.next().charAt(0);
					
					if(res != 'A' && res != 'B' && res != 'C' ) {
						System.out.println("Resposta inválida! A resposta deve ser A/B/C.");
					}else {
						System.out.println("Respondendo...");
						questaoRP.responder(res);
						break;
					}
				}
				System.out.println("Questão respondida com sucesso!");
				System.out.println("Nota obtida: " + questaoRP.avaliar());
			}
		}	
}
