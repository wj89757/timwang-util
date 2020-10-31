package com.timwang.util.baidu.ocr.handwriting.result;

import java.io.Serializable;
import java.util.List;

/**
 * @author wangjun
 * @date 2020-10-31
 */
public class HandWritingResult implements Serializable {
    private String log_id;
    private Integer words_result_num;
    private List<HandWritingItemResult> words_result;

    public String getLog_id() {
        return log_id;
    }

    public void setLog_id(String log_id) {
        this.log_id = log_id;
    }

    public Integer getWords_result_num() {
        return words_result_num;
    }

    public void setWords_result_num(Integer words_result_num) {
        this.words_result_num = words_result_num;
    }

    public List<HandWritingItemResult> getWords_result() {
        return words_result;
    }

    public void setWords_result(List<HandWritingItemResult> words_result) {
        this.words_result = words_result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("HandWritingResult{");
        sb.append("log_id='").append(log_id).append('\'');
        sb.append(", words_result_num=").append(words_result_num);
        sb.append(", words_result=").append(words_result);
        sb.append('}');
        return sb.toString();
    }
}
