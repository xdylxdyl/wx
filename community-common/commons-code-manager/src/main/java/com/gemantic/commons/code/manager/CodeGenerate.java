package com.gemantic.commons.code.manager;

import java.util.List;

import org.osoa.sca.annotations.Remotable;

import com.gemantic.commons.code.cmodel.CMold;
import com.gemantic.commons.code.cmodel.CProject;

@Remotable
public interface CodeGenerate {

	/**
	 * 批量创建Model
	 * 
	 * @param cms
	 * @return
	 */
	List<String> generateModels(CProject project);

	/**
	 * 批量创建接口
	 * 
	 * @param cms
	 * @return
	 */
	List<String> generateInterfaces(CProject project);

	/**
	 * 批量创建实现
	 * 
	 * @param cms
	 * @return
	 */
	List<String> generateImpls(CProject project);

	/**
	 * 生成Core的Project,包括Model和Interface的创建
	 * 
	 * @param project
	 * @return
	 */

	boolean generateCoreProject(CProject project);

	/**
	 * 生成Service的Project,包括Server,ServiceImpl,Test,各种Config的创建
	 * 
	 * @param project
	 * @return
	 */
	boolean generateServiceProject(CProject project);

	/**
	 * 启动类Server的创建
	 * 
	 * @param cms
	 * @return
	 */
	String generateServer(CProject project);

	/**
	 * 创建配置文件
	 * 
	 * @param project
	 * @return
	 */
	List<String> generateConfigs(CProject project);

	/**
	 * 创建Client
	 * 
	 * @param project
	 * @return
	 */

	boolean generateClientProject(CProject project);

	/**
	 * 创建Controller
	 * 
	 * @param project
	 * @return
	 */

	boolean generateControllerProject(CProject project);

	/**
	 * 创建Test
	 * 
	 * @param project
	 * @return
	 */

	List<String> generateTests(CProject project);

	/**
	 * 生成数据库表的脚本
	 * 
	 * @param project
	 * @return
	 */
	boolean generateDataBaseScript(CProject project);
	
	/**
	 * 生成数据库表的脚本(插入resources表的数据)
	 * 
	 * @param project
	 * @return
	 */
	boolean generateResourcesSqlScript(CProject project);

}
