package ood_design_exercise_P3;

import java.util.Objects;

public class BookNode implements BookCirculationSystem {

  private Book headBook;
  private BookNode nextBook;

  public BookNode(Book headBook, BookNode nextBook) {
    this.headBook = headBook;
    this.nextBook = nextBook;
  }

  public BookNode(Book headBook) {
    this.headBook = headBook;
    this.nextBook = null;
  }

  public Book getHeadBook() {
    return headBook;
  }

  public BookNode getNextBook() {
    return nextBook;
  }

  private void setNextBook(BookNode nextBook) {
    this.nextBook = nextBook;
  }

  @Override
  public Boolean isEmpty() {
    return (this.headBook == null);
  }

  @Override
  public BookCirculationSystem addBook(Book book) {
    return new BookNode(book, this);
  }

  @Override
  public BookCirculationSystem removeBook(Book book) throws BookNotFoundException {
    if(!this.containsBook(book))
      throw new BookNotFoundException("This book is not a part of the book circulation system!");
    else{
      //Book to remove is the head book
      if(this.headBook.equals(book))
        return this.getNextBook();
      else {
        BookNode currNode = this.getNextBook();
        while (this.getNextBook() != null) {
          if (this.headBook.equals(book)){
            currNode.setNextBook(currNode.getNextBook().getNextBook());
            return new BookNode(this.headBook, this.getNextBook());
          }
        else {
            currNode = currNode.getNextBook();
          }
        }
        //Check that the book to remove isn't last book
        if (currNode.headBook.equals(book))
          currNode = null;
      }
    }
    return this;
  }

  @Override
  public Boolean containsBook(Book book) {
    BookNode currNode = this;
    while(currNode != null){
      if(currNode.headBook.equals(book))
        return true;
      else
        currNode = currNode.getNextBook();
    }
    return false;
  }

  @Override
  public Integer getNumBooks() {
    int bookCounter = 0;
    BookNode currNode = this;
    while(currNode != null){
      bookCounter++;
      currNode = currNode.getNextBook();
    }
    return bookCounter;
  }

  @Override
  public Book getRandomBook() {
    return this.headBook;
  }

  @Override
  public Book getBookByISBN(String ISBN) throws InvalidISBNException {
    BookNode currNode = this;
    while(currNode != null){
      if(currNode.headBook.getISBN().equals(ISBN))
        return this.headBook;
      else
        currNode = currNode.getNextBook();
    }
    throw new InvalidISBNException("This ISBN is not a part of the book circulation system!");
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BookNode bookNode = (BookNode) o;
    return Objects.equals(headBook, bookNode.headBook) && Objects.equals(nextBook,
        bookNode.nextBook);
  }

  @Override
  public int hashCode() {
    return Objects.hash(headBook, nextBook);
  }

  @Override
  public String toString() {
    return "BookNode{" +
        "headBook=" + headBook +
        ", nextBook=" + nextBook +
        '}';
  }
}
