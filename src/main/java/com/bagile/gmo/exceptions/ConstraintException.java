package com.bagile.tms.exceptions;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.exception.ConstraintViolationException;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by adadi on 1/25/2016.
 */
public class ConstraintException extends Exception {
    @JsonIgnore
    private List<Validator> validators;

    private ConstraintViolationException constraintViolationException;


    public void setConstraintViolationException(ConstraintViolationException constraintViolationException) {
        this.constraintViolationException = constraintViolationException;
        Object e = constraintViolationException.getCause();
       //   if (e instanceof PSQLException) {
       //     restart((PSQLException) e);
      //  }
    }

    public ConstraintException(ConstraintViolationException constraintViolationException) {
        validators = new ArrayList<>();
        this.constraintViolationException = constraintViolationException;
        Throwable e = constraintViolationException.getCause();
        if (e.getClass().getName().equals("org.postgresql.util.PSQLException")) {
            restart(e);
        }
    }

    private void restart(Throwable cause) {
        validators.clear();
        String msgCause = cause.getMessage();
        Matcher matcher = null;
        if (msgCause.toLowerCase().indexOf("foreign") > -1) {
            Pattern pattern = Pattern.compile("on table \"(\\w+).*\\n.*Key \\((\\w+)\\)(=.*from).*_(\\w+).*");
            matcher = pattern.matcher(cause.getMessage());
            while (matcher.find()) {
                String path = matcher.group(1) + "";
                String field = matcher.group(2) + "";
                field = field.substring(field.indexOf(path));
                path = path.substring(4);
                //String msg = matcher.group(3) + "";
                String target = matcher.group(4) + "";

                String message = path +  " " + "est li� avec " + " " + target;
                Validator validator = new Validator();
                validator.setField(field);
                validator.setMessage(message);
                validator.setPath(path);
                validators.add(validator);
            }
        } else if (msgCause.toLowerCase().indexOf("unique") > -1) {
            Pattern pattern = Pattern.compile("(ERROR||EURREUR).*\\n.*Key \\((\\w+)\\)(.*)");
            matcher = pattern.matcher(cause.getMessage());
            while (matcher.find()) {
                String field = matcher.group(1) + "";

                String msg = matcher.group(2) + "";
                Matcher m = Pattern.compile("\\(([^)]+)\\)").matcher(msg);
                String message =  " " ;

                while(m.find()) {
                    message= m.group(1)+" existe d�ja";
                }
                if (" ".equals(message)) {
                	message = "Action impossible, cet objet existe d�ja.";
                }
                Validator validator = new Validator();
                validator.setField(field);
                validator.setMessage(message);
                validators.add(validator);
            }

        } else {
            String	message = "Action impossible, cet objet est li� � un enregistrement.";
            Validator validator = new Validator();
            validator.setField("");
            validator.setMessage(message);
            validators.add(validator);
        	
        }
        
    }

    @Override
    public String getMessage() {
        StringBuffer stringBuffer = new StringBuffer("[");
        for (Validator validator : validators) {
            stringBuffer.append(validator.toString());
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
