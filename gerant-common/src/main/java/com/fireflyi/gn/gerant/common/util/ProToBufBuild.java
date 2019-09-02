package com.fireflyi.gn.gerant.common.util;

import com.fireflyi.gerant.rpclient.protobuf.Greq;
import com.fireflyi.gerant.rpclient.protobuf.GreqPtc;
import com.fireflyi.gn.gerant.domain.enumentity.CmdIdEnum;
import com.fireflyi.gn.gerant.domain.protobuf.GerantReqProtobuf;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/7/23
 * DESC TODO
 */
public class ProToBufBuild {

    /**
     * 获取ptb实例
     * @return
     */
    public static final GerantReqProtobuf.GerantReqProtocol ProToBufInstance(){
        return GerantReqProtobuf.GerantReqProtocol.getDefaultInstance();
    }

    /**
     * 获取ptb Builder
     * @return
     */
    public static final Greq.Builder ProToBufBuild(){
        return Greq.newBuilder();
    }

    /**
     * 构造ptb pinger
     * @return
     */
    public static final Greq.Builder Pinger(){
        Greq.Builder heartBeat = ProToBufBuild.ProToBufBuild();
        heartBeat.setCmdId(CmdIdEnum.PONG.cmdId);
        heartBeat.setReqMsg(CmdIdEnum.PONG.cmdId);
        return heartBeat;
    }

    public static final Greq buildReq(String cmdId, String reqMsg, String uid, String objId){
        Greq.Builder req = Greq.newBuilder();
        req.setCmdId(cmdId);
        req.setReqMsg(reqMsg);
        req.setUid(uid);
        req.setObjId(objId);
        Greq request = req.build();
        return request;
    }

}
