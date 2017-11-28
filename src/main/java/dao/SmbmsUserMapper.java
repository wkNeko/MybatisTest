package dao;

import entity.SmbmsUser;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 用户信息数据访问接口
 *
 * @author rxliuli
 * @date 2017/11/28 10:10
 */
public interface SmbmsUserMapper {
  /**
   * 查询全部用户信息
   *
   * @return 全部用户信息列表
   */
  List<SmbmsUser> listByAll();

  /**
   * 根据 id 查询用户
   *
   * @param id 要查询的 id
   * @return 查询到的用户
   */
  SmbmsUser findById(int id);

  /**
   * 根据性别和生日查询用户信息
   *
   * @param gender   性别编号
   * @param birthday 生日
   * @return 根据性别和生日查询到的用户信息列表
   */
  List<SmbmsUser> listByGenderAndBirthday(@Param("gender") int gender, @Param("birthday") Date birthday);

  /**
   * 使用 map 封装多参数
   *
   * @param map 封装有多个参数的 map
   * @return 查询到的用户信息列表
   */
  List<SmbmsUser> listByMap(Map<String, String> map);

  /**
   * 添加一个新的用户
   *
   * @param smbmsUser 新的用户
   * @return 受影响行数
   */
  int insert(SmbmsUser smbmsUser);

  /**
   * 根据 id 删除用户信息
   *
   * @param id 删除用户的 id
   * @return 受影响行数
   */
  int deleteById(int id);

  /**
   * 修改用户信息
   *
   * @return 要进行修改用户信息
   */
  int update(SmbmsUser smbmsUser);

}
