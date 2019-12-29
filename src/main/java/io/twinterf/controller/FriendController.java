package io.twinterf.controller;

import io.micronaut.http.annotation.*;
import io.twinterf.entity.Friend;
import io.twinterf.service.FriendService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

@Controller("/friends")
public class FriendController {

    Logger logger = LoggerFactory.getLogger(FriendController.class);

    @Inject
    private FriendService friendService;

    @Post()
    public void addFriend(@Body Friend friend) {
        logger.info("received friend to add from controller");
        friendService.addFriend(friend);
    }

    @Get("/id/{id}")
    public Friend getFriendById(@PathVariable Long id) {
        return friendService.getFriendById(id);
    }

    @Get("/name/{name}")
    public Friend getFriendByName(@PathVariable String name) {
        return friendService.getFriendByName(name);
    }

    @Get()
    public Iterable<Friend> getAllFriends() {
        return friendService.getAllFriends();
    }

    @Delete("/delete/{id}")
    public void deleteFriend(@PathVariable Long id) {
        friendService.deleteFriend(id);
    }

}
