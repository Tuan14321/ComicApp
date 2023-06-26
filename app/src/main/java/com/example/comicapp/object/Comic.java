package com.example.comicapp.object;

public class Comic {
    private String ComicName;
    private String ChapterName;
    private String ImageLink;

    public Comic(String comicName, String chapterName, String imageLink) {
        ComicName = comicName;
        ChapterName = chapterName;
        ImageLink = imageLink;
    }

    public String getComicName() {
        return ComicName;
    }

    public void setComicName(String comicName) {
        ComicName = comicName;
    }

    public String getChapterName() {
        return ChapterName;
    }

    public void setChapterName(String chapterName) {
        ChapterName = chapterName;
    }

    public String getImageLink() {
        return ImageLink;
    }

    public void setImageLink(String imageLink) {
        ImageLink = imageLink;
    }
}
