package cc.anmink.dao;

import cc.anmink.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Jamin on 2017/2/26.
 */
public interface SysUserRepository extends JpaRepository<SysUser, Long> {
    SysUser findByUsername(String username);

//    @Query("select su from (sys_user su inner join sys_user_roles sur on su.id = sur.sys_user_id) inner join sys_role sr on sur.roles_id = sr.id where sr.id =2 order by su.id ASC")
    @Query(value = "select su from SysUser su where su.username <> 'admin'")
    List<SysUser> findAll();
}
