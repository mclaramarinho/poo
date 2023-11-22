package Consumo;

import java.util.Date;
public class Consumo {
	private int idAnterior = 0;
	private int idConsumo;
	private Date data;
	private char tipoConsumo;
	private char tipoCliente;
	private double valorConsumo;
	private double valorConta;
	
	//Constructors
	public Consumo(double valorConsumo) {
		do {
			this.idConsumo = (int)(Math.random()*1000);
		}while(idConsumo == idAnterior);
		this.idAnterior = this.idConsumo;
		this.data = new Date();
		this.tipoConsumo = 'C';
		this.tipoCliente = 'P';
		this.valorConsumo = valorConsumo;
		fechaConta(this.valorConsumo);
	}
	
	public Consumo(double valorConsumo, char tipoCliente) {
		this.idConsumo = (int)(Math.random()*1000);
		this.idAnterior = this.idConsumo;
		this.data = new Date();
		this.tipoConsumo = 'P';
		this.tipoCliente = tipoCliente;
		this.valorConsumo = valorConsumo;
		fechaConta(this.valorConsumo, this.tipoCliente);
	}
	
	//Methods
	private void fechaConta(double valorConsumo) {
		this.valorConta = valorConsumo * 1.1;
	}
	private void fechaConta(double valorConsumo, char tipoCliente) {
		if(tipoCliente == 'F') {
			this.valorConta = valorConsumo - 10;
		}else if(tipoCliente == 'A') {
			if(valorConsumo <= 30) {
				this.valorConta = valorConsumo - 3;
			}else {
				this.valorConta = valorConsumo - 5;
			}
		}else {
			this.valorConta = valorConsumo;
		}
	}
	
	@Override
	public String toString() {
		return String.format("ID Consumo: %d %nData: %t %nTipo Consumo: %c%nTipo Cliente: %c%nValor Consumo: R$%.2f %nValor Conta: R$%.2f", this.idConsumo, this.data.toString(), this.tipoConsumo, this.tipoCliente, this.valorConsumo, this.valorConta);
	}

}
