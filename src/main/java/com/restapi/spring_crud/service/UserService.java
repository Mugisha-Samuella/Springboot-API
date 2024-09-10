package com.restapi.spring_crud.service;

import com.restapi.spring_crud.api.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> userList;

    public UserService() {
        userList = new ArrayList<>();

        User user1 = new User(1, "samuella", "mugisha", "itsmugishasamuella@gmail.com");
        User user2 = new User(2, "joshua", "kwizera", "joshuakwizera@gmail.com");
        User user3 = new User(3, "janela", "keza", "janela@gmail.com");
        User user4 = new User(4, "Ian", "Kayitare", "ikayitare@gmail.com");
        User user5 = new User(5, "Jane", "Kayitare", "janekayitare@gmail.com");

        userList.addAll(Arrays.asList(user1, user2, user3, user4, user5));
    }
//
//
//    public Optional<User> getUser(Integer id) {
//        Optional<User> optional = Optional.empty();
//        for(User user : userList){
//            if(id.equals(user.get_id())){
//                optional = Optional.of(user);
//                return optional;
//            }
//        }
//        return optional;
//    }
}
