package com.javadevmz.leetcode.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 841. Keys and Rooms

 * There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0.
 * Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.

 * When you visit a room, you may find a set of distinct keys in it. Each key has a number on it,
 * denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.

 * Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i,
 * return true if you can visit all the rooms, or false otherwise.
 */
public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()]; //track the visited rooms to avoid cycles
        Queue<Integer> keys = new LinkedList<>();
        Integer currentRoom = 0;

        keys.add(0);

        while(!keys.isEmpty()) {
            currentRoom = keys.poll();
            visited[currentRoom] = true; //mark as visited
            //collect all the keys in the room
            for(Integer key : rooms.get(currentRoom)) {
                if(!visited[key]) {
                    keys.add(key);
                }
            }
        }

        //if there are rooms that haven't been visited, return false
        for(Boolean roomVisited : visited) {
            if(!roomVisited) return false;
        }
        return true;
    }
}
