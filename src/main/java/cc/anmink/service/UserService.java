package cc.anmink.service;

import cc.anmink.entity.SysRole;
import cc.anmink.entity.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Jamin on 2017/3/21.
 */
@Repository
public interface UserService {
    List<SysUser> getAll();

    SysUser create(String username, String password, String avatar, String name, String address, Long phone, Long created, String roles_name);
}
