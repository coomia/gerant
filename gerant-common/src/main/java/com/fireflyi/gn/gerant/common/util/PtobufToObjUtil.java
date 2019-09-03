package com.fireflyi.gn.gerant.common.util;

import com.fireflyi.gerant.rpclient.protobuf.Greq;
import com.fireflyi.gn.gerant.domain.entity.GreqEntity;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/8/16
 * DESC TODO
 */
public class PtobufToObjUtil {

    public static GreqEntity greqTran(Greq var1){
        GreqEntity entity = new GreqEntity();
        entity.setCmdId(var1.getCmdId());
        entity.setUid(var1.getUid());
        entity.setObjId(var1.getObjId());
        entity.setReqMsg(var1.getReqMsg());
        entity.setTime(var1.getTime());
        return entity;
    }

    public static Greq objToGreq(GreqEntity obj1){
        Greq.Builder req = Greq.newBuilder();
        req.setCmdId(obj1.getCmdId());
        req.setUid(obj1.getUid());
        req.setObjId(obj1.getObjId());
        req.setReqMsg(obj1.getReqMsg());
        req.setTime(obj1.getTime());
        return req.build();
    }

}
