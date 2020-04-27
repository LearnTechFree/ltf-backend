package com.learntechfree.ltf.user.role;

import com.learntechfree.ltf.common.enums.RoleType;
import com.learntechfree.ltf.entity.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository {
    Role findByName (RoleType name);
}
