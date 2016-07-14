package edu.feicui.safebox.utils;

import android.content.Context;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by admin on 2016/7/14.
 */
public class DBManager {

    /**
     * 复制本地 Assets  中的 db  文件到指定目录中
     *
     * @param context
     * @param path    Assets 内 内 db  文件路径
     * @param toFile  目标位置
     * @throws IOException
     */
    public static void copyAssetsToFile(Context context, String path,
                                            File toFile) throws IOException {
        InputStream inStream = null;
//  输入流( 用来读取当前项目的 Assets  内的 db  文本)
        BufferedInputStream buffInputStream = null;
//  输出流( 用来将读取到的 db  信息写到指定目录文件 toFile  中去)
        BufferedOutputStream buffOutputStream = null;
        try {
            inStream = context.getAssets().open(path);
            buffInputStream = new BufferedInputStream(inStream);
            buffOutputStream = new BufferedOutputStream(
                    new FileOutputStream(toFile, false));
// IO  操作
            int len = 0;
            byte[] buff = new byte[2 * 1024];
            while ((len = buffInputStream.read(buff)) != -1) {
                buffOutputStream.write(buff, 0, len);
            }
            buffOutputStream.flush();
        } catch (IOException e) {
            throw e;
        } finally {
// IO  关闭
            buffOutputStream.close();
            buffInputStream.close();
            inStream.close();
        }
    }
}
