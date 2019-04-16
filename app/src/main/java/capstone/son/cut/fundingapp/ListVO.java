package capstone.son.cut.fundingapp;

public class ListVO {
    private int image;
    private String name,developer, category,game_info, inve_info, inve_cond, com_info;
    private boolean success;
    private long game_id,current_price,goal_price;
    public ListVO(int image,String name,long game_id,String developer, String category, String game_info, String inve_cond, String com_info, boolean success, long current_price, long goal_price){
        this.image=image;
        this.name=name;
        this.game_id=game_id;
        this.category=category;
        this.developer=developer;
        this.game_info=game_info;
        this. inve_cond=inve_cond;
        this.inve_info=inve_cond;
        this.com_info=com_info;
        this.success=success;
        this.current_price=current_price;
        this.goal_price=goal_price;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }


    public String getDeveloper() {
        return developer;
    }

    public String getCategory() {
        return category;
    }

    public String getGame_info() {
        return game_info;
    }

    public String getInve_info() {
        return inve_info;
    }

    public String getInve_cond() {
        return inve_cond;
    }

    public String getCom_info() {
        return com_info;
    }

    public boolean isSuccess() {
        return success;
    }

    public long getGame_id() {
        return game_id;
    }

    public long getCurrent_price() {
        return current_price;
    }

    public long getGoal_price() {
        return goal_price;
    }
}
