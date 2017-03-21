package cc.anmink.service;

import cc.anmink.entity.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Jamin on 2017/3/21.
 */
@Repository
public interface UserService {
    List<SysUser> getAll();
}
