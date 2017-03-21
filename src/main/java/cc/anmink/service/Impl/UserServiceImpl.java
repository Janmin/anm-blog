package cc.anmink.service.Impl;

import cc.anmink.dao.SysUserRepository;
import cc.anmink.entity.SysUser;
import cc.anmink.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
