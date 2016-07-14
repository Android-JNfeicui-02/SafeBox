package edu.feicui.safebox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

import edu.feicui.safebox.utils.DBManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Copy(View view) {
        // Copy database to package name
        // 判断当前的package中有没有数据库的存在
        if (!DBReader.isExistDBFile()) {
            // 不存在则Copy到包名下
            try {
                DBManager.copyAssetsToFile(getApplicationContext(),"commonnum.db",DBReader.文件的全路径名);
            } catch (IOException e) {
                Toast.makeText(MainActivity.this, "数据库copy可能有异常", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }

    }
}
