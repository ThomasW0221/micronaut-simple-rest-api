package io.twinterf.service;

import io.twinterf.entity.Friend;
import io.twinterf.repository.FriendRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class FriendService {

    @Inject
    private FriendRepository friendRepository;

    private Logger logger = LoggerFactory.getLogger(FriendService.class);

    public Friend getFriendById(Long id) {
        return friendRepository.findById(id).orElse(null);
    }

    public Iterable<Friend> getAllFriends() {
        return friendRepository.findAll();
    }

    public void addFriend(Friend friend) {
        friendRepository.save(friend);
        logger.info("a new friend has been added to the database");
    }

    public void deleteFriend(Long id) {
        friendRepository.deleteById(id);
        logger.info("Friendship with " + id + " is over");
    }

    public Friend getFriendByName(String name) {
        logger.info("name to query for: " + name);
        return friendRepository.findByName(name);
    }
}
