package org.ansj.batch;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

/**
 * @author shenjian
 * @sinace 2024/6/25
 */
@Data
public class AddrDto {

    @Alias("业务编号")
    private String no;

    @Alias("地址")
    private String address;

    @Alias("识别结果")
    private String ret;

}
