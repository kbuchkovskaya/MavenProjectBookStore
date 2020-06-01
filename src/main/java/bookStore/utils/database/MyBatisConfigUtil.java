package bookStore.utils.database;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MyBatisConfigUtil {

    public static SqlSessionFactory getSqlSessionFactory(){

        SqlSessionFactory sqlSessionFactory = null;

        try {
            Reader reader = Resources.getResourceAsReader(DatabasePropertiesPath.CONFIG_FILE);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return sqlSessionFactory;
    }
}
