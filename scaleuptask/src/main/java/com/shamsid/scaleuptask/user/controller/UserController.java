package com.shamsid.scaleuptask.user.controller;

import com.shamsid.scaleuptask.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import com.shamsid.scaleuptask.user.domain.User;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {


    @Autowired
    UserService userService;

    @PostMapping("/createUser")
    public void createUser(@NotNull @RequestBody User user){
        userService.saveUser(user);

    }

    @PostMapping("/getAllUser")
    public List<User> getAllUser(){
        return userService.getAllUser();
   }

   @PostMapping("/getUserFormEmail")
   public User getUserFromEmail(@RequestParam(name = "email_id") String emailId,HttpServletRequest request,
                                HttpServletResponse response) throws IOException {

        User user = userService.getUserFromEmail(emailId);

        if(user!=null){
            response.setStatus(HttpServletResponse.SC_OK);
        }else{
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.getWriter().println("User not found");
        }
        return user;
   }

   @PostMapping("/getUsersFromLastName")
   public List<User> getUserFromLastName(@RequestParam(name = "last_name") String lastName, HttpServletRequest request,
                                   HttpServletResponse response){

        if(lastName!=null){
            response.setStatus(HttpServletResponse.SC_OK);
            return userService.getUserFromLastName(lastName);
        }else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return  null;
        }
   }


    @PostMapping("/getUsersFromFirstName")
    public List<User> getUsersFromFirstName(@RequestParam(name = "first_name") String firstName, HttpServletRequest request,
                                                       HttpServletResponse response){

        if(firstName!=null){
            response.setStatus(HttpServletResponse.SC_OK);
            return userService.getUserFromFirstName(firstName);
        }else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return  null;
        }
    }


    @DeleteMapping("/deleteUser")
    public HashMap deleteUser(@RequestParam(name = "email_id") String emailId, HttpServletRequest request,
                              HttpServletResponse response){

        HashMap hashMap = new HashMap();

        if(emailId!=null) {
            userService.deleteUser(emailId);
            response.setStatus(HttpServletResponse.SC_OK);

            try {
                response.getWriter().println("User deleted");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }else{
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            try {
                response.getWriter().println("Email Id is null");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return hashMap;
    }
}
