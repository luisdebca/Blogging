package debca.blogging;

import debca.blogging.model.Post;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

import static org.hibernate.cfg.AvailableSettings.*;

@Configuration
@EnableTransactionManagement
@ComponentScans(value = {@ComponentScan("debca.blogging.repository"), @ComponentScan("debca.blogging.service")})
public class AppConfig {

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        Properties properties = new Properties();
        properties.put(DRIVER, "org.h2.Driver");
        properties.put(URL, "jdbc:h2:mem:db;DB_CLOSE_DELAY=-1");
        properties.put(DIALECT, "org.hibernate.dialect.H2Dialect");
        properties.put(USER, "sa");
        properties.put(PASS, "sa");
        properties.put(SHOW_SQL, true);
        properties.put(HBM2DDL_AUTO, "create-drop");
        factoryBean.setHibernateProperties(properties);
        factoryBean.setAnnotatedClasses(Post.class);
        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }
}
