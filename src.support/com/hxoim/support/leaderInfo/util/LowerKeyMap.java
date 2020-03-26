package com.hxoim.support.leaderInfo.util;

import java.util.HashMap;

/**
 * @desc: 键值为小写的map
 * @author: lijing
 * @date: 2019/8/29
 */
public class LowerKeyMap<K,V> extends HashMap {
    @Override
    public V put(Object key, Object value){
        if (key != null){
            return (V) super.put(key.toString().toLowerCase(), value);
        }else{
            return (V) super.put(key, value);
        }

    }
}
