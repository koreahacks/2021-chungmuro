package com.example.budd;

public class Diary {
    public int no;
    public String title;
    public String userid;
    public String date;
    public String diary_type;
    public String opposite_id;
    public String cover_filePath;
    public String content_filePath;
    public String write_time;
    public String writer;


    public Diary(int no,String title, String userid,String diary_type,String opposite_id,
                 String cover_filePath,String content_filePath,String write_time){

        this.title = title;
        this.userid = userid;
        this.date = write_time.substring(0,10);
        this.diary_type = diary_type;
        this.opposite_id = opposite_id;
        this.cover_filePath = cover_filePath;
        this.content_filePath = content_filePath;
        this.write_time = write_time;

        whoWrite();
    }

    public Diary(String title, String userid,String date) {
        this.title = title;
        this.userid = userid;
        this.date = date.substring(0,10);
    }

    private void whoWrite(){
        if(diary_type.equals("send")){
            writer = userid;
        }else{
            writer = opposite_id;
        }
    }

}