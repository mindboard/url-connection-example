import java.io.*;
import java.net.*;

class Get {
    public static void main(String[] args) throws Exception {
        URI uri = new URI("http://localhost:8080/products/item/001");
        HttpURLConnection connection = (HttpURLConnection) uri.toURL().openConnection();
        connection.setRequestMethod("GET");

        // 受信
        StringBuffer sb = new StringBuffer();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
        String line;
        while( (line = reader.readLine())!=null ){
            sb.append(line);
        }

        connection.disconnect();
        System.out.println( sb.toString() );
    }
}
