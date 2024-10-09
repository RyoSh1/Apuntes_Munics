package es.storeapp.business.repositories;

import es.storeapp.business.entities.User;
import java.text.MessageFormat;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends AbstractRepository<User> {
    
    private static final String FIND_USER_BY_EMAIL_QUERY = "SELECT u FROM User u WHERE u.email = ''{0}''";
    private static final String COUNT_USER_BY_EMAIL_QUERY = "SELECT COUNT(*) FROM User u WHERE u.email = ''{0}''";
    private static final String LOGIN_QUERY = "SELECT u FROM User u WHERE u.email = ''{0}'' AND u.password = ''{1}''";

    public User findByEmail(String email) {
        try {
            Query query = entityManager.createQuery(MessageFormat.format(FIND_USER_BY_EMAIL_QUERY, email));
            return (User) query.getSingleResult();
        } catch (NoResultException e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    public boolean existsUser(String email) {
        Query query = entityManager.createQuery(MessageFormat.format(COUNT_USER_BY_EMAIL_QUERY, email));
        return ((Long) query.getSingleResult() > 0);
    }
    
    public User findByEmailAndPassword(String email, String password) {
        try {
            Query query = entityManager.createQuery(MessageFormat.format(LOGIN_QUERY, email, password));
            return (User) query.getSingleResult();
        } catch (NoResultException e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }
}
