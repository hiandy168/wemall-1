package com.wemall.foundation.domain.query;

import com.wemall.core.query.QueryObject;
import org.springframework.web.servlet.ModelAndView;

public class CommonGoodsClassQueryObject extends QueryObject {
    public CommonGoodsClassQueryObject(String currentPage, ModelAndView mv, String orderBy, String orderType){
        super(currentPage, mv, orderBy, orderType);
    }

    public CommonGoodsClassQueryObject(){
    }
}



