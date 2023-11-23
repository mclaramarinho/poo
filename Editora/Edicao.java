package Editora;
import java.util.Date;
public class Edicao {
	private int numeroEdicao;
	private Date data;
	private int tiragem; //no. de exemplares
	private int qtdeVendida;
	private boolean reciclou;
	
	public Edicao(int numeroEdicao, int tiragem) {
		this.numeroEdicao = numeroEdicao;
		this.tiragem = tiragem;
		this.data = new Date();
		this.qtdeVendida = 0;
		this.reciclou = false;
	}
	
	
	public void informaVenda(int qtdeVendida) {
		this.qtdeVendida = qtdeVendida;
	}
	public void reciclaExemplares() {
		this.reciclou = true;
	}
	public int obtemReciclagem() {
		return this.tiragem - this.qtdeVendida;
	}
	
	
	
	
	//getters e setters
	public int getNumeroEdicao() {
		return numeroEdicao;
	}

	public Date getData() {
		return data;
	}

	public int getTiragem() {
		return tiragem;
	}

	public int getQtdeVendida() {
		return qtdeVendida;
	}

	public boolean getReciclou() {
		return reciclou;
	}
	
	
}
