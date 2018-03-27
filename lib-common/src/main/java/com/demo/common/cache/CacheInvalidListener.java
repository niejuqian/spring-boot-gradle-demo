package com.demo.common.cache;

/**
 * 引起缓存失效的的监听
 * Created by linyh on 2017/9/13.
 */
public interface CacheInvalidListener {

    /**
     * 触发失效
     * @param key 需要失效的key值
     */
    public void invalid(String key);

}
