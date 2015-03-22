package com.fuzzycontrol.core.fuzzy

import net.sourceforge.jFuzzyLogic.membership.MembershipFunctionTrapetzoidal
import net.sourceforge.jFuzzyLogic.membership.MembershipFunctionTriangular
import spock.lang.Specification

import com.fuzzycontrol.core.controller.base.FuzzyControlInterface
import com.fuzzycontrol.core.controller.fuzzy.FuzzyController
import com.fuzzycontrol.core.model.fuzzy.FuzzyCoordinate
import com.fuzzycontrol.core.model.fuzzy.FuzzyTerm
import com.fuzzycontrol.core.model.fuzzy.enums.MembershipFunctionEnum
import com.fuzzycontrol.core.model.fuzzy.enums.VariableType
import com.fuzzycontrol.core.model.fuzzy.exception.InvalidParametersSizeException
import com.fuzzycontrol.core.model.fuzzy.exception.MembershipFunctionInstantiationException
import com.fuzzycontrol.core.model.fuzzy.put.Input

class FuzzyControllerSpec extends Specification {
	
	FuzzyControlInterface controller
	
	def setup() {
		controller = new FuzzyController()
	}
	
	/**
	 * @Method: createMembershipFunction(...)
	 */
	
	/*@Scenario: Instanciando a função de pertinência TRIANGULAR*/
	void "deve instanciar funções de pertinência TRIANGULAR"() {
		when:
			def function = controller.createMembershipFunction(MembershipFunctionEnum.TRIANGULAR, toCoordinate([1:0, 1.5:1, 2:0]))
		then:
			function instanceof MembershipFunctionTriangular
			function.getParameter(0) == 1
			function.getParameter(1) == 1.5
			function.getParameter(2) == 2
	}
	
	void "deve falhar quando a quantidade de parâmentros for diferente da espearada"() {
		when:"informar um quantidade inferior de parâmetros"
			controller.createMembershipFunction(MembershipFunctionEnum.TRIANGULAR, toCoordinate([1:0, 1.5:1]))
		then:
			thrown(InvalidParametersSizeException)
			
		when:"informar um quantidade superior de parâmetros"
			controller.createMembershipFunction(MembershipFunctionEnum.TRIANGULAR, toCoordinate([1:0, 1.5:1, 2:0, 3:1]))
		then:
			thrown(InvalidParametersSizeException)
	}
	
	void "deve falhar quando houver qualquer erro na instanciação da função de pertinência"() {
		when:"o valor min do triangulo for mair que o valor mid"
			controller.createMembershipFunction(MembershipFunctionEnum.TRIANGULAR, toCoordinate([1.5:0, 1:1, 2:0]))
		then:
			thrown(MembershipFunctionInstantiationException)
	}
	
	/*@Scenario: Instanciando a função de pertinência TRAPEZOIDAL*/
	void "deve instanciar funções de pertinência TRAPEZOIDAL"() {
		when:
			def function = controller.createMembershipFunction(MembershipFunctionEnum.TRAPETZOIDAL, toCoordinate([1:0, 1.5:0, 2:1, 2.5:1]))
		then:
			function instanceof MembershipFunctionTrapetzoidal
			function.getParameter(0) == 1
			function.getParameter(1) == 1.5
			function.getParameter(2) == 2
			function.getParameter(3) == 2.5
	}

	void "deve falhar quando a quantidade de parâmentros for diferente da espearada para funções TRAPEZOIDAIS"() {
		when:"informar um quantidade inferior de parâmetros"
			controller.createMembershipFunction(MembershipFunctionEnum.TRAPETZOIDAL, toCoordinate([1:0, 1.5:1, 2:0]))
		then:
			thrown(InvalidParametersSizeException)
			
		when:"informar um quantidade superior de parâmetros"
			controller.createMembershipFunction(MembershipFunctionEnum.TRAPETZOIDAL, toCoordinate([1:0, 1.5:1, 2:0, 3:1, 3.5:1]))
		then:
			thrown(InvalidParametersSizeException)
	}
	
	/**
	 * @Method: createTerm(...)
	 */
	
	/*@Scenario: Criando um termo linguístico*/
	void "deve criar termos linguisticos"() {
		when:
			def term = controller.createTerm(new FuzzyTerm("BAIXA", MembershipFunctionEnum.TRIANGULAR, toCoordinate([1:0, 1.5:1, 2:0])))
		then:
			term.termName == "BAIXA"
			term.membershipFunction instanceof MembershipFunctionTriangular	
	}
	
	/**
	 * @Method: createInput(...)
	 */
	
	/*@Scenario: Criando uma variável linguística a partir de um Input*/
	void "deve criar uma variável linguística"() {
		given:
			def termBAIXA = new FuzzyTerm("BAIXA", MembershipFunctionEnum.TRIANGULAR, toCoordinate([1:0, 1.5:1, 2:0]))
			def termMEDIA = new FuzzyTerm("MEDIA", MembershipFunctionEnum.TRIANGULAR, toCoordinate([1.5:0, 2:1, 2.5:0]))
		when:
			def variable = controller.createInput(new Input("Temperatura", VariableType.REAL, [termBAIXA, termMEDIA]))
		then:
			variable.input
			variable.name == "Temperatura"
			variable.linguisticTerms.size() == 2
	}
	
	void "deve substituir um termo caso já existe algum com a mesma descrição"() {
		given:
			def term1 = new FuzzyTerm("BAIXA", MembershipFunctionEnum.TRIANGULAR, toCoordinate([1:0, 1.5:1, 2:0]))
			def term2 = new FuzzyTerm("BAIXA", MembershipFunctionEnum.TRIANGULAR, toCoordinate([1.5:0, 2:1, 2.5:0]))
		when:
			def variable = controller.createInput(new Input("Temperatura", VariableType.REAL, [term1, term2]))
		then:
			variable.input
			variable.name == "Temperatura"
			variable.linguisticTerms.size() == 1
		and:"as coordenadas correspondem às do termo inserido por último"
			variable.linguisticTerms["BAIXA"].membershipFunction.getParameter(0) == 1.5
			variable.linguisticTerms["BAIXA"].membershipFunction.getParameter(1) == 2
			variable.linguisticTerms["BAIXA"].membershipFunction.getParameter(2) == 2.5
	}
	
	/*Helper Methods*/
	
	def toCoordinate(params) {
		def coordinates = []
		params.each { key, value ->
			coordinates.add(new FuzzyCoordinate(key, value))
		}
		return coordinates
	}

}