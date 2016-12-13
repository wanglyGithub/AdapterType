package com.wangly.adaptertype;

/**
 * Created by wangly on 2016/12/13.
 */

/**
 * {"result": [
 * {
 * "content":"放手并不等于放弃",,
 * "createtime":"2016-02-12"
 * "title": "标题",
 * "type": 0
 * },
 * {
 * "content":"放手并不等于放弃",
 * "createtime":"2016-02-13"
 * "title": "标题",
 * "type": 0
 * },
 * <p>
 * <p>
 * {
 * "content":"放手并不等于放弃",,
 * "createtime":"2016-02-14"
 * "title": "标题",
 * "type": 1
 * },
 * <p>
 * <p>
 * ]
 * }
 */
public class RankDeial {
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
