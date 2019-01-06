package com.mylibrary.objects;

import java.util.List;

public class Book {
  private String title, isbn, publisher, bookAbstract;
  private int year, pages, edition;
  private List<String> authors, keywords;

  public Book(String title, String isbn, String publisher, String bookAbstract, int year, int pages, int edition,
      List<String> authors, List<String> keywords) {
    this.title = title;
    this.isbn = isbn;
    this.publisher = publisher;
    this.bookAbstract = bookAbstract;
    this.year = year;
    this.pages = pages;
    this.edition = edition;
    this.setAuthors(authors);
    this.keywords = keywords;
  }

  public String getAbstract() {
    return this.bookAbstract;
  }

  public boolean compareTitle(String newTitle) {
    if (title.equalsIgnoreCase(newTitle)) {
      return true;
    }
    return false;
  }

  public boolean compareIsbn(String newIsbn) {
    if (isbn.equalsIgnoreCase(newIsbn)) {
      return true;
    }
    return false;
  }

  public boolean comparePublisher(String newPub) {
    if (publisher.equalsIgnoreCase(newPub)) {
      return true;
    }
    return false;
  }

  public boolean compareAbstract(String newAbstract) {
    if ((bookAbstract == null && newAbstract != "") || (!bookAbstract.equalsIgnoreCase(newAbstract))) {
      return false;
    }
    return true;
  }

  public boolean compareYear(int newYear) {
    if (year == newYear) {
      return true;
    }
    return false;
  }

  public boolean comparePages(int newPages) {
    if (pages == newPages) {
      return true;
    }
    return false;
  }

  public boolean compareEdition(int newEdition) {
    if (edition == newEdition) {
      return true;
    }
    return false;
  }

  public boolean compareAuthor(List<String> newAuthors) {
    // if author not in newAuthors, delete author
    // if new author not in authors, insert author
    for (String author : getAuthors()) {
      if (!newAuthors.contains(author)) {
        return false;
      }
    }
    for (String author : newAuthors) {
      if (!getAuthors().contains(author)) {
        return false;
      }
    }
    return true;
  }

  public boolean compareKeywords(List<String> newKeywords) {
    // if keyword not in newKeywords, delete keyword
    // if new keyword not in keywords, insert keyword
    if (!keywords.containsAll(newKeywords)) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return this.title + " " + this.isbn + " " + this.year + " " + this.edition + " " + this.pages + " "
        + this.publisher + " " + this.getAuthors().get(1) + " " + this.keywords.get(2);
  }

  /**
   * @return the authors
   */
  public List<String> getAuthors() {
    return authors;
  }

  /**
   * @param authors the authors to set
   */
  public void setAuthors(List<String> authors) {
    this.authors = authors;
  }
}
