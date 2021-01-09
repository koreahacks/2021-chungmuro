package com.example.budd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.security.auth.callback.Callback;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class NewPage_selectCover extends AppCompatActivity {
    ImageView btnAlbum;

    private static final int REQUEST_CODE = 0;
    private static Bitmap img;

    static String API_SRC_Test = "http://9290b0ddc12c.ngrok.io/diary/uploadCover";
    String API_SRC_TEMP = "";
    File saveCover;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newpage_select_cover);

        btnAlbum = findViewById(R.id.btnAlbum);

        btnAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*"); //이미지 파일을 불러오는 타입,
                //intent.setAction(Intent.ACTION_SCREEN_ON);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) { //intent 인자로 넘겨준 코드
            if (resultCode == RESULT_OK) { //사진을 정상적으로 선택했을 경우 result_ok, 취소했을 경우 result_canceled
                try {
                    InputStream in = getContentResolver().openInputStream(data.getData());

                    img = BitmapFactory.decodeStream(in); //받은 데이터를 비트맵화하여
                    in.close();

                    btnAlbum.setImageBitmap(img); //이미지 변경신 //이미지 변경 잠시 주석, 버튼 누르면 이걸로 수정해보
                    //btnAlbum.setImageResource(in.read());
                    //new JSONTask_sendImage().execute(API_SRC); //어싱크태스크 사용한 서버 통신

                    saveBitmap(); //이미지 형변환 후 서버로 전달

                } catch (Exception e) {

                }
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "사진 선택 취소", Toast.LENGTH_LONG).show();
            }
        }
    }

    //윤주 코드. 이미지 저장 관련
//    public void save(View view){
//        if (ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                != PackageManager.PERMISSION_GRANTED){ //권한이 있으면
//            ActivityCompat.requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},REQEST_PERMISSION);
//        }else{
//            saveBitmap();
//        }
//    }

    public void saveBitmap() {
        Bitmap bitmap = img;
        String name = "imageTest";
        //Log.d("nameeeeeeeeeeeeeeeee : ", name);

        try {
            saveCover = new File(Environment.getExternalStorageDirectory() + "/Pictures/Test/","Cover");
            if(!saveCover.exists()){
                saveCover.mkdirs();
            }
            System.out.println("save FILE : " + saveCover + File.separator + name);
            FileOutputStream out = new FileOutputStream(saveCover + File.separator + name);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
            Toast.makeText(getApplicationContext(),"저장하였습니다.", Toast.LENGTH_LONG).show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        send2Server(saveCover, name);
    }

    public void send2Server(File file, String name) {
        Log.d("짱나게 하지마라", "555555555");
        File image = new File(file, name);
        if (file.exists()) {
            RequestBody requestBody = new MultipartBody.Builder()
                    .setType(MultipartBody.FORM)
                    .addFormDataPart("userid", "q")
                    .addFormDataPart("opposite_id", "popo")
                    .addFormDataPart("cover_filePath", name, RequestBody.create(MediaType.parse(("image/png")), image))
                    .build();

            Request request = new Request.Builder()
                    .url(API_SRC_TEMP) // Server URL 은 본인 IP를 입력
                    .post(requestBody) //post 방식으로 requestBody를 담아 보내
                    .build();

            OkHttpClient client = new OkHttpClient();

            client.newCall(request).enqueue(new okhttp3.Callback() { //비동기 처리
                @Override
                public void onFailure(okhttp3.Call call, IOException e) {
                    e.printStackTrace();
                    Log.d("TEST : >>>>>>> ", "실패ㅐㅐㅐㅐㅐㅐㅐㅐㅐㅐㅐㅐㅐㅐㅐㅐㅐㅐㅐㅐㅐㅐㅐㅐㅐㅐ" + e.toString());
                }

                @Override
                public void onResponse(okhttp3.Call call, Response response) throws IOException {
                    Log.d("TEST : >>>>>>> ", response.body().string());
                    //uploadcover(new coverData(storynum, book_no));
                    //Toast.makeText(getApplicationContext(), "서버 전달 성공", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}