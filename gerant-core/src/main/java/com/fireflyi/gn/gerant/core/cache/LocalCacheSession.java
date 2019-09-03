package com.fireflyi.gn.gerant.core.cache;

/**
 * @author by fireflyi (6025606@qq.com)
 * @website https://www.fireflyi.com
 * @date 2019/8/7
 * DESC 本地缓存服务
 */
public interface LocalCacheSession<K, V> {

    public Boolean set(K var1, V var2);

    public V get(K var);

    public Boolean del(K var);
}
