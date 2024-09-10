//package com.restapi.spring_crud.service;
//
//import com.restapi.spring_crud.api.model.Employee;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//@Service
//public class UserService {
//
//    private List<Employee> userList;
//
//    public UserService() {
//        userList = new ArrayList<>();
//
//        Employee user1 = new Employee(1, "samuella", "mugisha", "itsmugishasamuella@gmail.com");
//        Employee user2 = new Employee(2, "joshua", "kwizera", "joshuakwizera@gmail.com");
//        Employee user3 = new Employee(3, "janela", "keza", "janela@gmail.com");
//        Employee user4 = new Employee(4, "Ian", "Kayitare", "ikayitare@gmail.com");
//        Employee user5 = new Employee(5, "Jane", "Kayitare", "janekayitare@gmail.com");
//
//        userList.addAll(Arrays.asList(user1, user2, user3, user4, user5));
//    }
////
////
////    public Optional<User> getUser(Integer id) {
////        Optional<User> optional = Optional.empty();
////        for(User user : userList){
////            if(id.equals(user.get_id())){
////                optional = Optional.of(user);
////                return optional;
////            }
////        }
////        return optional;
////    }
//}
