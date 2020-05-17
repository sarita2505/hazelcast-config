package com.hazelcast.config;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import java.util.HashMap;
import java.util.Map;

public class HazelCast {
  private static Map<String,Config> map=new HashMap<>();
    public static HazelcastInstance instance(String name) {
        Config config = HazelCast.getGroupConfig(name);
        return Hazelcast.newHazelcastInstance(config);
    }

    private static Config getGroupConfig(String groupName) {

        if (map.containsKey(groupName)){
            return map.get(groupName);
        }
        else{
        Config config = new Config();
        config.getGroupConfig().setName(groupName);
        map.put(groupName,config);
        return config;
        }
    }
}
