package com.example.dell.seasy.Activity;

import android.os.Bundle;
import android.widget.RadioButton;

import com.example.dell.seasy.Base.BaseActivity;
import com.example.dell.seasy.Fragment.ChatFragment;
import com.example.dell.seasy.Fragment.DynamicFragment;
import com.example.dell.seasy.Fragment.MainPageFragment;
import com.example.dell.seasy.Fragment.PersonFragment;
import com.example.dell.seasy.R;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

@BindView(R.id.main_page_rb)RadioButton mainPage_Rb;
@BindView(R.id.main_dynamic)RadioButton dynamic_Rb;
@BindView(R.id.main_chat_rb) RadioButton message_Rb;
@BindView(R.id.main_person_rb)RadioButton person_Rb;
private MainPageFragment mainPageFragment;
private DynamicFragment dynamicFragment;
private ChatFragment chatFragment;
private PersonFragment personFragment;


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        if (savedInstanceState!=null)
        {
          android.support.v4.app.FragmentManager fragmentManager=getSupportFragmentManager();
            mainPageFragment=(MainPageFragment)fragmentManager.findFragmentByTag(MainPageFragment.class.getName());
            dynamicFragment=(DynamicFragment)fragmentManager.findFragmentByTag(DynamicFragment.class.getName());
            chatFragment=(ChatFragment)fragmentManager.findFragmentByTag(ChatFragment.class.getName());
            personFragment=(PersonFragment)fragmentManager.findFragmentByTag(PersonFragment.class.getName());
        }else {
            mainPageFragment=MainPageFragment.newInstance(MainPageFragment.FR_MAINPAGE_TAG);
            dynamicFragment=DynamicFragment.newInstance(DynamicFragment.FR_DYNAMIC_TAG);
            chatFragment=ChatFragment.newInstance(ChatFragment.FR_CHAT_TAG);
            personFragment=PersonFragment.newInstance(PersonFragment.FR_PERSON_TAG);
        }
        initFragment();

    }
  protected void initFragment(){

      getSupportFragmentManager().beginTransaction().add(R.id.main_fragment_layout,mainPageFragment)
              .add(R.id.main_fragment_layout,dynamicFragment)
              .add(R.id.main_fragment_layout,chatFragment)
              .add(R.id.main_fragment_layout,personFragment).commit();
      getSupportFragmentManager().beginTransaction().hide(dynamicFragment).hide(chatFragment).hide(personFragment).show(mainPageFragment).commitNow();
  }
  @OnClick(R.id.main_page_rb)
  public void mainPage(){
      getSupportFragmentManager().beginTransaction().hide(dynamicFragment)
              .hide(chatFragment)
              .hide(personFragment)
              .show(mainPageFragment)
              .commitNow();
  }
  @OnClick(R.id.main_dynamic)
  public void dynamic(){
      getSupportFragmentManager().beginTransaction().hide(mainPageFragment)
              .hide(chatFragment)
              .hide(personFragment)
              .show(dynamicFragment)
              .commitNow();
  }
  @OnClick(R.id.main_chat_rb)
  public void chat(){
      getSupportFragmentManager().beginTransaction().hide(mainPageFragment)
              .hide(dynamicFragment)
              .hide(personFragment)
              .show(chatFragment)
              .commitNow();
  }
  @OnClick(R.id.main_person_rb)
  public void person(){
      getSupportFragmentManager().beginTransaction().hide(dynamicFragment)
              .hide(chatFragment)
              .hide(mainPageFragment)
              .show(personFragment)
              .commitNow();
  }

}
