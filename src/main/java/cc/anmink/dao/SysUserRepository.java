package cc.anmink.dao;

import cc.anmink.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Jamin on 2017/2/26.
 */
public interface SysUserRepository extends JpaRepository<SysUser, Long> {

    SysUser findByUsername(String username);
}
