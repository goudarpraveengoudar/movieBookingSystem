package com.vishwa.movieBookingSystem.services.impl;

import com.vishwa.movieBookingSystem.dao.UserDao;
import com.vishwa.movieBookingSystem.entities.User;
import com.vishwa.movieBookingSystem.exceptions.UserDetailsNotFoundException;
import com.vishwa.movieBookingSystem.exceptions.UserNameAlreadyExistsException;
import com.vishwa.movieBookingSystem.exceptions.UserTypeDetailsNotFoundException;
import com.vishwa.movieBookingSystem.services.UserService;
import com.vishwa.movieBookingSystem.services.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    /**
     * Allow the creation of users
     * I should also not allowed to create an existing
     * 1. to create on existing / duplicate user
     * 2. I should not be allowed to create a user of wrong
     */


    @Autowired
    private UserDao userDao;

    @Autowired
    private UserTypeService userTypeService;

    @Override
    public User acceptUserDetails(User user) throws UserNameAlreadyExistsException, UserTypeDetailsNotFoundException {
        if (userDao.findByUsername(user.getUsername()).isPresent()) {
            throw new UserNameAlreadyExistsException("This username is already taken.");
        }
        userTypeService.getUserTypeDetails(user.getUserType().getUserTypeId());
        return userDao.save(user);
    }

    /**
     * Fetch the user details based on the user Id
     */
    @Override
    public User getUserDetails(int id) throws UserDetailsNotFoundException {
        return userDao.findById(id)
                .orElseThrow(() -> new UserDetailsNotFoundException("Customer not found with id: " + id));
    }

    /**
     * Fetch the user by it's name
     */
    @Override
    public User getUserDetailsByUsername(String username) throws UserDetailsNotFoundException {
        return userDao.findByUsername(username)
                .orElseThrow(() -> new UserDetailsNotFoundException("Customer not found with username: " + username));
    }

    /**
     * Update the user details
     */

    @Override
    public User updateUserDetails(int id, User user)
            throws UserNameAlreadyExistsException, UserDetailsNotFoundException, UserTypeDetailsNotFoundException {
        User savedUser = getUserDetails(id);
        if (userDao.findByUsername(user.getUsername()).isPresent()) {
            throw new UserNameAlreadyExistsException("This username is already taken.");
        }
        userTypeService.getUserTypeDetails(user.getUserType().getUserTypeId());

        if (isNotNullOrZero(user.getFirstName())) {
            savedUser.setFirstName(user.getFirstName());
        }

        if (isNotNullOrZero(user.getLastName())) {
            savedUser.setLastName(user.getLastName());
        }

        if (isNotNullOrZero(user.getUsername())) {
            savedUser.setUsername(user.getUsername());
        }

        if (isNotNullOrZero(user.getPassword())) {
            savedUser.setPassword(user.getPassword());
        }

        if (isNotNullOrZero(user.getDateOfBirth())) {
            savedUser.setDateOfBirth(user.getDateOfBirth());
        }

        if (isNotNullOrZero(user.getPhoneNumbers())) {
            savedUser.setPhoneNumbers(user.getPhoneNumbers());
        }

        if (isNotNullOrZero(user.getUserType())) {
            savedUser.setUserType(user.getUserType());
        }

        if (isNotNullOrZero(user.getLanguage())) {
            savedUser.setLanguage(user.getLanguage());
        }

        return userDao.save(savedUser);
    }

    private boolean isNotNullOrZero(Object obj) {
        return obj != null;
    }


}
