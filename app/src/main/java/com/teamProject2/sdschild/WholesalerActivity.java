package com.teamProject2.sdschild;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class WholesalerActivity extends AppCompatActivity {

    Button BtnAdd;
    Button BtnCount, BtnAmount, BtnName;
    EditText EditSearch;

    ListView listView;
    SnackListAdapter adapter;
    List<Item> items = new ArrayList<>();

    FirebaseDatabase database;
    DatabaseReference warehouseRef;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        System.snack_search = "";
    }

    @Override
    protected void onPause() {
        super.onPause();
        overridePendingTransition(0, 0);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warehouse);

        database = FirebaseDatabase.getInstance();
        warehouseRef = database.getReference("warehouse");

        warehouseRef.addValueEventListener(postListener);

//        warehouseRef.child("warehouse").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                items.clear();
//                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                    Item item = snapshot.getValue(Item.class);
//                    items.add(item);
//                }
//                listView.requestLayout();//
//                adapter.notifyDataSetChanged();
////                adapter.refreshAdapter((ArrayList<Revenue>) revenues);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

        listView = findViewById(R.id.ListItem);
        adapter = new SnackListAdapter(items, this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(getApplicationContext(), RevenueEditActivity.class);
//                Object object = adapterView.getAdapter().getItem(i);
//                intent.putExtra("date", (Revenue) object);
//                startActivity(intent);
                Intent intent = new Intent(getApplicationContext(), WholesalerEditActivity.class);
                Object object = adapterView.getAdapter().getItem(i);
                intent.putExtra("item", (Item) object);
                startActivity(intent);
            }
        });

        BtnAdd = findViewById(R.id.BtnAdd);

        BtnAdd.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), WholesalerAddActivity.class);
                startActivity(intent);
            }
        });

//        btn_sort_name.setOnClickListener(new View.OnClickListener() {
//            int state = 0;
//            @Override
//            public void onClick(View view) {
//                if(state == 1)state = 2;
//                else state = 1;
//                switch(state){
//                    case 1:
//                        //이름 오름차순 정렬
//                        Collections.sort(list_item, new Comparator<Club>() {
//                            @Override
//                            public int compare(Club c1, Club c2) {
//                                return c1.getcName().compareTo(c2.getcName());
//                            }
//                        });
//                        adapter.notifyDataSetChanged() ;
//                        btn_sort_name.setText("이름순 ▲");
//                        btn_sort_year.setText("년도순 △");
//                        btn_sort_membernumber.setText("인원순 △");
//                        break;
//                    case 2:
//                        //이름 내림차순 정렬
//                        Collections.sort(list_item, new Comparator<Club>() {
//                            @Override
//                            public int compare(Club c1, Club c2) {
//                                return c2.getcName().compareTo(c1.getcName());
//                            }
//                        });
//                        adapter.notifyDataSetChanged();
//                        btn_sort_name.setText("이름순 ▼");
//                        btn_sort_year.setText("년도순 △");
//                        btn_sort_membernumber.setText("인원순 △");
//                    default:
//                        break;
//                }
//            }
//        });

        BtnCount = findViewById(R.id.BtnCount);
//        BtnCount.setText(System.state+"");
        BtnCount.setOnClickListener(new View.OnClickListener() {
//            int state = 0;
            @Override
            public void onClick(View view) {
                if (System.isCounted == 1) {
                    System.isCounted = 2;
                    Collections.sort(items, new Comparator<Item>() {
                        @Override
                        public int compare(Item i1, Item i2) {
                            return i1.getCount().compareTo(i2.getCount());
                        }
                    });
                    adapter.notifyDataSetChanged();
                    BtnCount.setText("개수 ▼");
                    BtnAmount.setText("금액 △");
                    BtnName.setText("이름 △");
                }
                else if (System.isCounted == 2){
                    System.isCounted = 1;
                    Collections.sort(items, new Comparator<Item>() {
                        @Override
                        public int compare(Item i1, Item i2) {
                            return i2.getCount().compareTo(i1.getCount());
                        }
                    });
                    adapter.notifyDataSetChanged();
                    BtnCount.setText("개수 ▲");
                    BtnAmount.setText("금액 △");
                    BtnName.setText("이름 △");
                }
            }
        });

//        BtnCount.setOnClickListener(new View.OnClickListener() {
//            int state = 0;
//            @Override
//            public void onClick(View view) {
//                Collections.sort(items, new Comparator<Item>() {
//                    @Override
//                    public int compare(Item i1, Item i2) {
//                        return i1.getCount().compareTo(i2.getCount());
//                    }
//                });
//                adapter.notifyDataSetChanged();
//            }
//        });

        BtnAmount = findViewById(R.id.BtnAmount);

        BtnAmount.setOnClickListener(new View.OnClickListener() {
            //            int state = 0;
            @Override
            public void onClick(View view) {
                if (System.isAmounted == 1) {
                    System.isAmounted = 2;
                    Collections.sort(items, new Comparator<Item>() {
                        @Override
                        public int compare(Item i1, Item i2) {
                            return i1.getAmount().compareTo(i2.getAmount());
                        }
                    });
                    adapter.notifyDataSetChanged();
                    BtnCount.setText("개수 △");
                    BtnAmount.setText("금액 ▲");
                    BtnName.setText("이름 △");
                }
                else if (System.isAmounted == 2){
                    System.isAmounted = 1;
                    Collections.sort(items, new Comparator<Item>() {
                        @Override
                        public int compare(Item i1, Item i2) {
                            return i2.getAmount().compareTo(i1.getAmount());
                        }
                    });
                    adapter.notifyDataSetChanged();
                    BtnCount.setText("개수 △");
                    BtnAmount.setText("금액 ▼");
                    BtnName.setText("이름 △");
                }
            }
        });

        BtnName = findViewById(R.id.BtnName);

        BtnName.setOnClickListener(new View.OnClickListener() {
            //            int state = 0;
            @Override
            public void onClick(View view) {
                if (System.isNamed == 1) {
                    System.isNamed = 2;
                    Collections.sort(items, new Comparator<Item>() {
                        @Override
                        public int compare(Item i1, Item i2) {
                            return i1.getName().compareTo(i2.getName());
                        }
                    });
                    adapter.notifyDataSetChanged();
                    BtnCount.setText("개수 △");
                    BtnAmount.setText("금액 △");
                    BtnName.setText("이름 ▲");
                }
                else if (System.isNamed == 2){
                    System.isNamed = 1;
                    Collections.sort(items, new Comparator<Item>() {
                        @Override
                        public int compare(Item i1, Item i2) {
                            return i2.getName().compareTo(i1.getName());
                        }
                    });
                    adapter.notifyDataSetChanged();
                    BtnCount.setText("개수 △");
                    BtnAmount.setText("금액 △");
                    BtnName.setText("이름 ▼");
                }
            }
        });

        EditSearch = findViewById(R.id.EditSearch);
        EditSearch.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                java.lang.System.out.println(keyCode);
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    System.snack_search = EditSearch.getText().toString();
                    Intent intent = new Intent(getApplicationContext(), WholesalerActivity.class);
//                    startActivity(getIntent());
                    intent.addFlags (Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    startActivity(intent);
                    finish();
                    return true;
                } else return false;
            }
        });

    }


    ValueEventListener postListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            items.clear();
            for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                String key = snapshot.getKey();
//                Revenue revenue = snapshot.getValue(Revenue.class);
//                revenue.date = key;
//                revenues.add(revenue);
//                if(key.contains(System.date)) {
                if(key.contains(System.snack_search)) {
                    Item item = snapshot.getValue(Item.class);
                    item.name = key;
                    items.add(item);
                }
//                }
            }
            listView.requestLayout(); //
            adapter.notifyDataSetChanged(); //
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };
}
