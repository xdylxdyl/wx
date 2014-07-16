package com.gemantic.commons.code.manager.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.VelocityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.gemantic.common.util.FileUtil;
import com.gemantic.commons.code.cmodel.CConfig;
import com.gemantic.commons.code.cmodel.CController;
import com.gemantic.commons.code.cmodel.CMold;
import com.gemantic.commons.code.cmodel.CProject;
import com.gemantic.commons.code.cmodel.CRequest;
import com.gemantic.commons.code.manager.CodeGenerate;
import com.gemantic.commons.code.util.CConfigUtil;

@Component("codeGenerate")
public class CodeGenerateImpl implements CodeGenerate {
	private static final Log log = LogFactory.getLog(CodeGenerateImpl.class);

	@Autowired
	private VelocityEngine velocityEngine;

	public boolean generateServiceProject(CProject project) {

		this.generateImpls(project);

		String server = this.generateServer(project);

		CConfigUtil.generateConfigs(project);
		List<String> configs = this.generateConfigs(project);

		List<String> tests = this.generateTests(project);

		return true;
	}

	public List<String> generateTests(CProject project) {
		List<String> tests = new ArrayList();
		for (CMold m : project.getMolds()) {
			log.info("generate test " + m.getImplClass());
			try {
				Map model = new HashMap();
				model.put("project", project);
				model.put("cm", m);
				String content = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "velocity/test/test.vm",
						model);
				FileUtil.writeFile(m.getTestPath(), m.getTestClass() + ".java", project.isAppend(), content);
				tests.add(content);
				log.info(m.getTestPath() + m.getTestClass() + ".java created ==============succeess ");

			} catch (VelocityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return tests;
	}

	public List<String> generateConfigs(CProject project) {

		List<CConfig> configs = project.getConfigs();
		Map model = new HashMap();
		model.put("project", project);
		List<String> contents = new ArrayList();
		for (CConfig config : configs) {
			try {

				model.put("config", config);

				String content = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, config.getPvelocity(),
						model);
				FileUtil.writeFile(config.getFilePath(), config.getName(), project.isAppend(), content);
				log.info(config.getFilePath() + " =========create============== " + config.getName());
				contents.add(content);
			} catch (VelocityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return contents;
	}

	public String generateServer(CProject project) {
		try {
			Map model = new HashMap();
			model.put("project", project);
			String content = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "velocity/server.vm", model);
			FileUtil.writeFile(project.getServerPath(), project.getServerClass() + ".java", project.isAppend(), content);
			return content;

		} catch (VelocityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<String> generateImpls(CProject project) {
		List<String> ms = new ArrayList();
		for (CMold cm : project.getMolds()) {
			log.info("generate impl " + cm.getImplClass());

			try {
				Map model = new HashMap();
				model.put("cm", cm);
				String content = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "velocity/impl.vm", model);
				FileUtil.writeFile(cm.getImplPath(), cm.getImplClass() + ".java", project.isAppend(), content);
				ms.add(content);

			} catch (VelocityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return ms;
	}

	public List<String> generateInterfaces(CProject project) {
		List<String> ms = new ArrayList();
		for (CMold cm : project.getMolds()) {
			try {
				Map model = new HashMap();
				model.put("cm", cm);

				String content = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "velocity/interface.vm",
						model);
				FileUtil.writeFile(cm.getInterfacePath(), cm.getInterfaceClass() + ".java", project.isAppend(), content);
				ms.add(content);

			} catch (VelocityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return ms;
	}

	public List<String> generateModels(CProject project) {
		List<String> ms = new ArrayList();
		for (CMold cm : project.getMolds()) {
			log.info(cm.getModelPath() + " generate model " + cm.getModelClass());
			try {
				Map model = new HashMap();
				model.put("cm", cm);
				String content = VelocityEngineUtils
						.mergeTemplateIntoString(velocityEngine, "velocity/model.vm", model);
				FileUtil.writeFile(cm.getModelPath(), cm.getModelClass() + ".java", project.isAppend(), content);
				ms.add(content);

			} catch (VelocityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return ms;
	}

	public boolean generateCoreProject(CProject project) {
		List<CMold> cms = project.getMolds();
		log.info("generate model ");
		List<String> models = this.generateModels(project);
		log.info("generate model success " + models.size());
		List<String> interfaces = this.generateInterfaces(project);
		log.info("generate interfaces success " + interfaces.size());

		return true;
	}

	public boolean generateClientProject(CProject project) {
		for (CMold m : project.getMolds()) {
			log.info("generate client " + m.getImplClass());
			try {
				Map model = new HashMap();
				model.put("project", project);
				model.put("cm", m);
				String content = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "velocity/client.vm",
						model);
				FileUtil.writeFile(m.getClientPath(), m.getClientClass() + ".java", project.isAppend(), content);
				log.info(m.getClientPath() + m.getClientClass() + ".java created ==============succeess ");

			} catch (VelocityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return true;

	}

	public boolean generateControllerProject(CProject project) {

		List<String> ms = new ArrayList();
		for (CMold cm : project.getMolds()) {
			log.info(cm.getModelPath() + " generate table " + cm.getModelClass());
			try {
				Map model = new HashMap();
				model.put("cm", cm);
				model.put("project", project);
				String content = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
						"velocity/controller/controller.vm", model);
				FileUtil.writeFile(project.getControllerPath(), cm.getModelClass() + "Controller" + ".java",
						project.isAppend(), content);
				log.info(project.getControllerPath() + " =========create============== " + cm.getModelClass()
						+ "Controller" + ".java");

				String jsonListContent = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
						"velocity/json/list.vm", model);
				FileUtil.writeFile(
						project.getJsonPath() + project.getArtifactID() + "\\" + cm.uncapitalize(cm.getModelClass())
								+ "\\json\\", cm.uncapitalize(cm.getModelClass()) + "ListJson.jsp", project.isAppend(),
						jsonListContent);
				log.info(project.getJsonPath() + project.getArtifactID() + "\\" + cm.uncapitalize(cm.getModelClass())
						+ "\\json\\" + " =========create============== " + cm.uncapitalize(cm.getModelClass())
						+ "ListJson.jsp");

				String jsonDetailContent = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
						"velocity/json/detail.vm", model);
				FileUtil.writeFile(
						project.getJsonPath() + project.getArtifactID() + "\\" + cm.uncapitalize(cm.getModelClass())
								+ "\\json\\", cm.uncapitalize(cm.getModelClass()) + "DetailJson.jsp",
						project.isAppend(), jsonDetailContent);
				log.info(project.getJsonPath() + project.getArtifactID() + "\\" + cm.uncapitalize(cm.getModelClass())
						+ "\\json\\" + " =========create============== " + cm.uncapitalize(cm.getModelClass())
						+ "DetailJson.jsp");

				String jspListContent = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
						"velocity/jsp/list.vm", model);
				FileUtil.writeFile(
						project.getJspPath() + project.getArtifactID() + "\\" + cm.uncapitalize(cm.getModelClass())
								+ "\\view\\", cm.uncapitalize(cm.getModelClass()) + "List.jsp", project.isAppend(),
						jspListContent);

				log.info(project.getJspPath() + project.getArtifactID() + "\\" + cm.uncapitalize(cm.getModelClass())
						+ "\\view\\" + " =========create============== " + cm.uncapitalize(cm.getModelClass())
						+ "List.jsp");

				String jspDetailContent = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
						"velocity/jsp/detail.vm", model);
				FileUtil.writeFile(
						project.getJspPath() + project.getArtifactID() + "\\" + cm.uncapitalize(cm.getModelClass())
								+ "\\view\\", cm.uncapitalize(cm.getModelClass()) + "Detail.jsp", project.isAppend(),
						jspDetailContent);
				log.info(project.getJspPath() + project.getArtifactID() + "\\" + cm.uncapitalize(cm.getModelClass())
						+ "\\view\\" + " =========create============== " + cm.uncapitalize(cm.getModelClass())
						+ "Detail.jsp");

				String jsListContent = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
						"velocity/js/list.vm", model);
				FileUtil.writeFile(
						project.getJsPath() + project.getArtifactID() + "\\" + cm.uncapitalize(cm.getModelClass())
								+ "\\", cm.uncapitalize(cm.getModelClass()) + "List.js", project.isAppend(),
						jsListContent);
				log.info(project.getJsPath() + project.getArtifactID() + "\\" + cm.uncapitalize(cm.getModelClass())
						+ "\\" + " =========create============== " + cm.uncapitalize(cm.getModelClass()) + "List.js");

				String jsDetailContent = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
						"velocity/js/detail.vm", model);
				FileUtil.writeFile(
						project.getJsPath() + project.getArtifactID() + "\\" + cm.uncapitalize(cm.getModelClass())
								+ "\\", cm.uncapitalize(cm.getModelClass()) + "Detail.js", project.isAppend(),
						jsDetailContent);

				log.info(project.getJsPath() + project.getArtifactID() + "\\" + cm.uncapitalize(cm.getModelClass())
						+ "\\" + " =========create============== " + cm.uncapitalize(cm.getModelClass()) + "Detail.js");

				ms.add(content);

			} catch (VelocityException e) {
				e.printStackTrace();
			}
		}
		return true;

	}

	public boolean generateDataBaseScript(CProject project) {
		List<String> ms = new ArrayList();
		StringBuffer allSB=new StringBuffer();
		for (CMold cm : project.getMolds()) {
			log.info(cm.getModelPath() + " generate table " + cm.getModelClass());
			try {
				Map model = new HashMap();
				model.put("cm", cm);
				String content = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "velocity/db/table.vm",
						model);
				FileUtil.writeFile(project.getDbresource(), cm.getTable() + ".sql", project.isAppend(), content);
				ms.add(content);
				allSB=allSB.append(content);
				

			} catch (VelocityException e) {
				e.printStackTrace();
			}
		}
		FileUtil.writeFile(project.getDbresource(), "all.sql", project.isAppend(), allSB.toString());
		
		return true;
	}

	public boolean generateResourcesSqlScript(CProject project) {
		List<String> ms = new ArrayList();
		String hostName = project.getArtifactID().replaceAll("-", ".");
		StringBuffer allSB=new StringBuffer();
		for (CMold cm : project.getMolds()) {
			log.info(cm.getModelPath() + " generate resources sql " + cm.getModelClass());
			try {
				Map model = new HashMap();
				model.put("cm", cm);
				model.put("hostName", hostName);
				String content = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
						"velocity/db/resources.vm", model);
				FileUtil.writeFile(project.getDbresource(), cm.getTable() + "_resources" + ".sql", project.isAppend(),
						content);
				ms.add(content);
				allSB=allSB.append(content);

			} catch (VelocityException e) {
				e.printStackTrace();
			}
		}
		FileUtil.writeFile(project.getDbresource(), "all-resource.sql", project.isAppend(), allSB.toString());
		return true;
	}
}
