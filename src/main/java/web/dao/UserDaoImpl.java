package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public List<User> getAllUsers() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String query = "SELECT u FROM User u";
        TypedQuery<User> typedQuery = entityManager.createQuery(query, User.class);
        List<User> users = typedQuery.getResultList();
        entityManager.close();
        return users;
    }
}
