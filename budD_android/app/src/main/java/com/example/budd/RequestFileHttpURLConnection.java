package com.example.budd;

/**
 * Created by user on 2018-02-01.
 */

import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RequestFileHttpURLConnection {

    public String request(String _url, String _body, File _path, String date, String _filename){

        // HttpURLConnection 참조 변수.
        HttpURLConnection conn = null;
        DataOutputStream dos = null;
        String lineEnd = "\r\n";
        String twoHyphens = "--";
        String boundary = "*****";
        int bytesRead, bytesAvailable, bufferSize;
        byte[] buffer;
        int maxBufferSize = 1 * 1024 * 1024;
        int serverResponseCode;
        String TAG = "FileUpload";
        String page = "";

        File sourceFile = new File(_path, _filename);

        if (!sourceFile.isFile()) {
            Log.e("uploadFile", "Source File not exist :"
                    +sourceFile.getName() + "");
            return null;
        }else {

             //String fileName = sourceFile.getPath();
            String date_thumbnail_filename = "/";
            date_thumbnail_filename += date;
            date_thumbnail_filename += "/";
            date_thumbnail_filename += _filename;

            /**
             * 2. HttpURLConnection을 통해 web의 데이터를 가져온다.
             * */
            try {
                FileInputStream fileInputStream = new FileInputStream(sourceFile);
                URL url = new URL(_url);
                conn = (HttpURLConnection) url.openConnection();

                // [2-1]. urlConn 설정.
                conn.setDoInput(true); // Allow Inputs
                conn.setDoOutput(true); // Allow Outputs
                conn.setUseCaches(false); // Don't use a Cached Copy
                conn.setRequestMethod("POST"); // URL 요청에 대한 메소드 설정 : POST.
                conn.setRequestProperty("Connection", "Keep-Alive");
                conn.setRequestProperty("ENCTYPE", "multipart/form-data");
                conn.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundary);
                conn.setRequestProperty("uploaded_file", _filename);

                dos = new DataOutputStream(conn.getOutputStream());

                dos.writeBytes(twoHyphens + boundary + lineEnd);
                //dos.writeBytes("Content-Disposition: form-data; name=\"uploaded_file\"; filename=\"" + date_thumbnail_filename + "\"" + lineEnd);
                dos.writeBytes("Content-Disposition: form-data; name=" + date_thumbnail_filename + "; filename=\"" + date_thumbnail_filename + "\"" + lineEnd);
                dos.writeBytes(lineEnd);

                // create a buffer of  maximum size
                bytesAvailable = fileInputStream.available();

                bufferSize = Math.min(bytesAvailable, maxBufferSize);
                buffer = new byte[bufferSize];

                // read file and write it into form...
                bytesRead = fileInputStream.read(buffer, 0, bufferSize);

                while (bytesRead > 0) {

                    dos.write(buffer, 0, bufferSize);
                    bytesAvailable = fileInputStream.available();
                    bufferSize = Math.min(bytesAvailable, maxBufferSize);
                    bytesRead = fileInputStream.read(buffer, 0, bufferSize);
                }

                // send multipart form data necesssary after file data...
                dos.writeBytes(lineEnd);
                dos.writeBytes(twoHyphens + boundary + twoHyphens + lineEnd);

                // Responses from the server (code and message)
                serverResponseCode = conn.getResponseCode();
                String serverResponseMessage = conn.getResponseMessage();

                Log.i("uploadFile", "HTTP Response is : " + serverResponseMessage + ": " + serverResponseCode);

                if (serverResponseCode ==  HttpURLConnection.HTTP_OK) {
                    ;
                }

                // [2-4]. 읽어온 결과물 리턴.
                // 요청한 URL의 출력물을 BufferedReader로 받는다.
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

                // 출력물의 라인과 그 합에 대한 변수.
                String line;

                // 라인을 받아와 합친다.
                while ((line = reader.readLine()) != null){
                    page += line;
                }

                if (page.length() == 0)
                    page = conn.getResponseMessage();

                //close the streams //
                fileInputStream.close();
                dos.flush();
                dos.close();

            } catch (MalformedURLException e) { // for URL.
                e.printStackTrace();
                Log.e("Upload file to server", "error: " + e.getMessage(), e);
            } catch (IOException e) { // for openConnection().
                e.printStackTrace();
                Log.e("Upload file to server", "error: " + e.getMessage(), e);
            } catch (Exception e) { // for openConnection().
                e.printStackTrace();
                Log.e("Upload file to server", "error: " + e.getMessage(), e);
            }finally {
                if (conn != null)
                    conn.disconnect();
            }
        }
        return page;
    }
}


