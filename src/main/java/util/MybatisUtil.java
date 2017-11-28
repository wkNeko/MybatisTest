package util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.function.Function;
import java.util.logging.Logger;

/**
 * mybatis 工具类
 *
 * @author rxliuli
 * @date 2017-11-23 08:57:00
 */
public class MybatisUtil {
  /**
   * 初始化 SqlSessionFactory 实例（单例模式）
   */
  private static SqlSessionFactory factory;
  private static ThreadLocal<SqlSession> tl = new ThreadLocal<>();
  private static Logger logger = Logger.getLogger(MybatisUtil.class.getName());

  static {
    InputStream inputStream = null;
    try {
      inputStream = Resources.getResourceAsStream("mybatis-config.xml");
    } catch (IOException e) {
      logger.info(e.getMessage());
    }
    factory = new SqlSessionFactoryBuilder().build(inputStream);
  }

  private MybatisUtil() {
  }

  /**
   * 获取操作数据库的实例
   *
   * @return mybatis 用于操作数据库的实例
   */
  public static SqlSession getSession() {
    SqlSession session = tl.get();
    if (session == null) {
      //获取 session 时开启手动提交事务
      session = factory.openSession(false);
      tl.set(session);
    }
    return session;
  }

  /**
   * 提交/关闭操作数据库的对象
   */
  private static void closeSession() {
    SqlSession session = tl.get();
    if (session != null) {
      session.commit();
      session.close();
      tl.remove();
    }
  }

  /**
   * 回滚操作数据库的对象
   */
  private static void rollbackSession() {
    SqlSession session = tl.get();
    if (session != null) {
      session.rollback();
      session.close();
      tl.remove();
    }
  }

  /**
   * 借贷模式
   * 自动获得和关闭 SqlSession 实例，会进行简单的异常处理
   * 如果发生了异常则必然返回 null
   *
   * @param f   要执行的一些操作
   * @param <R> 执行操作最终返回的类型
   * @return 如果正常执行返回的值
   */
  public static <R> R using(Function<SqlSession, R> f) {
    SqlSession sqlSession = getSession();
    try {
      return f.apply(sqlSession);
    } catch (Exception e) {
      logger.info(e.getMessage());
      rollbackSession();
      return null;
    } finally {
      closeSession();
    }
  }

  /**
   * 借贷模式
   * 自动开启和关闭 mybatis 映射接口实例，并且会获得 mybatis 映射接口，会进行简单的异常处理
   * 如果发生了异常则必然返回 null
   *
   * @param type 映射接口类型（因为 java 是伪泛型，所以必须类型参数）
   * @param f    要执行的一些增删改查操作
   * @param <T>  获取到的 mybatis 映射接口
   * @param <R>  执行完所有操作之后返回的类型
   * @return 执行完所有操作之后的返回值
   */
  public static <T, R> R using(Class<T> type, Function<T, R> f) {
    SqlSession sqlSession = getSession();
    try {
      return f.apply(sqlSession.getMapper(type));
    } catch (Exception e) {
      logger.info(e.getMessage());
      rollbackSession();
      return null;
    } finally {
      closeSession();
    }
  }

  /**
   * 借贷模式
   * 自动获得和关闭 SqlSession 实例，会进行简单的异常处理
   * 如果发生异常则返回 Optional.empty()
   *
   * @param f   要执行的一些操作
   * @param <R> 执行操作最终返回的类型
   * @return 如果正常执行返回的值
   */
  public static <R> Optional<R> usingOptional(Function<SqlSession, R> f) {
    SqlSession sqlSession = getSession();
    try {
      return Optional.of(f.apply(sqlSession));
    } catch (Exception e) {
      logger.info(e.getMessage());
      rollbackSession();
      return Optional.empty();
    } finally {
      closeSession();
    }
  }

  /**
   * 借贷模式
   * 自动开启和关闭 mybatis 映射接口实例，并且会获得 mybatis 映射接口
   * 如果发生异常则返回 Optional.empty()
   *
   * @param type 映射接口类型（因为 java 是伪泛型，所以必须类型参数）
   * @param f    要执行的一些增删改查操作
   * @param <T>  获取到的 mybatis 映射接口
   * @param <R>  执行完所有操作之后返回的类型
   * @return 执行完所有操作之后的返回值
   */
  public static <T, R> Optional<R> usingOptional(Class<T> type, Function<T, R> f) {
    SqlSession sqlSession = getSession();
    try {
      return Optional.of(f.apply(sqlSession.getMapper(type)));
    } catch (Exception e) {
      logger.info(e.getMessage());
      rollbackSession();
      return Optional.empty();
    } finally {
      closeSession();
    }
  }

}
