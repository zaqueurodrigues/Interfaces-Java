package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contrato;
import model.entities.Prestacao;
import model.services.ContratoServico;
import model.services.PaypalServico;


public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Dados do contrato");
		System.out.print("Numero: ");
		int number = sc.nextInt();
		System.out.print("Data: ");
		Date date = sdf.parse(sc.next());
		System.out.print("Valor do contrato: ");
		double totalValue = sc.nextDouble();
		
		Contrato contrato = new Contrato(number, date, totalValue);
		
		System.out.print("Numero de meses: ");
		int n = sc.nextInt();
		
		ContratoServico contratoServico = new ContratoServico(new PaypalServico());
		
		contratoServico.processarContrato(contrato, n);
		
		System.out.println("Prestacoes:");
		for (Prestacao x : contrato.getPrestacoes()) {
			System.out.println(x);
		}
		
		sc.close();
	}
}