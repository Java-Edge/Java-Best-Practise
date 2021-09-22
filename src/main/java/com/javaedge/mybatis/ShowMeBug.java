package com.javaedge.mybatis;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author apple
 */
public class ShowMeBug {

    /**
     * 将 ["1=22", "1=23", "1=24", "2=12"] 格式的集合转为形如 { "user_tags_1": "22,23,24", "user_tags_2":"12"} 的 JSON字符串
     */
    @Test
    public void mergeToJSON() {
        LinkedList<String> list = Lists.newLinkedList();
        list.push("1=22");
        list.push("1=23");
        list.push("1=24");
        list.push("2=12");
        Map<String, List<Integer>> map = new HashMap<>();
        String prefix = "user";
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                String pair = list.get(i); // 格式形如："12=35"
                String[] parts = pair.split("=");
                List<Integer> tagIds = map.computeIfAbsent(prefix + "_tags_" + parts[0], k -> new ArrayList<>());
                tagIds.add(Integer.parseInt(parts[1]));
            }
        }

        Map<String, String> userTagsMap = new HashMap<>();
        for (String key : map.keySet()) {
            final List<Integer> tagIds = map.get(key);
            userTagsMap.put(key, tagIds.stream().map(Object::toString).collect(Collectors.joining(",")));
        }
        System.out.println(JSON.toJSONString(userTagsMap));
    }

}
