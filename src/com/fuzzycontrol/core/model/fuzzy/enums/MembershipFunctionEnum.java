/**
 * 
 */
package com.fuzzycontrol.core.model.fuzzy.enums;

import java.util.List;

import net.sourceforge.jFuzzyLogic.membership.MembershipFunction;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunctionTriangular;
import net.sourceforge.jFuzzyLogic.membership.Value;

/**
 * @author Pedro Almir
 *
 */
public enum MembershipFunctionEnum {
	
	TRIANGULAR {
		
		@Override
		public MembershipFunction createMembershipFunction(List<String> params) {
			return new MembershipFunctionTriangular(new Value(0D), new Value(0D), new Value(0D));
		}
		
	}, 
	
	TRAPETZOIDAL {
		
		@Override
		public MembershipFunction createMembershipFunction(List<String> params) {
			// TODO Auto-generated method stub
			return null;
		}
		
	};
	
	public abstract MembershipFunction createMembershipFunction(List<String> params);
	
}
