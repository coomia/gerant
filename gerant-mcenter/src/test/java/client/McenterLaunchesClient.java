package client;

import com.fireflyi.gerant.rpclient.McenterApiServiceGrpc;
import com.fireflyi.gerant.rpclient.protobuf.Greq;
import com.fireflyi.gerant.rpclient.protobuf.Gres;
import com.fireflyi.gn.gerant.domain.enumentity.CmdIdEnum;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/7/26
 * DESC TODO
 */
public class McenterLaunchesClient {
    private Logger logger= LoggerFactory.getLogger(McenterLaunchesClient.class);
    private final ManagedChannel channel;
    private final McenterApiServiceGrpc.McenterApiServiceBlockingStub blockingStub;

    public static void main(String[] args) throws Exception {
        McenterLaunchesClient client = new McenterLaunchesClient("localhost", 50051);
        try {
            /* Access a service running on the local machine on port 50051 */
            String user = "来自客户端的信息->222222222";
            if (args.length > 0) {
                user = args[0]; /* Use the arg as the name to greet if provided */
            }
            long a = System.currentTimeMillis();
            for(int i=0;i<100;i++) {
                client.greet(user);
            }
            long b = System.currentTimeMillis();
            System.out.printf(b-a+"");
        } finally {
            client.shutdown();
        }
    }

    public void greet(String name) {
        Greq.Builder req = Greq.newBuilder();
        req.setCmdId(CmdIdEnum.ADMIN_TO_ALL.cmdId);
        req.setReqMsg("推送消息哈哈哈啊");
        Greq request = req.build();

        Gres response;
        try {
            response = blockingStub.mcPipline(request);
        } catch (StatusRuntimeException e) {
            return;
        }
        logger.info("收到服务端信息返回: " + response.getResMsg());

    }

    public McenterLaunchesClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build());
    }

    McenterLaunchesClient(ManagedChannel channel) {
        this.channel = channel;
        blockingStub = McenterApiServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }
}
