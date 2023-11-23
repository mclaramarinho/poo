package Editora;

public class App {
	static Revista rev = new Revista(1234, "Veja");
	public static void main (String [] args) {
		
		rev.adicionaEdicao(52, 1000);
		rev.adicionaEdicao(53, 900);
		rev.adicionaEdicao(54, 1200);
		
		rev.getListaEdicoes().get(0).informaVenda(800);
		rev.getListaEdicoes().get(1).informaVenda(900);
		rev.getListaEdicoes().get(2).informaVenda(1000);
		
		recicla(53);
		recicla(54);
		recicla(99);
	}
	
	public static void recicla(int edicao) {
		int i = 0;
		for(Edicao e : rev.getListaEdicoes()) {
			if(e.getNumeroEdicao() == edicao) {
				i = rev.getListaEdicoes().indexOf(e);
			}
		}
		System.out.println(rev.reciclaEdicao(edicao));
		System.out.println(rev.getListaEdicoes().get(i).getReciclou());
		System.out.println(rev.getReciclagemProduzida());
	}
}
