package io.twinterf.repository;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;
import io.twinterf.entity.Friend;

import javax.transaction.Transactional;

@Repository
public interface FriendRepository extends CrudRepository<Friend, Long> {

    @Transactional
    public Friend findByName(String name);
}
