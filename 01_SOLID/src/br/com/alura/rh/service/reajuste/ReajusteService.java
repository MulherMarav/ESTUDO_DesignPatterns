package br.com.alura.rh.service.reajuste;

import java.math.BigDecimal;
import java.util.List;

import br.com.alura.rh.model.Funcionario;

//SINGLE RESPONSIBILITY PRINCIPLE
//DEPENDENCY INVERSION PRINCIPLE
public class ReajusteService {
	
	//OPEN CLOSED PRINCIPLE
	//DEPENDENCY INVERSION PRINCIPLE
	private List<ValidacaoReajuste> validacoes;
	
	public ReajusteService(List<ValidacaoReajuste> validacoes) {
		this.validacoes = validacoes;
	}

	public void reajustarSalarioDoFuncionario(Funcionario funcionario, BigDecimal aumento) {
		this.validacoes.forEach(v -> v.validar(funcionario, aumento));
		
		BigDecimal salarioReajustado = funcionario.getDadosPessoais().getSalario().add(aumento); 
		funcionario.atualizarSalario(salarioReajustado);
	}

}
