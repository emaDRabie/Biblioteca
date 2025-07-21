//TIP <i><b>This is a library system</b></i>
//TIP <b><b>Prepared by Emad</b></b>
import kotlin.system.exitProcess

fun main() {
    val librarian = Librarian("Emad", 1, "admin123")
    val db = LibraryDatabase(librarian)
    val user = User("Arwa", 2, "Engineer")

    println("Welcome to the Library System")

    var choice: Int

    do {
        println(
            """
            ─────────────────────────────
            1. Add a New Book
            2. View Available Books
            3. Lend a Book
            4. Receive a Book (Return)
            5. Exit
            ─────────────────────────────
            Enter your choice: 
        """.trimIndent()
        )

        choice = readlnOrNull()?.toIntOrNull() ?: -1

        when (choice) {
            1 -> {
                print("Enter book title: ")
                val title = readlnOrNull() ?: ""
                print("Enter ISBN: ")
                val isbn = readlnOrNull() ?: ""
                print("Enter publication: ")
                val publication = readlnOrNull() ?: ""
                print("Enter number of pages: ")
                val pages = readlnOrNull()?.toIntOrNull() ?: 0

                val newBook = Book(title, isbn, publication, pages)
                db.addBook(newBook)
                println("Book added successfully!\n")
            }

            2 -> db.viewAvailableBooks()

            3 -> {
                print("Enter book title to lend: ")
                val title = readlnOrNull() ?: ""
                val book = db.searchForABook(title)
                if (book != null) {
                    db.lendBook(book, user)
                } else {
                    println("Book not found or unavailable.")
                }
            }

            4 -> {
                print("Enter book title to return: ")
                val title = readlnOrNull() ?: ""
                val book = db.searchForBookInBorrowed(title)
                if (book != null) {
                    db.receiveBookFromBorrower(book)
                } else {
                    println("Book not found in borrowed list.")
                }
            }

            5 -> {
                println("Exiting...")
                exitProcess(0)
            }

            else -> println("Invalid choice, please try again.")
        }

    } while (true)
}
