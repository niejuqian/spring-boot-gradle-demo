package com.demo.common.util;

import com.github.stuxuhai.jpinyin.PinyinException;
import com.github.stuxuhai.jpinyin.PinyinHelper;

/**
 * 拼音转换工具
 * Created by linyh on 2017/9/9.
 */
public class PinyinUtil {

    /**
     * 获取中文单词的首字母
     * @param word
     * @return
     */
    public static Character getInitial(String word){
        if(StringUtil.isNil(word)) return null;
        try {
            String s = PinyinHelper.getShortPinyin(word);
            return s.charAt(0);
        } catch (PinyinException e) {
            e.printStackTrace();
            throw new RuntimeException("获取中文单词的首字母报错：" + e);
        }
    }
    public static String getFirstWordUpper(String word){
        if(StringUtil.isNil(word)) return null;
        try {
            String s = PinyinHelper.getShortPinyin(word);
            return s.toUpperCase();
        } catch (PinyinException e) {
            e.printStackTrace();
            throw new RuntimeException("获取中文单词的首字母报错：" + e);
        }
    }
/*   public static void main(String[] args) {
        String word = "广发钱袋子";
        System.out.println(getFirstWord(word));
   }*/
}
