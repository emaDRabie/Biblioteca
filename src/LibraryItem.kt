abstract class LibraryItem(
    var title: String,
    private val isbn: String,
    val publication: String,
    val noOfPages: Int
) {
    var available: Boolean = true
    override fun toString(): String = "$title ($isbn)"
    abstract fun isAvailable(): Boolean
}

class Book(title: String, isbn: String, publication: String, noOfPages: Int) :
    LibraryItem(title, isbn, publication, noOfPages) {
    override fun isAvailable() = available
}

class Magazine(title: String, isbn: String, publication: String, noOfPages: Int) :
    LibraryItem(title, isbn, publication, noOfPages) {
    override fun isAvailable() = available
}

class Journal(title: String, isbn: String, publication: String, noOfPages: Int) :
    LibraryItem(title, isbn, publication, noOfPages) {
    override fun isAvailable() = available
}
