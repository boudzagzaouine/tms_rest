package com.bagile.gmo.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ErrorType;
import com.querydsl.core.types.dsl.BooleanExpression;

/**
 * Created by adadi on 12/23/2015.
 */
public class Search {

    private Search() {

    }
    
    public static Field getFieldWithType(String className, String field) throws ClassNotFoundException, NoSuchFieldException, SecurityException {
    	Class<?> clazz = Class.forName("com.bagile.gmo.dto." + className);
    	
    	return clazz.getDeclaredField(field);
    }

    public static String getField(String name, String search) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchFieldException {
        try {
            String field = "";
            if ("StockView".equals(name)) {
                name = "Stock";
            }
            if ("ContainerView".equals(name)) {
                name = "Container";
            }
            if (search.indexOf('.') == -1) {
                Class<?> cls = Class.forName("com.bagile.gmo.mapper." + name + "Mapper");
                //Object mapper = cls.newInstance();
                Method method = cls.getDeclaredMethod("getField", String.class);
                field = (String) method.invoke(null, search);
            } else {

                StringTokenizer stringTokenizer = new StringTokenizer(search, ".");
                String str = (String) stringTokenizer.nextElement();
                Class<?> cls = Class.forName("com.bagile.gmo.mapper." + name + "Mapper");
                //Object mapper = cls.newInstance();
                Method method = cls.getDeclaredMethod("getField", String.class);
                field = (String) method.invoke(null, str);
                cls = Class.forName("com.bagile.gmo.dto." + name);
                Class<?> type = cls.getDeclaredField(str).getType();
                if (type.getTypeName().toString().equals("java.util.Set")) {
                    ParameterizedType parameterizedType = (ParameterizedType) cls.getDeclaredField(str).getGenericType();
                    type = (Class<?>) parameterizedType.getActualTypeArguments()[0];
                }
                while (stringTokenizer.hasMoreElements()) {
                    str = (String) stringTokenizer.nextElement();
                    name = type.getSimpleName();
                    cls = Class.forName("com.bagile.gmo.mapper." + name + "Mapper");
                    //mapper = cls.newInstance();
                    method = cls.getDeclaredMethod("getField", String.class);
                    field += "." + (String) method.invoke(null, str);
                    cls = Class.forName("com.bagile.gmo.dto." + name);
                    type = cls.getDeclaredField(str).getType();
                    if (type.getTypeName().toString().equals("java.util.Set")) {
                        ParameterizedType parameterizedType = (ParameterizedType) cls.getDeclaredField(str).getGenericType();
                        type = (Class<?>) parameterizedType.getActualTypeArguments()[0];
                    }
                }
            }
            return field;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
  return null;
    }

    private static String search(Map<String, String> map, String value) {
   /*     for (String key : map.keySet()
                ) {
            if (value.equals(map.get(key))) {
                return key;
            }
        }*/

        for (Map.Entry entry : map.entrySet()
        ) {
            if (value.equals(map.get(entry.getKey()))) {
                return entry.getKey().toString();
            }
        }
        return "";
    }


    public static String getFieldDto(String name, String search) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchFieldException {
        String field = "";
        if (search.indexOf('.') == -1) {
            Class<?> cls = Class.forName("com.bagile.gmo.mapper." + name + "Mapper");
            Object mapper = cls.newInstance();
            Method method = cls.getDeclaredMethod("getMap");
            Map<String, String> map = (HashMap<String, String>) method.invoke(mapper);
            field = search(map, search);
        } else {
            StringTokenizer stringTokenizer = new StringTokenizer(search, ".");
            String field0 = (String) stringTokenizer.nextElement();
            String field1 = (String) stringTokenizer.nextElement();
            Class<?> cls = Class.forName("com.bagile.gmo.mapper." + name + "Mapper");
            Object mapper = cls.newInstance();
            Method method = cls.getDeclaredMethod("getMap", String.class);
            Map<String, String> map = (HashMap<String, String>) method.invoke(mapper);
            field = search(map, field0);
            cls = Class.forName("com.bagile.gmo.dto." + name);
            cls = Class.forName("com.bagile.gmo.mapper." + cls.getDeclaredField(field0).getType().getSimpleName() + "Mapper");
            Object mapper2 = cls.newInstance();
            method = cls.getDeclaredMethod("getMap");
            map = (HashMap<String, String>) method.invoke(mapper2);
            field += "." + (String) search(map, field1);
        }
        return field;
    }

    public static BooleanExpression expression(String search, Class<?> entity) throws AttributesNotFound, ErrorType {
		BooleanExpression booleanExpression = null;
		Index index = (new Search()).new Index(0);
        if (null == search) {
            throw new AttributesNotFound("");
        }

        return analyzePattern(entity, search + "|", booleanExpression, index);
    }
    
	static BooleanExpression analyzePattern(Class<?> entityClass, String pattern, BooleanExpression exp, Index index) throws AttributesNotFound, ErrorType {

		char c;
		if(pattern.length() < 3)
			return null;
		c = pattern.charAt(index.getValue());
		switch (c) {
		case ' ':
			break;
		case '(':
			index.incValue(1);
			exp = analyzePattern(entityClass, pattern, exp, index);
			break;
		case ')':
			index.incValue(1);
			return exp;
		case ',':
			index.incValue(1);
			return exp.and(analyzePattern(entityClass, pattern, exp, index));
		case '|':
			index.incValue(1);
			return exp.or(analyzePattern(entityClass, pattern, exp, index));
		default:
			
		}
		if(c != '(')
			exp = new CriteriaPredicate(getCriteria(entityClass, pattern, index)).getPredicate(entityClass);

		if (pattern.length() <= index.getValue() + 1)
			return exp;

		return analyzePattern(entityClass, pattern, exp, index);
	}

	private static SearchCriteria getCriteria(Class<?> entityClass, String simpleQuery, Index index) throws AttributesNotFound {
		Pattern pattern0 = Pattern.compile("([a-z]\\w+(\\.[a-z]\\w+)*)([:~<>^])(((?!(,|\\||\\(|\\))).)*)[,|\\||\\(|\\)]");
		Matcher matcher = pattern0.matcher(simpleQuery.substring(index.getValue()));
		matcher.find();

		if(simpleQuery.length() <= index.getValue() + 1)
			return new SearchCriteria();

		index.incValue(matcher.group(0).length() - 1);
		String field;
		try {
	        field = getField(entityClass.getSimpleName().substring(3), matcher.group(1));
	        if (field == null || field == "") {
	            throw new Exception("Property : " + matcher.group(1) + " Not found in Type " + entityClass.getSimpleName());
	        }
	    } catch (Exception e) {
		    e.printStackTrace();
	        throw new AttributesNotFound(simpleQuery);
	    }

		
		return new SearchCriteria(field, matcher.group(3), matcher.group(4));
	}

	private class Index {
		Integer value;

		
		
		public Index(Integer value) {
			super();
			this.value = 0;
		}

		public Integer getValue() {
			return value;
		}

		public void setValue(Integer value) {
			this.value = value;
		}
		
		public void incValue(Integer newValue) {
			this.value = this.value + newValue;
		}
		
	}

}
