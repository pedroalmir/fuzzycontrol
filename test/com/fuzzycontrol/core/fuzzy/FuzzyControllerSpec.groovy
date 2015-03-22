package com.fuzzycontrol.core.fuzzy

import net.sourceforge.jFuzzyLogic.membership.MembershipFunctionTriangular
import spock.lang.Specification

import com.fuzzycontrol.core.controller.base.FuzzyControlInterface
import com.fuzzycontrol.core.controller.fuzzy.FuzzyController
import com.fuzzycontrol.core.model.fuzzy.FuzzyCoordinate
import com.fuzzycontrol.core.model.fuzzy.enums.MembershipFunctionEnum
import com.fuzzycontrol.core.model.fuzzy.exception.InvalidParametersSizeException
import com.fuzzycontrol.core.model.fuzzy.exception.MembershipFunctionInstantiationException

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
	
	/*Helper Methods*/
	
	def toCoordinate(params) {
		def coordinates = []
		params.each { key, value ->
			coordinates.add(new FuzzyCoordinate(key, value))
		}
		return coordinates
	}

}