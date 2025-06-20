package com.bank.CustomGenerator;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class IdGeneratorService {
	
	 @PersistenceContext
	    private  EntityManager entityManager;
	 	
		/* run this script on db for first time
		 * CREATE SEQUENCE user_id START WITH 1 INCREMENT BY 1; CREATE SEQUENCE
		 * account_number START WITH 1 INCREMENT BY 1;
		 */
	 
	    @Transactional
	    public  String generateUserId() {
	        Long seq = ((Number) entityManager.createNativeQuery("SELECT nextval('user_id')").getSingleResult()).longValue();
	        return String.format("OBC%05d", seq);
	    }

	    @Transactional
	    public  String generateAccountNumber() {
	        Long seq = ((Number) entityManager.createNativeQuery("SELECT nextval('account_number')").getSingleResult()).longValue();
	        return String.format("SAPR%06d", seq); 
	    }

}
