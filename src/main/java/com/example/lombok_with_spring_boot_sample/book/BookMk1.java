package com.example.lombok_with_spring_boot_sample.book;

public class BookMk1 {
    private String isbn;

    private String title;

    private String author;

    private int page;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookMk1)) return false;

        BookMk1 bookMk1 = (BookMk1) o;

        if (getPage() != bookMk1.getPage()) return false;
        if (getIsbn() != null ? !getIsbn().equals(bookMk1.getIsbn()) : bookMk1.getIsbn() != null) return false;
        if (getTitle() != null ? !getTitle().equals(bookMk1.getTitle()) : bookMk1.getTitle() != null) return false;
        if (getAuthor() != null ? !getAuthor().equals(bookMk1.getAuthor()) : bookMk1.getAuthor() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getIsbn() != null ? getIsbn().hashCode() : 0;
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + (getAuthor() != null ? getAuthor().hashCode() : 0);
        result = 31 * result + getPage();
        return result;
    }

    @Override
    public String toString() {
        return "BookMk1{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", page=" + page +
                '}';
    }
}
