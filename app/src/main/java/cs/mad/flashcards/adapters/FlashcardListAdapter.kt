package cs.mad.flashcards.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import cs.mad.flashcards.R
import cs.mad.flashcards.activities.FlashCardSetDetailActivity
import cs.mad.flashcards.entities.Flashcard
import cs.mad.flashcards.entities.FlashcardSet

class FlashcardListAdapter(private val dataset: MutableList<Flashcard>) :
        RecyclerView.Adapter<FlashcardListAdapter.ViewHolder>() {


    // need to get and store a reference to the data set

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // store view references as properties using findViewById on view
        val textView: TextView = view.findViewById(R.id.textView)
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        /*
            this is written for you but understand what is happening here
            the layout for an individual item is being inflated
            the inflated layout is passed to view holder for storage

            THE ITEM LAYOUT STILL NEEDS TO BE SETUP IN THE LAYOUT EDITOR
         */

        return ViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.flashcard_item, viewGroup, false))
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = dataset[position]
        viewHolder.textView.text = item.question
    }

    fun insertItem() {
        val index: Int = dataset.lastIndex+1
        val newItem = Flashcard("term 42","answer The Question")
        dataset.add(newItem)
        notifyItemInserted(index)
    }


        //viewHolder.textView.setOnClickListener {
        //    viewHolder.itemView.context.startActivity(Intent(viewHolder.itemView.context, FlashCardSetDetailActivity::class.java))


        // add item function


        /*
            fill the contents of the view using references in view holder and current position in data set

            to launch FlashcardSetDetailActivity ->
            viewHolder.itemView.context.startActivity(Intent(viewHolder.itemView.context, FlashcardSetDetailActivity::class.java))
         */
    override fun getItemCount(): Int {
        // return the size of the data set
        return dataset.size
        //return -1
    }
}