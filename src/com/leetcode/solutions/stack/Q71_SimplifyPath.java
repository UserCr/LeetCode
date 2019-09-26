package com.leetcode.solutions.stack;

import com.leetcode.solutions.SolutionInterface;

import java.util.LinkedList;
import java.util.List;

public class Q71_SimplifyPath implements SolutionInterface {
    @Override
    public void run() {
        System.out.println(simplifyPath("/..."));
    }

    //无聊水题。注意样例中没有说明..可以出现在普通目录名中，也就是说出现'.'的字符串不仅仅是'.'和'..'，其他情况要当作普通目录名处理。
    public String simplifyPath(String path) {
        List<String> resParts = new LinkedList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < path.length(); ) {
            while (i < path.length() && '/' == path.charAt(i)) {
                i++;
            }
            while (i < path.length() && '/' != path.charAt(i)) {
                stringBuilder.append(path.charAt(i++));
            }
            String curString = stringBuilder.toString();
            stringBuilder.delete(0, stringBuilder.length());
            if ("..".equals(curString)) {
                if (resParts.size() > 0) {
                    resParts.remove(resParts.size() - 1);
                }
            } else if (!"".equals(curString) && !".".equals(curString)) {
                resParts.add(curString);
            }
        }
        return "/" + String.join("/", resParts);
    }
}
