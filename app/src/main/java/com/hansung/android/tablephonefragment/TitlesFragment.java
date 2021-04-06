package com.hansung.android.tablephonefragment;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class TitlesFragment extends Fragment {

    public TitlesFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_titles, container, false);

        // id가 listview인 리스트뷰 객체를 얻어옴
        ListView listView = rootView.findViewById(R.id.listview);
        // 리스트뷰 객체에 Shakespear.TITLES 배열을 데이터원본으로 설정한 ArrayAdapter 객체를 연결
        listView.setAdapter(
                new ArrayAdapter<String>(
                        getActivity(),  // 현재 프래그먼트 연결된 액티비티
                        android.R.layout.simple_list_item_activated_1,
                        Shakespeare.TITLES));  // 데이터 원본
        // 리스트뷰 항목이 선택되었을 때, 항목 클릭 이벤트 처리
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // 현재 프래그먼트와 연결된 액티비티를 반환 --> 프래그먼트와 액티비티 연결은 무엇을 통해 ?
                // --> 액티비티의 레이아웃 파일에 정적으로 추가하기 : 해당 코드는 정적으로 추가했음
                // --> 프래그먼트 매니저를 사용해서(강의자료 참고)
                // 정적으로 추가시 처음시작부터 프래그먼트와 액티비티를 연결하기 때문에 프래그먼트를 다른것으로
                // 바꾸거나 수정시 별로임 --> 따라서 앱을 만들때는 동적으로 만들어 주는 것이 좋다
                Activity activity = getActivity();

                // 선택된 항목 위치(position)을 OnTitleSelectedListener 인터페이스를 구현한 액티비티로 전달
                if (activity instanceof OnTitleSelectedListener) //OnTitleSelectedListener 인터페이스 타입인 경우에
                    ((OnTitleSelectedListener)activity).onTitleSelected(position); //position정보를 넘겨줌

            }
        });
        return rootView;
    }

    // 인터페이스 추가 정의 --> TitlesFragment와 통신을 하려면 해당 인터페이스를 구현하기만 하면됨
    //따라서 MainActivity외에도 다른 Activity에서도 해당 인터페이스만 구현한다면 서로 통신이 가능해짐
    public interface OnTitleSelectedListener {
        public void onTitleSelected(int i); // 추상메소드
        // 해당 인터페이스를 구현한 Activity에서 onTitleSeleced메소드를 구현하면
        // 해당 파라미터를 Activity에서 사용할 수 있게 된다 (data 전송역할 ! )
        // 해당 코드에서는 사용자가 클릭한 Listview의 position을 전달
     }
}