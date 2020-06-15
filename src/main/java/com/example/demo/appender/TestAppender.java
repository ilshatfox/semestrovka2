package com.example.demo.appender;

import ch.qos.logback.core.FileAppender;
import ch.qos.logback.core.OutputStreamAppender;
import ch.qos.logback.core.UnsynchronizedAppenderBase;
import ch.qos.logback.core.spi.DeferredProcessingAware;
import ch.qos.logback.core.status.ErrorStatus;
import com.example.demo.dto.LogsImpl;
import com.example.demo.dto.UserDaoImpl;
import com.example.demo.models.Logs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

@Component
public class TestAppender<E> extends FileAppender<E> {

    @Autowired
    private LogsImpl userDao;


    public TestAppender(){
        System.out.println("я создан!");
    }

    private void writeBytes(byte[] byteArray) throws IOException {
        if (byteArray != null && byteArray.length != 0) {
            this.lock.lock();

            try {
                System.out.println("z nu111");
                Logs my_logs = new Logs();
                my_logs.setLogField(new String(byteArray));

//                LogsImpl userDao = new LogsImpl();
//                userDao.saveLogs(my_logs);
                Class.forName("org.postgresql.Driver");
                String url = "jdbc:postgresql://localhost:5432/test_database";
                Connection conn = DriverManager.getConnection(url, "test_user", "test_password");
//                Statement st = conn.createStatement();
//                st.executeUpdate("insert into logs_info VALUES(" + "1, " + "''" + new String(byteArray) + "'')");
                PreparedStatement statement = conn.prepareStatement("INSERT INTO logs_info (log_field) VALUES (?)");
                statement.setString(1, new String(byteArray));
//                statement.setString(1, user.getLogin());
//                statement.setString(2, user.getPassword());
//                statement.setString(3, user.getCountry());
//                statement.setString(4, user.getSex());
//                statement.setString(5, user.getBirthday());
                statement.executeUpdate();

                System.out.println("z nu2222");
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
            finally {
                this.lock.unlock();
            }

        }
    }

    @Override
    protected void subAppend(E event) {
        if (this.isStarted()) {
            try {
                if (event instanceof DeferredProcessingAware) {
                    ((DeferredProcessingAware)event).prepareForDeferredProcessing();
                }

                byte[] byteArray = this.encoder.encode(event);
                System.out.println("my bytes!: " + new String(byteArray));
                this.writeBytes(byteArray);
            } catch (IOException var3) {
                this.started = false;
                this.addStatus(new ErrorStatus("IO failure in appender", this, var3));
            }

        }
    }

    @Override
    protected void append(E eventObject) {
        System.out.println("hello! avfsd1fgsdfgsdfg");
        if (this.isStarted()) {
            this.subAppend(eventObject);
        }
    }

    @Override
    protected void writeOut(E event) throws IOException {
        System.out.println("hello! avfsdfgsdfgsdfg");
//        byte[] byteArray = this.encoder.encode(event);
//        this.writeBytes(byteArray);
    }
}
