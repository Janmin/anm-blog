package cc.anmink.service;

import cc.anmink.entity.Message;
import cc.anmink.entity.SysMessage;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by xiezijian on 2017/5/30.
 */
@Repository
public interface MessageService {
    List<SysMessage> getAll();
}
