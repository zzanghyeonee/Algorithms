package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class practice {
	    public static void main(String[] args) {
	        InputStream is = null;
	        OutputStream os = null;

	        try{
	            // ./는 현재경로를 의미합니다.
	            is = new FileInputStream("./koala.jpeg");
	            os = new FileOutputStream("./sad.jpg");

	            int data = -1;
	            while( (data = is.read()) != -1 ){
	                os.write(data);
	            }
	        }
	        catch (FileNotFoundException e){
	            System.out.println("파일 없음");
	            e.printStackTrace();
	        }
	        catch (IOException e){
	            System.out.println("I/O 에러");
	            e.printStackTrace();
	        }

	    }
}

