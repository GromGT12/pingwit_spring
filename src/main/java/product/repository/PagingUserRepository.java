package product.repository;

import org.apache.catalina.User;
import org.springframework.data.repository.PagingAndSortingRepository;
public interface PagingUserRepository extends PagingAndSortingRepository<User, Integer> {

}
