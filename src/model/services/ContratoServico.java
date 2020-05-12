package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contrato;
import model.entities.Prestacao;

public class ContratoServico {
	
	private PagamentoOnlineServico pagamentoOnlineServico;

	public ContratoServico(PagamentoOnlineServico pagamentoOnlineServico) {
		this.pagamentoOnlineServico = pagamentoOnlineServico;
	}
	
	public void processarContrato(Contrato contrato, int meses) {
		double valorBase = contrato.getValorTotal() / meses;
		
		for (int i = 1; i <= meses; i++) {
			Date data = addMes(contrato.getData(), i);
			double valorAtualizado = valorBase + pagamentoOnlineServico.jurosMes(valorBase)*i;
			double valorFinal = valorAtualizado + pagamentoOnlineServico.jurosPagamento(valorAtualizado);
			contrato.adicionarPrestacao(new Prestacao(data, valorFinal));
			
		}
		
	}
	
	private Date addMes(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}
	
	

}
