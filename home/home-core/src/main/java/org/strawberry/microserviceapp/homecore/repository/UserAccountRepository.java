package org.strawberry.microserviceapp.homecore.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.strawberry.microserviceapp.homecore.model.UserAccount;

import java.util.List;

public interface UserAccountRepository extends MongoRepository<UserAccount, String> {

    public UserAccount findByUsername( String username );

    public List<UserAccount> findAll( );

}
