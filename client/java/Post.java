import java.io.*;
import java.net.*;

class Post {
    public static void main(String[] args) throws Exception {
        String productData = "{\"name\":\"iPad Pro\",\"price\":\"1200\"}";
        byte[] bytes = productData.getBytes("UTF-8");
        URI uri = new URI("http://localhost:8080/products/newitem/004");
        
        HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setFixedLengthStreamingMode(bytes.length);
        connection.addRequestProperty("Content-Type", "application/json; charset=UTF-8");
        
        // 送信
        new DataOutputStream(connection.getOutputStream()).write(bytes);
        
        // 受信
        StringBuffer sb = new StringBuffer();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
        String line;
        while( (line = reader.readLine())!=null ){
            sb.append(line);
        }

        connection.disconnect();
        
        System.out.println(sb.toString());
    }
}
