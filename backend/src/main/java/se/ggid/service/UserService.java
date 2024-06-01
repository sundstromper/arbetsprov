package se.ggid.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.jboss.logging.Logger;
import se.ggid.controller.UserController;
import se.ggid.dto.UserDto;

import java.util.HashSet;
import java.util.Set;

@Transactional
@ApplicationScoped
public class UserService {

    Set<UserDto> users = new HashSet<>();

    public Set<UserDto> findAll() {
        return users;
    }

    public UserDto addUser(UserDto userDto) {
        UserDto user = new UserDto();
        user.setName(userDto.getName());
        user.setAddress(userDto.getAddress());
        user.setEmail(userDto.getEmail());
        user.setTelephone(userDto.getTelephone());
        users.add(user);
        return user;
    }

    public void rensaUsers()
    {
        users.clear();
    }

}
