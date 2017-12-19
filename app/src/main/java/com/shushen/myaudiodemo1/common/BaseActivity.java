package com.shushen.myaudiodemo1.common;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.shushen.myaudiodemo1.constant.Constant;

/**
 * Created by Administrator on 2017/12/19.
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    /**
     * 申请指定权限
     */

    public void requestPermission(int code,String... permissions){

        ActivityCompat.requestPermissions(this,permissions,code);
    }

    /**
     * 判断是否有权限
     * @return
     */
    public boolean hasPermissions(String... permissions){
        for (String permission: permissions) {
            if(ContextCompat.checkSelfPermission(this,permission)!= PackageManager.PERMISSION_GRANTED){
                 return false;
            }
        }
        return true;
    }


    /**
     * 有权限后执行之后的操作
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch(requestCode){
           case Constant.WRITE_READ_EXTERNAL_CODE:
                   if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                       doSDCardPermission();
                   }
            break;
        }

    }

    private void doSDCardPermission() {

    }
}
