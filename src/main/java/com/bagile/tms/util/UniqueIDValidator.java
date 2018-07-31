/**
 *
 */
package com.bagile.tms.util;

import org.springframework.context.ApplicationContext;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author SINNO
 */
public class UniqueIDValidator implements ConstraintValidator<Unique, String> {
    private boolean valide = false;
    private ApplicationContext applicationContext;
    private String nameFunction;
    private String message;
    private Class<?> service;

    //Sdeed
    @Override
    public void initialize(Unique constraintAnnotation) {
        nameFunction = constraintAnnotation.nameFunction();
        message = constraintAnnotation.message();
        service = constraintAnnotation.service();

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        //Object service = this.applicationContext.getBean(this.service);
        //Method method = this.service.getDeclaredMethod("findById2", Long.class);
          /*  Object object = null;// method.invoke(service, new Long(1));
            if (null == object) {
                valide = true;
            } else {
                // context.buildConstraintViolationWithTemplate(message);
                valide = false;
            }
        } catch (Exception e) {
            // context.buildConstraintViolationWithTemplate(message);
            valide = false;
        }*/
        return valide;

    }
}
