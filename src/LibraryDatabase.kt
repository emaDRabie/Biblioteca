class LibraryDatabase(val currentLibrarian: Librarian) {
    private val listOfAvailableBooks = mutableListOf<LibraryItem>()
    private val listOfBorrowedBooks = mutableMapOf<LibraryItem, User>()

    fun addBook(item: LibraryItem) {
        listOfAvailableBooks.add(item)
    }

    fun viewAvailableBooks() {
        println("Available Books:")
        listOfAvailableBooks.forEach { println("- ${it.title}") }
    }

    fun searchForABook(title: String): LibraryItem? {
        return listOfAvailableBooks.find { it.title.equals(title, ignoreCase = true) }
    }

    fun lendBook(item: LibraryItem, user: User) {
        if (item.isAvailable() && listOfAvailableBooks.contains(item)) {
            item.available = false
            listOfAvailableBooks.remove(item)
            listOfBorrowedBooks[item] = user
            println("${user.name} borrowed ${item.title}")
        } else {
            println("${item.title} is not available.")
        }
    }

    fun receiveBookFromBorrower(item: LibraryItem) {
        if (listOfBorrowedBooks.containsKey(item)) {
            item.available = true
            listOfBorrowedBooks.remove(item)
            listOfAvailableBooks.add(item)
            println("${item.title} has been returned.")
        } else {
            println("${item.title} was not borrowed.")
        }
    }

    fun searchForBookInBorrowed(title: String): LibraryItem? {
        return listOfBorrowedBooks.keys.find { it.title.equals(title, ignoreCase = true) }
    }

}
