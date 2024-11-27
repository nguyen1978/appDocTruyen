package com.example.appdoctruyen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.WithHint;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.appdoctruyen.adapter.adapterTruyen;
import com.example.appdoctruyen.adapter.adapterchuyenmuc;
import com.example.appdoctruyen.adapter.adapterthongtin;
import com.example.appdoctruyen.database.databasedoctruyen;
import com.example.appdoctruyen.model.Taikhoan;
import com.example.appdoctruyen.model.Truyen;
import com.example.appdoctruyen.model.chuyenmuc;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    ViewFlipper viewFlipper;
    NavigationView navigationView;
    ListView listView, listViewNew, listViewThongTin;
    DrawerLayout drawerLayout;
    private int i;
    private int idd;

    String email;
    String taikhoan;

    ArrayList<Truyen> TruyenArratList;

    adapterTruyen adapterTruyen;

    ArrayList<chuyenmuc> chuyenmucArrayList;

    ArrayList<Taikhoan> taikhoanArrayList;

    databasedoctruyen databasedoctruyen;

    adapterchuyenmuc adapterchuyenmuc;
    adapterthongtin adapterthongtin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databasedoctruyen = new databasedoctruyen(this);
        //nhận dữ liệu đăng nhập
        Intent intentpq = getIntent();
        i = intentpq.getIntExtra("phanquyen", 0);
        Log.d("TAG", "onCreate: "+i);
        idd = intentpq.getIntExtra("idd", 0);
        email = intentpq.getStringExtra("email");
        taikhoan = intentpq.getStringExtra("taikhoan");

        AnhXa();
        ActionBar();
        ActionViewFlipper();

        //bắt sự kiện click item
        listViewNew.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, NoiDung.class);
                String tent = TruyenArratList.get(position).getTenTruyen();
                String noidungt = TruyenArratList.get(position).getNoiDung();
                intent.putExtra("tentruyen", tent);
                intent.putExtra("noidung", noidungt);
                startActivity(intent);
            }
        });

        //bắt click item cho listview
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    if(i == 1){
                        Intent intent = new Intent(MainActivity.this, Admin.class);
                        //gửi id tài khoản qua Admin
                        intent.putExtra("Id", idd);
                        startActivity(intent);
                    }
                    else{

                        Toast.makeText(MainActivity.this, "Bạn không có quyền đăng bài", Toast.LENGTH_SHORT).show();
                        Log.e("Đăng bài", "Bạn không có quyền");
                    }
                }
                //chuyển qua màn thông tin
                else if(position == 1){
                    Intent intent = new Intent(MainActivity.this, ThongTin.class);
                    startActivity(intent);
                }
                //đăng xuất
                else if(position==2){
                    finish();
                }
            }
        });
    }

    //thanh action
    private void ActionBar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationIcon(android.R.drawable.ic_menu_sort_by_size);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
    }

    // phương thức chạy viewfilipper
    private void ActionViewFlipper() {
        ArrayList<String> mangqc = new ArrayList<>();
        mangqc.add("https://cdn.hellobacsi.com/wp-content/uploads/2017/11/14-cau-chuyen-y-nghia-ban-ke-cho-be-nghe-moi-dem-2-e1511109071378.jpg");
        mangqc.add("https://cdn.hellobacsi.com/wp-content/uploads/2017/11/14-cau-chuyen-y-nghia-ban-ke-cho-be-nghe-moi-dem-3-e1511109086177.jpg");
        mangqc.add("https://cdn.hellobacsi.com/wp-content/uploads/2017/11/14-cau-chuyen-y-nghia-ban-ke-cho-be-nghe-moi-dem-4-e1511109098651.jpg");
        mangqc.add("https://cdn.hellobacsi.com/wp-content/uploads/2017/11/14-cau-chuyen-y-nghia-ban-ke-cho-be-nghe-moi-dem-5-e1511109054210.jpg");
        mangqc.add("https://cdn.hellobacsi.com/wp-content/uploads/2017/11/14-cau-chuyen-y-nghia-ban-ke-cho-be-nghe-moi-dem-1.jpg");

        //thực hiện vòng lặp
        for(int i=0; i<mangqc.size(); i++){
            ImageView imageView = new ImageView(getApplicationContext());
            //sử dụng thư viện picasso
            Picasso.get().load(mangqc.get(i)).into(imageView);
            //chỉnh hình ảnh
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            //thêm hình ảnh
            viewFlipper.addView(imageView);
        }
        //chạy trong 4s
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);
        //gọi animition cho vào ra
        Animation animation_sile_in = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.silde_in_right);
        Animation animation_sile_out = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_out_right);
        //gọi animition vào viewflipper
        viewFlipper.setInAnimation(animation_sile_in);
        viewFlipper.setInAnimation(animation_sile_out);
    }

    //phương thức ánh xạ
    private void AnhXa() {
        toolbar = findViewById(R.id.tool_bar_trangchu);
        viewFlipper = findViewById(R.id.view_flipper);
        listViewNew = findViewById(R.id.list_view);
        listView = findViewById(R.id.list_view_trangchu);
        listViewThongTin = findViewById(R.id.list_view_thongtin);
        navigationView = findViewById(R.id.navigation_view);
        drawerLayout = findViewById(R.id.drawer_layout);

        TruyenArratList = new ArrayList<>();

        Cursor cursor1 = databasedoctruyen.getDatal();
        while (cursor1.moveToNext()){
            int id = cursor1.getInt(0);
            String tentruyen = cursor1.getString(1);
            String noidung = cursor1.getString(2);
            String anh = cursor1.getString(3);
            int id_tk = cursor1.getInt(4);

            TruyenArratList.add(new Truyen(id, tentruyen, noidung, anh, id_tk));
            adapterTruyen = new adapterTruyen(getApplicationContext(), TruyenArratList);
            listViewNew.setAdapter(adapterTruyen);
        }
        cursor1.moveToFirst();
        cursor1.close();

        //thông tin
        taikhoanArrayList = new ArrayList<>();
        taikhoanArrayList.add(new Taikhoan(taikhoan,email));

        adapterthongtin = new adapterthongtin(this, R.layout.navigation_thongtin, taikhoanArrayList);
        listViewThongTin.setAdapter(adapterthongtin);

        //chuyển mục
        chuyenmucArrayList = new ArrayList<>();
        chuyenmucArrayList.add(new chuyenmuc("Đăng bài",R.drawable.ic_post));
        chuyenmucArrayList.add(new chuyenmuc("Thông tin", R.drawable.ic_sub));
        chuyenmucArrayList.add(new chuyenmuc("Đăng xuất", R.drawable.ic_login));

        adapterchuyenmuc = new adapterchuyenmuc(this, R.layout.chuyenmuc, chuyenmucArrayList);
        listView.setAdapter(adapterchuyenmuc);
    }


    @Override
    public void onOptionsMenuClosed(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        super.onOptionsMenuClosed(menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mymenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //click tìm kiếm
        switch (item.getItemId()){
            case R.id.menu1:
                Intent intent = new Intent(MainActivity.this,timkiem.class);
                startActivity(intent);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}