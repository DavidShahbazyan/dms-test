package am.davsoft.test.dms.api.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

/**
 * Author: David Shahbazyan
 * Company: DavSoft
 * Date: Dec 18, 2020
 * Time: 02:34
 */
@ControllerAdvice
public class ApiException {
    @ResponseBody
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String entityNotFoundHandler(EntityNotFoundException ex) {
        return ex.getMessage();
    }
}
