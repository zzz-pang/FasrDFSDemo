package com.qf.util;

import org.csource.fastdfs.*;

/**
 * @Description:
 * @Company: 千锋互联
 * @Author: 李丽婷
 * @Date: 2019/7/22
 * @Time: 上午11:12
 */
public class FastDFSUtils {

    //声明   tracker  storage
    TrackerClient trackerClient = null;
    TrackerServer trackerServer = null;
    StorageServer storageServer = null;
    StorageClient storageClient = null;

    public FastDFSUtils(){

        try{
            //1,加载配置文件
            ClientGlobal.init("client.conf");
            System.out.println(ClientGlobal.configInfo());

            //2,创建trackerClient 对象
            trackerClient  = new TrackerClient();
            //3,得到TrackerServer对象
            trackerServer = trackerClient.getConnection();
            //4,构建storageClient 对象
            //    public StorageClient(TrackerServer trackerServer, StorageServer storageServer) {
            storageClient = new StorageClient(trackerServer,storageServer);

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public  String[]  upload(String local_name,String  suffix) {
        try{
            return  storageClient.upload_file(local_name,suffix,null);
        }catch(Exception e){
            e.printStackTrace();
        }
        return  null;
    }

    public String[] upload(byte [] b,String  ext){
        try{
            return  storageClient.upload_file(b,ext,null);

        }catch(Exception e){
            e.printStackTrace();
        }

        return  null;
    }



}
