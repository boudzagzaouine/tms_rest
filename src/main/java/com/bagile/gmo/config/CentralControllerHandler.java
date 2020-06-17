package com.bagile.gmo.config;

import com.bagile.gmo.exceptions.AttributesNotFound;
import com.bagile.gmo.exceptions.ConstraintException;
import com.bagile.gmo.exceptions.IdNotFound;
import com.bagile.gmo.exceptions.ValidatorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.lang.reflect.InvocationTargetException;

@ControllerAdvice
public class CentralControllerHandler {
    private final static Logger LOGGER = LoggerFactory
            .getLogger(CentralControllerHandler.class);

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<RuntimeException> handleNotFound(RuntimeException pe) {
        LOGGER.error(pe.getMessage(),pe);
        return new ResponseEntity<RuntimeException>(pe, HttpStatus.SEE_OTHER);
    }

    @ExceptionHandler({ClassNotFoundException.class})
    public ResponseEntity<ClassNotFoundException> handleNotFound(ClassNotFoundException pe) {
        LOGGER.error(pe.getMessage(),pe);
        return new ResponseEntity<ClassNotFoundException>(pe, HttpStatus.SEE_OTHER);
    }


    @ExceptionHandler({TypeMismatchException.class})
    public ResponseEntity<TypeMismatchException> handlePersonNotFound(TypeMismatchException pe) {
        LOGGER.error(pe.getMessage(),pe);
        return new ResponseEntity<TypeMismatchException>(pe,
                HttpStatus.SEE_OTHER);
    }


    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<ValidatorException> constraintViolationException(ConstraintViolationException pe) {

        //validatorException.
        ValidatorException validatorException = null;
        try {
            validatorException = new ValidatorException(pe);
        } catch (NoSuchMethodException e) {
            LOGGER.error(e.getMessage(),pe);
            //e.printStackTrace();
        } catch (IllegalAccessException e) {
            LOGGER.error(e.getMessage(),e);
            //e.printStackTrace();
        } catch (InstantiationException e) {
            LOGGER.error(e.getMessage(),e);
            //e.printStackTrace();
        } catch (ClassNotFoundException e) {
            LOGGER.error(e.getMessage(),e);
            //e.printStackTrace();
        } catch (InvocationTargetException e) {
            LOGGER.error(e.getMessage(),e);
            //e.printStackTrace();
        } catch (NoSuchFieldException e) {
            LOGGER.error(e.getMessage(),e);
            //e.printStackTrace();
        }
        LOGGER.error(pe.getMessage());
        return new ResponseEntity<ValidatorException>(validatorException, HttpStatus.SEE_OTHER);
    }

    @ExceptionHandler({ValidatorException.class})
    public ResponseEntity<ValidatorException> validator(ValidatorException pe) {
        LOGGER.error(pe.getMessage(),pe);
        return new ResponseEntity<ValidatorException>(pe, HttpStatus.SEE_OTHER);
    }

    @ExceptionHandler({IdNotFound.class})
    public ResponseEntity<IdNotFound> handleIdNotFound(IdNotFound pe) {

        return new ResponseEntity<IdNotFound>(pe, HttpStatus.SEE_OTHER);
    }

    @ExceptionHandler({AttributesNotFound.class})
    public ResponseEntity<AttributesNotFound> handleIdNotFound(AttributesNotFound pe) {
        LOGGER.error(pe.getMessage(),pe);
        return new ResponseEntity<AttributesNotFound>(pe, HttpStatus.SEE_OTHER);
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    public ResponseEntity<ConstraintException> dataIntegrityViolationException(DataIntegrityViolationException pe) {
        if (pe.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
            ConstraintException constraintException = new ConstraintException((org.hibernate.exception.ConstraintViolationException) pe.getCause());
            LOGGER.error(constraintException.getMessage(),constraintException);
            return new ResponseEntity<ConstraintException>(constraintException, HttpStatus.SEE_OTHER);
        }
        return null;
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Exception> handleException(Exception pe) {
        LOGGER.error(pe.getMessage(),pe);
        return new ResponseEntity<>(pe, HttpStatus.SEE_OTHER);
    }
}
