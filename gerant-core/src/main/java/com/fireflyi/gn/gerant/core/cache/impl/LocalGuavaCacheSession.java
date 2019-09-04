package com.fireflyi.gn.gerant.core.cache.impl;

import com.fireflyi.gn.gerant.core.cache.LocalCacheService;
import com.fireflyi.gn.gerant.core.cache.LocalCacheSession;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.inject.Singleton;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/8/7
 * DESC Guava Cache（Cache)实现本地缓存，仅适用于route本机模式，集群请换memcache或者redis
 */
@Singleton
public class LocalGuavaCacheSession implements LocalCacheSession<String, NioSocketChannel> {

    private static final Logger log = LoggerFactory.getLogger(LocalGuavaCacheSession.class);

    private static Cache<String, NioSocketChannel> localCache;

    public LocalGuavaCacheSession(){
        localCache = CacheBuilder.newBuilder()
                        .maximumSize(5000)
                        //.expireAfterWrite(0L, TimeUnit.MINUTES) // 设置缓存永不失效
                        .concurrencyLevel(10) // 设置并发级别为10
                        .recordStats() // 开启缓存统计
                        .build();
    }


    @Override
    public Boolean set(String key,NioSocketChannel value) {
        localCache.put(key, value);
        return true;
    }

    @Override
    public NioSocketChannel get(String key) {
        return localCache.getIfPresent(key);
    }

    @Override
    public NioSocketChannel getLoad(String key) {
        try {
            return localCache.get(key, new Callable<NioSocketChannel>() {
                @Override
                public NioSocketChannel call() throws Exception {
                    return null;
                }
            });
        } catch (ExecutionException e) {
            e.printStackTrace();
            log.error("e->{}",e.getMessage());
        }
        return null;
    }

    @Override
    public Boolean del(String key){
        localCache.invalidate(key);
        return true;
    }

    public static void main(String[] a){
        LocalGuavaCacheSession lc = new LocalGuavaCacheSession();
        NioSocketChannel res = lc.get("a");
    }
}
