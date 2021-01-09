package com.example.budd;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class SearchActivity extends AppCompatActivity {

    ArrayList<Diary> d_items;
    String userid;
    String opposite_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        final SearchResultAdapter adapter = new SearchResultAdapter(getApplicationContext());

        adapter.setOnItemClickListener(new SearchResultAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(SearchResultAdapter.ViewHolder holder, View view, int position) {
                Diary item = adapter.getItem(position);
                //다이어리 화면으로 넘어가기//intend~
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.options_menu,menu);
        SearchView searchView = (SearchView)menu.findItem(R.id.action_search).getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        //쿼리 필드가 비어있을 때 나타나는 문장
        searchView.setQueryHint("제목");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
           //검색 완료
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(getApplicationContext(),"검색을 완료했습니다.",Toast.LENGTH_SHORT).show();
                //String userid, String opposite_id, String title
                http_api_cmd("/findTitle", find_title_cmd_msg(userid,opposite_id,query));
                //list 받아와서 adapter.addItem으로 추가
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        //검색버튼 눌렀을 때 이벤트 제어
        if(id == R.id.action_search){
            //검색했을 때 쿼리 구현

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void http_api_cmd(String param, String body) {
        String url = "http://" + DEFINITION.FRONT_IP+ ":" + DEFINITION.FRONT_PORT + param;
        //String url = "http://222.122.30.58:6800/userinfo";
        // AsyncTask를 통해 HttpURLConnection 수행.
        //NetworkTask net_task = new NetworkTask(url, body);
//        net_task.execute();
        BackgroundTask(url,body);

    }

    Disposable backgroundtask;
    String result_ack;

    void BackgroundTask(String url,String body) {
//onPreExecute

        //progressBar.setVisibility(View.VISIBLE);

        backgroundtask = Observable.fromCallable(() -> {
//doInBackground

            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
            result_ack = requestHttpURLConnection.request(url, body); // 해당 URL로 부터 결과물을 얻어온다.
            return false;
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((result) -> {

//onPostExecute

                    if (result_ack == null)
                        return;
                    if (result_ack.contains("ErrorCode(") == true) {
                        Toast.makeText(SearchActivity.this, result_ack, Toast.LENGTH_SHORT).show();
                    }

                    if (url.contains("/findTitle")) {
                        find_title_ack(result_ack);
                        return;
                    }

                    backgroundtask.dispose();
                });
    }
//
//    private class NetworkTask extends AsyncTask<Void, Void, String> {
//
//        private String url;
//        private String body;
//
//        public NetworkTask(String url, String body) {
//            this.url = url;
//            this.body = body;
//        }
//
//        @Override
//        protected String doInBackground(Void... params) {
//            String result; // 요청 결과를 저장할 변수.
//            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
//            result = requestHttpURLConnection.request(url, body); // 해당 URL로 부터 결과물을 얻어온다.
//            return result;
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//
//            if (s == null)
//                return;
//            if (s.contains("ErrorCode(") == true) {
//                Toast.makeText(SearchActivity.this, s, Toast.LENGTH_SHORT).show();
//
////                if (s.contains("Unauthorized") == true) {
////                    Toast.makeText(getApplicationContext(), "please, login again", Toast.LENGTH_SHORT).show();
////                    Application.getInstance().clear();
////                    Intent intent = new Intent(SearchActivity.this, LoginActivity.class);
////                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
////                    startActivity(intent);
////                    finish();
////                }
////                return;
//            }
//
//            if (url.contains("/findTitle")) {
//                find_title_ack(s);
//                return;
//            }
//        }
//    }

    private String find_title_cmd_msg(String userid, String opposite_id, String title) {
        String json = "";
        try {
            JSONObject data = new JSONObject();

            data.put("user",userid);
            data.put("opposite_id", opposite_id);
            data.put("title", title);

            JSONObject root = new JSONObject();
            root.put("diary", data);
            json = root.toString();

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }

    private int find_title_ack(String ack_body) {
        JSONObject json = null;
        try {
            json = new JSONObject(ack_body);
            JSONArray jArray = json.getJSONArray("title");
            int size = jArray.length();
            System.out.println("*****JARRAY*****"+size);
            if(size<=0){
                //검색결과 없음
                return 0;
            }else{
                d_items = new ArrayList<>();
                for(int i=0;i<size;i++){
//                    int no,String title, String userid,String diary_type,String opposite_id,
//                            String cover_filePath,String content_filePath,String write_time
                    JSONObject json_data = jArray.getJSONObject(i);
                    Diary item = new Diary(json_data.getInt("no"),json_data.getString("title"),
                            json_data.getString("userid"), json_data.getString("diary_type"),
                            json_data.getString("opposite_id"), json_data.getString("cover_filePath"),
                            json_data.getString("content_filePath"), json_data.getString("write_time"));
                    d_items.add(item);
                }
            }
            return size;

        } catch (JSONException e) {
            e.printStackTrace();
            return 0;
        }
    }

}