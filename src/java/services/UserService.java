/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dataaccess.RoleDB;
import java.util.List;
import models.User;
import dataaccess.UserDB;
import models.Role;

/**
 *
 * @author Jonat
 */
public class UserService {
    public User get(String email) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        return user;
    }
    
    public List<User> getAll() throws Exception {
        UserDB userDB = new UserDB();
        List<User> users = userDB.getAll();
        return users;
    }
    
    public void insert(String email, String firstname, String lastname, String password, Role role) throws Exception {
        
        User user = new User(email, firstname, lastname, password);
        user.setRole(role);
        
        UserDB userDB = new UserDB();       
        userDB.insert(user);
    }
    
    public void update(String email, String firstname, String lastname, String password, Role role) throws Exception {
        
        User user = new User(email, firstname, lastname, password);
        user.setRole(role);
        UserDB userDB = new UserDB();
        userDB.update(user);
    }
    
    public void delete(String email, String firstname, String lastname, String password, Role role) throws Exception {
        
        User user = get(email);
        UserDB userDB = new UserDB();
        userDB.delete(user);
    }
}