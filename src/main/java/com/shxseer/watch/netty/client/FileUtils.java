package com.shxseer.watch.netty.client;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author yangsonglin
 * @create 2018-07-16 16:55
 **/
public class FileUtils {

    /**
     * 读取过程暂停，给当前做一个标记，下一次从标记位置开始读取
     * @param fileName
     */
    public static String readFile(String fileName) {
        // TODO Auto-generated method stub

        //读取过程中暂停
        //给当前做一个标记
        //下一次从标记位置开始读取
        String str ="";

        try {
            BufferedInputStream bis= new BufferedInputStream(new FileInputStream(fileName));
            byte[] b = new byte[bis.available()];
            bis.read(b);

			/*char[] c = new char[b.length];
			for (int i = 0; i < c.length; i++) {
				c[i]=(char) b[i];
			}
			System.out.println(Arrays.toString(c));//乱码
			 */

//            System.out.println(Arrays.toString(b));//得到的是字节
            //String(byte[])把字节数组转成字符串
            str = new String(b);
            str = str .replaceAll("\\s*", "");

            bis.close();//关闭流(关闭bis就可以了)
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return str;
    }


}
