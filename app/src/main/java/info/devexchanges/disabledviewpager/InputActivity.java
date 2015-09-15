package info.devexchanges.disabledviewpager;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import info.devexchanges.disabledviewpager.adapter.ViewPagerAdapter;
import info.devexchanges.disabledviewpager.fragment.NameEmailFragment;
import info.devexchanges.disabledviewpager.fragment.OtherInfoFragment;
import info.devexchanges.disabledviewpager.pojo.User;

public class InputActivity extends AppCompatActivity implements NameEmailFragment.OnNameEmailChangedListener,
        OtherInfoFragment.OnInfoChangedListener {

    private ViewPager viewPager;
    private User user;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = new User();

        viewPager = (ViewPager)findViewById(R.id.view_pager);
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }

    public void goToNextPage() {
        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
    }

    public void goToResultActivity() {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("USER INFO", user);
        startActivity(intent);
    }

    @Override
    public void onNameEmailChanged(int position, String s) {
        if (position == 1) {
            user.setEmail(s);
        } else {
            user.setName(s);
        }
    }

    @Override
    public void onInfoChanged(String age, String gender) {
        user.setAge(Integer.valueOf(age));
        user.setGender(gender);
    }
}
