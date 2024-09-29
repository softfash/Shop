package com.example.supermarket;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private String[] names = {"手撕面包", "华夫饼", "小麻花", "每日坚果", "盐焗鸡蛋",
            "原味肉松饼"};
    private String[] prices = {"￥32.90", "￥36.90", "￥18.80", "￥19.90",
            "￥30.70", "￥34.90"};
    private String[] shops = {"良品铺子旗舰店", "百草味旗舰店", "比比赞旗舰店",
            "憨豆熊旗舰店", "无穷旗舰店", "良品铺子旗舰店"};
    private int[] pictures = {R.drawable.tear_bread, R.drawable.waffle,
            R.drawable.dough_twist, R.drawable.daily_nuts,
            R.drawable.salt_baked_eggs, R.drawable.meat_floss};




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = findViewById(R.id.lv_list);
        MyBaseAdapter mAdapter = new MyBaseAdapter(this);
        mListView.setAdapter(mAdapter);
    }


    class MyBaseAdapter extends BaseAdapter {
        private Context mContext;
        public MyBaseAdapter(Context context) {
            this.mContext=context;
        }

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int position) {
            return names[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if(convertView == null){
                convertView  = LayoutInflater.from(mContext).inflate(
                        R.layout.list_item, null);
                holder = new ViewHolder();
                holder.tv_goods_name = convertView.findViewById(R.id.tv_goods_name);
                holder.tv_price = convertView.findViewById(R.id.tv_price);
                holder.tv_shop = convertView.findViewById(R.id.tv_shop);
                holder.iv_img = convertView.findViewById(R.id.iv_img);
                convertView.setTag(holder);
            }else{
                holder = (ViewHolder) convertView.getTag();
            }
            holder.tv_goods_name.setText(names[position]);
            holder.tv_price.setText(prices[position]);
            holder.tv_shop.setText(shops[position]);
            holder.iv_img.setBackgroundResource(pictures[position]);
            return convertView;
        }
    }


    class ViewHolder{
        TextView tv_goods_name, tv_price, tv_shop;
        ImageView iv_img;
    }

}
