package com.hansung.android.tablephonefragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;
//TitlesFragment와 통신을 하기 위해 TitlesFragment내부에 정의된 OnTitlesSelectedListener를 구현을 해야한다
//따라서 implements로 선언을 해준다(해당 인터페이스를 구현한다고 명시하는 거임 )
public class MainActivity extends AppCompatActivity implements TitlesFragment.OnTitleSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //TitlesFragment와의 통신을 위해
    //OnTitlesSelectedListener에 정의되어진  추상 메소드를 구현해야됨
    public void onTitleSelected(int i){ //추상 메소드 구현
        //Toast.makeText(getApplicationContext(), "position="+i, Toast.LENGTH_SHORT).show();
        DetailsFragment detailsFragment = DetailsFragment.newInstance(i); //DatailsFragment에 항목정보 넘겨주기 --> DatailsFragment의 newInstance는 해당 항목정보에대한 data를 저장한 객체를 return 해줌
        //자바코드에서 동적으로 프래그먼트 추가하기 : 프래그먼트 매니저 사용
        getSupportFragmentManager().beginTransaction().replace(R.id.details, detailsFragment).commit();//기존의 프래드 먼트를 새로운 프래그 먼트로 변경 (details라는 id는 activity_main (large)에 있음 따라서 스마트폰앱 실행시 앱 다운

    }


}