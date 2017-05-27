package com.jiepier.filemanager.sqlite;

import android.util.Log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Arrays;
import java.util.Calendar;

/**
 * Created by Administrator on 2017/5/27.
 */


@Aspect

public class Aj2 {

    private static final String TAG = "Aspectj";
    @Before("execution(* com.jiepier.filemanager.sqlite.*.deleteSQL(..))")
    public void mytest(JoinPoint joinPoint) throws Throwable {

        String key = joinPoint.getSignature().toString();
        //Log.d(TAG, "调用的删除函数为：" + key);
   //     for(int i = 0; i < joinPoint.getArgs().length; i ++){
            String temp,temp2;
        //获得函数名以及参数
        temp2 = "函数为："+joinPoint.getSignature().toString()+"参数为："+Arrays.toString(joinPoint.getArgs());
        //获得删除开始时系统时间
        long time = System.currentTimeMillis();
        final Calendar mcalendar = Calendar.getInstance();
        mcalendar.setTimeInMillis(time);
        int s = mcalendar.get(Calendar.SECOND);
        int ms = mcalendar.get(Calendar.MILLISECOND);
            //temp = Arrays.toString(joinPoint.getArgs());
        temp = String.valueOf(s) + "秒"+String.valueOf(ms)+"毫秒";
        Log.d(TAG,"调用信息："+temp2);
            Log.d(TAG, "开始时间：" + temp);

    }
    @After("execution(* com.jiepier.filemanager.sqlite.*.deleteSQL(..))")
    public void mytest2(JoinPoint joinPoint){
        String temp;
        //获得结束时时间
        long time = System.currentTimeMillis();
        final Calendar mcalendar = Calendar.getInstance();
        mcalendar.setTimeInMillis(time);
        int s = mcalendar.get(Calendar.SECOND);
        int ms = mcalendar.get(Calendar.MILLISECOND);
        //temp = Arrays.toString(joinPoint.getArgs());
        temp = String.valueOf(s) + "秒"+String.valueOf(ms)+"毫秒";
        Log.d(TAG, "结束时间："+temp);
    }
}