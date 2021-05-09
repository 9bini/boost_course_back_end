package org.edwith.webbe.securityexam.service;

import java.util.List;

import org.edwith.webbe.securityexam.service.security.UserEntity;
import org.edwith.webbe.securityexam.service.security.UserRoleEntity;


public interface UserDbService {
    public UserEntity getUser(String loginUserId);
    public List<UserRoleEntity> getUserRoles(String loginUserId);
}