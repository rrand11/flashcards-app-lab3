package cs.mad.flashcards.activities

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import cs.mad.flashcards.R
import cs.mad.flashcards.adapters.FlashcardListAdapter
import cs.mad.flashcards.adapters.FlashcardSetAdapter
import cs.mad.flashcards.entities.getHardcodedFlashcards


class FlashCardSetDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flash_card_set_detail)

        val listrecycler = findViewById<RecyclerView>(R.id.CardList)

        // Access the RecyclerView Adapter and load the data into it
        //val gridLayoutManager = GridLayoutManager(applicationContext, 2, GridLayoutManager.VERTICAL,false)
        val linearLayoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        listrecycler.layoutManager = linearLayoutManager
        listrecycler.setHasFixedSize(true)
        val list = getHardcodedFlashcards()
        listrecycler.adapter = FlashcardListAdapter(list)

        val addbutton = findViewById(R.id.add_card_button) as Button
        // set on-click listener

        addbutton.setOnClickListener {
            (listrecycler.adapter as FlashcardListAdapter).insertItem()
        }
    }
}


/*
           connect to views using findViewById
           setup views here - recyclerview,
           add set button - goes into main xml - on click listener here - call add function from adapter

           don't forget to notify the adapter if the data set is changed

           val list = listof...
           recycler.adapter.notifyDataSetChanged()
        */
