package com.github.kyrenesjtv.stepbystep.designmodel.oo.abs;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;

/**
 * @author huojianxiong
 * @Description FileLogger
 * @Date 2022/2/14 18:42
 */
public class FileLogger extends Logger {

    private Writer fileWriter;

    public FileLogger(String name, boolean enabled, Level minPermittedLevel, String filepath) throws IOException {
        super(name, enabled, minPermittedLevel);
        this.fileWriter = new FileWriter(filepath);
    }

    @Override
    protected void doLog(Level level, String message) {
        // 格式化level和message,输出到日志文件
//         fileWriter.write(...);
    }
}
