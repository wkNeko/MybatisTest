package dao;

import entity.SmbmsUserExtension;

import java.util.List;

/**
 * 用户信息扩展类
 *
 * @author rxliuli
 * @date 2017/11/28 14:24
 */
public interface SmbmsUserExtensionMapper {
  /**
   * 查询所有的用户信息
   *
   * @return 所有的用户信息
   */
  List<SmbmsUserExtension> listByAll();

  /**
   * 根据 id 查询用户扩展信息
   *
   * @return 查询到的用户扩展信息
   */
  List<SmbmsUserExtension> findById(int id);

}
