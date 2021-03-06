<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json"%>
<%@ taglib prefix="date" uri="http://www.gemantic.com/taglibs/date"%>
<%@ taglib prefix="mobile" uri="http://www.gemantic.com/taglibs/mobile"%>
<%@ taglib prefix="string" uri="http://www.gemantic.com/taglibs/string"%>
<%@ taglib prefix="page" uri="/WEB-INF/tag/page.tld"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<jsp:useBean id="now" class="java.util.Date" />
<%
	response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0
	//response.setDateHeader("Expires", 0); //prevents caching at the proxy server
%>
<c:set var="frontVersion" value="1.01"></c:set>
