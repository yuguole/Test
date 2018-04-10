package com.fedming.bottomnavigationdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alamkanak.weekview.WeekView;
import com.fedming.bottomnavigationdemo.Model.CourseModel;
import com.fedming.bottomnavigationdemo.view.TimetableView;

import java.util.ArrayList;
import java.util.List;

/**
 * BaseFragment
 */

public class BaseFragment extends Fragment {
    private WeekView mWeekView;
    private TimetableView mTimetable;
    public static BaseFragment newInstance(String info) {
        Bundle args = new Bundle();
        BaseFragment fragment = new BaseFragment();
        args.putString("info", info);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=null;
//        通过不同的newInstance传入的参数控制Fragment的布局信息。
//        注意信息的重复刷新。
//        信息的重复获取是本次毕业设计的最大的难点。
//        以及包括服务器的设计和架设。
//        这里将会是项目结构逻辑最复杂的实习地方。
//        写于2018/2/25   航海楼
//        学习fragment的笔记。


        if (getArguments().getString("info")!="课表"){
            view= inflater.inflate(R.layout.fragment_base, null);
            TextView tvInfo = (TextView) view.findViewById(R.id.textView);
            tvInfo.setText(getArguments().getString("info"));
        }else{
          view= inflater.inflate(R.layout.testlayout, null);
//            找到个个布局的布局文件并进行视图渲染。
            mTimetable = (TimetableView) view.findViewById(R.id.timetable);
            mTimetable.loadCourses(getData());
        }
        return view;
    }

//    从网络Volley端获取数据------目前只是测试。
    private List<CourseModel> getData() {
        List<CourseModel> list = new ArrayList<>();

        CourseModel course1 = new CourseModel();
        course1.setCname("计算机网络");
        course1.setClassroom("1号楼103");
        course1.setStartSection(1);
        course1.setEndSection(4);
        course1.setDayOfWeek(1);
        course1.setStartWeek(1);
        course1.setEndWeek(12);
        list.add(course1);

        CourseModel course2 = new CourseModel();
        course2.setCname("计算机组成原理");
        course2.setClassroom("1号楼312");
        course2.setStartSection(7);
        course2.setEndSection(8);
        course2.setDayOfWeek(1);
        course2.setStartWeek(1);
        course2.setEndWeek(12);
        list.add(course2);


        CourseModel course3 = new CourseModel();
        course3.setCname("数据结构与算法");
        course3.setClassroom("1号楼201");
        course3.setStartSection(1);
        course3.setEndSection(2);
        course3.setDayOfWeek(2);
        course3.setStartWeek(4);
        course3.setEndWeek(18);
        list.add(course3);


        CourseModel course4 = new CourseModel();
        course4.setCname("高等数学");
        course4.setClassroom("3号楼602");
        course4.setStartSection(5);
        course4.setEndSection(6);
        course4.setDayOfWeek(2);
        course4.setStartWeek(1);
        course4.setEndWeek(12);
        list.add(course4);


        CourseModel course5 = new CourseModel();
        course5.setCname("离散数学");
        course5.setClassroom("1号楼311");
        course5.setStartSection(3);
        course5.setEndSection(4);
        course5.setDayOfWeek(3);
        course5.setStartWeek(1);
        course5.setEndWeek(12);
        list.add(course5);


        CourseModel course6 = new CourseModel();
        course6.setCname("无线网络技术");
        course6.setClassroom("1号楼210");
        course6.setStartSection(1);
        course6.setEndSection(2);
        course6.setDayOfWeek(4);
        course6.setStartWeek(4);
        course6.setEndWeek(8);
        list.add(course6);

        CourseModel course7 = new CourseModel();
        course7.setCname("大学体育");
        course7.setClassroom("运动场");
        course7.setStartSection(5);
        course7.setEndSection(6);
        course7.setDayOfWeek(4);
        course7.setStartWeek(4);
        course7.setEndWeek(12);
        list.add(course7);

        CourseModel course8 = new CourseModel();
        course8.setCname("操作系统");
        course8.setClassroom("2号楼303");
        course8.setStartSection(1);
        course8.setEndSection(4);
        course8.setDayOfWeek(5);
        course8.setStartWeek(1);
        course8.setEndWeek(12);
        list.add(course8);

        CourseModel course9 = new CourseModel();
        course9.setCname("Java语言程序设计");
        course9.setClassroom("2号楼104");
        course9.setStartSection(7);
        course9.setEndSection(8);
        course9.setDayOfWeek(5);
        course9.setStartWeek(1);
        course9.setEndWeek(12);
        list.add(course9);

        return list;
    }
}
