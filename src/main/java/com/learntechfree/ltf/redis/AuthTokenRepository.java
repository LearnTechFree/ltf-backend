package com.learntechfree.ltf.redis;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthTokenRepository extends CrudRepository<AuthToken, String> {
    Optional<AuthToken> findByReferenceToken(String referenceToken);
}
