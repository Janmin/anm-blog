package cc.anmink.service.Impl;

import cc.anmink.dao.SysUserRepository;
import cc.anmink.entity.SysRole;
import cc.anmink.entity.SysUser;
import cc.anmink.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Jamin on 2017/3/21.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    SysUserRepository sysUserRepository;

    @Override
    public List<SysUser> getAll() {
        return sysUserRepository.findAll();
    }

    @Override
    public SysUser create(String username, String password, String avatar, String name, String address, Long phone, Long created, String roles_name) {
        SysRole sysRole = new SysRole(roles_name);

        List<SysRole> sysRoles = new ArrayList<SysRole>();
        sysRoles.add(sysRole);

        SysUser sysUser = new SysUser(username, password, avatar, name, address, phone, created, sysRoles);
        return sysUserRepository.save(sysUser);
    }
}
