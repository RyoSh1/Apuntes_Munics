package es.storeapp.business.repositories;

import es.storeapp.business.entities.*;
import java.text.MessageFormat;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class OrderLineRepository extends AbstractRepository<OrderLine>{

    private static final String FIND_BY_USER_AND_PRODUCT_QUERY = 
            "SELECT COUNT(*) FROM OrderLine o WHERE " +
            "o.order.state = es.storeapp.business.entities.OrderState.COMPLETED " + 
            "AND o.order.user.id = {0} AND o.product.id = {1}";

    public boolean findIfUserBuyProduct(Long userId, Long productId) {
        Query query = entityManager.createQuery(MessageFormat.format(FIND_BY_USER_AND_PRODUCT_QUERY, userId, productId));
        return ((Long) query.getSingleResult()) > 0;
    }
    
}
