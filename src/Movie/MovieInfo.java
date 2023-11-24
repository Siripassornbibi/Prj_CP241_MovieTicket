package Movie;

public class MovieInfo {
    String movieName;
    String typeMovie;
    String language;
    String totalTime;
    String posterMoviePath;

    //mutator
    public void setMovieName(String a){
        movieName = a;
    }

    public void setTypeMovie(String typeMovie){
        this.typeMovie = typeMovie;
    }

    public void setLanguage(String language){
        this.language = language;
    }

    public void setTotalTime(String totalTime){
        this.totalTime = totalTime;
    }

    public void setPosterMoviePath(String posterMoviePath){
        this.posterMoviePath = posterMoviePath;
    }

    //accessor
    public String getMovieName(){
        return movieName;
    }

    public String getTypeMovie(){
        return typeMovie;
    }

    public String getLanguage(){
        return language;
    }

    public String getTotalTime(){
        return totalTime;
    }

    public String getPosterMoviePath(){
        return posterMoviePath;
    }
}
