package jsonpathtest;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import com.jayway.jsonpath.JsonPath;

public class JsonpathUtil {


    public static String readData() throws Exception {
        String json = "";
        //url中不可以出现空格，空格全部用%20替换
        String url = "http://m.dcdapp.com/motor/m/article/detail?group_id=6631042760742797827";
//        在线测试环境url:http://test.qx.qinxuezx.com/api/home/user/register
//        String url = "http://test.qx.qinxuezx.com/api/home/user/register";
        URL urls = new URL(url);
        java.net.HttpURLConnection conn = (java.net.HttpURLConnection)urls.openConnection();
        //因为服务器的安全设置不接受Java程序作为客户端访问，解决方案是设置客户端的User Agent
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        //只可以设置为GET方式，不可以使用POST方式
//        conn.setRequestMethod("POST");
        conn.setRequestMethod("GET");
        //设置编码格式为UTF-8
        conn.setRequestProperty("contentType", "UTF-8");

        //得到输入流
        InputStream inputStream = conn.getInputStream();
        //从输入流中获取数据（一定要设置编码格式，不然在服务器端接收到的数据可能乱码）
        BufferedReader bf=new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));

        String line = null;
        while((line=bf.readLine())!=null){//一行一行的读
            json = json + line;
        }
        return json;

    }


    public static void jsonutil(){
        try {
            String html =  readData();
//          System.out.println(html);
//            String content = JsonPath.read(html, "$.data.content").toString();
//            System.out.println( content );
            String publish_time = JsonPath.read(html, "$.data.publish_time").toString();
            System.out.println( publish_time );
            String title = JsonPath.read(html, "$.data.title").toString();
            System.out.println( title );
            String source = JsonPath.read(html, "$.data.source").toString();
            System.out.println( source );
            String url = JsonPath.read(html, "$.data.url").toString();
            System.out.println( url );
            String id = JsonPath.read(html, "$.data.media_user.id").toString();
            System.out.println( id );
            String status = JsonPath.read(html, "$.status").toString();
            System.out.println( status );
        } catch (Exception e) {

            System.out.println( e );
        }
    }

    public static void main(String[] args) {
        jsonutil();
    }
}
