package dg.bin.com.recyclerviewstudy.tools;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import dg.bin.com.recyclerviewstudy.model.RecyclerViewTypeListModel;
import dg.bin.com.recyclerviewstudy.model.RecyclerViewTypeModel;

/**
 * Created by b on 2018/8/22.
 */

public class ReadDataTool {

    public<T> T readDataFromAssets(Context mContext, String mFileName, Class<T> cla){
        T t = null;
        //将json数据变成字符串
        StringBuilder stringBuilder = new StringBuilder();
        try {
            //获取assets资源管理器
            AssetManager assetManager = mContext.getAssets();
            //通过管理器打开文件并读取
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    assetManager.open(mFileName)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(stringBuilder.length() != 0){
                t = new Gson().fromJson(stringBuilder.toString(), cla);
            }
            return t;
        }
    }

}
