package com.shamsid.scaleuptask.user.repo;

import com.shamsid.scaleuptask.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

    public User findUserByEmailId(String email);
    public List<User> getUserByFirstNameOrderByIdAsc(String firstName);
    public List<User> getUserByLastNameOrderByIdAsc(String lastName);
    public List<User> getUserByIdOrderById(Integer id);

    public List<User> getUserByFirstNameAndLastNameOrderByIdAsc(String firstName,String lastName);
    public List<User> getUserByFirstNameAndLastNameAndEmailIdOrderByIdAsc(String firstName,String lastName,
                                                                          String emailId);

}
