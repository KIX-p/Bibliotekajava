import java.util.ArrayList;
import java.util.List;

class Library {
    private List<Book> books;

    public Library() {
        books = new ArrayList<Book>();
    }

    public void dodaj(Book book) {
        books.add(book);
    }

    public void usun(Book book) {
        books.remove(book);
    }

    public List<Book> wyszukajpoAutorze(String authorName) {
        List<Book> result = new ArrayList<Book>();
        for (Book book : books) {
            if (book.getAuthor().getLastName().equalsIgnoreCase(authorName)) {
                result.add(book);
            }
        }
        return result;
    }

    public Book wyszukajpoTytule(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
}