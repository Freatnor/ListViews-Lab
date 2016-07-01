package ly.generalassemb.drewmahrt.bookshelf;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    BaseAdapter mBookAdapter;

    //TODO: Define your ListView
    ListView mListView;

    //TODO: Define your Book List
    List<Book> mBookList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Use helper method to add books to the list
        mBookList = generateBooks();
        mListView = (ListView) findViewById(R.id.listview);

        //TODO: Instantiate BaseAdapter
        //Below is a partially complete example for one Adapter
        mBookAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return mBookList.size();
            }

            @Override
            public Object getItem(int position) {
                return mBookList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                //TODO: Update the view
                View view = convertView;
                if(view == null){
                    LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    view = inflater.inflate(android.R.layout.simple_list_item_2, null);
                }

                TextView bookNameView = (TextView) view.findViewById(android.R.id.text1);
                TextView authorNameView = (TextView) view.findViewById(android.R.id.text2);

                bookNameView.setText(mBookList.get(position).getTitle());
                authorNameView.setText(mBookList.get(position).getAuthor());

                return view;
            }
        };

        //TODO: Set the ListView's adapter
        mListView.setAdapter(mBookAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView bookNameView = (TextView) view.findViewById(android.R.id.text1);
                TextView authorNameView = (TextView) view.findViewById(android.R.id.text2);


                bookNameView.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
                authorNameView.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            }
        });

    }

    //Method to generate a list of Books
    private List<Book> generateBooks(){
        List<Book> books = new ArrayList<>();

        books.add(new Book("Apples Book","Brad",2002,30));
        books.add(new Book("Cats Book","Ryan",25,400));
        books.add(new Book("Eagles Book","Kate",-70,2));
        books.add(new Book("Strawberries Cathy","Brad",1876,500));
        books.add(new Book("Dogs Book","Tom",1297,7000));
        books.add(new Book("Ants Book","Zane",2025,20205));

        return books;
    }
}
