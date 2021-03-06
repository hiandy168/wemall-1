package com.wemall.foundation.service.impl;

import com.wemall.core.dao.IGenericDAO;
import com.wemall.core.query.GenericPageList;
import com.wemall.core.query.PageObject;
import com.wemall.core.query.support.IPageList;
import com.wemall.core.query.support.IQueryObject;
import com.wemall.foundation.domain.ChattingLog;
import com.wemall.foundation.service.IChattingLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ChattingLogServiceImpl
    implements IChattingLogService {
    @Resource(name = "chattingLogDAO")
    private IGenericDAO<ChattingLog> chattingLogDao;

    public boolean save(ChattingLog chattingLog){
        try {
            this.chattingLogDao.save(chattingLog);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public ChattingLog getObjById(Long id){
        ChattingLog chattingLog = (ChattingLog)this.chattingLogDao.get(id);
        if (chattingLog != null){
            return chattingLog;
        }

        return null;
    }

    public boolean delete(Long id){
        try {
            this.chattingLogDao.remove(id);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public boolean batchDelete(List<Serializable> chattingLogIds){
        for (Serializable id : chattingLogIds){
            delete((Long)id);
        }

        return true;
    }

    public IPageList list(IQueryObject properties){
        if (properties == null){
            return null;
        }
        String query = properties.getQuery();
        Map params = properties.getParameters();
        GenericPageList pList = new GenericPageList(ChattingLog.class, query,
                params, this.chattingLogDao);
        if (properties != null){
            PageObject pageObj = properties.getPageObj();
            if (pageObj != null)
                pList.doList(pageObj.getCurrentPage() == null ? 0 : pageObj
                             .getCurrentPage().intValue(), pageObj.getPageSize() == null ? 0 :
                             pageObj.getPageSize().intValue());
        }else{
            pList.doList(0, -1);
        }

        return pList;
    }

    public boolean update(ChattingLog chattingLog){
        try {
            this.chattingLogDao.update(chattingLog);
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public List<ChattingLog> query(String query, Map params, int begin, int max){
        return this.chattingLogDao.query(query, params, begin, max);
    }
}




