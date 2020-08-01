package app.repository;


import app.models.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Long> {

    @Query(value = "SELECT * from bookstore2.users where name=:name", nativeQuery = true)
    Users getName(String name);
}
