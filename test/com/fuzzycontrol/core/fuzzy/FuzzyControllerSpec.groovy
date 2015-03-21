package com.fuzzycontrol.core.fuzzy

import net.sourceforge.jFuzzyLogic.membership.MembershipFunctionTriangular;

import com.fuzzycontrol.core.controller.base.FuzzyControlInterface;
import com.fuzzycontrol.core.controller.fuzzy.FuzzyController;
import com.fuzzycontrol.core.model.fuzzy.enums.MembershipFunctionEnum;

import spock.lang.Specification;

class FuzzyControllerSpec extends Specification {
	
	FuzzyControlInterface controller
	
	def setup() {
		controller = new FuzzyController()
	}
	
	/**
	 * @Scenario:  
	 * Testa o comportamento do método <code>createMembershipFunction</code>
	 */
	void "deve instanciar a função de pertinência correspondente a um determinado tipo de função"() {
		//FIXME - TO BE CONTINUED...
		when:
			def function = controller.createMembershipFunction(MembershipFunctionEnum.TRIANGULAR, [])
		then:
			function instanceof MembershipFunctionTriangular
	}

}