package com.l000phone.mylore.entitys;

import java.util.List;

/**
 * Created by Administrator on 2015/11/18.
 */
public class FoundSelectData {
    private List<FoundSelectAuthor> authors;
    private List<String>  tags;
    private List<FoundSelectSections> sections;
    private List<FoundSelectBook> books;

    public List<FoundSelectAuthor> getAuthors() {
        return authors;
    }

    public void setAuthors(List<FoundSelectAuthor> authors) {
        this.authors = authors;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<FoundSelectSections> getSections() {
        return sections;
    }

    public void setSections(List<FoundSelectSections> sections) {
        this.sections = sections;
    }

    public List<FoundSelectBook> getBooks() {
        return books;
    }

    public void setBooks(List<FoundSelectBook> books) {
        this.books = books;
    }
}
