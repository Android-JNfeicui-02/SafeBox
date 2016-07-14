package edu.feicui.safebox;

import java.io.File;

/**
 * 执行数据库的读取
 * Created by admin on 2016/7/14.
 */
public class DBReader {

    // package name

    // 定义一个File对象
    static File 文件的全路径名;

    static {
        String packageName = "data/data/edu.feicui.safebox/";
        // 指定路径
        File path = new File(packageName);
        // 创建文件夹
        //path.mkdir();
        文件的全路径名 = new File(packageName, "commonnum.db");
        System.out.println(文件的全路径名.toString());
    }

    public static boolean isExistDBFile() {
        File file = DBReader.文件的全路径名;
        // 如果你要的File对象不存在 或者长度小于等于0
        if (!file.exists() || file.length() <= 0) {
            return false;
        }
        return true;
    }
}
