package org.ansj.batch;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.core.text.csv.*;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.poi.excel.ExcelFileUtil;
import cn.hutool.poi.excel.ExcelUtil;
import org.ansj.domain.Result;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.junit.Test;

import java.util.List;

/**
 * 批量文件识别
 *
 * @author shenjian
 * @sinace 2024/6/25
 */
public class BatchFileTest {

    @Test
    public void testBatchFile() {
        CsvReader reader = CsvUtil.getReader();
        List<AddrDto> data = reader.read(ResourceUtil.getUtf8Reader("D:\\IdeaProject\\ansj_seg\\src\\test\\java\\org\\ansj\\batch\\test.csv"), AddrDto.class);
        for (AddrDto dto : data) {
            //getRawList返回一个List列表，列表的每一项为CSV中的一个单元格（既逗号分隔部分）
            Result result = ToAnalysis.parse(dto.getAddress());
            dto.setRet(result.toString());
        }

        CsvWriter writer = CsvUtil.getWriter("D:/testWrite.csv", CharsetUtil.CHARSET_UTF_8);
        writer.writeBeans(data);
    }
}
