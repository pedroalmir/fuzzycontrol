/**
 * 
 */
package com.fuzzycontrol.core.model.fuzzy.enums;

import java.util.List;

import net.sourceforge.jFuzzyLogic.membership.MembershipFunction;
import net.sourceforge.jFuzzyLogic.membership.MembershipFunctionTriangular;
import net.sourceforge.jFuzzyLogic.membership.Value;

import com.fuzzycontrol.core.model.fuzzy.FuzzyCoordinate;
import com.fuzzycontrol.core.model.fuzzy.exception.InvalidParametersSizeException;
import com.fuzzycontrol.core.model.fuzzy.exception.MembershipFunctionInstantiationException;

/**
 * @author Pedro Almir
 */
public enum MembershipFunctionEnum {
	
	/**
	 * Represents the TRIANGULAR function and wait for parameters <code>min</code>, <code>mid</code>, <code>max</code>
	 */
	TRIANGULAR {
		
		@Override
		public MembershipFunction createMembershipFunction(List<FuzzyCoordinate> params) throws InvalidParametersSizeException, MembershipFunctionInstantiationException {
			if (params == null || params.size() != 3)
				throw new InvalidParametersSizeException(String.format("The method expect 3 parameters, but got %d", params.size()));
				
			try {
				return new MembershipFunctionTriangular(new Value(params.get(0).getX()), new Value(params.get(1).getX()), new Value(params.get(2).getX()));
			} catch (Exception ex) {
				throw new MembershipFunctionInstantiationException(ex.getMessage());
			}
		}
		
	}, 
	
	TRAPETZOIDAL {
		
		@Override
		public MembershipFunction createMembershipFunction(List<FuzzyCoordinate> params) throws InvalidParametersSizeException, MembershipFunctionInstantiationException {
			// TODO Auto-generated method stub
			return null;
		}
		
	};
	
	public abstract MembershipFunction createMembershipFunction(List<FuzzyCoordinate> params) throws InvalidParametersSizeException, MembershipFunctionInstantiationException;
	
}
