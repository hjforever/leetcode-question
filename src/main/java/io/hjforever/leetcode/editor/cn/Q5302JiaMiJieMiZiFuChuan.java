//给你一个字符数组 keys ，由若干 互不相同 的字符组成。还有一个字符串数组 values ，内含若干长度为 2 的字符串。另给你一个字符串数组
//dictionary ，包含解密后所有允许的原字符串。请你设计并实现一个支持加密及解密下标从 0 开始字符串的数据结构。 
//
// 字符串 加密 按下述步骤进行： 
//
// 
// 对字符串中的每个字符 c ，先从 keys 中找出满足 keys[i] == c 的下标 i 。 
// 在字符串中，用 values[i] 替换字符 c 。 
// 
//
// 字符串 解密 按下述步骤进行： 
//
// 
// 将字符串每相邻 2 个字符划分为一个子字符串，对于每个子字符串 s ，找出满足 values[i] == s 的一个下标 i 。如果存在多个有效的 i ，
//从中选择 任意 一个。这意味着一个字符串解密可能得到多个解密字符串。 
// 在字符串中，用 keys[i] 替换 s 。 
// 
//
// 实现 Encrypter 类： 
//
// 
// Encrypter(char[] keys, String[] values, String[] dictionary) 用 keys、values 和 
//dictionary 初始化 Encrypter 类。 
// String encrypt(String word1) 按上述加密过程完成对 word1 的加密，并返回加密后的字符串。 
// int decrypt(String word2) 统计并返回可以由 word2 解密得到且出现在 dictionary 中的字符串数目。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["Encrypter", "encrypt", "decrypt"]
//[[['a', 'b', 'c', 'd'], ["ei", "zf", "ei", "am"], ["abcd", "acbd", "adbc", 
//"badc", "dacb", "cadb", "cbda", "abad"]], ["abcd"], ["eizfeiam"]]
//输出：
//[null, "eizfeiam", 2]
//
//解释：
//Encrypter encrypter = new Encrypter([['a', 'b', 'c', 'd'], ["ei", "zf", "ei", 
//"am"], ["abcd", "acbd", "adbc", "badc", "dacb", "cadb", "cbda", "abad"]);
//encrypter.encrypt("abcd"); // 返回 "eizfeiam"。 
//                           // 'a' 映射为 "ei"，'b' 映射为 "zf"，'c' 映射为 "ei"，'d' 映射为 
//"am"。
//encrypter.decrypt("eizfeiam"); // return 2. 
//                              // "ei" 可以映射为 'a' 或 'c'，"zf" 映射为 'b'，"am" 映射为 
//'d'。 
//                              // 因此，解密后可以得到的字符串是 "abad"，"cbad"，"abcd" 和 
//"cbcd"。 
//                              // 其中 2 个字符串，"abad" 和 "abcd"，在 dictionary 中出现，所以
//答案是 2 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= keys.length == values.length <= 26 
// values[i].length == 2 
// 1 <= dictionary.length <= 100 
// 1 <= dictionary[i].length <= 100 
// 所有 keys[i] 和 dictionary[i] 互不相同 
// 1 <= word1.length <= 2000 
// 1 <= word2.length <= 200 
// 所有 word1[i] 都出现在 keys 中 
// word2.length 是偶数 
// keys、values[i]、dictionary[i]、word1 和 word2 只含小写英文字母 
// 至多调用 encrypt 和 decrypt 总计 200 次 
// 
// Related Topics 哈希表 字符串 👍 4 👎 0


package io.hjforever.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Q5302JiaMiJieMiZiFuChuan {
    public static void main(String[] args) {

        //Solution solution = new Q5302JiaMiJieMiZiFuChuan().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Encrypter {
        //hash
        //解密需要逆向思维，因为解密需要判断的字符串是固定的，直接加密看是否和需要解密串是否一致，即密码破解撞库方式。

        Map<Character, String> encryptMap = new HashMap<>();
        Map<String, Integer> decryptCntMap = new HashMap<>();

        public Encrypter(char[] keys, String[] values, String[] dictionary) {
            for (int i = 0; i < keys.length; i++) {
                encryptMap.put(keys[i], values[i]);
            }
            for (String dict : dictionary) {
                String s = encrypt(dict);
                decryptCntMap.put(s, decryptCntMap.getOrDefault(s, 0) + 1);
            }
        }

        public String encrypt(String word1) {
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < word1.length(); i++) {
                res.append(encryptMap.get(word1.charAt(i)));
            }
            return res.toString();
        }

        public int decrypt(String word2) {
            return decryptCntMap.getOrDefault(word2, 0);
        }
    }

/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 * <p>
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */

/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */
//leetcode submit region end(Prohibit modification and deletion)

  }