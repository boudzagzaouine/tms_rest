package com.bagile.tms.config;

import com.bagile.tms.exceptions.AttributesNotFound;
import com.bagile.tms.exceptions.ConstraintException;
import com.bagile.tms.exceptions.IdNotFound;
import com.bagile.tms.exceptions.ValidatorException;
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
        LOGGER.error(pe.getMessage());
        return new ResponseEntity<RuntimeException>(pe, HttpStatus.SEE_OTHER);
    }

    @ExceptionHandler({ClassNotFoundException.class})
    public ResponseEntity<ClassNotFoundException> handleNotFound(ClassNotFoundException pe) {
        LOGGER.error(pe.getMessage());
        return new ResponseEntity<ClassNotFoundException>(pe, HttpStatus.SEE_OTHER);
    }


    @ExceptionHandler({TypeMismatchException.class})
    public ResponseEntity<TypeMismatchException> handlePersonNotFound(TypeMismatchException pe) {
        LOGGER.error(pe.getMessage());
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
            LOGGER.error(e.getMessage());
            //e.printStackTrace();
        } catch (IllegalAccessException e) {
            LOGGER.error(e.getMessage());
            //e.printStackTrace();
        } catch (InstantiationException e) {
            LOGGER.error(e.getMessage());
            //e.printStackTrace();
        } catch (ClassNotFoundException e) {
            LOGGER.error(e.getMessage());
            //e.printStackTrace();
        } catch (InvocationTargetException e) {
            LOGGER.error(e.getMessage());
            //e.printStackTrace();
        } catch (NoSuchFieldException e) {
            LOGGER.error(e.getMessage());
            //e.printStackTrace();
        }
        return new ResponseEntity<ValidatorException>(validatorException, HttpStatus.SEE_OTHER);
    }

    @ExceptionHandler({ValidatorException.class})
    public ResponseEntity<ValidatorException> validator(ValidatorException pe) {
        LOGGER.error(pe.getMessage());
        return new ResponseEntity<ValidatorException>(pe, HttpStatus.SEE_OTHER);
    }

    @ExceptionHandler({IdNotFound.class})
    public ResponseEntity<IdNotFound> handleIdNotFound(IdNotFound pe) {
        return new ResponseEntity<IdNotFound>(pe, HttpStatus.SEE_OTHER);
    }

    @ExceptionHandler({AttributesNotFound.class})
    public ResponseEntity<AttributesNotFound> handleIdNotFound(AttributesNotFound pe) {
        return new ResponseEntity<AttributesNotFound>(pe, HttpStatus.SEE_OTHER);
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    public ResponseEntity<ConstraintException> dataIntegrityViolationException(DataIntegrityViolationException pe) {
        if (pe.getCause() instanceof org.hibernate.exception.ConstraintViolationException) {
            ConstraintException constraintException = new ConstraintException((org.hibernate.exception.ConstraintViolationException) pe.getCause());
            LOGGER.error(constraintException.getMessage());
            return new ResponseEntity<ConstraintException>(constraintException, HttpStatus.SEE_OTHER);
        }
        return null;
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<Exception> handleException(Exception pe) {
        LOGGER.error(pe.getMessage());
        return new ResponseEntity<>(pe, HttpStatus.SEE_OTHER);
    }

//    @ExceptionHandler({DataIntegrityViolationException.class})
//    public ResponseEntity<Exception> handleIdNotFound(DataIntegrityViolationException pe) {
//        if (pe.getCause() instanceof ConstraintViolationException) {
//            ConstraintViolationException tmp = (ConstraintViolationException) pe.getCause();
//            if (tmp.getCause() instanceof PSQLException) {
//                PSQLException exception = (PSQLException) tmp.getCause();
//            }
//            //exception.getMessage();
//            return new ResponseEntity<Exception>(pe, HttpStatus.SEE_OTHER);
//        }
//        if (pe.getCause() instanceof PropertyValueException) {
//            return new ResponseEntity<Exception>(pe, HttpStatus.SEE_OTHER);
//        }
//        if (pe.getCause() instanceof DataException) {
//            return new ResponseEntity<Exception>(pe, HttpStatus.SEE_OTHER);
//        }
//        return new ResponseEntity<Exception>(pe, HttpStatus.SEE_OTHER);
//    }

}
