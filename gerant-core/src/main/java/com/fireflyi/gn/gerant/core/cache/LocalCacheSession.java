package com.fireflyi.gn.gerant.core.cache;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/8/7
 * DESC 本地缓存服务
 */
public interface LocalCacheSession<K, V> {

     Boolean set(K var1, V var2);

     V get(K var);

     V getLoad(K var);

     Boolean del(K var);
}
