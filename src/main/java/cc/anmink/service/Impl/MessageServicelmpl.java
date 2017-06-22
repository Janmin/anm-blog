package cc.anmink.service.Impl;

import cc.anmink.dao.SysMessageRepoitory;
import cc.anmink.entity.Message;
import cc.anmink.entity.SysMessage;
import cc.anmink.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by xiezijian on 2017/5/30.
 */
@Service
public class MessageServicelmpl implements MessageService {
    @Autowired
    private SysMessageRepoitory sysMessageRepoitory;

    @Override
    public List<SysMessage> getAll() {
        return sysMessageRepoitory.findAll();
    }
}
