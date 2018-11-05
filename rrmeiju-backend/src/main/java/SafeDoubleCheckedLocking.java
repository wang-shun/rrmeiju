import com.caizhukui.rrmeiju.model.Subtitle;

/**
 * 基于双重检查锁定实现的单例
 * 
 * @author caizhukui
 * @date 2018年1月24日
 */
public class SafeDoubleCheckedLocking {
    
    private volatile static Subtitle subtitle;
    
    /**
     * 
     * 
     * @return Subtitle
     * @author caizhukui
     * @date 2018年1月24日
     */
    public static Subtitle getInstance() {
        if (subtitle == null) {
            synchronized (SafeDoubleCheckedLocking.class) {
                if (subtitle == null) {
                    subtitle = new Subtitle();
                }
            }
        }
        return subtitle;
    }

}
