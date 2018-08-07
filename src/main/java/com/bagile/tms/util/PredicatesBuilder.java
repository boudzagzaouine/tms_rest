/**
 * 
 */
package com.bagile.tms.util;


import com.bagile.tms.exceptions.ErrorType;
import com.querydsl.core.types.dsl.BooleanExpression;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aelguezzar
 *
 */
public class PredicatesBuilder {

	private List<SearchCriteria> params;

	public PredicatesBuilder() {
		params = new ArrayList<SearchCriteria>();
	}

	public PredicatesBuilder with(String key, String operation, Object value) {
		params.add(new SearchCriteria(key, operation, value));
		return this;
	}

	public int size(){
		return params.size();
	}

	public BooleanExpression buildAND(Class<?> entityClass) throws ErrorType {
		if (params.size() == 0) {
			return null;
		}

		List<BooleanExpression> predicates = new ArrayList<BooleanExpression>();
		CriteriaPredicate predicate;
		for (SearchCriteria param : params) {
			predicate = new CriteriaPredicate(param);
			BooleanExpression exp;
			exp = predicate.getPredicate(entityClass);
			if (exp != null) {
				predicates.add(exp);
			}
		}

		BooleanExpression result = predicates.get(0);
		for (int i = 1; i < predicates.size(); i++) {
			result = result.and(predicates.get(i));
		}
		return result;
	}

	public BooleanExpression buildOR(Class<?> entityClass) throws ErrorType {
		if (params.size() == 0) {
			return null;
		}

		List<BooleanExpression> predicates = new ArrayList<BooleanExpression>();
		CriteriaPredicate predicate;
		for (SearchCriteria param : params) {
			predicate = new CriteriaPredicate(param);
			BooleanExpression exp = predicate.getPredicate(entityClass);
			if (exp != null) {
				predicates.add(exp);
			}
		}

		BooleanExpression result = predicates.get(0);
		for (int i = 1; i < predicates.size(); i++) {
			result = result.or(predicates.get(i));
		}
		return result;
	}

}
