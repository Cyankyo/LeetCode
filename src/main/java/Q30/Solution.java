/*
 * Project: LeetCode
 *
 * File Created at 2022/2/22
 *
 * Copyright 2016 kyo Corporation Limited.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * ZYHY Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license.
 */

package Q30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***
 * @Type
 * @Desc
 * @Author cyankyo
 * @Date 2022/2/22 16:26
 * @Version 1.0
 */
//给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
//
// 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。
//
//
//
// 示例 1：
//
//
//输入：s = "barfoothefoobarman", words = ["foo","bar"]
//输出：[0,9]
//解释：
//从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//输出的顺序不重要, [9,0] 也是有效答案。
//
//
// 示例 2：
//
//
//输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
//输出：[]
//
//
// 示例 3：
//
//
//输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
//输出：[6,9,12]
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 104
// s 由小写英文字母组成
// 1 <= words.length <= 5000
// 1 <= words[i].length <= 30
// words[i] 由小写英文字母组成
//
// Related Topics 哈希表 字符串 滑动窗口


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> wordsMap = new HashMap<>();
        List<Integer> location = new ArrayList<>();
        int wordNum = words.length;
        if (wordNum == 0) {
            return location;
        }
        int wordLength = words[0].length();
        for (String word : words) {
            Integer value = wordsMap.getOrDefault(word, 0);
            wordsMap.put(word, value + 1);
        }

        for (int i = 0; i < wordLength; i++) {
            HashMap<String, Integer> hasWords = new HashMap<String, Integer>();
            int num = 0;
            for (int j = i; j < s.length() - wordLength * wordNum + 1; j += wordLength) {
                while (num < wordNum) {
                    String subString = s.substring(j + num * wordLength, j + (num + 1) * wordLength);

                    if (wordsMap.containsKey(subString)) {
                        int value = hasWords.getOrDefault(subString, 0);
                        hasWords.put(subString, value + 1);

                        if (hasWords.get(subString) > wordsMap.get(subString)) {
                            int removesNum = 0;
                            while (hasWords.get(subString) > wordsMap.get(subString)) {
                                String firstWord = s.substring(j + removesNum * wordLength, j + (removesNum + 1) * wordLength);
                                value = hasWords.getOrDefault(firstWord, 0);
                                hasWords.put(firstWord, value - 1);
                                removesNum++;
                            }
                            num = num - removesNum + 1;
                            j = j + (removesNum - 1) * wordLength;
                            break;
                        }

                    } else {
                        hasWords.clear();
                        j += wordLength * num;
                        num = 0;
                        break;
                    }
                    num++;
                }
                if (num == wordNum) {
                    location.add(j);
                }
                if ( num > 0) {
                    String firstWord = s.substring(j, j + wordLength);
                    int v = hasWords.get(firstWord);
                    hasWords.put(firstWord, v - 1);
                    num--;
                }

            }

        }
        return location;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/*
 * Revision history
 * -------------------------------------------------------------------------
 *
 * Date Author Note
 * -------------------------------------------------------------------------
 * 2022/2/22 cyankyo create
 */