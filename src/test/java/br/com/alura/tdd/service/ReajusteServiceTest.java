package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {

	private ReajusteService service;
	private Funcionario funcionario;
	
	@BeforeEach
	public void inicializar() {
		System.out.println("Inicio de cada método");
		this.service = new ReajusteService();
		this.funcionario = new Funcionario("filipe",LocalDate.now(),new BigDecimal("1000.00"));	
	}
	
	@AfterEach
	public void encerraMetodo() {
		System.out.println("Fim de cada método");
	}
	
	@BeforeAll
	public static void inicia() {
		System.out.println("inicio dos testes");
	}
	
	@AfterAll
	public static void encerra() {
		System.out.println("Fim dos testes");
	}

	@Test
	public void reajusteDeveriaSerDeTresPorCentoQuandoDesenpenhoForADesejar() {			
		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteDeveriaSerDeQuinzePorCentoQuandoDesenpenhoForBom() {				
		service.concederReajuste(funcionario, Desempenho.BOM);
		assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
	}
	
	@Test
	public void reajusteDeveriaSerDeQuinzePorCentoQuandoDesenpenhoForOtimo() {		
		service.concederReajuste(funcionario, Desempenho.OTIMO);
		assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
	}
	
}
