package Editora;
import java.util.ArrayList;
public class Revista {
	private int codigo;
	private String titulo;
	private int reciclagemProduzida;
	private ArrayList<Edicao> listaEdicoes;
	
	public Revista(int codigo, String titulo) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.reciclagemProduzida = 0;
		this.listaEdicoes = new ArrayList<Edicao>();
	}
	
	public void adicionaEdicao(int numeroEdicao, int tiragem) {
		this.listaEdicoes.add(new Edicao(numeroEdicao, tiragem));
	}
	public void removeEdicao(Edicao edicao) {
		for(Edicao e : this.listaEdicoes) {
			if(e == edicao) {
				this.listaEdicoes.remove(edicao);
			}
		}
	}
	public String reciclaEdicao(int numeroEdicao) {
		String retorno = "";
		for(Edicao e : this.listaEdicoes) {
			if(e.getNumeroEdicao() == numeroEdicao) {
				if((e.obtemReciclagem() > 0) && (!e.getReciclou())) {
					this.reciclagemProduzida += e.obtemReciclagem();
					retorno = "Reciclagem realizada.";
					e.reciclaExemplares();
				}else if(e.getTiragem() - e.getQtdeVendida() <= 0) {
					retorno = "Não houve exemplares para reciclar.";
				}else if(e.getReciclou()) {
					retorno = "Edição já reciclada.";
				}
				break;
			}
		}
		if(retorno.equals("")) {
			retorno = "Edição não encontrada.";
		}
		return retorno;
	}
	 
	public ArrayList<Edicao> getListaEdicoes(){
		return this.listaEdicoes;
	}
	public int getReciclagemProduzida() {
		return this.reciclagemProduzida;
	}
}
