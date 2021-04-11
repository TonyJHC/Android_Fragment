package com.hansung.android.tablephonefragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
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
    public void onTitleSelected(int i) { //추상 메소드 구현 :TilesFragment에서 onTitleSelected(position)으로 항목 정보 넘겨줬음
        if (getResources().getConfiguration().isLayoutSizeAtLeast(Configuration.SCREENLAYOUT_SIZE_LARGE)){
            DetailsFragment detailsfragment = DetailsFragment.newInstance(i);
            getSupportFragmentManager().beginTransaction().replace(R.id.details,detailsfragment).commit();
    }
        else{
            Intent intent = new Intent(this, DetailsActivity.class);
            intent.putExtra("index",i);
            startActivity(intent);
        }
        //자바코드에서 동적으로 프래그먼트 추가하기 : 프래그먼트 매니저 사용

        //R.id.details 는 태블릿 pc에서 진행될때
    }


}