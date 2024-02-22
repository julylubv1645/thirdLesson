package com.example.thirdlesson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity {


    private int id = 0;
    private EditText inputName;
    private EditText inputAuthor;
    private TextView output;
    private Button button;
    private Book[] books;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        inputName = findViewById(R.id.inputName);
        inputAuthor = findViewById(R.id.inputAuthor);
        output = findViewById(R.id.output);
        button = findViewById(R.id.button);


        books = new Book[100];


        button.setOnClickListener(listener);
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            output.setText("");
            String name = inputName.getText().toString();
            String author = inputAuthor.getText().toString();
            id++;
            Book book = new Book(id, author, name);

            books[id-1] = book;

            Stream<Book> bookStream = Arrays.stream(books).filter(Objects::nonNull);

            bookStream.sorted(Comparator.comparing(Book::getAuthor)).forEach(s -> output.append(s.getId() + " Автор " + s.getAuthor() + ", книга " + s.getName() + "\n"));
        }
    };
}