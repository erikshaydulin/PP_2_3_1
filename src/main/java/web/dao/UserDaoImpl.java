package web.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {

        String query = "SELECT u FROM User u";
        TypedQuery<User> typedQuery = entityManager.createQuery(query, User.class);
        List<User> users = typedQuery.getResultList();
        return users;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        System.out.println(user);
        entityManager.persist(user);
    }
}
