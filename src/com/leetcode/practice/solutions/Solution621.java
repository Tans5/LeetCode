package com.leetcode.practice.solutions;

import java.util.*;

public class Solution621 {

    public static class Task {
        public final char task;
        public int waitTime = 0;
        public int count = 0;
        public Task(char t) {
            this.task = t;
        }
    }

    public static class TaskChain {
        public final Task task;
        public TaskChain next = null;
        public TaskChain pre = null;
        public TaskChain(Task t) {
            this.task = t;
        }

        /**
         * @return  Is finish and cost time.
         */
        public Object[] runCurrentTask(int coldTime) {
            int costTime = 0;
            TaskChain nextRunChain = null;
            if (task.count > 0) {
                if (task.waitTime <= 0) {
                    costTime = 1;
                } else {
                    costTime = task.waitTime + 1;
                }
                costTime(costTime);
                task.count --;
                task.waitTime = coldTime;
                nextRunChain = nextRunTask();
            }
            if (task.count <= 0) {
                boolean isFinish = this == next;
                pre.next = next;
                next.pre = pre;
                next = null;
                pre = null;
                if (isFinish) {
                    return new Object[]{costTime, null};
                }
            }
            return new Object[]{costTime, nextRunChain};
        }

        public void costTime(int costTime) {
            TaskChain focus = next;
            while (focus != this && focus != null) {
                int wTime = focus.task.waitTime;
                focus.task.waitTime = Math.max(wTime - costTime, 0);
                focus = focus.next;
            }
        }

        public TaskChain nextRunTask() {
            int targetChainTaskCount = task.count;
            int waitTime = task.waitTime;
            TaskChain result = this;
            TaskChain focus = next;
            while (focus != null && focus != this) {
                if (focus.task.waitTime < waitTime || (focus.task.waitTime == waitTime && focus.task.count > targetChainTaskCount)) {
                    targetChainTaskCount = focus.task.count;
                    waitTime = focus.task.waitTime;
                    result = focus;
                }
                focus = focus.next;
            }
            return result;
        }
    }

    public static int leastInterval(char[] tasks, int n) {
        if (tasks.length == 0) {
            return 0;
        }
        LinkedHashMap<Character, Task> taskMap = new LinkedHashMap<>(16, 0.75f, true);
        for (Character t: tasks) {
            if (!taskMap.containsKey(t)) {
                Task task = new Task(t);
                task.count = 1;
                taskMap.put(t, task);
            } else {
                taskMap.get(t).count ++;
            }
        }
        TaskChain head = null;
        TaskChain focus = null;
        List<Task> taskList = new ArrayList<>(taskMap.values());
        taskList.sort((o1, o2) -> o2.count - o1.count);
        for (Task t: taskList) {
            if (head == null) {
                head = new TaskChain(t);
                focus = head;
                continue;
            }
            TaskChain chain = new TaskChain(t);
            chain.pre = focus;
            focus.next = chain;
            focus = chain;
        }
        focus.next = head;
        head.pre = focus;
        focus = head;
        int costTime = 0;
        while (true) {
            Object[] r = focus.runCurrentTask(n);
            costTime += (Integer) r[0];
            if (r[1] == null) {
                break;
            }
            focus = (TaskChain) r[1];
        }

        return costTime;
    }
}
