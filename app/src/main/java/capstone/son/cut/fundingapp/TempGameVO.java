package capstone.son.cut.fundingapp;

public class TempGameVO {
    private static ListVO vo;
    private static int image;
    private static String name,developer, category,game_info, inve_info, inve_cond, com_info;
    private static boolean success;
    private static long game_id,current_price,goal_price;
    public static void setVO(ListVO vo){
        image=vo.getImage();
        name=vo.getName();
        game_id=vo.getGame_id();
        category=vo.getCategory();
        developer=vo.getDeveloper();
        game_info=vo.getGame_info();
        inve_cond=vo.getInve_cond();
        inve_info=vo.getInve_info();
        com_info=vo.getCom_info();
        success=vo.isSuccess();
        current_price=vo.getCurrent_price();
        goal_price=vo.getGoal_price();
    }

    public static int getImage() {
        return image;
    }

    public static String getName() {
        return name;
    }

    public static String getDeveloper() {
        return developer;
    }

    public static String getCategory() {
        return category;
    }

    public static String getGame_info() {
        return game_info;
    }

    public static String getInve_info() {
        return inve_info;
    }

    public static String getInve_cond() {
        return inve_cond;
    }

    public static String getCom_info() {
        return com_info;
    }

    public static boolean isSuccess() {
        return success;
    }

    public static long getGame_id() {
        return game_id;
    }

    public static long getCurrent_price() {
        return current_price;
    }

    public static long getGoal_price() {
        return goal_price;
    }

}
