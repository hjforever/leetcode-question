package io.hjforever.leetcode.editor.cn.week.d80;

public class Test03 {
    public static void main(String[] args) {
        Test03 t = new Test03();
    }


    public boolean strongPasswordCheckerII(String password) {
        //它有至少 8 个字符。
        //至少包含 一个小写英文 字母。
        //至少包含 一个大写英文 字母。
        //至少包含 一个数字 。
        //至少包含 一个特殊字符 。特殊字符为："!@#$%^&*()-+" 中的一个。
        //它 不 包含 2 个连续相同的字符（比方说 "aab" 不符合该条件，但是 "aba" 符合该条件）。


        if (password.length() < 8) return false;

        boolean t = false;
        boolean low = false;
        boolean high = false;
        boolean digest = false;
        int n = password.length();
        for (int i = 0; i < n; i++) {
            char c = password.charAt(i);
            if (i < n - 1) {
                if (password.charAt(i) == password.charAt(i + 1)) {
                    return false;
                }
            }
            if (Character.isDigit(c)) {
                digest = true;
            }
            if (c >= 'a' && c <= 'z') low = true;
            if (c >= 'A' && c <= 'Z') high = true;
            if ("!@#$%^&*()-+".indexOf(c) != -1) t = true;
        }

        return t && low && high && digest;
    }
}
