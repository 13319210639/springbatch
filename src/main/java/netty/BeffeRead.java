package netty;

import java.io.*;

public class BeffeRead {

    public static void main(String[] args) throws FileNotFoundException {
        File file=new File("C:\\Users\\ambition\\Desktop\\短息入库慢测试报告.docx");
        FileInputStream inputStream =new FileInputStream(file);
        InputStreamReader reader =new InputStreamReader(inputStream);
        BufferedReader bufferedReader=new BufferedReader(reader,10240);
    }
}
