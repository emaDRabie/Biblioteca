interface Person {
    val name: String
    val id: Int
}

class Librarian(
    override val name: String,
    override val id: Int,
    val password: String
) : Person

class User(
    override val name: String,
    override val id: Int,
    val job: String
) : Person
