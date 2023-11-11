//package spring;
//
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import org.springframework.web.filter.HiddenHttpMethodFilter;
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//import org.springframework.web.servlet.DispatcherServlet;
//
//
//public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException { //реализуем фильтр для запросов отличных от GET и POST
//        super.onStartup(servletContext);
//        registerHiddenFiledFilter(servletContext);
//    }
//
//    private  void  registerHiddenFiledFilter(ServletContext aContext){
//        aContext.addFilter("hiddenHttpMethodFilter",
//                new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null, true, "/*");
//    }
//
//    // Метод, указывающий на класс конфигурации
//    @Override
//    protected Class<?>[] getRootConfigClasses() {
//        return new Class[0];
//    }
//
//
//    // Добавление конфигурации, в которой инициализируем ViewResolver, для корректного отображения jsp.
//    @Override
//    protected Class<?>[] getServletConfigClasses() {
//        return new Class<?>[]{
//               AppConfig.class
//        };
//    }
//
//
//    /* Данный метод указывает url, на котором будет базироваться приложение */
//    @Override
//    protected String[] getServletMappings() {
//        return new String[]{"/"};
//    }
//
//}
package spring;

import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
               AppConfig.class
        };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException { //реализуем фильтр для запросов отличных от GET и POST
        super.onStartup(servletContext);
        registerHiddenFiledFilter(servletContext);
    }

    private  void  registerHiddenFiledFilter(ServletContext aContext){
        aContext.addFilter("hiddenHttpMethodFilter",
                new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null, true, "/*");
    }
}