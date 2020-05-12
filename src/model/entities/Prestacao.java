package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Prestacao {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	private Date dataVencimento;
	private Double montante;
	
	public Prestacao() {
		
	}

	public Prestacao(Date dataVencimento, Double montante) {
		this.dataVencimento = dataVencimento;
		this.montante = montante;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Double getMontante() {
		return montante;
	}

	public void setMontante(Double montante) {
		this.montante = montante;
	}
	
	@Override
	public String toString() {
		return sdf.format(dataVencimento) + " - " + String.format("%.2f", montante);
	}
	
	
}
