package com.shushen.myaudiodemo1.common;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

import com.shushen.myaudiodemo1.constant.Constant;

/**
 * Created by Administrator on 2017/12/19.
 */

public class BaseFragment extends Fragment {

    protected Activity mContext;

    public void requestPermission(int code,String... permissions){
        if (Build.VERSION.SDK_INT >= 23){
            requestPermissions(permissions,code);
        }
    }

    /**
     * 判断是否有权限
     * @return
     */
    public boolean hasPermissions(String... permissions){
        for (String permission: permissions) {
            if(ContextCompat.checkSelfPermission(getActivity(),permission)!= PackageManager.PERMISSION_GRANTED){
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
            case Constant.HARDWEAR_CAMERA_CODE:
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    doOpenCamera();
                }
                break;
            case Constant.WRITE_READ_EXTERNAL_CODE:
                if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    doWriteSDCard();
                }
                break;
        }

}

    private void doWriteSDCard() {
    }

    private void doOpenCamera() {
    }
}
