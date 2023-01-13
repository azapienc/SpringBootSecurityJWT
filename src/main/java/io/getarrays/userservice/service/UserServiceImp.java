package io.getarrays.userservice.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.getarrays.userservice.domain.Role;
import io.getarrays.userservice.domain.User;
import io.getarrays.userservice.repository.RoleRepository;
import io.getarrays.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImp implements UserService {
  private final UserRepository userRepository;
  private final RoleRepository roleRepository;

  @Override
  public User saveUser(User user) {
    log.info("Saving new user {} to the database", user.getUsername());
    return userRepository.save(user);
  }

  @Override
  public Role saveRole(Role role) {
    log.info("Saving new role {} to the database", role.getName());
    return roleRepository.save(role);
  }

  @Override
  public void addRoleToUser(String username, String rolename) {
    User user = userRepository.findByUsername(username);
    Role role = roleRepository.findByName(rolename);
    log.info("Adding role {} to user {}", rolename, username);
    user.getRoles().add(role);
  }

  @Override
  public User getUser(String username) {
    log.info("Fetching user {}", username);
    return userRepository.findByUsername(username);
  }

  @Override
  public List<User> getUsers() {
    log.info("Fetching all users");
    return userRepository.findAll();
  }

}
