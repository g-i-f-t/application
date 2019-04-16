package capstone.son.cut.fundingapp;

public class GameInfoVO {
    public GameInfoVO(String title, String desc){
        this.title=title;
        this.desc=desc;
    }
    private String title,desc;

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }
}
