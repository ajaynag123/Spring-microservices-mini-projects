package com.mini_projects.user_service.domain.user.repository;

import com.mini_projects.user_service.domain.user.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class UserRepository {
    private final Map<Long, User> store = new HashMap<>();
    private Long sequence = 0L;

    public User save(User user){
        if(user.getId() == null){
            user.setId(++sequence);
        }

        store.put(user.getId(), user);
        return user;
    }

    public Optional<User> findById(Long id){
        return Optional.ofNullable(store.get(id));
    }
}
