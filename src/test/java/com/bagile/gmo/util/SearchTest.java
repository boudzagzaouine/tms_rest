package com.bagile.tms.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

import com.bagile.gmo.dto.Account;
import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ErrorType;
import com.querydsl.core.types.dsl.BooleanExpression;

class SearchTest {

	Boolean parentheseOpened, parentheseClosed;
	PredicatesBuilder builder = new PredicatesBuilder();
//	int index = 0;


	@Test
	void verifyExpression() throws AttributesNotFound, ErrorType {
//		testPrediactes();

		String pattern = "name>test1|name<test2|name>test3|name<test4|name:test5|name:test6";
		BooleanExpression exp = null;
		Integer index=0;
		BooleanExpression s = analyzePattern(Account.class, pattern + "|", exp, index);
		System.out.println(s.toString());
	}

	BooleanExpression analyzePattern(Class<?> entityClass, String pattern, BooleanExpression exp, Integer index) throws AttributesNotFound, ErrorType {

		char c;
		c = pattern.charAt(index);
		switch (c) {
		case ' ':
			break;
		case '(':
			index++;
			exp = analyzePattern(entityClass, pattern, exp, index);
			break;
		case ')':
			index++;
			return exp;
		case '&':
			index++;
			return exp.and(analyzePattern(entityClass, pattern, exp, index));
		case '|':
			index++;
			return exp.or(analyzePattern(entityClass, pattern, exp, index));
		default:
			
		}
		if(c != '(')
			exp = new CriteriaPredicate(getCriteria(pattern, index)).getPredicate(entityClass);

		if (pattern.length() <= index + 1)
			return exp;

		return analyzePattern(entityClass, pattern, exp, index);
	}

	private SearchCriteria getCriteria(String simpleQuery, Integer index) {
		Pattern pattern0 = Pattern.compile("([a-z]\\w+(\\.[a-z]\\w+)*)([:~<>^])(((?!(\\&|\\||\\(|\\))).)*)[\\&|\\||\\(|\\)]");
		Matcher matcher = pattern0.matcher(simpleQuery.substring(index));
		matcher.find();

		if(simpleQuery.length() <= index + 1)
			return new SearchCriteria();

		index = index + matcher.group(0).length() - 1;

		return new SearchCriteria(matcher.group(1), matcher.group(3), matcher.group(4));
	}

	private BooleanExpression testPrediactes() throws ErrorType {
		SearchCriteria searchCriteria01 = new SearchCriteria("name", ":", "test01");
		SearchCriteria searchCriteria02 = new SearchCriteria("name", ":", "test02");
		SearchCriteria searchCriteria03 = new SearchCriteria("name", ":", "test03");
		SearchCriteria searchCriteria04 = new SearchCriteria("name", ":", "test04");
		SearchCriteria searchCriteria05 = new SearchCriteria("name", ":", "test05");
		SearchCriteria searchCriteria06 = new SearchCriteria("name", ":", "test06");

		CriteriaPredicate predicate01 = new CriteriaPredicate(searchCriteria01);
		CriteriaPredicate predicate02 = new CriteriaPredicate(searchCriteria02);
		CriteriaPredicate predicate03 = new CriteriaPredicate(searchCriteria03);
		CriteriaPredicate predicate04 = new CriteriaPredicate(searchCriteria04);
		CriteriaPredicate predicate05 = new CriteriaPredicate(searchCriteria05);
		CriteriaPredicate predicate06 = new CriteriaPredicate(searchCriteria06);
		BooleanExpression exp01 = predicate01.getPredicate(Account.class);
		BooleanExpression exp02 = predicate02.getPredicate(Account.class);
		BooleanExpression exp03 = predicate03.getPredicate(Account.class);
		BooleanExpression exp04 = predicate04.getPredicate(Account.class);
		BooleanExpression exp05 = predicate03.getPredicate(Account.class);
		BooleanExpression exp06 = predicate04.getPredicate(Account.class);
		BooleanExpression expression = exp01.or(exp02.and(exp03.or(exp04.and(exp05.or(exp06)))));

		return expression;
	}
}
