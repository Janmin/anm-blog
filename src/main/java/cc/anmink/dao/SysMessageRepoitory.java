package cc.anmink.dao;

import cc.anmink.entity.Message;
import cc.anmink.entity.SysMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by xiezijian on 2017/5/30.
 */
public interface SysMessageRepoitory extends JpaRepository<SysMessage,Long> {
    List<SysMessage> findAll();
}
