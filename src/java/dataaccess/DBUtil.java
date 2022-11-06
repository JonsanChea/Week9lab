package dataaccess;

import java.sql.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
    
    public static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("UserPU");
    
    public static EntityManagerFactory getEmFactory(){
        return emf;
    }
    
}
