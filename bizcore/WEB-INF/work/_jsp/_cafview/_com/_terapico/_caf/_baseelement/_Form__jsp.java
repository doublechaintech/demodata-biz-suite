/*
 * JSP generated by Resin-resin-3.1.15 (built Mon, 13 Oct 2014 03:54:20 PDT)
 */

package _jsp._cafview._com._terapico._caf._baseelement;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;

public class _Form__jsp extends com.caucho.jsp.JavaPage
{
  private static final java.util.HashMap<String,java.lang.reflect.Method> _jsp_functionMap = new java.util.HashMap<String,java.lang.reflect.Method>();
  private boolean _caucho_isDead;
  
  public void
  _jspService(javax.servlet.http.HttpServletRequest request,
              javax.servlet.http.HttpServletResponse response)
    throws java.io.IOException, javax.servlet.ServletException
  {
    javax.servlet.http.HttpSession session = request.getSession(true);
    com.caucho.server.webapp.WebApp _jsp_application = _caucho_getApplication();
    javax.servlet.ServletContext application = _jsp_application;
    com.caucho.jsp.PageContextImpl pageContext = _jsp_application.getJspApplicationContext().allocatePageContext(this, _jsp_application, request, response, null, session, 8192, true, false);
    javax.servlet.jsp.PageContext _jsp_parentContext = pageContext;
    javax.servlet.jsp.JspWriter out = pageContext.getOut();
    final javax.el.ELContext _jsp_env = pageContext.getELContext();
    javax.servlet.ServletConfig config = getServletConfig();
    javax.servlet.Servlet page = this;
    response.setContentType("text/plain; charset=utf-8");
    request.setCharacterEncoding("UTF-8");
    com.caucho.jstl.rt.SetLocaleTag _jsp_SetLocaleTag_0 = null;
    com.caucho.jsp.IteratorLoopSupportTag _jsp_loop_0 = null;
    try {
      out.write(_jsp_string0, 0, _jsp_string0.length);
      if (_jsp_SetLocaleTag_0 == null) {
        _jsp_SetLocaleTag_0 = new com.caucho.jstl.rt.SetLocaleTag();
        _jsp_SetLocaleTag_0.setPageContext(pageContext);
        _jsp_SetLocaleTag_0.setParent((javax.servlet.jsp.tagext.Tag) null);
        _jsp_SetLocaleTag_0.setValue("zh_CN");
      }

      _jsp_SetLocaleTag_0.doStartTag();
      out.write(_jsp_string1, 0, _jsp_string1.length);
      _caucho_expr_0.print(out, _jsp_env, false);
      out.write(_jsp_string2, 0, _jsp_string2.length);
      if (_jsp_loop_0 == null)
        _jsp_loop_0 = new com.caucho.jsp.IteratorLoopSupportTag();
      java.lang.Object _jsp_items_5 = _caucho_expr_1.evalObject(_jsp_env);
      java.util.Iterator _jsp_iter_5 = com.caucho.jstl.rt.CoreForEachTag.getIterator(_jsp_items_5);
      _jsp_loop_0.init(0, Integer.MAX_VALUE, 1);
      Object _jsp_oldVar_5 = pageContext.getAttribute("action");
      while (_jsp_iter_5.hasNext()) {
        Object _jsp_i_5 = _jsp_iter_5.next();
        pageContext.setAttribute("action", _jsp_i_5);
        _jsp_loop_0.setCurrent(_jsp_i_5, _jsp_iter_5.hasNext());
        out.write(_jsp_string3, 0, _jsp_string3.length);
        _caucho_expr_2.print(out, _jsp_env, false);
        out.write(_jsp_string4, 0, _jsp_string4.length);
      }
      pageContext.pageSetOrRemove("action", _jsp_oldVar_5);
      out.write(_jsp_string5, 0, _jsp_string5.length);
      _caucho_expr_3.print(out, _jsp_env, false);
      out.write(_jsp_string6, 0, _jsp_string6.length);
      _caucho_expr_4.print(out, _jsp_env, false);
      out.write(_jsp_string7, 0, _jsp_string7.length);
      if (_jsp_loop_0 == null)
        _jsp_loop_0 = new com.caucho.jsp.IteratorLoopSupportTag();
      java.lang.Object _jsp_items_6 = _caucho_expr_5.evalObject(_jsp_env);
      java.util.Iterator _jsp_iter_6 = com.caucho.jstl.rt.CoreForEachTag.getIterator(_jsp_items_6);
      _jsp_loop_0.init(0, Integer.MAX_VALUE, 1);
      Object _jsp_status_6 = pageContext.putAttribute("status", _jsp_loop_0);
      Object _jsp_oldVar_6 = pageContext.getAttribute("field");
      while (_jsp_iter_6.hasNext()) {
        Object _jsp_i_6 = _jsp_iter_6.next();
        pageContext.setAttribute("field", _jsp_i_6);
        _jsp_loop_0.setCurrent(_jsp_i_6, _jsp_iter_6.hasNext());
        out.write(_jsp_string8, 0, _jsp_string8.length);
        _caucho_expr_6.print(out, _jsp_env, false);
        out.write(_jsp_string9, 0, _jsp_string9.length);
        _caucho_expr_3.print(out, _jsp_env, false);
        out.write(_jsp_string10, 0, _jsp_string10.length);
        _caucho_expr_7.print(out, _jsp_env, false);
        out.write(_jsp_string11, 0, _jsp_string11.length);
        _caucho_expr_3.print(out, _jsp_env, false);
        out.write(_jsp_string12, 0, _jsp_string12.length);
      }
      pageContext.pageSetOrRemove("field", _jsp_oldVar_6);
      pageContext.removeAttribute("status");
      out.write(_jsp_string13, 0, _jsp_string13.length);
      if (_jsp_loop_0 == null)
        _jsp_loop_0 = new com.caucho.jsp.IteratorLoopSupportTag();
      java.lang.Object _jsp_items_7 = _caucho_expr_1.evalObject(_jsp_env);
      java.util.Iterator _jsp_iter_7 = com.caucho.jstl.rt.CoreForEachTag.getIterator(_jsp_items_7);
      _jsp_loop_0.init(0, Integer.MAX_VALUE, 1);
      Object _jsp_oldVar_7 = pageContext.getAttribute("action");
      while (_jsp_iter_7.hasNext()) {
        Object _jsp_i_7 = _jsp_iter_7.next();
        pageContext.setAttribute("action", _jsp_i_7);
        _jsp_loop_0.setCurrent(_jsp_i_7, _jsp_iter_7.hasNext());
        out.write(_jsp_string14, 0, _jsp_string14.length);
        _caucho_expr_8.print(out, _jsp_env, false);
        out.write(_jsp_string15, 0, _jsp_string15.length);
        _caucho_expr_9.print(out, _jsp_env, false);
        out.write(_jsp_string16, 0, _jsp_string16.length);
      }
      pageContext.pageSetOrRemove("action", _jsp_oldVar_7);
      out.write(_jsp_string17, 0, _jsp_string17.length);
      _caucho_expr_10.print(out, _jsp_env, false);
      out.write(_jsp_string18, 0, _jsp_string18.length);
      _caucho_expr_11.print(out, _jsp_env, false);
      out.write(_jsp_string19, 0, _jsp_string19.length);
    } catch (java.lang.Throwable _jsp_e) {
      pageContext.handlePageException(_jsp_e);
    } finally {
      if (_jsp_SetLocaleTag_0 != null)
        _jsp_SetLocaleTag_0.release();
      _jsp_application.getJspApplicationContext().freePageContext(pageContext);
    }
  }

  private java.util.ArrayList _caucho_depends = new java.util.ArrayList();

  public java.util.ArrayList _caucho_getDependList()
  {
    return _caucho_depends;
  }

  public void _caucho_addDepend(com.caucho.vfs.PersistentDependency depend)
  {
    super._caucho_addDepend(depend);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
  }

  public boolean _caucho_isModified()
  {
    if (_caucho_isDead)
      return true;
    if (com.caucho.server.util.CauchoSystem.getVersionId() != 3802963613949670813L)
      return true;
    for (int i = _caucho_depends.size() - 1; i >= 0; i--) {
      com.caucho.vfs.Dependency depend;
      depend = (com.caucho.vfs.Dependency) _caucho_depends.get(i);
      if (depend.isModified())
        return true;
    }
    return false;
  }

  public long _caucho_lastModified()
  {
    return 0;
  }

  public java.util.HashMap<String,java.lang.reflect.Method> _caucho_getFunctionMap()
  {
    return _jsp_functionMap;
  }

  public void init(ServletConfig config)
    throws ServletException
  {
    com.caucho.server.webapp.WebApp webApp
      = (com.caucho.server.webapp.WebApp) config.getServletContext();
    super.init(config);
    com.caucho.jsp.TaglibManager manager = webApp.getJspApplicationContext().getTaglibManager();
    manager.addTaglibFunctions(_jsp_functionMap, "c", "http://java.sun.com/jsp/jstl/core");
    manager.addTaglibFunctions(_jsp_functionMap, "fmt", "http://java.sun.com/jsp/jstl/fmt");
    manager.addTaglibFunctions(_jsp_functionMap, "fn", "http://java.sun.com/jsp/jstl/functions");
    com.caucho.jsp.PageContextImpl pageContext = new com.caucho.jsp.PageContextImpl(webApp, this);
    _caucho_expr_0 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${baseURL}");
    _caucho_expr_1 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${result.actions}");
    _caucho_expr_2 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${action.name}");
    _caucho_expr_3 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${field.name}");
    _caucho_expr_4 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${field.type.name}");
    _caucho_expr_5 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${result.fields}");
    _caucho_expr_6 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${status.index}");
    _caucho_expr_7 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${field.defaultValue}");
    _caucho_expr_8 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${action.title}");
    _caucho_expr_9 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${action.name }");
    _caucho_expr_10 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${userContext.localeMap['@qr_code']}");
    _caucho_expr_11 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${userContext.localeMap['@qr_scan_to_continue']}");
  }

  public void destroy()
  {
      _caucho_isDead = true;
      super.destroy();
  }

  public void init(com.caucho.vfs.Path appDir)
    throws javax.servlet.ServletException
  {
    com.caucho.vfs.Path resinHome = com.caucho.server.util.CauchoSystem.getResinHome();
    com.caucho.vfs.MergePath mergePath = new com.caucho.vfs.MergePath();
    mergePath.addMergePath(appDir);
    mergePath.addMergePath(resinHome);
    com.caucho.loader.DynamicClassLoader loader;
    loader = (com.caucho.loader.DynamicClassLoader) getClass().getClassLoader();
    String resourcePath = loader.getResourcePathSpecificFirst();
    mergePath.addClassPath(resourcePath);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("cafview/com/terapico/caf/baseelement/Form.jsp"), -4278638719224666026L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    depend = new com.caucho.vfs.Depend(mergePath.lookup("jar:file:/opt/resin-3.1.12/lib/resin.jar!/com/caucho/jstl/fmt.tld"), 8594578285720415164L, false);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, depend);
    com.caucho.jsp.JavaPage.addDepend(_caucho_depends, new com.caucho.make.ClassDependency(com.caucho.jstl.rt.SetLocaleTag.class, -5807438068488217094L));
  }

  static {
    try {
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }
  private static com.caucho.el.Expr _caucho_expr_0;
  private static com.caucho.el.Expr _caucho_expr_1;
  private static com.caucho.el.Expr _caucho_expr_2;
  private static com.caucho.el.Expr _caucho_expr_3;
  private static com.caucho.el.Expr _caucho_expr_4;
  private static com.caucho.el.Expr _caucho_expr_5;
  private static com.caucho.el.Expr _caucho_expr_6;
  private static com.caucho.el.Expr _caucho_expr_7;
  private static com.caucho.el.Expr _caucho_expr_8;
  private static com.caucho.el.Expr _caucho_expr_9;
  private static com.caucho.el.Expr _caucho_expr_10;
  private static com.caucho.el.Expr _caucho_expr_11;

  private final static char []_jsp_string7;
  private final static char []_jsp_string2;
  private final static char []_jsp_string12;
  private final static char []_jsp_string16;
  private final static char []_jsp_string9;
  private final static char []_jsp_string15;
  private final static char []_jsp_string19;
  private final static char []_jsp_string5;
  private final static char []_jsp_string3;
  private final static char []_jsp_string4;
  private final static char []_jsp_string10;
  private final static char []_jsp_string14;
  private final static char []_jsp_string1;
  private final static char []_jsp_string11;
  private final static char []_jsp_string6;
  private final static char []_jsp_string0;
  private final static char []_jsp_string18;
  private final static char []_jsp_string13;
  private final static char []_jsp_string17;
  private final static char []_jsp_string8;
  static {
    _jsp_string7 = "\" autocomplete=\"off\" -->\n    <form class=\"mainform\"  >\n		".toCharArray();
    _jsp_string2 = "/\" /> \n    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->\n    <meta name=\"description\" content=\"\">\n    <meta name=\"author\" content=\"\">\n   \n    <title>  Spring Bean Manage Console</title>\n\n    <!-- Bootstrap core CSS -->\n    <link href=\"./bootstrap/bootstrap.min.css\" rel=\"stylesheet\">\n\n    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->\n    <link href=\"./bootstrap/ie10-viewport-bug-workaround.css\" rel=\"stylesheet\">\n 	<link href=\"./bootstrap/jquery-ui.css\" rel=\"stylesheet\">\n    <!-- Custom styles for this template -->\n    <link href=\"./bootstrap/dashboard.css\" rel=\"stylesheet\">\n   \n   \n\n    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->\n    <!--[if lt IE 9]><script src=\"../../assets/js/ie8-responsive-file-warning.js\"></script><![endif]-->\n    <script src=\"./bootstrap/ie-emulation-modes-warning.js\"></script>\n\n    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->\n    <!--[if lt IE 9]>\n      <script src=\"https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js\"></script>\n      <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\n    <![endif]-->\n <style type=\"text/css\">* {\n text-shadow: transparent 0px 0px 0px, rgba(0,0,0,0.68) 0px 0px 0px !important; \n}\n\n</style>\n\n\n</head>\n\n  <body >\n\n\n    <div class=\"container-fluid\">\n      <div class=\"row\">\n      \n      \n\n\n<style>\n.form {\n	font-size: 20px;\n}\n#parameters {\n	display: none;\n	border: 1px solid grey; \n	width: 400px;\n	height: 400px;\n	overfollow:auto;\n	padding-left: 20px;\n	padding-right: 20px;\n	background: white;\n#	opacity: 0.5;\n	background-color:rgba(255,255,255,0.8);\n}\n</style>\n\n<div class=\"form\">\n\n\n\n\n\n</div>\n\n\n<div class=\"panel panel-default\">\n  <div class=\"panel-heading\">\n    <h3 class=\"panel-title\">\n    \n    ".toCharArray();
    _jsp_string12 = "\" type=\"text\" append=\"true\" />\n			\n		</div>\n		".toCharArray();
    _jsp_string16 = "\"  />\n			 \n		</div>\n		".toCharArray();
    _jsp_string9 = "\" class=\"form-control input-sm\" \n			placeHolder=\"".toCharArray();
    _jsp_string15 = "\" action=\"".toCharArray();
    _jsp_string19 = "\";\n	\n</script>\n    <script src=\"./scripts/common.js\" type=\"text/javascript\"></script>   \n \n    \n\n<script type=\"text/javascript\">\n	$(function() {\n		var action=\"\";\n		\n		$(\".submit\").click(function(){\n			action=$(this).attr(\"action\");\n		});\n		/*\n		$(\":input\").dblclick(function(){		\n			//alert(\"sdfsdf\");	\n			//$( \".parameters\" ).toggle();\n			\n			var pos = $(this).position();\n\n		    // .outerWidth() takes into account border and padding.\n		   \n		    //show the menu directly over the placeholder\n		    \n		    if(!$(\"#parameters\").is(\":visible\")){\n		    	// var width = $(this).outerWidth();\n				var parameterType=$(this).attr(\"parameterType\");\n				var parameterName=$(this).attr(\"parameterName\");\n		    \n		    	fillResult(\"suggestParameter/\"+parameterType+\"/\"+parameterName+\"/\",\"#parameters\");\n		    }\n		    \n		    $(\"#parameters\").css({\n		        position: \"absolute\",\n		        top: pos.top + pos.height+\"px\",\n		        left: (pos.left) + \"px\",\n				    overflow: \"scroll\"\n		    }).toggle();\n			\n		\n		});\n		\n		$( window ).resize(function() {\n			 // $( \"#log\" ).append( \"<div>Handler for .resize() called.</div>\" );\n			var currentTargetId= $(\"#parameters\").attr(\"targetInputId\");\n			console.log(currentTargetId)	;\n			var pos = $(\"#\"+currentTargetId).position();\n			 $(\"#parameters\").css({\n			        position: \"absolute\",\n			        top: pos.top + pos.height+\"px\",\n			        left: (pos.left) + \"px\",\n				      overflow: \"scroll\"\n			   });\n		});\n	*/\n		\n		var cache = {};\n\n		$(\".mainform\").submit(function(event) {\n			\n			if(action==\"\"){\n				return;\n			}\n			console.log(\"code get here!\");\n			$(this).find(\":input\").attr(\"disabled\", true);\n			event.preventDefault();\n			var parameters = \"\";\n			var valid=true;\n			$(\".mainform :input\").each(function() {\n				//console.log(\"-------------\"+$(this).val());\n				if ($(this).val()==\"\"){\n					console.log(\"--eee-----------\"+$(this).val());\n					$(this).parent().addClass(\"has-error\");\n					//$(this).addClass(\"input-danger\");\n					valid=false;\n				}\n				if ($(this).attr(\"append\") == \"true\") {\n					parameters += encodeURIComponent($(this).val()) + \"/\";\n				}				\n			});\n			if(!valid){\n				$(this).find(\":input\").attr(\"disabled\", false);\n				return true;\n			}\n			var reqURI =  action + \"/\" + parameters;\n			fillResult(reqURI,\"#result\");\n			$(this).find(\":input\").attr(\"disabled\", false);\n			//$(\".mainform\").submit();\n			//return true;\n			//$(\".mainform:not(.filter) :input:visible:enabled:first\").val(\"\");\n		});\n		//var currentTargetId=\"\";\n		 $( \"form input:text\" ).focus(function() {\n			 \n			 //currentTargetId=$(this).attr(\"id\");\n			 //console.log(\"form input:text clicked: \"+currentTargetId)	;\n			 $(\"#parameters\").attr(\"targetInputId\",$(this).attr(\"id\"));\n			 \n		});\n		\n		//\n\n\n	});\n		\n	$(document).ready(function() {\n		 $(\".mainform:not(.filter) :input:visible:enabled:first\").focus();\n		 //$(\".mainform\").elements().first().focus();\n	\n	});	\n		\n</script>\n\n\n</body></html>\n\n\n\n\n\n".toCharArray();
    _jsp_string5 = "\n    \n    </h3>\n  </div>\n  \n  <div class=\"panel-body\">\n    <!-- parameterName=\"".toCharArray();
    _jsp_string3 = "\n			".toCharArray();
    _jsp_string4 = "\n		".toCharArray();
    _jsp_string10 = "\" value=\"".toCharArray();
    _jsp_string14 = "\n		<div class=\"col-sm-2\">\n			<input type=\"submit\" class=\"btn btn-primary btn-sm action submit\" value=\"".toCharArray();
    _jsp_string1 = "\n\n\n<!DOCTYPE html>\n<!-- saved from url=(0043)http://getbootstrap.com/examples/dashboard/ -->\n<html lang=\"en\" slick-uniqueid=\"3\"><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n    <base href=\"".toCharArray();
    _jsp_string11 = "\"\n			title=\"".toCharArray();
    _jsp_string6 = "\" parameterType=\"".toCharArray();
    _jsp_string0 = "\n\n\n\n\n".toCharArray();
    _jsp_string18 = "\";\n 	var scanQRTips = \"".toCharArray();
    _jsp_string13 = "\n		\n		".toCharArray();
    _jsp_string17 = "\n		\n	</form>\n	<br/>\n    <hr/>\n    <div id=\"result\" >  </div>\n  </div>\n</div>\n\n\n<div id=\"parameters\" > Parameters </div>\n\n\n      \n      \n     \n        </div><!--  <div class=\"col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main\"> -->\n        </div><!-- <div class=\"row\"> -->\n        \n        \n      \n<div id=\"footer\">\n  <div class=\"col-xs-12 navbar-inverse navbar-fixed-bottom\">\n  <div class=\"row\" id=\"bottomNav\">\n    <div class=\"col-xs-3 text-center\">\n    	<a href=\"./secUserManager/home/\"><i class=\"glyphicon glyphicon-home\"></i><br/>\u4e3b\u9875</a>\n    </div>\n    <div class=\"col-xs-3 text-center\">\n    	<a href=\"./secUserManager/login/SU000002/123456/\"><i class=\"glyphicon glyphicon-envelope\"></i><br>\u6d88\u606f</a>\n    </div>\n    <div class=\"col-xs-3 text-center\">\n    	<a href=\"./secUserManager/login/SU000002/123456/\"><i class=\"glyphicon glyphicon-envelope\"></i><br>\u6d88\u606f</a>\n    </div>\n    <div class=\"col-xs-3 text-center\">\n    	<a href=\"./navi/index/secUserManager/#secUserManager/loadSecUserDetail/SU000002/\">\n    	<i class=\"glyphicon glyphicon-user\"></i><br>\u6211</a>\n    </div>\n  </div>\n  </div>\n</div><!-- /.footer -->\n        \n    <!-- Bootstrap core JavaScript\n    ================================================== -->\n    <!-- Placed at the end of the document so the pages load faster -->\n    <script src=\"./bootstrap/jquery.min.js\"></script>\n    <script src=\"./bootstrap/jquery-ui.min.js\"></script>\n    \n    <script>window.jQuery || document.write('<script src=\"../../assets/js/vendor/jquery.min.js\"><\\/script>')</script>\n    <script src=\"./bootstrap/bootstrap.min.js\"></script>\n    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->\n    <script src=\"./bootstrap/holder.min.js\"></script>\n    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->\n    <script src=\"./bootstrap/ie10-viewport-bug-workaround.js\"></script>\n    <script src=\"./scripts/qrcode.js\" type=\"text/javascript\"></script>\n      <script>\n\n 	var qrLocaleLabel = \"".toCharArray();
    _jsp_string8 = "\n		<div class=\"col-sm-12\">\n			<input id=\"fl".toCharArray();
  }
}
