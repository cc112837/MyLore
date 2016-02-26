package com.l000phone.mylore.utils.fileutils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.l000phone.mylore.utils.logutils.LogUtils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2015/11/13.
 */
public class FileUtils {
    public static void writeDataToFile(final String data, final String fileName, final Context context) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                FileOutputStream fos = null;
                try {
                    fos = context.openFileOutput(fileName+".txt", Context.MODE_PRIVATE);
                    byte[] bytes = data.getBytes();
                    fos.write(bytes);
                    fos.flush();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();

    }

    public static String readDataFromFile(String fileName, Context context) {
        FileInputStream fis = null;
        BufferedReader br = null;
        StringBuffer sb = new StringBuffer();
        try {
            fis = context.openFileInput(fileName+".txt");
            br = new BufferedReader(new InputStreamReader(fis));
            String str = null;
            while((str = br.readLine())!= null){
                sb.append(str);
            }
            return sb.toString();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static boolean isNetConnect(Context context) {
        ConnectivityManager manager = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE));
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info != null) {
            return info.isConnected();
        }
        LogUtils.log("网路连接", "无连接");
        return false;
    }
}
