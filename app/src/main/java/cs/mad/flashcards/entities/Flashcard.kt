package cs.mad.flashcards.entities


data class Flashcard(
    val question: String,
    val answer: String
)
fun getHardcodedFlashcards(): MutableList<Flashcard> {
    return mutableListOf(Flashcard("Term 1", "Def 1"),
        Flashcard( "Term 2", "Def 1"),
        Flashcard( "Term 3", "Def 1"),
        Flashcard( "Term 4", "Def 1"),
        Flashcard( "Term 5", "Def 1"),
        Flashcard( "Term 6", "Def 1"),
        Flashcard( "Term 7", "Def 1"),
        Flashcard( "Term 8", "Def 1"),
        Flashcard( "Term 9", "Def 1"),
        Flashcard( "Term 10", "Def 1"),
    )
}