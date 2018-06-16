package eu.dauphine.microservices.architecture.currencyexchange.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TransactionNotFoundException extends Exception {

    public TransactionNotFoundException(String message){
        super(message);
    }

}
