package com.fuzzycontrol.core.fuzzy

import net.sourceforge.jFuzzyLogic.membership.MembershipFunctionTrapetzoidal
import net.sourceforge.jFuzzyLogic.membership.MembershipFunctionTriangular
import spock.lang.Shared
import spock.lang.Specification

import com.fuzzycontrol.core.controller.base.FuzzyControlInterface
import com.fuzzycontrol.core.controller.fuzzy.FuzzyController
import com.fuzzycontrol.core.model.fuzzy.FuzzyControl
import com.fuzzycontrol.core.model.fuzzy.FuzzyCoordinate
import com.fuzzycontrol.core.model.fuzzy.FuzzySystem
import com.fuzzycontrol.core.model.fuzzy.FuzzyTerm
import com.fuzzycontrol.core.model.fuzzy.enums.MembershipFunctionEnum
import com.fuzzycontrol.core.model.fuzzy.enums.VariableType
import com.fuzzycontrol.core.model.fuzzy.exception.InvalidParametersSizeException
import com.fuzzycontrol.core.model.fuzzy.exception.MembershipFunctionInstantiationException
import com.fuzzycontrol.core.model.fuzzy.put.Input
import com.fuzzycontrol.core.model.fuzzy.put.Output

class FuzzyControllerSpec extends Specification {
	
	FuzzyControlInterface controller
	
	@Shared
	def input, output
	
	def setup() {
		controller = new FuzzyController()
	}
	
	def setupSpec() {
		def termBAIXA = new FuzzyTerm("BAIXA", MembershipFunctionEnum.TRIANGULAR, toCoordinate([1:0, 1.5:1, 2:0]))
		def termMEDIA = new FuzzyTerm("MEDIA", MembershipFunctionEnum.TRIANGULAR, toCoordinate([1.5:0, 2:1, 2.5:0]))
		input = new Input("Temperatura", VariableType.REAL, [termBAIXA, termMEDIA])
		
		def termBOM = new FuzzyTerm("BOM", MembershipFunctionEnum.TRIANGULAR, toCoordinate([1:0, 1.5:1, 2:0]))
		def termRUIM = new FuzzyTerm("RUIM", MembershipFunctionEnum.TRIANGULAR, toCoordinate([1.5:0, 2:1, 2.5:0]))
		output = new Output("Atendimento", VariableType.REAL, [termBOM, termRUIM], null, "0.9")
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
	void "deve criar uma variável linguística a partir de um Input"() {
		when:
			def variable = controller.createInput(input)
		then:
			variable.input
			variable.name == "Temperatura"
			variable.linguisticTerms.size() == 2
	}
	
	/**
	 * @Method: createOutput(...)
	 */
	
	/*@Scenario: Criando uma variável linguística a partir de um Output*/
	void "deve criar uma variável linguística a partir de um Output"() {
		when:
			def variable = controller.createOutput(output)
		then:
			variable.output
			variable.name == "Atendimento"
			variable.linguisticTerms.size() == 2
	}

	/**
	 * @Method: createFuzzyControl(...)
	 */
	
	/*@Scenario: Criando um bloco de função a partir de um FuzzyControl*/
	void "deve instanciar um bloco de função a partir de um FuzzyControl"() {
		given:
			def fuzzyControl = new FuzzyControl("Controle de Caldeira", "")
			fuzzyControl.addInput(input)
			fuzzyControl.addOutput(output)
		when:
			def functionBlock = controller.createFuzzyControl(fuzzyControl, null)
		then:
			functionBlock.name == fuzzyControl.name
			functionBlock.variablesByName.containsKey(input.name)
			functionBlock.variablesByName.containsKey(output.name)
	}
	
	/**
	 * @Method: createFuzzySystem(...)
	 */
	
	/*@Scenario: Criando um sistema fuzzy a partir de um FuzzySystem*/
	void "deve instanciar um FIS a partir de um FuzzySystem"() {
		given:
			def fuzzyControl = new FuzzyControl("Controle de Caldeira", "")
			def fuzzySystem = new FuzzySystem("Sistema Fuzzy", "")
			fuzzySystem.addFuzzyControl(fuzzyControl)
		when:
			def system = controller.createFuzzySystem(fuzzySystem)
		then:
			system.functionBlocks.containsKey(fuzzyControl.name)	
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