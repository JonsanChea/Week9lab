package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Role;
import models.User;

/**
 *
 * @author Jonat
 */
public class RoleDB {

    public List<Role> getAll() throws Exception {
       EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try{
           List<Role> roles = em.createNamedQuery("Role.findAll", Role.class).getResultList();
           return roles;
            
        } finally {
            em.close();
        }
    }

    public Role get(int roleId) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try{
            Role roles = em.find(Role.class, roleId);
            return roles;
        }finally{
            em.close();
        }
    }

    public void insert(Role role) throws Exception {
       EntityManager em = DBUtil.getEmFactory().createEntityManager();
       EntityTransaction trans = em.getTransaction();
       
        try {
            trans.begin();
            em.persist(role);
            em.merge(role);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();    
        } finally {
          em.close(); 
        }
    }

    public void update(Role role) throws Exception {
       EntityManager em = DBUtil.getEmFactory().createEntityManager();
       EntityTransaction trans = em.getTransaction();
       
        try {
            trans.begin();
            em.merge(role);
            trans.commit();
        }catch (Exception ex){
            trans.rollback();    
        } finally {
          em.close(); 
        }
    }

    public void delete(Role role) throws Exception {
       EntityManager em = DBUtil.getEmFactory().createEntityManager();
       EntityTransaction trans = em.getTransaction();
       
        try {
            trans.begin();
            em.remove(em.merge(role));
            trans.commit();
        }catch (Exception ex){
            trans.rollback();    
        } finally {
          em.close(); 
        }
    }
}
