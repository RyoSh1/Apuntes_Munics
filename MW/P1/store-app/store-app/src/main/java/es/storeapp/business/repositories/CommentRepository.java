package es.storeapp.business.repositories;

import es.storeapp.business.entities.Comment;
import java.text.MessageFormat;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CommentRepository extends AbstractRepository<Comment>{

    private static final String COUNT_BY_USER_AND_PRODUCT_QUERY = 
        "SELECT COUNT(*) FROM Comment c WHERE c.user.id = {0} and c.product.id = {1}";
    
    private static final String FIND_BY_USER_AND_PRODUCT_QUERY = 
        "SELECT c FROM Comment c WHERE c.user.id = {0} and c.product.id = {1}";
    
    public Integer countByUserAndProduct(Long userId, Long productId) {
        Query query = entityManager.createQuery(MessageFormat
            .format(COUNT_BY_USER_AND_PRODUCT_QUERY, userId, productId));
        return (Integer) query.getSingleResult();
    }
    
    public Comment findByUserAndProduct(Long userId, Long productId) {
        Query query = entityManager.createQuery(MessageFormat
            .format(FIND_BY_USER_AND_PRODUCT_QUERY, userId, productId));
        return (Comment) query.getSingleResult();
    }
    
}
