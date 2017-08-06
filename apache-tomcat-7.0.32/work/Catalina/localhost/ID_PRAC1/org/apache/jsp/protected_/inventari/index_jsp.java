/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.32
 * Generated at: 2012-10-28 10:34:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.protected_.inventari;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");

  if (request.getParameter("logoff") != null) {
    session.invalidate();
    response.sendRedirect("../index.jsp");
    return;
  }

      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<title>Modul d'inventari</title>\n");
      out.write("</head>\n");
      out.write("<body bgcolor=\"white\">\n");
      out.write("\n");
      out.write("<h1>MODUL D'INVENTARI</h1>\n");
      out.write("\n");

	// Separem els rols que tenim assignats a l'usuari:
	String temp = "";
   	temp = (String)session.getAttribute("rolsUsuari");
	String[] rols = temp.split("[.]");

	// Guardarem les accions assignades segons el rol de l'usuari:
	List<String> lsAccions = new ArrayList<String>();

	// Obrim el fitxer que indica les polÃ­tiques de la pÃ gina segons el rol:
	FileInputStream fs = new FileInputStream(System.getProperty("catalina.home") + "/conf/rols_accions.txt");
        DataInputStream in = new DataInputStream(fs);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

	String linia;
	while ((linia = br.readLine()) != null)
	{
		// Separem els camps de la lÃ­nia:
		String[] temp2 = linia.split(":");

		// Primer comprovem que la lÃ­nia marqui el mÃ²dul adequat, en cas
		// contrari no cal continuar tractant la lÃ­nia:
		if (temp2[0].equals("inventari"))
		{
			// Comprovem si al segon camp, els rols, existeix algun
			// dels rols de l'usuari en qÃ¼estiÃ³:
			String[] temp3 = temp2[1].split("[.]");

			for (int i=0; i<temp3.length; i++)
			{
				for (int j=0; j<rols.length; j++)
				{
					// Si tÃ© algun dels rols, mostrem l'operaciÃ³:
					if (temp3[i].equals(rols[j]))
					{ 
						// NomÃ©s l'afegirem si no existeix a la llista:
						Iterator it = lsAccions.iterator();
						String sActual = "";
						boolean bTrobat = false;
						
						while (it.hasNext() && (!(bTrobat))) 
						{
							sActual = (String)it.next();
							if (sActual.equals(temp2[2])) 
							{
								bTrobat = true;
							}
						}

						if (!(bTrobat))
						{
							lsAccions.add(temp2[2]);
						}
					}
				}
			}
		}
	}

	// Tanquem el fitxer:
	in.close();

      out.write("\n");
      out.write("<b><u>Accions autoritzades:</u></b><br>\n");

	// Mostrem les accions disponibles al mÃ²dul segons els rols assignats:
	Iterator it = lsAccions.iterator();

	while(it.hasNext())
	{

      out.write('\n');
      out.write('	');
      out.write('	');
      out.print((String)it.next() );
      out.write("<br>\n");

	}

      out.write("\n");
      out.write("\n");
      out.write("<br><br>\n");
      out.write("<a href='");
      out.print( response.encodeURL("../index.jsp") );
      out.write("'>Menu principal</a><br>\n");
      out.write("<a href='");
      out.print( response.encodeURL("index.jsp?logoff=true") );
      out.write("'>Tancar sessio</a>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
