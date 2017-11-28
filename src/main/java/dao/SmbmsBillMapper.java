package dao;

import entity.SmbmsBill;

import java.util.List;

/**
 * 供货商应用列表
 *
 * @author rxliuli
 * @date 2017/11/28 16:42
 */
public interface SmbmsBillMapper {
  /**
   * 查询全部供货商
   *
   * @return 全部供货商列表
   */
  List<SmbmsBill> listByAll();
}
