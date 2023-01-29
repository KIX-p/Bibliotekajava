class Book {
    private String title;
    private Author author;
    private int pages;
    private String ISBN;

    public Book(String title, Author author, int pages, String ISBN) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public String getISBN() {
        return ISBN;
    }
}