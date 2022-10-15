package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService service = new BonusService();
		Funcionario funcionario = new Funcionario("César", LocalDate.now(), new BigDecimal("25000"));
		
		//assertThrows(IllegalArgumentException.class, () -> service.calcularBonus(funcionario));
		
		try {
			service.calcularBonus(funcionario);
			fail("Não ocorreu a exception esperada!");
		} catch (Exception e){
			assertEquals("Funcionário com salário acima de R$ 10000 não pode receber bônus!", e.getMessage());;
		}
	}
	
	@Test
	void bonusDeveriaSer10PorCentoDoSalario() {
		
		BonusService service = new BonusService();
		
		Funcionario funcionario = new Funcionario("César", LocalDate.now(), new BigDecimal("2500"));
		
		BigDecimal bonus = service.calcularBonus(funcionario);
		
		assertEquals(new BigDecimal("250.00"), bonus);
	}
	
	@Test
	void bonusDeveriaSer10PorCentoParaSalarioDeExatamente10000() {
		
		BonusService service = new BonusService();
		
		Funcionario funcionario = new Funcionario("César", LocalDate.now(), new BigDecimal("10000"));
		
		BigDecimal bonus = service.calcularBonus(funcionario);
		
		assertEquals(new BigDecimal("1000.00"), bonus);
	}

}
