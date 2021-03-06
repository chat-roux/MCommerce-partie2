package com.mcommande.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * <b>EXCEPTION DU TYPE CI-DESSOUS :</b><br/>
 * TYPE : 'CREATION IMPOSSIBLE'
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class CommandeAlreadyExistsException extends RuntimeException {

	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * <b>CONSTRUCTEUR AVEC UN ARGUMENT</b><br/>
     * @param pMessage Le message de l'exception
     */
	public CommandeAlreadyExistsException(String pMessage) {
        super(pMessage);
    }
}
