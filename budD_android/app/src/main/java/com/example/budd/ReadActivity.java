package com.example.budd;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ReadActivity extends AppCompatActivity {

    Button readdiary;
    ImageButton writenew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_diary);


        readdiary = findViewById(R.id.readdiary);
        writenew = findViewById(R.id.writenew);

        readdiary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), Page_view.class);
                startActivity(intent);
            }
        });

        writenew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), NewPage_write.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.options_menu,menu);
//        SearchView searchView = (SearchView)menu.findItem(R.id.action_search).getActionView();
//        searchView.setMaxWidth(Integer.MAX_VALUE);
//        //쿼리 필드가 비어있을 때 나타나는 문장
//        searchView.setQueryHint("제목");
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            //검색 완료
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
//                startActivity(intent);
//                finish();
//                //Toast.makeText(getApplicationContext(),"검색을 완료했습니다.",Toast.LENGTH_SHORT).show();
////                int no,String title, String userid,String diary_type,String opposite_id,
////                        String cover_filePath,String content_filePath,String write_time
//
//
//                //서버가 돌아갈 때 사용
//                //String userid, String opposite_id, String title
//                //http_api_cmd("/findTitle", find_title_cmd_msg(userid,opposite_id,query));
//                //list 받아와서 adapter.addItem으로 추가
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        //검색버튼 눌렀을 때 이벤트 제어
        if(id == R.id.action_search){
            //검색했을 때 쿼리 구현
            Intent intent = new Intent(getApplicationContext(), SearchActivity.class);
            startActivity(intent);
            finish();
            return true;
        }

        if(id == R.id.action_break){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("절교").setMessage("정말 절교하시겠습니다?\n지금까지 나눠 온 교환일기가 사라집니다.\n복구가 불가능합니다.");

            builder.setPositiveButton("예", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int id)
                {
                    Toast.makeText(getApplicationContext(), "OK Click", Toast.LENGTH_SHORT).show();
                }
            });

            builder.setNegativeButton("아니오", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialog, int id)
                {
                    Toast.makeText(getApplicationContext(), "Cancel Click", Toast.LENGTH_SHORT).show();
                }
            });

            AlertDialog alertDialog = builder.create();
            alertDialog.show();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
