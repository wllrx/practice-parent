package cn.wllsrx.zoe.hadoop.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author zoe
 **/
public class HdfsOp {
    private static final String ADDRESS = "hdfs://192.168.59.128:9000";

    public static void main(String[] args) throws IOException {

        //创建一个配置对象
        Configuration configuration = new Configuration();
        //指定hdfs的地址  如果要使用主机名访问需要在本地hosts文件配置ip和主机名
        configuration.set("fs.defaultFS", ADDRESS);
        //获取操作hdfs的对象
        FileSystem fileSystem = FileSystem.get(configuration);
        //上传文件
        put(fileSystem);
        //下载文件
        get(fileSystem);
        //删除文件
        delete(fileSystem);
    }

    /**
     * 删除文件
     *
     * @param fileSystem hdfs对象
     * @throws IOException 异常
     */
    private static void delete(FileSystem fileSystem) throws IOException {
        boolean flag = fileSystem.delete(new Path("/user.txt"), true);
        if (flag) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
    }

    /**
     * 下载文件
     *
     * @param fileSystem hdfs对象
     * @throws IOException 异常
     */
    private static void get(FileSystem fileSystem) throws IOException {
        //获取hdfs文件系统得输入流
        FSDataInputStream inputStream = fileSystem.open(new Path("/README.txt"));
        //获取本地文件得输出流
        FileOutputStream outputStream = new FileOutputStream("F:\\README.txt");
        //下载文件
        IOUtils.copyBytes(inputStream, outputStream, 1024, true);
    }

    /**
     * 上传文件
     *
     * @param fileSystem hdfs对象
     * @throws IOException 异常
     */
    private static void put(FileSystem fileSystem) throws IOException {
        //获取hdfs文件系统的输出流
        FSDataOutputStream outputStream = fileSystem.create(new Path("/user.txt"));
        //获取本地文件的输入流
        FileInputStream inputStream = new FileInputStream("F:\\user.txt");
        //上传文件 通过工具类把输入流拷到输出流里面,实现本地文件上传到hdfs
        IOUtils.copyBytes(inputStream, outputStream, 1024, true);
    }
}
