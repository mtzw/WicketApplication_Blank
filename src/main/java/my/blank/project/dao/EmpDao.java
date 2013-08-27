package my.blank.project.dao;

import java.util.List;

import my.blank.project.config.AppConfig;
import my.blank.project.entity.Emp;

import org.seasar.doma.Dao;
import org.seasar.doma.Delete;
import org.seasar.doma.Insert;
import org.seasar.doma.Select;
import org.seasar.doma.Update;

/**
 */
@Dao(config = AppConfig.class)
public interface EmpDao {

	/**
	 * @return the Emp list
	 */
	@Select
	List<Emp> selectAll();

	/**
	 * @param id
	 * @return the Emp entity
	 */
	@Select
	Emp selectById(Long id);

	/**
	 * @param id
	 * @param versionNo
	 * @return the Emp entity
	 */
	@Select(ensureResult = true)
	Emp selectByIdAndVersion(Long id, Integer versionNo);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Insert
	int insert(Emp entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Update
	int update(Emp entity);

	/**
	 * @param entity
	 * @return affected rows
	 */
	@Delete
	int delete(Emp entity);

}