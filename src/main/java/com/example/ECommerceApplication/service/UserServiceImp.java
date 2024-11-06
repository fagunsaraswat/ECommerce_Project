package com.example.ECommerceApplication.service;

import java.util.ArrayList;
import java.util.List;

import com.example.ECommerceApplication.model.*;
import com.example.ECommerceApplication.repository.UserRepository;
import com.example.ECommerceApplication.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImp(UserRepository userRepository, ProductRepository productRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.passwordEncoder = passwordEncoder;
    }

    List<UserEntity> users = new ArrayList<>();

    @Override
    public String createUser(UserEntity user) { //have to convert this model (user) to entity object (So we can save it into table)
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(user, userEntity); //stored in entity obj
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userRepository.save(userEntity);

        // users.add(user);
        return "User Added Successfully.";
    }

    @Override
    public String getUserById(Long id) {
        UserEntity user = userRepository.findById(id).orElse(null);

        if (user != null && !user.isDeleted()) {
            return user.getName();
        } else {
            return "No User Found";
        }
    }

    @Override
    public List<UserEntity> getAllUsers() {
        List<UserEntity> usersList = userRepository.findAll();
        List<UserEntity> users = new ArrayList<>();

        for(UserEntity userE : usersList){
            UserEntity u = new UserEntity();
            u.setName(userE.getName());
            u.setSurname(userE.getSurname());
            u.setEmail(userE.getEmail());
            u.setAge(userE.getAge());
            // u.setId(userE.getUserId());

            users.add(u);
        }
        return users;
    }

    @Override
    public String deleteUser(Long id) {
        UserEntity user = userRepository.findById(id).get();

        if(user!=null){
            user.setDeleted();
            userRepository.save(user);
            return "User Soft-Deleted Succesfully";
        }
        else{
            return "User Not Found";
        }
    }

    @Override
    public String updateUser(Long id, UserEntity user) {
        UserEntity existingUser = userRepository.findById(id).get();

        existingUser.setEmail(user.getEmail());
        existingUser.setName(user.getName());
        existingUser.setSurname(user.getSurname());
        existingUser.setAge(user.getAge());

        userRepository.save(existingUser);
        return "Updated Succesfully";
    }

    @Override
    public void buyProduct(Long userId, Long productId) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        ProductEntity product = productRepository.findById(productId).orElse(null);

        if(user!=null && product!=null){
            user.getPurchasedProducts().add(product);
            userRepository.save(user);
        }
    }

    @Override
    public List<ProductEntity> getPurchasedProducts(Long userId) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        return (user != null) ? user.getPurchasedProducts() : List.of();
    }

    @Override
    public ProductEntity getProductById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }
}
