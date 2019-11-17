package com.shamsid.scaleuptask.user.service;

import com.shamsid.scaleuptask.user.event.UserOperationEvent;
import com.shamsid.scaleuptask.user.event.UserOperationsEventListener;
import com.shamsid.scaleuptask.user.domain.User;
import com.shamsid.scaleuptask.user.repo.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserRepository userRepos;

    @Autowired
    private ApplicationEventPublisher publisher;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public User saveUser(User user){
        User savedUser = userRepos.save(user);
        if(savedUser!=null){
            publisher.publishEvent(new UserOperationEvent("User Registered Successfully"));
        }else {
            publisher.publishEvent(new UserOperationEvent("User Registered failed"));
        }

        return user;
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void deleteUser(String  emailId){

        User user = userRepos.findUserByEmailId(emailId);
        if(user!=null){
            logger.info("User found in database");
            userRepos.delete(user);
            publisher.publishEvent(new UserOperationEvent("User deleted successfully"));
        }else{
            logger.info("user not found in database");
        }
    }

    public List<User> getAllUser(){
        return userRepos.findAll();
    }

    public User getUserFromEmail(String email){
        return userRepos.findUserByEmailId(email);
    }


    public List<User> getUserFromLastName(String lastName){
        return userRepos.getUserByLastNameOrderByIdAsc(lastName);
    }

    public List<User> getUserFromFirstName(String firstName){
        return userRepos.getUserByFirstNameOrderByIdAsc(firstName);
    }

}
