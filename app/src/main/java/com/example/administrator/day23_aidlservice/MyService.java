package com.example.administrator.day23_aidlservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import org.day23.IMyAidlInterface;

public class MyService extends Service {
    public MyService() {
    }
    //第一步创建胶水类
    //public class MyBinder extends IMyAidlInterfacce.Stub
    public class MyBinder extends IMyAidlInterface.Stub{

        @Override
        public int plus(int plus1, int plus2) throws RemoteException {

            return plus1+plus2;
        }
    }
    //第二步，将胶水涂在service表面
    @Override
    public IBinder onBind(Intent intent) {

        return new MyBinder();
    }
}
