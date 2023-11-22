package Movie;

public class MovieInfo {
    String movieName = "BorBor And The Gang";
    String typeMovie = "Comedy";
    String language = "TH/EN";
    String totalTime = "160 minute";
    String posterMoviePath = "src/picture/Poster1.png";

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
