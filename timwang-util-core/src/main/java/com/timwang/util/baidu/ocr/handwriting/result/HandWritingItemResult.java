package com.timwang.util.baidu.ocr.handwriting.result;

import java.io.Serializable;

/**
 * @author wangjun
 * @date 2020-10-31
 */
public class HandWritingItemResult implements Serializable {
    private String words;

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }
}
