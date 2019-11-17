package com.shamsid.scaleuptask.user.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class UserOperationsEventListener {

    Logger logger = LoggerFactory.getLogger(UserOperationsEventListener.class);

    @EventListener(UserOperationEvent.class)
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    void handleUserOperations(UserOperationEvent event){
        logger.info(event.getMessage());
    }
}
