package util;

/**
 * @author rxliuli
 * @date 2017/11/21 16:54
 */
public class StringUtil {
  /**
   * 转换为下划线
   *
   * @param camelCaseName 驼峰命名的字符串
   * @return 转换得到的下划线命名的字符串
   */
  public static String underscoreName(String camelCaseName) {
    StringBuilder result = new StringBuilder();
    if (camelCaseName != null && camelCaseName.length() > 0) {
      result.append(camelCaseName.substring(0, 1).toLowerCase());
      for (int i = 1; i < camelCaseName.length(); i++) {
        char ch = camelCaseName.charAt(i);
        if (Character.isUpperCase(ch)) {
          result.append("_");
          result.append(Character.toLowerCase(ch));
        } else {
          result.append(ch);
        }
      }
    }
    return result.toString();
  }

  /**
   * 转换为驼峰
   *
   * @param underscoreName 下划线命名的字符串
   * @return 转换得到的驼峰命名的字符串
   */
  public static String camelCaseName(String underscoreName) {
    StringBuilder result = new StringBuilder();
    if (underscoreName != null && underscoreName.length() > 0) {
      boolean flag = false;
      for (int i = 0; i < underscoreName.length(); i++) {
        char ch = underscoreName.charAt(i);
        if ("_".charAt(0) == ch) {
          flag = true;
        } else {
          if (flag) {
            result.append(Character.toUpperCase(ch));
            flag = false;
          } else {
            result.append(ch);
          }
        }
      }
    }
    return result.toString();
  }
}
