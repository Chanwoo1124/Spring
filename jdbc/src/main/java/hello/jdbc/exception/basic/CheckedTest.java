package hello.jdbc.exception.basic;

import jdk.dynalink.beans.StaticClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CheckedTest {
    /**
     * Exception을 상속받은 예외는 체크 예외가 된다
     */
    static class MyCheckedException extends Exception{
        public MyCheckedException(String message) {
            super(message);
        }
    }

    /**
     * 옝
     */

    static class Service{
        Repository repository = new Repository();
        public void callCatch(){
            try {
                repository.call();
            } catch (MyCheckedException e) {
                log.info("예외 처리, message={}", e.getMessage(), e);
            }


        }

    }

    static class Repository{
        public void call() throws MyCheckedException {
            throw new MyCheckedException("ex");
        }

    }

}
