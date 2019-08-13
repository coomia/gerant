package app;

import com.fireflyi.gerant.rpclient.McenterApiServiceGrpc;
import com.fireflyi.gerant.rpclient.protobuf.Greq;
import com.fireflyi.gerant.rpclient.protobuf.Gres;
import com.fireflyi.gerant.rpclient.route.UcenterServiceGrpc;
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
public class RouteLaunchesClient {
    private Logger logger= LoggerFactory.getLogger(RouteLaunchesClient.class);
    private final ManagedChannel channel;
    private final McenterApiServiceGrpc.McenterApiServiceBlockingStub blockingStub;
    //路由服务客户端测试类
    private final UcenterServiceGrpc.UcenterServiceBlockingStub ucenterStub;

    /** Construct client connecting to HelloWorld server at {@code host:port}. */
    public RouteLaunchesClient(String host, int port) {
        this(ManagedChannelBuilder.forAddress(host, port)
                // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
                // needing certificates.
                .usePlaintext()
                .build());
    }

    public static void main(String[] args) throws Exception {
        RouteLaunchesClient client = new RouteLaunchesClient("localhost", 9001);
        try {
            /* Access a service running on the local machine on port 50051 */
            String user = "来自客户端的信息->222222222";
            if (args.length > 0) {
                user = args[0]; /* Use the arg as the name to greet if provided */
            }
            long a = System.currentTimeMillis();
            for(int i=0;i<1;i++) {
                client.greet(user);
            }
            long b = System.currentTimeMillis();
        } finally {
            client.shutdown();
        }
    }

    public void greet(String name) {
        Greq.Builder req = Greq.newBuilder();
        req.setUid("123456");
        Greq request = req.build();

        Gres response;
        try {
            //用户长连接注册
            //response = ucenterStub.register(request);
            response = ucenterStub.getUsers(request);
            //response = ucenterStub.outLine(request);
        } catch (StatusRuntimeException e) {
            return;
        }
        logger.info("服务端信息返回->{}", response.toString());

    }

    RouteLaunchesClient(ManagedChannel channel) {
        this.channel = channel;
        blockingStub = McenterApiServiceGrpc.newBlockingStub(channel);
        ucenterStub = UcenterServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }


}
