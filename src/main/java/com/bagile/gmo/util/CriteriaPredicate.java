package com.bagile.gmo.util;

import com.bagile.gmo.exceptions.ErrorType;
import com.querydsl.core.types.dsl.*;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CriteriaPredicate {

    private SearchCriteria criteria;

    public CriteriaPredicate() {
    }

    public CriteriaPredicate(SearchCriteria criteria) {
        super();
        this.criteria = criteria;
    }




    public Type getType(String key, Class<?> entityClass) throws NoSuchFieldException, ClassNotFoundException {
        if (!key.contains(".")) {
            Type type = entityClass.getDeclaredField(key).getType();
            if (type.getTypeName().toString().equals("java.util.Set") || type.getTypeName().toString().equals("java.util.List")) {
                ParameterizedType parameterizedType = (ParameterizedType) entityClass.getDeclaredField(key).getGenericType();
                type = parameterizedType.getActualTypeArguments()[0];
            }
            return type;
        }
        Field field = null;
        Type type = null;
        String[] keys = key.split("\\.");
        for (int i = 0; i < keys.length - 1; i++) {
            if (null != entityClass) {
                try {
                    field = entityClass.getDeclaredField(keys[i]);
                } catch (NoSuchFieldException e) {
                    field = entityClass.getSuperclass().getDeclaredField(keys[i]);
                }            }
            if (null != field) {

                Class classe = field.getType();
                if (null != classe) {
                    Field declaredField = null;
                    if (classe.getTypeName().toString().equals("java.util.Set")) {
                        ParameterizedType parameterizedType = (ParameterizedType) entityClass.getDeclaredField(keys[i]).getGenericType();
                        classe = (Class) parameterizedType.getActualTypeArguments()[0];
                    }
                    try {
                        declaredField = classe.getDeclaredField(keys[i + 1]);
                    } catch (NoSuchFieldException e) {
                        declaredField = classe.getSuperclass().getDeclaredField(keys[i + 1]);
                    }
                    type = declaredField.getType();
                }
                entityClass = classe;

            }
        }
        return type;
    }

    public BooleanExpression getPredicate(Class<?> entityClass) throws ErrorType {

        PathBuilder<?> entityPath = new PathBuilder(entityClass,
                StringUtils.uncapitalize(entityClass.getSimpleName()));

        Type type = null;

        try {

            type = getType(criteria.getKey(), entityClass);
        } catch (NoSuchFieldException e) {
            //e.printStackTrace();
        } catch (ClassNotFoundException e) {
            //e.printStackTrace();
        }
        System.out.println(criteria.getKey() + type.getTypeName() + criteria.getValue().toString() + " searching");


        if (Boolean.TYPE == type || Boolean.class == type) {
            BooleanPath booleanPath = entityPath.getBoolean(criteria.getKey());
            Boolean valueBoolean = Boolean.valueOf(criteria.getValue().toString());
            return booleanPath.eq(valueBoolean);
        }
        if (Date.class == type) {
            DatePath<Date> datePath = entityPath.getDate(criteria.getKey(), Date.class);
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date date = formatter.parse(criteria.getValue().toString());
                if (":".equals(this.criteria.getOperation())) {
                    return datePath.eq(date);
                }
                if (">".equals(this.criteria.getOperation())) {
                    return datePath.goe(date);
                }
                if ("<".equals(this.criteria.getOperation())) {
                    return datePath.loe(date);
                }

            } catch (ParseException e) {
                throw new ErrorType("");
            }
        }

        if (BigDecimal.class == type || Double.TYPE == type || Double.class == type) {
            NumberPath<BigDecimal> bigDecimalNumberPath = entityPath.getNumber(criteria.getKey(), BigDecimal.class);
            BigDecimal bigDecimal = new BigDecimal(criteria.getValue().toString());
            if (":".equals(this.criteria.getOperation())) {
                return bigDecimalNumberPath.eq(bigDecimal);
            }
            if (">".equals(this.criteria.getOperation())) {
                return bigDecimalNumberPath.goe(bigDecimal);
            }
            if ("<".equals(this.criteria.getOperation())) {
                return bigDecimalNumberPath.loe(bigDecimal);
            }
        }
        if (String.class == type) {
            StringPath path = entityPath.getString(criteria.getKey());
            if (criteria.getOperation().equalsIgnoreCase(":")) {
                if (criteria.getValue().toString().toLowerCase().equals("null"))
                    return path.isNull().or(path.isEmpty());
                if (criteria.getValue().toString().toLowerCase().equals("notnull"))
                    return path.isNull().or(path.isNotEmpty());
                else
                    return path.lower().eq(criteria.getValue().toString().toLowerCase());
            }
            if (criteria.getOperation().equalsIgnoreCase("~")) {
                return path.lower().like("%" + criteria.getValue().toString().toLowerCase() + "%");
            }
            if (criteria.getOperation().equalsIgnoreCase(">")) {
                return path.lower().startsWith(criteria.getValue().toString().toLowerCase());
            }
            if (criteria.getOperation().equalsIgnoreCase("<")) {
                return path.lower().in(criteria.getValue().toString().toLowerCase().split(";"));
            }
            if (criteria.getOperation().equalsIgnoreCase("<")) {
                return path.lower().in(criteria.getValue().toString().toLowerCase().split(";"));
            }
//            if (criteria.getOperation().equalsIgnoreCase("|")) {
//                return path.isNull().or(path.isEmpty());
//            }
            if (criteria.getOperation().equalsIgnoreCase("^")) {
                String[] split = criteria.getValue().toString().split(";");
                ArrayList<String> strings = new ArrayList<String>();
                for (int i = 0; i < split.length; i++) {
                    strings.add(String.valueOf(split[i]));
                }
                return path.in(strings);
            } else if (criteria.getOperation().equalsIgnoreCase("!")) {
                String[] split = criteria.getValue().toString().split(";");
                ArrayList<String> strings = new ArrayList<String>();
                for (int i = 0; i < split.length; i++) {
                    strings.add(String.valueOf(split[i]));
                }
                return path.notIn(strings);
            }

        }
        if (Long.TYPE == type || Long.class == type || Integer.TYPE == type || Integer.class == type || Short.class == type || Short.TYPE == type) {
            NumberPath<Long> path = entityPath.getNumber(criteria.getKey(),
                    Long.class);
            if (criteria.getOperation().equals("?")) {
                String[] split = criteria.getValue().toString().split(";");
                ArrayList<Long> numbers = new ArrayList<Long>();
                for (int i = 0; i < split.length; i++) {
                    numbers.add(Long.valueOf(split[i]));
                }
                return path.in(numbers);
            } else if (criteria.getOperation().equalsIgnoreCase("!")) {
                String[] split = criteria.getValue().toString().split(";");
                ArrayList<Long> numbers = new ArrayList<Long>();
                for (int i = 0; i < split.length; i++) {
                    numbers.add(Long.valueOf(split[i]));
                }
                return path.notIn(numbers);
            } else {
                Long valueLong = Long.parseLong(criteria.getValue().toString());
                if (criteria.getOperation().equalsIgnoreCase(":")) {

                    return path.eq(valueLong);
                } else if (criteria.getOperation().equalsIgnoreCase(">")) {
                    return path.goe(valueLong);
                } else if (criteria.getOperation().equalsIgnoreCase("<")) {
                    return path.loe(valueLong);
                } else if (criteria.getOperation().equalsIgnoreCase("#")) {
                    return path.isNull();
                }
            }
        }
        System.out.println(criteria.getKey() + type.getTypeName() + criteria.getValue().toString() + " Not found");
        throw new ErrorType(criteria.getKey(), type.getTypeName(), criteria.getValue().toString());
    }
}
