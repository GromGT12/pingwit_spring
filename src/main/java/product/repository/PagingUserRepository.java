package product.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import product.repository.model.User;

public interface PagingUserRepository extends PagingAndSortingRepository<User, Integer> {

}
