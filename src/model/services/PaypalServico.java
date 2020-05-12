package model.services;

public class PaypalServico implements PagamentoOnlineServico {

	@Override
	public Double jurosMes(Double montante) {
		return montante*0.01;
	}

	@Override
	public Double jurosPagamento(Double montante) {
		return montante*0.02;
	}

}
