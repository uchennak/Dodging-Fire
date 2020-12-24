package rect.dodgingfire.dodgingfire.classes.gamemain;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.WindowManager;

public class GameMainActivity extends Activity {
    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 450;
    public static GameView sGame;
    public static AssetManager assets;

    private static SharedPreferences easyPrefs, hardPrefs, superHardPrefs, superDuperHardPrefs;
    private static final String easyHighScoreKey = "easyHighScoreKey";
    private static final String hardHighScoreKey = "hardHighScoreKey";
    private static final String superHardHighScoreKey = "superHardHighScoreKey";
    private static final String superDuperHardHighScoreKey = "superDuperHardHighScoreKey";
    private static int easyHighScore, hardHighScore, superHardHighScore, superDuperHardHighScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        easyPrefs = getPreferences(Activity.MODE_PRIVATE); // New line!
        easyHighScore = retrieveEasyHighScore();

        hardPrefs = getPreferences(Activity.MODE_PRIVATE);
        hardHighScore = retrieveHardHighScore();

        superHardPrefs = getPreferences(Activity.MODE_PRIVATE);
        superHardHighScore = retrieveSuperHardHighScore();

        superDuperHardPrefs = getPreferences(Activity.MODE_PRIVATE);
        superHardHighScore = retrieveSuperDuperHardHighScore();


        assets = getAssets();
        sGame = new GameView(this, GAME_WIDTH, GAME_HEIGHT);
        setContentView(sGame);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
    }

    public static void setEasyHighScore(int highScore) {
        GameMainActivity.easyHighScore = highScore;
        Editor editor = easyPrefs.edit();
        editor.putInt(easyHighScoreKey, highScore);
        editor.commit();
    }

    public static void setHardHighScore(int highScore) {
        GameMainActivity.hardHighScore = highScore;
        Editor editor = hardPrefs.edit();
        editor.putInt(hardHighScoreKey, highScore);
        editor.commit();
    }

    public static void setSuperHardHighScore(int highScore) {
        GameMainActivity.superHardHighScore = highScore;
        Editor editor = superHardPrefs.edit();
        editor.putInt(superHardHighScoreKey, highScore);
        editor.commit();
    }

    public static void setSuperDuperHardHighScore(int highScore) {
        GameMainActivity.superDuperHardHighScore = highScore;
        Editor editor = superDuperHardPrefs.edit();
        editor.putInt(superDuperHardHighScoreKey, highScore);
        editor.commit();
    }

    private int retrieveEasyHighScore() {
        return easyPrefs.getInt(easyHighScoreKey, 0);
    }
    private int retrieveHardHighScore() {
        return hardPrefs.getInt(hardHighScoreKey, 0);
    }
    private int retrieveSuperHardHighScore() {return superHardPrefs.getInt(superHardHighScoreKey, 0);}
    private int retrieveSuperDuperHardHighScore() {return superDuperHardPrefs.getInt(superDuperHardHighScoreKey, 0);}

    public static int getEasyHighScore() {
        return easyHighScore;
    }
    public static int getHardHighScore(){return hardHighScore;    }
    public static int getSuperHardHighScore(){return superHardHighScore;}
    public static int getSuperDuperHardHighScore(){return superDuperHardHighScore;}
}
