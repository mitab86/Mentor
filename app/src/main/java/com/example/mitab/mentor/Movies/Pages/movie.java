package com.example.mitab.mentor.Movies.Pages;

import java.util.Date;

/**
 * Created by Mitab on 1/14/2016.
 */
public class movie {
    private long id;
    private String averagevote;
    private String title;
    private Date releasedate;
    private String overview;
    private String votecount;
    private String urlSimilar;
    private String reviews;
    private String image;

    public movie(){

    }
    public movie(long id,String title,Date releasedate,String overview, String  votecount,String averagevote, String urlSimilar,String reviews,String image){
        this.id=id;
        this.image=image;
        this.overview=overview;
        this.releasedate=releasedate;
        this.reviews=reviews;
        this.title=title;
        this.urlSimilar=urlSimilar;
        this.votecount=votecount;
        this.averagevote=averagevote;
    }

    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id=id;
    }
    public String getOverview(){
        return overview;
    }
    public void setOverview(String overview){
        this.overview=overview;
    }
    public String getAveragevote(){
        return averagevote;
    }
    public void setAveragevote(String averagevote){
        this.averagevote=averagevote;
    }
    public String getTitle(){
        return title;
    }
    public  void setTitle(String title){
        this.title=title;
    }
    public Date getReleasedate(){
        return releasedate;
    }
    public  void setReleasedate(Date releasedate){
        this.releasedate=releasedate;
    }
    public String getReviews(){
        return reviews;
    }
    public  void setReviews(String reviews){
        this.reviews=reviews;
    }
    public String getImage(){
        return image;
    }
    public  void setImage(String image){
        this.image="http://image.tmdb.org/t/p/w500/"+image;
    }
    public String getUrlSimilar(){
        return urlSimilar;
    }
    public  void setUrlSimilar(String urlSimilar){
        this.urlSimilar=urlSimilar;
    }
    public String getVotecount(){
        return votecount;
    }
    public  void setVotecount(String votecount){
        this.votecount=votecount;
    }

    @Override
    public String toString(){
        return "ID:" +id+
                "Title:" +title+
                "Date:" +releasedate+
                "Avgvote"+averagevote+
                "Overview" +overview+
                "Votes:" +votecount+
                "Poster" +image;



    }
}


